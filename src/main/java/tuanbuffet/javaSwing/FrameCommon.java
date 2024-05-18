package tuanbuffet.javaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCommon extends JFrame {
    public FrameCommon(){
        super("Auto tổng hợp :)))");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(0xB6B9BD));
        setLocationRelativeTo(null);
        setSize(1200, 500);
        setLayout(new GridLayout(1,4));
        add(new PanelL6());
        add(new PanelLMS());
        add(new PanelOpenSchedule());
        add(new PanelDeleteStudentAskForLeave());
    }
    public static void main(String[] args) {
        PanelL6 panelL6 = new PanelL6();
        PanelOpenSchedule panelOpenSchedule = new PanelOpenSchedule();
        SwingUtilities.invokeLater(FrameCommon::new);
        panelL6.Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelL6.evenClick();
            }
        });
        panelOpenSchedule.Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelOpenSchedule.eventClick();
            }
        });
    }
}
