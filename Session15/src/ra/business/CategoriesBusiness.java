package ra.business;

import jdk.jfr.Category;
import ra.entity.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoriesBusiness implements ICategories {
    public static List<Category> categories = new ArrayList<>();

    @Override
    public void updateCatalogStatus(String categoryId, boolean catalogStatus) {

    }

    @Override
    public boolean create(Category category) {
        categories.add(category);
        return true;
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public boolean update(Category category) {
        int index = categories.indexOf(category);
        if (index != -1) {
            categories.set(index, category);
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteById(String id) {
        int index = categories.indexOf(findById(id));
        if (index!= -1) {
            categories.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Category findById(String id) {
        for (Category category : categories) {
            if (category!= null && category.equals(id)) {
                return category;
            }
        }
        return null;
    }

}