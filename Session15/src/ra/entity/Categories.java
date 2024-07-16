package ra.entity;

import java.util.Scanner;

public class Categories {
    private int CategoryId;
    private String categoryName, description;
    private boolean catalogStatus;
    private static int autoId = 1;
    public Categories() {
    }

    public Categories(String categoryName, String description, boolean catalogStatus) {
        CategoryId = autoId++;
        this.categoryName = categoryName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCategoryid() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName(String name) {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
    Scanner sc = new Scanner(System.in);
    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
        // Nhập tên danh mục
        while (true) {
            System.out.print("Nhập tên danh mục: ");
            String name = scanner.nextLine();
            boolean isDuplicate = false;
            for (Categories category : arrCategories) {
                if (category != null && category.getCategoryName(name).equals(name)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Tên danh mục đã tồn tại. Vui lòng nhập lại.");
            } else if (name.length() > 50) {
                System.out.println("Tên danh mục không được quá 50 ký tự. Vui lòng nhập lại.");
            } else {
                this.categoryName = name;
                break;
            }
        }


        System.out.print("Nhập mô tả danh mục: ");
        this.description = scanner.nextLine();

        while (true) {
            System.out.print("Nhập trạng thái danh mục (true - hoạt động, false - không hoạt động): ");
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            } else {
                System.out.println("Trạng thái danh mục không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
    @Override
    public String toString() {
        return "Categories{" +
                "Categoryid=" + CategoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", catalogStatus=" + catalogStatus +
                '}';
    }
}
