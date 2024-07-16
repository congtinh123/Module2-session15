package ra.business;

import jdk.jfr.Category;
import ra.entity.Categories;

public interface ICategories extends IGenericDesign <Category, String>{
    //cập nhật trạng thái danh mục
    void updateCatalogStatus(String categoryId, boolean catalogStatus);
}
