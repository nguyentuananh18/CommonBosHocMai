package tuanbuffet.javaSwing;

import tuanbuffet.openSchedule.InformationEasySpeak;

import javax.swing.*;
import java.awt.*;

public class PanelOpenSchedule extends JPanel {
    static JCheckBox checkBoxEsOld = new JCheckBox("ESP - EasySpeak");
    static JCheckBox checkBoxEsNew = new JCheckBox("ESP24FAMX - Easy Speak For Adults Mix");
    JCheckBox checkBox3 = new JCheckBox("Chờ...");
    static JButton Run = new JButton("Run");
    public PanelOpenSchedule(){
        setSize(300,500);
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setJPanelTitle();
        add(JPanelTitle);
        add(checkBoxEsOld);
        add(checkBoxEsNew);
        add(JPanelContent);
        setJPanelContent();
        add(Run);
        setLayout(new GridLayout(6,1));
    }
    JPanel JPanelTitle = new JPanel();
    public void setJPanelTitle(){
        JPanelTitle.setBackground(new Color(0xEACB00));
        JPanelTitle.add(new JLabel("Auto Open Schedule"),BorderLayout.CENTER);
    }
    JPanel JPanelContent = new JPanel();
    static JTextField DayofStart = new JTextField(15);
    static JTextField numberDay = new JTextField(15);
    public void setJPanelContent(){
        JPanelContent.setLayout(new GridLayout(2,2));
        JPanelContent.add(new JLabel("Ngày bắt đầu dd/MM/yyyy: "));
        JPanelContent.add(DayofStart);
        JPanelContent.add(new JLabel("Số ngày chạy: "));
        JPanelContent.add(numberDay);
    }
    public void eventClick() {

        InformationEasySpeak informationEasySpeak = new InformationEasySpeak(1,1,10,"2222","abc",111);
        if (!checkBoxEsOld.isSelected() && !checkBoxEsNew.isSelected()){
            JOptionPane.showMessageDialog(null, "Đù má, không tick vào checkbox kia thì chạy kiểu gì:)))");
        }
        else {
            if (DayofStart.getText().isEmpty() ||  numberDay.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Điền đủ 2 ô input kia tao mới chạy được chớ:)))");
            }
            else {
                /*Nếu chỉ chọn ES cũ*/
                if (checkBoxEsOld.isSelected() && !checkBoxEsNew.isSelected()) {
                            try {
                                informationEasySpeak.runEsOld();
                                JOptionPane.showMessageDialog(null, "Đã chạy xong!");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Đù má, điền đúng trường dữ liệu giúp tôi, huhu:))) 1 ");
                            }
                }
                /*Nếu chỉ chọn ES mới*/
                else if (!checkBoxEsOld.isSelected() && checkBoxEsNew.isSelected()) {
                            try {
                                informationEasySpeak.runEsNew();
                                JOptionPane.showMessageDialog(null, "Đã chạy xong!");
                            }catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Đù má, điền đúng trường dữ liệu giúp tôi, huhu:))) 2");
                            }
                }
                /*Nếu chọn cả 2*/
                else {
                            try {
                                informationEasySpeak.runEsOld();
                                informationEasySpeak.runEsNew();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Đù má, điền đúng trường dữ liệu giúp tôi, huhu:))) 3");
                            }
                            JOptionPane.showMessageDialog(null, "Đã chạy xong!");
                }
            }
        }

    }
}
