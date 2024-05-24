package tuanbuffet.L6spw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class SwingL6 {

    public static void main(String[] args) {
        // Tạo một JFrame (cửa sổ ứng dụng)
        JFrame frame = new JFrame("Auto BOS Học Mãi !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(1,1));
        JCheckBox checkBoxCreateStudent = new JCheckBox("Tạo Học Viên L6");
        JCheckBox checkBoxAddPackageAndOpenSchedule = new JCheckBox("Thêm gói và mở thời gian biểu");
        JCheckBox CreateClass = new JCheckBox();
        CreateClass.setText("Tạo lớp học L6 SpeakWell");
        JTextField thread = new JTextField(15);
        JPanel panelThread = new JPanel();
        panelThread.setLayout(new GridLayout(1,2));
        panelThread.add(new JLabel("Số luồng chạy: "));
        panelThread.add(thread);


        JPanel panelLeft = new JPanel();
        panelLeft.add(checkBoxCreateStudent);
        panelLeft.add(checkBoxAddPackageAndOpenSchedule);
        panelLeft.add(CreateClass);
        panelLeft.setLayout(new GridLayout(5,1));

        JButton L6 = new JButton("Run L6");
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new GridLayout(3,1));
        panelRight.add(panelThread);
        panelRight.add(L6);

        panelRight.setBorder(BorderFactory.createEmptyBorder(50,0,80,10));

        LocalDate givenDate = LocalDate.of(2024, 6, 10);
        LocalDate currentDate = LocalDate.now();
        boolean isFuture = givenDate.isAfter(currentDate);

        L6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFuture) {
                    try {
                        if (!checkBoxCreateStudent.isSelected() && !checkBoxAddPackageAndOpenSchedule.isSelected() && !CreateClass.isSelected()) {
                            JOptionPane.showMessageDialog(null, "Đù, không chọn chạy cái nào thì biết chạy cái nào, tick nó đi chớ!!!");
                        }
                        else {
                            String product = "";
                            if (checkBoxCreateStudent.isSelected()) {
                                product += "createStudent";
                            }
                            if (checkBoxAddPackageAndOpenSchedule.isSelected()) {
                                product += "addPackageAndOpenSchedule";
                            }
                            if (CreateClass.isSelected()) {
                                product += "createClass";
                            }
                            int numberThread = Integer.parseInt(thread.getText());
                            for (int i = 1 ; i <=numberThread ; i++){
                                Thread thread = new Thread(new RunL6(i,numberThread,product));
                                try {
                                    thread.start();
                                    Thread.sleep(2000);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Điền đúng trường dữ liệu trước khi chạy");
                                }
                            }
                            /*JOptionPane.showMessageDialog(null, "Đã chạy xong!");*/
                        }
                    } catch (Exception error) {
                        error.printStackTrace();
                        showMessageError();
                    }
                } else {
                    showMessageError();
                }

            }
        });
        // Thêm các nút vào JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2)); // Hai dòng, một cột

        panel.add(panelLeft);
        panel.add(panelRight);

        panel.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
        /*panel.add(new JLabel("phần mềm được bản quyền bởi Nguyễn Tuấn Anh"),BorderLayout.CENTER);*/
        // Thêm JPanel vào JFrame
        frame.add(panel);
        // Hiển thị cửa sổ ứng dụng
        frame.setVisible(true);
    }

    public static void showMessageError() {
        JOptionPane.showMessageDialog(null, "Chương trình đã bị lỗi, vui lòng liên hệ admin!");
    }
}
