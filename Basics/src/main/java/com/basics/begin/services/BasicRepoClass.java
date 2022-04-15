package com.basics.begin.services;

import org.springframework.stereotype.Controller;

import com.basics.begin.BasicRepo;
@Controller
public class BasicRepoClass implements BasicRepo {

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return "Object is saved";
	}

}
