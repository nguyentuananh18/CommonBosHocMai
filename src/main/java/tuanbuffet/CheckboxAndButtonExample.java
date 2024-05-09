package tuanbuffet;
import javax.swing.*;
import java.awt.*;

public class CheckboxAndButtonExample {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Checkbox and Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Tạo JPanel để chứa các thành phần
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Tạo 3 checkbox
        JCheckBox checkBox1 = new JCheckBox("Option 1");
        JCheckBox checkBox2 = new JCheckBox("Option 2");
        JCheckBox checkBox3 = new JCheckBox("Option 3");
        JButton button = new JButton("Click me!");

        // Thêm checkbox vào JPanel
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(button);



        // Thêm JPanel vào JFrame
        frame.add(panel);

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
