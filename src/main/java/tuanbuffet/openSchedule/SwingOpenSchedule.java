package tuanbuffet.openSchedule;

import tuanbuffet.common.PassWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class SwingOpenSchedule {

    public static void main(String[] args) {
        // Tạo một JFrame (cửa sổ ứng dụng)
        JFrame frame = new JFrame("Auto BOS Học Mãi !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(258, 300);
        frame.setLocationRelativeTo(null);

        JTextField DayofStart = new JTextField(15);
        JTextField numberDay = new JTextField(15);

        JCheckBox checkBoxEsOld = new JCheckBox();
        checkBoxEsOld.setText("ESP - EasySpeak");
        JCheckBox checkBoxEsNew = new JCheckBox();
        checkBoxEsNew.setText("ESP24FAMX - Easy Speak For Adults Mix");

        JButton OpenSchedule = new JButton("Run");
        OpenSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Xử lý sự kiện khi nút được nhấn

                if (!checkBoxEsOld.isSelected() && !checkBoxEsNew.isSelected()){
                    JOptionPane.showMessageDialog(null, "Đù má, không tick vào checkbox kia thì chạy kiểu gì:)))");
                }
                else {
                    if (DayofStart.getText().isEmpty() ||  numberDay.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Điền đủ 2 ô input kia tao mới chạy được chớ:)))");
                    }
                    else {
                        if (checkBoxEsOld.isSelected() && !checkBoxEsNew.isSelected()) {
                            PassWord passWord = new PassWord();
                            String passWeb = passWord.CheckPassWord();
                            String passOutput = JOptionPane.showInputDialog(null, "Nhập mật khẩu:");
                            for (int i = 0; i <= 2; i++) {
                                if (i == 2) {
                                    JOptionPane.showMessageDialog(null, "Bạn đã nhập sai quá 3 lần!!!");
                                }
                                if (passWeb.equals(passOutput)) {
                                    InformationEasySpeak informationEasySpeak = new InformationEasySpeak();
                                    try {
                                        informationEasySpeak.runEsOld(DayofStart.getText(), Integer.parseInt(numberDay.getText()));
                                        JOptionPane.showMessageDialog(null, "Đã chạy xong!");
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Đù má, điền đúng trường dữ liệu giúp tôi, huhu:)))");
                                    }

                                    break;
                                } else {
                                    passWeb = passWord.CheckPassWord();
                                    passOutput = JOptionPane.showInputDialog(null, "Mật khẩu không đúng, vui lòng nhập lại:");
                                }
                            }

                        }
                        else if (!checkBoxEsOld.isSelected() && checkBoxEsNew.isSelected()) {


                            PassWord passWord = new PassWord();
                            String passWeb = passWord.CheckPassWord();
                            String passOutput = JOptionPane.showInputDialog(null, "Nhập mật khẩu:");
                            for (int i = 0; i <= 2; i++) {
                                if (i == 2) {
                                    JOptionPane.showMessageDialog(null, "Bạn đã nhập sai quá 3 lần!!!");
                                }
                                if (passWeb.equals(passOutput)) {

                                    InformationEasySpeak informationEasySpeak = new InformationEasySpeak();
                                    try {
                                        informationEasySpeak.runEsNew(DayofStart.getText(), Integer.parseInt(numberDay.getText()));
                                        JOptionPane.showMessageDialog(null, "Đã chạy xong!");
                                    }catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Đù má, điền đúng trường dữ liệu giúp tôi, huhu:)))");
                                }
                                    break;
                                } else {
                                    passWeb = passWord.CheckPassWord();
                                    passOutput = JOptionPane.showInputDialog(null, "Mật khẩu không đúng, vui lòng nhập lại:");
                                }
                            }


                        }
                        else {
                            PassWord passWord = new PassWord();
                            String passWeb = passWord.CheckPassWord();
                            String passOutput = JOptionPane.showInputDialog(null, "Nhập mật khẩu:");
                            for (int i = 0; i <= 2; i++) {
                                if (passWeb.equals(passOutput)) {
                                    InformationEasySpeak informationEasySpeak = new InformationEasySpeak();
                                    try {
                                        informationEasySpeak.runEsOld(DayofStart.getText(), Integer.parseInt(numberDay.getText()));
                                        informationEasySpeak.runEsNew(DayofStart.getText(), Integer.parseInt(numberDay.getText()));
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Đù má, điền đúng trường dữ liệu giúp tôi, huhu:)))");
                                    }
                                    JOptionPane.showMessageDialog(null, "Đã chạy xong!");
                                    break;
                                } else {
                                    if (i == 2) {
                                        JOptionPane.showMessageDialog(null, "Bạn đã nhập sai quá 3 lần!!!");
                                    } else {
                                        passWeb = passWord.CheckPassWord();
                                        passOutput = JOptionPane.showInputDialog(null, "Mật khẩu không đúng, vui lòng nhập lại:");
                                    }
                                }
                            }

                        }
                    }
                }

            }
        });
        // Thêm các nút vào JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2)); // Hai dòng, một cột

        panel.add(checkBoxEsOld, BorderLayout.NORTH);
        panel.add(checkBoxEsNew, BorderLayout.CENTER);
        panel.add(new JLabel("Ngày bắt đầu dd/MM/yyyy: "));
        panel.add(DayofStart);
        panel.add(new JLabel("Số ngày chạy: "));
        panel.add(numberDay);
        panel.add(OpenSchedule, BorderLayout.SOUTH);
        panel.add(new JLabel("The software is copyrighted by TuanBuffet"), BorderLayout.CENTER);
        ////
        frame.setLayout(new GridLayout(1,2));
        // Thêm JPanel vào JFrame
        frame.add(panel);
        // Hiển thị cửa sổ ứng dụng
        frame.setVisible(true);
    }
}
