package tuanbuffet.javaSwing;

import javax.swing.*;
import java.awt.*;

public class PanelDeleteStudentAskForLeave extends JPanel {
    JCheckBox checkBox1 = new JCheckBox("Xóa học viên xin nghỉ:)))");
    JCheckBox checkBox2 = new JCheckBox("Thêm gói và mở thời gian biểu");
    JCheckBox checkBox3 = new JCheckBox("Tạo lớp học L6");
    JButton Run = new JButton("Run");
    public PanelDeleteStudentAskForLeave(){
        setSize(300,500);
        setLayout(new GridLayout(6,1));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 40));
        setJPanelTitle();
        add(JPanelTitle);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(Run);
    }
    JPanel JPanelTitle = new JPanel();
    public void setJPanelTitle(){
        JPanelTitle.setBackground(new Color(0xEA5200));
        JPanelTitle.add(new JLabel("Delete absent students"));
    }
}
