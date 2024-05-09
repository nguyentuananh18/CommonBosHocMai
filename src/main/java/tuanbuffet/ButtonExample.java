package tuanbuffet;

import tuanbuffet.L6spw.Main;
import tuanbuffet.common.PassWord;
import tuanbuffet.openSchedule.InformationEasySpeak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ButtonExample {

    public static void main(String[] args) {
        // Tạo một JFrame (cửa sổ ứng dụng)
        JFrame frame = new JFrame("Auto BOS Học Mãi !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        JTextField DayofStart = new JTextField(15);
        JTextField numberDay = new JTextField(15);


        JCheckBox checkBoxEsOld = new JCheckBox();
        checkBoxEsOld.setText("ESP - EasySpeak");
        JCheckBox checkBoxEsNew = new JCheckBox();
        checkBoxEsNew.setText("ESP24FAMX - Easy Speak For Adults Mix");
        // Tạo một JButton với văn bản "Click Me"
        JButton L6 = new JButton("Run L6");
        /*L6.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));*/
        L6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Xử lý sự kiện khi nút được nhấn
                Main main = new Main();
                try {
                    main.RUN();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,"Đã chạy xong!");
            }
        });
        JButton OpenSchedule = new JButton("Run");
        OpenSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Xử lý sự kiện khi nút được nhấn
                if (checkBoxEsOld.isSelected() && !checkBoxEsNew.isSelected()){

                    PassWord passWord = new PassWord();
                    String passWeb = passWord.CheckPassWord();
                    String passOutput = JOptionPane.showInputDialog(null,"Nhập mật khẩu:");
                    for (int i = 0 ; i <= 2 ; i++){
                        if (i==2){
                            JOptionPane.showMessageDialog(null,"Bạn đã nhập sai quá 3 lần!!!");
                        }
                        if (passWeb.equals(passOutput)){
                            InformationEasySpeak informationEasySpeak = new InformationEasySpeak();
                            try {
                                informationEasySpeak.runEsOld(DayofStart.getText(),Integer.parseInt(numberDay.getText()));
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(null,"Đã chạy xong!");
                            break;
                        }
                        else {
                            passWeb = passWord.CheckPassWord();
                            passOutput = JOptionPane.showInputDialog(null,"Mật khẩu không đúng, vui lòng nhập lại:");
                        }
                    }

                }
                else if (!checkBoxEsOld.isSelected() && checkBoxEsNew.isSelected()){


                    PassWord passWord = new PassWord();
                    String passWeb = passWord.CheckPassWord();
                    String passOutput = JOptionPane.showInputDialog(null,"Nhập mật khẩu:");
                    for (int i = 0 ; i <= 2 ; i++){
                        if (i==2){
                            JOptionPane.showMessageDialog(null,"Bạn đã nhập sai quá 3 lần!!!");
                        }
                        if (passWeb.equals(passOutput)){

                            InformationEasySpeak informationEasySpeak = new InformationEasySpeak();
                            try {
                                informationEasySpeak.runEsNew(DayofStart.getText(),Integer.parseInt(numberDay.getText()));
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(null,"Đã chạy xong!");
                            break;
                        }
                        else {
                            passWeb = passWord.CheckPassWord();
                            passOutput = JOptionPane.showInputDialog(null,"Mật khẩu không đúng, vui lòng nhập lại:");
                        }
                    }



                }
                else if (checkBoxEsOld.isSelected() && checkBoxEsNew.isSelected()){


                    PassWord passWord = new PassWord();
                    String passWeb = passWord.CheckPassWord();
                    String passOutput = JOptionPane.showInputDialog(null,"Nhập mật khẩu:");
                    for (int i = 0 ; i <= 2 ; i++){
                        if (passWeb.equals(passOutput)){
                            InformationEasySpeak informationEasySpeak = new InformationEasySpeak();
                            try {
                                informationEasySpeak.runEsOld(DayofStart.getText(),Integer.parseInt(numberDay.getText()));
                                informationEasySpeak.runEsNew(DayofStart.getText(),Integer.parseInt(numberDay.getText()));
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }
                            JOptionPane.showMessageDialog(null,"Đã chạy xong!");
                            break;
                        }
                        else {
                            if (i==2){
                                JOptionPane.showMessageDialog(null,"Bạn đã nhập sai quá 3 lần!!!");
                            }
                            else {
                                passWeb = passWord.CheckPassWord();
                                passOutput = JOptionPane.showInputDialog(null,"Mật khẩu không đúng, vui lòng nhập lại:");
                            }

                        }
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null,"Đù má, không tick vào checkbox kia thì chạy kiểu gì:)))");
                }
            }
        });
        // Thêm các nút vào JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2)); // Hai dòng, một cột


        panel.add(checkBoxEsOld, BorderLayout.NORTH);
        panel.add(checkBoxEsNew,BorderLayout.CENTER);
        panel.add(new JLabel("Ngày bắt đầu: "));
        panel.add(DayofStart);
        panel.add(new JLabel("Số ngày chạy: "));
        panel.add(numberDay);
        panel.add(OpenSchedule, BorderLayout.SOUTH);
        panel.add(new JLabel("phần mềm được bản quyền bởi Nguyễn Tuấn Anh"),BorderLayout.CENTER);
        ////

        // Thêm JPanel vào JFrame
        frame.add(panel, BorderLayout.CENTER);
        // Hiển thị cửa sổ ứng dụng
        frame.setVisible(true);
    }
}
