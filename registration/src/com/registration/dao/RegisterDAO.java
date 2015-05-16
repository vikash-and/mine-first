package com.registration.dao;

import com.registration.bean.Register;

public interface RegisterDAO {
	
	public void insert(Register register);
	public Register findByCustomerId(int registrationId);
	public int findCustomer(String username,String password);

}
