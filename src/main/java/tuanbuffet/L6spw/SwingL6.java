package tuanbuffet.L6spw;

import tuanbuffet.L6spw.commonL6.Teacher;
import tuanbuffet.L6spw.commonL6.TeacherData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import static tuanbuffet.common.StringProcessing.*;

public class SwingL6 {

    public static void main(String[] args) {
        // Tạo một JFrame (cửa sổ ứng dụng)
        JFrame frame = new JFrame("Auto BOS Học Mãi !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(1, 1));
        JCheckBox checkBoxCreateStudent = new JCheckBox("Tạo Học Viên L6");
        JCheckBox checkBoxAddPackageAndOpenSchedule = new JCheckBox("Thêm gói và mở thời gian biểu");
        JCheckBox CreateClass = new JCheckBox();
        CreateClass.setText("Tạo lớp học L6 SpeakWell");
        JTextField thread = new JTextField(15);
        JPanel panelThread = new JPanel();
        panelThread.setLayout(new GridLayout(1, 2));
        panelThread.add(new JLabel("Số luồng chạy: "));
        panelThread.add(thread);

        JPanel panelLeft = new JPanel();
        panelLeft.add(checkBoxCreateStudent);
        panelLeft.add(checkBoxAddPackageAndOpenSchedule);
        panelLeft.add(CreateClass);
        panelLeft.setLayout(new GridLayout(5, 1));

        JButton L6 = new JButton("Run L6");
        JCheckBox loadTeacherCheckBox = new JCheckBox("Lấy dữ liệu giáo viên");
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new GridLayout(3, 1));
        panelRight.add(loadTeacherCheckBox);
        panelRight.add(panelThread);
        panelRight.add(L6);

        panelRight.setBorder(BorderFactory.createEmptyBorder(10, 0, 130, 10));

        LocalDate givenDate = LocalDate.of(2024, 6, 10);
        LocalDate currentDate = LocalDate.now();
        boolean isFuture = givenDate.isAfter(currentDate);

        L6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFuture) {
                    try {
                        if (!checkBoxCreateStudent.isSelected() && !checkBoxAddPackageAndOpenSchedule.isSelected() && !CreateClass.isSelected()) {
                            if (loadTeacherCheckBox.isSelected()) {
                                TeacherData data = new TeacherData();
                                data.UpTeacherOnFile();
                            } else {
                                JOptionPane.showMessageDialog(null, "Vui lòng tick vào lựa chọn bạn muốn thực hiện!!!");
                            }
                        }
                        else {
                            if (thread.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập ô số luồng");
                            }
                            else {
                                if (loadTeacherCheckBox.isSelected()) {
                                    TeacherData data = new TeacherData();
                                    data.UpTeacherOnFile();
                                }
                                    try {
                                        int numberThread = Integer.parseInt(thread.getText());
                                        String work = "";
                                        if (checkBoxCreateStudent.isSelected()) {
                                            work += "createStudent";
                                        }
                                        if (checkBoxAddPackageAndOpenSchedule.isSelected()) {
                                            work += "addPackageAndOpenSchedule";
                                        }
                                        if (CreateClass.isSelected()) {
                                            work += "createClass";
                                        }
                                        Teacher teacher = new Teacher();
                                        List<Teacher> listTeacherData = teacher.getListTeacher();
                                        Thread[] threads = new Thread[numberThread];
                                        for (int i = 1; i <= numberThread; i++) {
                                            threads[i-1] = new Thread(new RunL6(i, numberThread, work,listTeacherData));
                                            try {
                                                threads[i-1].start();
                                                sleep(3);
                                            } catch (Exception ex) {
                                                showMessageError();
                                            }
                                        }
                                        for (Thread thread : threads){
                                            try {
                                                thread.join(); // Chờ luồng kết thúc
                                            } catch (InterruptedException ignored) {
                                            }
                                        }
                                        JOptionPane.showMessageDialog(null, "Đã chạy xong");
                                    } catch (Exception e1) {
                                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng!");
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

        panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
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
