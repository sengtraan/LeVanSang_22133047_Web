package LapTrinhWeb_Cha.dao;

import java.util.List;

import LapTrinhWeb_Cha.models.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
	List<CategoryModel> getAll(); //Get ở đây hiểu là find cho tất cả, search cũng là find theo keyword 
	List<CategoryModel> search(String keyword);

}
