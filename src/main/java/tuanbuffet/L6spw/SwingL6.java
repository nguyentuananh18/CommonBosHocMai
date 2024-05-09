package tuanbuffet.L6spw;

import tuanbuffet.common.PassWord;
import tuanbuffet.openSchedule.InformationEasySpeak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
        L6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkBoxCreateStudent.isSelected() && !checkBoxAddPackageAndOpenSchedule.isSelected() && !CreateClass.isSelected()){
                    JOptionPane.showMessageDialog(null,"Đù, không chọn chạy cái nào thì biết chạy cái nào, tick nó đi chớ!!!");
                }
                else {
                    Main main = new Main();
                    try {
                        main.Setup();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (checkBoxCreateStudent.isSelected()){

                        main.CreateStudent();
                    }
                    if (checkBoxAddPackageAndOpenSchedule.isSelected()){

                        main.AddPackageAndOpenSchedule();
                    }
                    if (CreateClass.isSelected()){

                        try {
                            main.CreateClass();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    JOptionPane.showMessageDialog(null,"Đã chạy xong!");
                }

            }
        });
        // Thêm các nút vào JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 10)); // Hai dòng, một cột


        panel.add(checkBoxCreateStudent, BorderLayout.NORTH);
        panel.add(checkBoxAddPackageAndOpenSchedule,BorderLayout.CENTER);
        panel.add(CreateClass);
        panel.add(L6, BorderLayout.SOUTH);
        /*panel.add(new JLabel("phần mềm được bản quyền bởi Nguyễn Tuấn Anh"),BorderLayout.CENTER);*/
        // Thêm JPanel vào JFrame
        frame.add(panel, BorderLayout.CENTER);
        // Hiển thị cửa sổ ứng dụng
        frame.setVisible(true);
    }
}
