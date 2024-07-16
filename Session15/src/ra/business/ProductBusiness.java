//package ra.business;
//import ra.entity.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ProductBusiness implements IProduct{
//    Scanner scanner = new Scanner(System.in);
//    public static List<Product> products = new ArrayList<>();
//
//    @Override
//    public boolean create(Product product) {
//        products.add(product);
//        return true;
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return products;
//    }
//
//    @Override
//    public boolean update(Product product) {
//        int index = products.indexOf(product);
//        if (index!= -1) {
//            products.set(index, product);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteById(String id) {
//        int index = products.indexOf(id);
//        if (index!= -1) {
//            products.remove(index);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Product findById(String id) {
//        for (Product product : products) {
//            if (product.getProductId().equals(id)) {
//                return product;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void sortProduct(Product[] arrProduct) {
//        for (int i = 0; i < arrProduct.length - 1; i++) {
//            for (int j = i + 1; j < arrProduct.length; j++) {
//                if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
//                    Product temp = arrProduct[i];
//                    arrProduct[i] = arrProduct[j];
//                    arrProduct[j] = temp;
//                }
//            }
//        }
//    }
//
//    @Override
//    public void searchProduct(Product[] arrProduct) {
//        for (int i = 0; i < arrProduct.length; i++) {
//            System.out.println(arrProduct[i].toString());
//        }
//        System.out.println("Nhập tên sản phẩm cần tìm kiếm: ");
//        String name = scanner.nextLine();
//        for (int i = 0; i < arrProduct.length; i++) {
//            if (arrProduct[i].getProductName().equals(name)) {
//                System.out.println(arrProduct[i].toString());
//            }
//        }
//    }
//
//    @Override
//    public void searchProductByPrice(Product[] arrProduct, float a, float b) {
//        //tìm giá sản phẩm từ khoảng a đến b
//        System.out.println("Nhập giá sản phẩm từ: ");
//        float price = scanner.nextFloat();
//        System.out.println("Nhập giá sản phẩm đến: ");
//        float price1 = scanner.nextFloat();
//        for (Product product: products){
//
//        }
//    }
//}



package ra.business;

import ra.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductBusiness implements IProduct {
    Scanner scanner = new Scanner(System.in);
    public static List<Product> products = new ArrayList<>();

    @Override
    public boolean create(Product product) {
        products.add(product);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public boolean update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(product.getProductId())) {
                products.set(i, product);
                return true;
            }
        }
        return false; // Product not found
    }

    @Override
    public boolean deleteById(String id) {
        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public Product findById(String id) {
        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null; // Product not found
    }

    @Override
    public void sortProduct(Product[] arrProduct) {
        // Sorting products array based on price ascending
        for (int i = 0; i < arrProduct.length - 1; i++) {
            for (int j = i + 1; j < arrProduct.length; j++) {
                if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
    }

    @Override
    public void searchProduct(Product[] arrProduct) {
        // Display all products and search by name
        for (Product product : arrProduct) {
            System.out.println(product.toString());
        }
        System.out.println("Enter the name of the product to search for: ");
        String name = scanner.nextLine();
        for (Product product : arrProduct) {
            if (product.getProductName().equals(name)) {
                System.out.println(product.toString());
            }
        }
    }

    @Override
    public void searchProductByPrice(Product[] arrProduct, float a, float b) {
        // Search products within a price range
        System.out.println("Enter minimum price: ");
        float minPrice = scanner.nextFloat();
        System.out.println("Enter maximum price: ");
        float maxPrice = scanner.nextFloat();
        for (Product product : arrProduct) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println(product.toString());
            }
        }
    }
}
