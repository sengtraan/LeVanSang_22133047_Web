package LapTrinhWeb_Cha.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import LapTrinhWeb_Cha.configs.DBConnectionSQL;
import LapTrinhWeb_Cha.dao.ICategoryDao;
import LapTrinhWeb_Cha.models.CategoryModel;

public class CategoryDaoImpl extends DBConnectionSQL implements ICategoryDao {

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO Category(cate_name, images, active) VALUES (?, ?, ?)";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category.getCate_name());
		ps.setString(2, category.getImages());
		ps.setBoolean(3, category.getActive());
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}

	@Override
	public void edit(CategoryModel category) {
		String sql = "UPDATE Category SET cate_name = ?, images = ?, active = ? WHERE cate_id = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, category.getCate_name());
		ps.setString(2, category.getImages());
		ps.setBoolean(3, category.getActive());
		ps.setInt(4, category.getCate_id());
		ps.executeUpdate();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE cate_id = ?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public CategoryModel get(int id) {
		String sql = "SELECT * FROM Category WHERE cate_id = ? ";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		CategoryModel category = new CategoryModel();
		category.setCate_id(rs.getInt("cate_id"));
		category.setCate_name(rs.getString("cate_name"));
		category.setImages(rs.getString("images"));
		return category;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;

	}

	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> getAll() {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category";
		try {
		Connection conn = super.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		CategoryModel category = new CategoryModel(); //Dang rong
		category.setCate_id(rs.getInt("cate_id"));
		category.setCate_name(rs.getString("cate_name"));
		category.setImages(rs.getString("images"));
		category.setActive(rs.getBoolean("active")); // Bo sung set active
		categories.add(category);
		}} catch (Exception e) {
		e.printStackTrace();}
		return categories;
	}

	@Override
	public List<CategoryModel> search(String keyword) {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category where cate_name like ?";
		try {
		Connection conn = super.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + keyword + "%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		CategoryModel category = new CategoryModel(); //Dang rong
		category.setCate_id(rs.getInt("cate_id"));
		category.setCate_name(rs.getString("cate_name"));
		category.setImages(rs.getString("images"));
		category.setActive(rs.getBoolean("active")); // Bo sung set active
		categories.add(category);
		}} catch (Exception e) {
		e.printStackTrace();}
		return categories;
	}

}
