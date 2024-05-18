public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        // Tạo hai luồng
        Thread thread1 = new Thread(new MyRunnable(names, 0, 2));
        Thread thread2 = new Thread(new MyRunnable(names, 1, 2));

        // Khởi động luồng
        thread1.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable {
    private String[] names;
    private int start;
    private int step;

    public MyRunnable(String[] names, int start, int step) {
        this.names = names;
        this.start = start;
        this.step = step;
    }

    public void run() {
        for (int i = start; i < names.length; i += step) {
            System.out.println(names[i]);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
