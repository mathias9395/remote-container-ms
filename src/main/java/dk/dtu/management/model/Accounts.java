package dk.dtu.management.model;

import java.util.HashSet;
import java.util.Set;

public class Accounts {
	private Set<User> users = new HashSet<User>();

	
	public void addUser(User user) {
		users.add(user);
	}
	
	public Boolean login(String email, String password) {
		for (User u : users) {
			if (u.getEmail().toLowerCase().equals(email.toLowerCase()) && 
					u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public User getUser(String email) {
		for (User u : users) {
			if (email.toLowerCase().equals(u.getEmail().toLowerCase())) {
				return u;
			}
		}
		return null;
	}
}
