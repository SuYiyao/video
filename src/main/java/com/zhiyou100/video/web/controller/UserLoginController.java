package com.zhiyou100.video.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.zhiyou100.video.model.Result;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
import com.zhiyou100.video.utils.MD5Utils;
import com.zhiyou100.video.utils.MailUtil;

@Controller
@RequestMapping("/front/user")
public class UserLoginController {

	@Autowired
	UserService us;
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	@ResponseBody
	public Result login(User u,HttpSession se){

		User user = us.login(u);
		Result re = new Result();
		if(user!=null){
			re.setSuccess(true);
			
			se.setAttribute("_front_user", user);
		}else{
			re.setMessage("登录失败");
		}
		return re;
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession se){
		se.removeAttribute("_front_user");
		return "redirect:/index.jsp";
	}
	@RequestMapping(value="/regist.do",method=RequestMethod.POST)
	@ResponseBody
	public Result regist(User u){

		User uu = us.find(u);
		Result re = new Result();
		if(uu==null){
			re.setSuccess(true);
			us.regist(u);
		}else{
			re.setMessage("注册失败,用户名已存在");
		}
		return re;
	}
	@RequestMapping("/forgetpwd.do")
	public String forgetpwd(){
		
		return "/front/user/forget_pwd";
	}
	@RequestMapping("/index.do")
	public String index(Integer id,Model mo){
		User u = us.find(id);
		mo.addAttribute("user", u);
		
		return "/front/user/index";
	}
	@RequestMapping("/profile.do")
	public String profile(Integer id,Model mo){
		User u = us.find(id);
		mo.addAttribute("user", u);
		
		return "/front/user/profile";
	}
	@RequestMapping("/updateProfile.do")
	public String updateProfile(User u){
		us.updateProfile(u);
		return "forward:/front/user/index.do";
	}
	
	@RequestMapping("/avatar.do")
	public String avatar(Integer id,Model mo){
		User u = us.find(id);
		mo.addAttribute("user", u);
		
		return "/front/user/avatar";
	}
	@RequestMapping("/updateAvatar.do")
	public String updateAvatar(User u,MultipartFile pic,Model mo) throws Exception{
		
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		String fileName = str+"."+ext;
		String path = "d:\\upload";
		pic.transferTo(new File(path+"\\"+fileName));
		u.setHeadUrl(fileName);
		us.updateAvatar(u);
		User uu = us.find(u.getId());
		mo.addAttribute("user", uu);
		return "/front/user/avatar";
	}
	@RequestMapping("/password.do")
	public String password(Integer id,Model mo){
		User u = us.find(id);
		mo.addAttribute("user", u);
		
		return "/front/user/password";
	}
	@RequestMapping("/updatePwd.do")
	public String updatePwd(Integer id,Model mo,String oldPassword,String password){
		User u = us.find(id);
		String message = null;
		oldPassword = MD5Utils.getMD5(oldPassword);
		oldPassword = MD5Utils.getMD5(oldPassword);
		if(oldPassword.equals(u.getPassword())){
			u.setPassword(password);
			message="修改成功";
			mo.addAttribute("message", message);
			us.updatePwd(u);
		}else{
			message="旧密码输入错误,请重新输入";
			mo.addAttribute("message", message);
		}
		mo.addAttribute("user", u);
		return "/front/user/password";
	}
	@RequestMapping("/sendEmail.do")
	@ResponseBody
	public Result sendEmail(String email) throws Exception{
		Random ran = new Random();
		String a = ""+(ran.nextInt(99999-10000+1)+10000);
		User user = us.findUserByEmail(email);
		Result re = new Result();
		if(user!=null){
			re.setSuccess(true);
			MailUtil.send(email, "验证码为:", a);
			user.setCaptcha(a);
			us.updateCaptcha(user);
		}else{
			re.setMessage("旧密码输入错误,请重新输入");
		}
		return re;
	}
	@RequestMapping("/resetpwd.do")
	public String resetpwd(User u,Model mo){
		User user = us.findUserByCaptcha(u);
		
		if(user!=null){
			mo.addAttribute("uu", user);
		return "/front/user/reset_pwd";
		}else{
			mo.addAttribute("error", "验证码输入错误");
			return "/front/user/forget_pwd";
		}
	}
	@RequestMapping("/resetpwd2.do")
	public String resetpwd2(User u,String password){
		User user = us.findUserByCaptcha(u);
		user.setPassword(password);
		us.updatePwd(user);
			return "redirect:/index.jsp";
		
	}
	
}
