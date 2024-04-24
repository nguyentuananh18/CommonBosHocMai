package tuanbuffet.L6spw.createStudent;

public class Main {
    public static void main(String[] args) {
        String input = "2"; // Thay đổi chuỗi này để kiểm tra

        // Biểu thức chính quy để tìm kiếm ký tự đặc biệt
        String regex = "[^a-zA-Z0-9]"; // Tìm ký tự không phải là chữ cái hoặc số

        if (input.matches(regex)) {
            System.out.println("Chuỗi chứa ký tự đặc biệt.");
        } else {
            System.out.println("Chuỗi không chứa ký tự đặc biệt.");
        }
    }
}
