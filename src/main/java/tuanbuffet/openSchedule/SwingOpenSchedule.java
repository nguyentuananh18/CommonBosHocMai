package tuanbuffet.openSchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class SwingOpenSchedule {

    public static void main(String[] args) {
        // Tạo một JFrame (cửa sổ ứng dụng)
        JFrame frame = new JFrame("Auto BOS Học Mãi !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);
        JTextField DayofStart = new JTextField(15);
        JTextField JText_numberDay = new JTextField(15);
        JTextField thread = new JTextField(15);
        JCheckBox checkBoxEsOld = new JCheckBox();
        checkBoxEsOld.setText("ESP - EasySpeak");
        JCheckBox checkBoxEsNew = new JCheckBox();
        checkBoxEsNew.setText("ESP24FAMX - Easy Speak For Adults Mix");
        JButton openButton = new JButton("Run");

        LocalDate givenDate = LocalDate.of(2024, 6, 10);
        LocalDate currentDate = LocalDate.now();
        boolean isFuture = givenDate.isAfter(currentDate);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (isFuture) {
                    // Xử lý sự kiện khi nút được nhấn
                    if (!checkBoxEsOld.isSelected() && !checkBoxEsNew.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng tick 1 trong 2 lựa chọn trên trước khi chạy!");
                    } else {
                        if (DayofStart.getText().isEmpty() || JText_numberDay.getText().isEmpty() || thread.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Điền đủ 3 trường input trước khi chạy!");
                        } else {
                            int numberThread = Integer.parseInt(thread.getText());
                            int numberDay = Integer.parseInt(JText_numberDay.getText());

                            //Trường hợp chỉ tick checkbox chạy ES old
                            if (checkBoxEsOld.isSelected() && !checkBoxEsNew.isSelected()) {
                                System.out.println("Chạy cũ");
                                for (int i = 0; i < numberThread; i++) {
                                    Thread thread = new Thread(new InformationEasySpeak(i, numberThread, numberDay, DayofStart.getText(), "Old", i * 240));
                                    try {
                                        thread.start();
                                        Thread.sleep(500);
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Điền đúng trường dữ liệu trước khi chạy");
                                    }
                                }
                            }

                            //Trường hợp chỉ tick checkbox chạy ES new
                            else if (!checkBoxEsOld.isSelected() && checkBoxEsNew.isSelected()) {
                                System.out.println("Chạy mới");
                                for (int i = 0; i < numberThread; i++) {
                                    Thread thread = new Thread(new InformationEasySpeak(i, numberThread, numberDay, DayofStart.getText(), "New", i * 240));
                                    try {
                                        thread.start();
                                        Thread.sleep(500);
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Điền đúng trường dữ liệu trước khi chạy");
                                    }
                                }

                            }
                            //Trường hợp chỉ tick cả 2 checkbox old và new
                            else {
                                System.out.println("Chạy cả");
                                for (int i = 0; i < numberThread; i++) {
                                    Thread thread = new Thread(new InformationEasySpeak(i, numberThread, numberDay, DayofStart.getText(), "All", i * 240));
                                    try {
                                        thread.start();
                                        Thread.sleep(500);
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Điền đúng trường dữ liệu trước khi chạy");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chương trình đã bị lỗi, vui lòng liên hệ admin!");
                }
            }
        });
        //panel startDay
        JPanel Jpanel_Option = new JPanel();
        Jpanel_Option.setLayout(new GridLayout(3, 1));
        Jpanel_Option.add(checkBoxEsOld);
        Jpanel_Option.add(checkBoxEsNew);

        JPanel JPanel_Config = new JPanel();
        JPanel_Config.setLayout(new GridLayout(3, 2));
        JPanel_Config.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 65));
        JPanel_Config.add(new JLabel("Ngày bắt đầu dd/MM/yyyy: "));
        JPanel_Config.add(DayofStart);
        JPanel_Config.add(new JLabel("Số ngày chạy: "));
        JPanel_Config.add(JText_numberDay);
        JPanel_Config.add(new JLabel("Số luồng chạy (max = 7): "));
        JPanel_Config.add(thread);

        JPanel JPanel_Run = new JPanel();
        JPanel_Run.setLayout(new GridLayout(1, 1));
        JPanel_Run.setBorder(BorderFactory.createEmptyBorder(50, 150, 0, 150));
        JPanel_Run.add(openButton);

        JPanel JPanel_bottom = new JPanel();
        JPanel_bottom.setLayout(new FlowLayout());
        JPanel_bottom.add(new JLabel("The software is designed by Tuan Anh"));
        JPanel_bottom.setBorder(BorderFactory.createEmptyBorder(35, 5, 10, 5));
        // Thêm các nút vào JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // Hai dòng, một cột
        panel.add(Jpanel_Option);
        panel.add(JPanel_Config);
        panel.add(JPanel_Run);
        panel.add(JPanel_bottom);
        frame.setLayout(new GridLayout(1, 2));

        frame.add(panel);
        // Hiển thị cửa sổ ứng dụng
        frame.setVisible(true);
    }
}
