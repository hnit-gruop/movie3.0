package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.User;
import com.yc.bean.UserExample;
import com.yc.dao.UserMapper;
import com.yc.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User login(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(username).andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

	@Override
	public int reg(User u) {
		return 0;
	}

	@Override
	public User get(int userId) {
		User selectByPrimaryKey = userMapper.selectByPrimaryKey(userId);		
		return selectByPrimaryKey;
	}

	@Override
	public User loginByEamil(String username, String email) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andEmailEqualTo(email);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

	@Override
	public Boolean isReg(String phone) {
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0)
			return true;
		return false;
	}

	@Override
	public void addUser(String phone, String password) {
		User record =new User();
		record.setPhone(phone);
		record.setPassword(password);
		record.setHeadImg("reg_default.png");
		int list = userMapper.insert(record);
	}

	@Override
	public User login(String phonenum) {
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(phonenum);
		List<User> list = userMapper.selectByExample(example);
		if(list.size()>0)
			return list.get(0);
		return null;
	}


	
}
