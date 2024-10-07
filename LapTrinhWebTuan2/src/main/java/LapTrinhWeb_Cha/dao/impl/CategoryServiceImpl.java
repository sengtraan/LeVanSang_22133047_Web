package LapTrinhWeb_Cha.dao.impl;

import java.io.File;
import java.util.List;

import LapTrinhWeb_Cha.dao.ICategoryService;
import LapTrinhWeb_Cha.models.CategoryModel;

public class CategoryServiceImpl implements ICategoryService {
	public CategoryDaoImpl categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
	}

	@Override
	public void edit(CategoryModel newCategory) {
//		CategoryModel oldCate = categoryDao.get(newCategory.getCate_id());
//		oldCate.setCate_name(newCategory.getCate_name());
//		categoryDao.edit(oldCate);
		CategoryModel oldCategory = categoryDao.get(newCategory.getCate_id());
		oldCategory.setCate_name(newCategory.getCate_name());
		if (newCategory.getImages() != null) {
			// XOA ANH CU DI
			String fileName = oldCategory.getImages();
			final String dir = "E:\\upload";
			File file = new File(dir + "/category" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setImages(newCategory.getImages());
		}
		categoryDao.edit(newCategory);//Vừa sửa old thành new, thầy còn có bước kiểm tra oldCategory có khác nu;ll không
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = categoryDao.get(id);
		if (cate != null) {
			categoryDao.delete(id);
		}
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public CategoryModel get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<CategoryModel> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<CategoryModel> search(String catename) {
		return categoryDao.search(catename);
	}

}
