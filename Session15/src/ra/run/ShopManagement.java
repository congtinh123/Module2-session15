package ra.run;
import ra.entity.Categories;
import ra.entity.Product;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShopManagement {
    public static ArrayList<Categories> categories = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("-----------SHOP MENU-----------\n" +
                    "\n" +
                    "1.Quản lý danh mục sản phẩm\n" +
                    "2.Quản lý sản phẩm\n" +
                    "3.Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    managementCategory();
                    break;
                case 2:
                    managementProduct();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                    break;
            }
        }
    }

    public static void managementCategory() {
        while (true) {
            System.out.println("----------------CATEGORIES MENU------------------\n" +
                    "1.Nhập thông tin các danh mục\n" +
                    "2.Hiển thị thông tin các danh mục\n" +
                    "3.Cập nhật thông tin danh mục\n" +
                    "4.Xóa danh mục\n" +
                    "5.Cập nhật trạng thái danh mục\n" +
                    "6.Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    displayCategory();
                    break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    updateStatusCategory();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                    break;
            }
        }
    }

    public static void managementProduct() {
        while (true) {
            System.out.println("---------------PRODUCT MANAGEMENT----------------\n" +
                    "\n" +
                    "1.Nhập thông tin các sản phẩm\n" +
                    "2.Hiển thị thông tin các sản phẩm\n" +
                    "3.Sắp xếp các sản phẩm theo giá\n" +
                    "4.Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                    "5.Xóa sản phẩm theo mã sản phẩm\n" +
                    "6.Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
                    "7.Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)\n" +
                    "8.Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    sortProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    searchProduct();
                    break;
                case 7:
                    searchProductByPrice();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại");
                    break;
            }
        }
    }

    public static void addCategory() {
        System.out.println("Thêm mới danh mục");
        System.out.print("Tên danh mục: ");
        String name = scanner.nextLine();
        System.out.print("Mô tả: ");
        String description = scanner.nextLine();
        System.out.print("Trạng thái danh mục (true/false): ");
        boolean catalogStatus = scanner.nextBoolean();
        scanner.nextLine();
        Categories category = new Categories(name, description, catalogStatus);
        categories.add(category);
        System.out.println("Thêm mới danh mục thành công");
    }

    public static void displayCategory() {
        if (categories.isEmpty()){
            System.out.println("Không có thể loại nào");
        }else{
            for (Categories category : categories) {
                System.out.println(category);
            }
        }
    }

    public static void updateCategory() {
        System.out.println("Nhập mã danh mục cần chỉnh sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        Categories category = categories.stream().filter(c -> c.getCategoryid() == id).findFirst().orElse(null);
        if(category != null){
            System.out.print("Tên danh mục mới: ");
            String name = scanner.nextLine();
            System.out.print("Mô tả mới: ");
            String description = scanner.nextLine();
            System.out.print("Trạng thái danh mục mới (true/false): ");
            boolean catalogStatus = scanner.nextBoolean();
            scanner.nextLine();  // Consume newline left-over
            category.setCategoryName(name);
            category.setDescription(description);
            category.setCatalogStatus(catalogStatus);
            System.out.println("Cập nhật danh mục thành công");
        } else {
            System.out.println("Không tìm thấy danh mục với mã số: " + id);
        }
    }

    public static void deleteCategory() {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        Categories category = categories.stream().filter(c -> c.getCategoryid() == id).findFirst().orElse(null);
        if (category != null) {
            categories.remove(category);
            System.out.println("Xóa danh mục thành công");
        } else {
            System.out.println("Không tìm thấy danh mục với mã số: " + id);
        }
    }

    public static void updateStatusCategory() {
        System.out.println("Nhập mã danh mục cần cập nhật trạng thái: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        Categories category = categories.stream().filter(c -> c.getCategoryid() == id).findFirst().orElse(null);
        if (category != null) {
            System.out.print("Trạng thái mới (true/false): ");
            boolean catalogStatus = scanner.nextBoolean();
            scanner.nextLine();  // Consume newline left-over
            category.setCatalogStatus(catalogStatus);
            System.out.println("Cập nhật trạng thái danh mục thành công");
        } else {
            System.out.println("Không tìm thấy danh mục với mã số: " + id);
        }
    }

    public static void addProduct() {
        System.out.println("Thêm mới sản phẩm");

        System.out.print("Nhập mã đồ uống (C/S/Axxx): ");
        String productId;
        while (true) {
            productId = scanner.nextLine();
            if (productId.matches("[CSA][0-9]{3}")) {
                String finalProductId = productId;
                boolean exists = products.stream().anyMatch(p -> p.getProductId().equals(finalProductId));
                if (!exists) {
                    break;
                } else {
                    System.out.println("Mã này đã tồn tại, vui lòng nhập mã khác.");
                }
            } else {
                System.out.println("Định dạng mã không hợp lệ, vui lòng nhập lại.");
            }
        }

        System.out.print("Nhập tên đồ uống: ");
        String productName;
        while (true) {
            productName = scanner.nextLine();
            if (productName.length() >= 10 && productName.length() <= 50) {
                break;
            } else {
                System.out.println("Tên sản phẩm phải từ 10 đến 50 ký tự.");
            }
        }

        System.out.print("Giá sản phẩm: ");
        float price;
        while (true) {
            price = scanner.nextFloat();
            scanner.nextLine();
            if (price > 0) {
                break;
            } else {
                System.out.println("Giá sản phẩm phải lớn hơn 0.");
            }
        }

        System.out.print("Mô tả sản phẩm: ");
        String description = scanner.nextLine();

        System.out.print("Ngày nhập sản phẩm (dd/MM/yyyy): ");
        LocalDate createdDate;
        while (true) {
            String created = scanner.nextLine();
            try {
                createdDate = LocalDate.parse(created, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("Định dạng ngày không hợp lệ, vui lòng nhập lại.");
            }
        }

        System.out.print("Mã danh mục mà sản phẩm thuộc về: ");
        int categoryId;
        while (true) {
            categoryId = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            int finalCategoryId = categoryId;
            boolean exists = categories.stream().anyMatch(c -> c.getCategoryid() == finalCategoryId);
            if (exists) {
                break;
            } else {
                System.out.println("Mã danh mục không tồn tại, vui lòng nhập lại.");
            }
        }

        System.out.print("Trạng thái sản phẩm (0: Đang bán - 1: Hết hàng - 2: Không bán): ");
        int productStatus;
        while (true) {
            productStatus = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            if (productStatus == 0 || productStatus == 1 || productStatus == 2) {
                break;
            } else {
                System.out.println("Trạng thái không đúng, vui lòng nhập lại.");
            }
        }

        Product product = new Product(productId, productName, price, description, createdDate, categoryId, productStatus);
        products.add(product);
        System.out.println("Thêm sản phẩm thành công!!!");
    }


    public static void displayProduct() {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public static void sortProduct() {
        products.sort(Comparator.comparing(Product::getPrice));
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void updateProduct() {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();
        Product product = products.stream().filter(p -> p.getProductId().equals(id)).findFirst().orElse(null);
        if (product != null) {
            System.out.print("Tên sản phẩm mới: ");
            String productName = scanner.nextLine();
            System.out.print("Giá sản phẩm mới: ");
            float price = scanner.nextFloat();
            scanner.nextLine();  // Consume newline left-over
            System.out.print("Ngày nhập sản phẩm mới (dd/MM/yyyy): ");
            LocalDate createdDate;
            while (true) {
                String created = scanner.nextLine();
                try {
                    createdDate = LocalDate.parse(created, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    break;
                } catch (Exception e) {
                    System.out.println("Định dạng ngày không hợp lệ, vui lòng nhập lại.");
                }
            }
            System.out.print("Mã danh mục sản phẩm thuộc về mới: ");
            int categoryId = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            System.out.print("Trạng thái sản phẩm mới (0: Đang bán – 1: Hết hàng – 2: Không bán): ");
            int status = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            product.setProductName(productName);
            product.setPrice(price);
            product.setCreatedDate(createdDate);
            product.setCategoryId(categoryId);
            product.setProductStatus(status);
            System.out.println("Cập nhật sản phẩm thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm với mã số: " + id);
        }
    }

    public static void deleteProduct() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        Product product = products.stream().filter(p -> p.getProductId().equals(id)).findFirst().orElse(null);
        if (product != null) {
            products.remove(product);
            System.out.println("Xóa sản phẩm thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm với mã số: " + id);
        }
    }

    public static void searchProduct() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        List<Product> foundProducts = products.stream().filter(p -> p.getProductName().contains(name)).collect(Collectors.toList());
        if (!foundProducts.isEmpty()) {
            for (Product product : foundProducts) {
                System.out.println(product);
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm với tên: " + name);
        }
    }

    public static void searchProductByPrice() {
        System.out.print("Nhập giá tìm từ khoảng: ");
        float from = scanner.nextFloat();
        System.out.print("Nhập giá tiền đến khoảng: ");
        float to = scanner.nextFloat();
        scanner.nextLine();  // Consume newline left-over
        List<Product> foundProducts = products.stream().filter(p -> p.getPrice() >= from && p.getPrice() <= to).collect(Collectors.toList());
        if (!foundProducts.isEmpty()) {
            for (Product product : foundProducts) {
                System.out.println(product);
            }
            System.out.println("Tìm thấy " + foundProducts.size() + " sản phẩm");
        } else {
            System.out.println("Không tìm thấy sản phẩm với giá từ " + from + " đến " + to);
        }
    }
}
