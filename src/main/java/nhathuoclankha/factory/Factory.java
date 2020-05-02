package nhathuoclankha.factory;

import nhathuoclankha.auth.model.User;

public class Factory {
	public static User getUserInstant() {
		User user = new User();
		//Set default password;
		user.setPassword("1");
		return user;
	}

}
