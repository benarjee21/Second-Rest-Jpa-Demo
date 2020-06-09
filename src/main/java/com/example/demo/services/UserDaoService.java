package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.beans.User;

@Component
public class UserDaoService {
	private int count=5;
	public static List<User> users=new ArrayList<User>();
	
	static {
		users.add(new User(1,"vikky1",new Date()));
		users.add(new User(2,"vikky2",new Date()));
		users.add(new User(3,"vikky3",new Date()));
		users.add(new User(4,"vikky4",new Date()));
		users.add(new User(5,"vikky5",new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User save(User user) {
		if(user.getId()==0) {
			user.setId(++count);
		}
			users.add(user);
			return user;
	}
	
	public User delete(int id) {
		Iterator<User> i=users.iterator();
		while(i.hasNext()) {
			User user=i.next();
			if(user.getId()==id) {
				i.remove();
				return user;
			}
		}
		return null;
	}

}
