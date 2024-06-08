import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Class để lưu trữ dữ liệu giáo viên
class TeacherData {
    // Định nghĩa dữ liệu giáo viên ở đây
}

public class Main {
    public static void main(String[] args) {
        // Đường dẫn tới file Excel
        String filePath = "teacher_data.xlsx";

        // Tạo một ExecutorService với pool thread có 1 thread
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Sử dụng Future để nhận kết quả từ luồng đầu tiên
        Future<TeacherData> futureTeacherData = executor.submit(new Callable<TeacherData>() {
            @Override
            public TeacherData call() throws Exception {
                // Đọc dữ liệu giáo viên từ file Excel và trả về
                return readTeacherData(filePath);
            }
        });

        // Sử dụng dữ liệu giáo viên từ luồng đầu tiên
        try {
            TeacherData teacherData = futureTeacherData.get(); // Lấy kết quả từ Future
            // Sử dụng dữ liệu giáo viên ở đây

            // Tạo và chạy các luồng tiếp theo
            for (int i = 0; i < 5; i++) { // Ví dụ tạo 5 luồng tiếp theo
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        // Sử dụng dữ liệu giáo viên từ luồng đầu tiên
                        // Thực hiện các thao tác khác với dữ liệu giáo viên ở đây
                    }
                });
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown ExecutorService khi đã hoàn thành công việc
        executor.shutdown();
    }

    // Hàm để đọc dữ liệu từ file Excel và trả về dữ liệu giáo viên
    private static TeacherData readTeacherData(String filePath) {
        // Thực hiện đọc dữ liệu giáo viên từ file Excel và trả về
        return new TeacherData(); // Giả sử đây là dữ liệu giáo viên đã được đọc từ file
    }
}