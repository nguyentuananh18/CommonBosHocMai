package tuanbuffet.javaSwing;

import tuanbuffet.L6spw.RunL6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelL6 extends JPanel {
    static JCheckBox checkBoxCreateStudent = new JCheckBox("Tạo tài khoản học viên L6");
    static JCheckBox checkBoxAddPackageAndOpenSchedule = new JCheckBox("Thêm gói và mở thời gian biểu");
    static JCheckBox CreateClass = new JCheckBox("Tạo lớp học L6");
    static JButton Run = new JButton("Run");

    public PanelL6() {
        setSize(300, 500);
        setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 20));
        setLayout(new GridLayout(6, 1));
        setJPanelTitle();
        add(JPanelTitle);
        add(checkBoxCreateStudent);
        add(checkBoxAddPackageAndOpenSchedule);
        add(CreateClass);
        add(Run);
    }

    JPanel JPanelTitle = new JPanel();

    public void setJPanelTitle() {
        JPanelTitle.setBackground(new Color(0x08EA00));
        JPanelTitle.add(new JLabel("Create class L6"));
    }

    public void evenClick() {
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
            showMessageError();

        }
    }

    public static void showMessageError() {
        JOptionPane.showMessageDialog(null, "Chương trình đã bị lỗi, vui lòng liên hệ admin!");
    }

    public static void main(String[] args) {
        JFrame abc = new JFrame("abc");
        abc.add(new PanelL6());
        abc.setLocationRelativeTo(null);
        abc.setVisible(true);
        Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelL6 panelL6 = new PanelL6();
                panelL6.evenClick();
            }
        });
    }

}
