package com.zhiyou100.video.web.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.service.AdminService;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService as;
	@RequestMapping("/login.action")
	public String login(Admin av,HttpServletRequest req){
		av.getLoginName();
		av.getLoginPwd();
		Admin ad = as.findUserByNameAndPwd(av);
		if (ad == null) {
			req.getSession().setAttribute("errorMessage", "用户名或密码错误");
			return "forward:/WEB-INF/view/admin/login.jsp"; 
		} else {
			req.getSession().setAttribute("admin", ad);
			return "redirect:/admin/video/videoList.action";
		}
	}
	@RequestMapping("/logout.action")
	public String logout(){
		return "forward:/WEB-INF/view/admin/login.jsp"; 
	}
	@RequestMapping("/AdminLogin.action")
	public String login(){
		return "forward:/WEB-INF/view/admin/login.jsp"; 
	}
}
