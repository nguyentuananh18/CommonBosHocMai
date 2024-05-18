package tuanbuffet.javaSwing;

import javax.swing.*;
import java.awt.*;

public class PanelLMS extends JPanel {
    JCheckBox checkBox1 = new JCheckBox("Tạo tài khoản LMS ");
    JCheckBox checkBox2 = new JCheckBox("Kiểm tra tài khoản LMS");
    JCheckBox checkBox3 = new JCheckBox("chờ...");
    JButton Run = new JButton("Run");
    public PanelLMS(){
        setSize(300,500);
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setJPanelTitle();
        add(JPanelTitle);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(Run);
        setLayout(new GridLayout(6,1));
    }
    JPanel JPanelTitle = new JPanel();
    public void setJPanelTitle(){
        JPanelTitle.setBackground(new Color(0x00EAE2));
        JPanelTitle.add(new JLabel("Create Account LMS"));
    }
}
