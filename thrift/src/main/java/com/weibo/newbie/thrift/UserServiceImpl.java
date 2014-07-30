package com.weibo.newbie.thrift;

import org.apache.thrift.TException;

import com.weibo.newbie.thrift.UserService.Iface;

public class UserServiceImpl implements UserService.Iface {

	public User getUser(long id) throws TException {
		return new User(id, "xiaoming");
	}

}
