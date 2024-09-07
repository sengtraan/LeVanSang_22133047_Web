package LapTrinhWeb_Cha.dao;

import LapTrinhWeb_Cha.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);

	UserModel get(String username);

	UserModel findByUserName(String username);

	boolean register(String email, String password, String username, String fullname, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	void insert(UserModel user);
}
