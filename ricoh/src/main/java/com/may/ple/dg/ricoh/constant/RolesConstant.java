package com.may.ple.dg.ricoh.constant;

public enum RolesConstant {
	ROLE_USER(1, "User"), 
	ROLE_ADMIN(2, "Admin"),
	ROLE_Sale(3, "Sale");
	
	private int id;
	private String name;
	
	private RolesConstant(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static RolesConstant findById(int id) {
		RolesConstant[] values = RolesConstant.values();
		for (RolesConstant rolesConstant : values) {
			if(rolesConstant.getId() == id) 
				return rolesConstant;
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
