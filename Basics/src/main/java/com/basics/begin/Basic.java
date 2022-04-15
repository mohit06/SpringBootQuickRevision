package com.basics.begin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Basic {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Basic(String name) {
		super();
		this.name = name;
	}

	public Basic() {
		super();
	}

	@Override
	public String toString() {
		return "Basic [name=" + name + "]";
	}
	

}
