package LapTrinhWeb_Cha.dao.impl;

import LapTrinhWeb_Cha.dao.IUserService;
import LapTrinhWeb_Cha.models.UserModel;

public class UserServiceImpl implements IUserService {
	UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {

		UserModel user = this.findByUserName(username);

		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email, username, fullname,password,null, 1, phone ,date));
		return true;
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

}
