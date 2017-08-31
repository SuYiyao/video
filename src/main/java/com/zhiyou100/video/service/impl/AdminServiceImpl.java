package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.AdminMapper;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.AdminExample;

import com.zhiyou100.video.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper am;

	@Override
	public Admin findUserByNameAndPwd(Admin av) {
		 
		AdminExample ae = new AdminExample();
		ae.createCriteria().andLoginNameEqualTo(av.getLoginName()).andLoginPwdEqualTo(av.getLoginPwd());
		
		List<Admin> li = am.selectByExample(ae);
		if(li.size()==0){
			return null;
		}else{
		Admin ad = li.get(0);
		return ad;
		}
	}
}
