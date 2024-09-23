package LapTrinhWeb_Cha.dao;

import java.util.List;

import LapTrinhWeb_Cha.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();

	UserModel findByUserName(String username);

	void insert(UserModel user);

	UserModel get(String username);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	
    void updatePassword(String username, String newPassword);
    
    boolean updateUserInfo(UserModel user);

}
