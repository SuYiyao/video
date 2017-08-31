package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import com.zhiyou100.video.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper um;
	@Override
	public User login(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		List<User> list= um.selectByExample(ue);
		User user = null;
		if(list.size()==0){
			return user;
		}else{
			user = list.get(0);
			return user;
		}
		
	}
	@Override
	public User find(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		List<User> list= um.selectByExample(ue);
		User user = null;
		if(list.size()==0){
			return user;
		}else{
			user = list.get(0);
			return user;
		}
	}
	@Override
	public void regist(User u) {
		um.insertSelective(u);
		
	}
	@Override
	public User find(Integer id) {
		
		return um.selectByPrimaryKey(id);
	}
	@Override
	public void updateProfile(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}
	@Override
	public void updateAvatar(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}
	@Override
	public void updatePwd(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}
	@Override
	public User findUserByEmail(String email) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(email);
		List<User> list= um.selectByExample(ue);
		User user = null;
		if(list.size()==0){
			return user;
		}else{
			user = list.get(0);
			return user;
		}
	}
	@Override
	public void updateCaptcha(User user) {
		um.updateByPrimaryKeySelective(user);
	}
	@Override
	public User findUserByCaptcha(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		List<User> list= um.selectByExample(ue);
		User user = null;
		if(list.size()==0){
			return user;
		}else{
			user = list.get(0);
			return user;
		}
		
	}

}
