package com.nazar.useradmin.dao;

import com.nazar.useradmin.dto.User;
import com.nazar.useradmin.util.IDGenerator;

public class UserDAO {
	
	public int create(User user) {
		int id = IDGenerator.generateID();
		
		// Save the user object to the database
		return id;
		
	}
}
