package com.atul.app.supersetapi.entity;

import java.util.HashMap;

public class GuestUser {
	
	private HashMap<String, String> User;
	private HashMap<String, String>[] Resources;
	private HashMap<String, String>[] Rls;
	
	public HashMap<String, String> getUser() {
		return User;
	}

	public void setUser(HashMap<String, String> user) {
		User = user;
	}

	public HashMap<String, String>[] getResources() {
		return Resources;
	}

	public void setResources(HashMap<String, String>[] resources) {
		Resources = resources;
	}

	public HashMap<String, String>[] getRls() {
		return Rls;
	}

	public void setRls(HashMap<String, String>[] rls) {
		Rls = rls;
	}

	@Override
	public String toString() {
		return "GuestUser [User=" + User + ", Resources=" + Resources + "], Rls=" + Rls + "]";
	}
	
}
