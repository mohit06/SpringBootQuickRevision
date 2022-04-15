package com.basics.begin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.basics.begin.Basic;
import com.basics.begin.BasicRepo;

@Repository
public class BasicService {

	@Autowired
	private BasicRepo br;
	
	public String businessLogic() {
		br.save();
		
		
		return br.save();
	}
	
}
