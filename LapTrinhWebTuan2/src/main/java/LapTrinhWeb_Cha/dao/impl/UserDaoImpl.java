package LapTrinhWeb_Cha.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import LapTrinhWeb_Cha.configs.DBConnectionSQL;
import LapTrinhWeb_Cha.dao.IUserDao;
import LapTrinhWeb_Cha.models.UserModel;

public class UserDaoImpl extends DBConnectionSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "select * from [User]";
		List<UserModel> list = new ArrayList<>();

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("password"), rs.getString("images"), rs.getString("fullname"),
						rs.getString("avatar"), rs.getInt("roleid"), rs.getString("phone"), rs.getDate("createDate")

				));
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM [User] WHERE username = ? ";
		try {
			conn = DBConnectionSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO [User](email, username, fullname, password, avatar, roleid,phone, createdate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn = DBConnectionSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassWord());
			ps.setString(5, user.getAvatar());	
			ps.setInt(6,user.getRoleid());
			ps.setString(7,user.getPhone());
			ps.setDate(8, user.getCreatedDate());
			ps.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [User] where email = ?";
		try {
			conn = DBConnectionSQL.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [User] where username = ?";
		try {
			conn = DBConnectionSQL.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();

//		userDao.insert(new UserModel(3, "Phuc", "fgh", "e", "f", "PhucDinh"));

		List<UserModel> list = userDao.findAll();

		for (UserModel user : list) {
			System.out.println(user);
		}
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

}
