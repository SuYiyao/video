package com.zhiyou100.video.service;

import com.zhiyou100.video.model.User;

public interface UserService {

	User login(User u);

	User find(User u);

	void regist(User u);

	User find(Integer id);

	void updateProfile(User u);

	void updateAvatar(User u);

	void updatePwd(User u);

	User findUserByEmail(String email);

	void updateCaptcha(User user);

	User findUserByCaptcha(User u);

}
