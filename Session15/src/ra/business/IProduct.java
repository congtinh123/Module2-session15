package ra.business;

import ra.entity.Product;

public interface IProduct extends IGenericDesign<Product, String>{
    //sắp xếp sản phẩm
    void sortProduct(Product[] arrProduct);
    //tìm kiếm sản phẩm theo tên
    void searchProduct(Product[] arrProduct);
    //timd kiếm trong khoảng giá a-b
    void searchProductByPrice(Product[] arrProduct, float a, float b);
}
