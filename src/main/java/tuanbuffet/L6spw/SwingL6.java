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
        JCheckBox checkBoxCreateStudent = new JCheckBox("Tạo Học Viên L6");
        JCheckBox checkBoxAddPackageAndOpenSchedule = new JCheckBox("Thêm gói và mở thời gian biểu");
        JCheckBox CreateClass = new JCheckBox();
        CreateClass.setText("Tạo lớp học L6 SpeakWell");
        // Tạo một JButton với văn bản "Click Me"
        JButton L6 = new JButton("Run L6");
        L6.setBounds(100, 50, 100, 30);
        /*L6.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));*/

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
                        } else {
                            RunL6 runL6 = new RunL6();
                            try {
                                runL6.Setup();
                            } catch (InterruptedException ex) {
                                runL6.QuitProgram();
                                showMessageError();
                            }
                            if (checkBoxCreateStudent.isSelected()) {
                                runL6.CreateStudent();
                            }
                            if (checkBoxAddPackageAndOpenSchedule.isSelected()) {
                                runL6.AddPackageAndOpenSchedule();
                            }
                            if (CreateClass.isSelected()) {
                                try {
                                    runL6.CreateClass();
                                } catch (InterruptedException ex) {
                                    runL6.QuitProgram();
                                    showMessageError();
                                }
                            }
                            runL6.QuitProgram();
                            JOptionPane.showMessageDialog(null, "Đã chạy xong!");
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
        panel.setLayout(new GridLayout(5, 10)); // Hai dòng, một cột


        panel.add(checkBoxCreateStudent, BorderLayout.NORTH);
        panel.add(checkBoxAddPackageAndOpenSchedule, BorderLayout.CENTER);
        panel.add(CreateClass);
        panel.add(L6, BorderLayout.SOUTH);
        /*panel.add(new JLabel("phần mềm được bản quyền bởi Nguyễn Tuấn Anh"),BorderLayout.CENTER);*/
        // Thêm JPanel vào JFrame
        frame.add(panel, BorderLayout.CENTER);
        // Hiển thị cửa sổ ứng dụng
        frame.setVisible(true);
    }

    public static void showMessageError() {
        JOptionPane.showMessageDialog(null, "Chương trình đã bị lỗi, vui lòng liên hệ admin!");
    }
}
