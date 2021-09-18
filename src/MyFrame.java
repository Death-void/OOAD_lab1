import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    public MyFrame(String title) throws HeadlessException {
        super(title);
        JLabel label1 = new JLabel("蚂蚁数量");
        JTextField antCount = new JTextField(10);
        JLabel label2 = new JLabel("蚂蚁速度");
        JTextField antSpeed = new JTextField(10);
        JLabel label3 = new JLabel("木杆长度");
        JTextField stickLength = new JTextField(10);
        JLabel label4 = new JLabel("蚂蚁位置");
        JTextField antPosition = new JTextField(30);
        JButton start = new JButton("开始");
        //内容面板
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        //添加控件
        contentPane.add(label3);contentPane.add(stickLength);
        contentPane.add(label1);contentPane.add(antCount);
        contentPane.add(label2);contentPane.add(antSpeed);
        contentPane.add(label4);contentPane.add(antPosition);
        contentPane.add(start);
        //创建监听器
        //匿名内部类
        start.addActionListener((e)->{
            int length = Integer.parseInt(stickLength.getText());
            int num = Integer.parseInt(antCount.getText());
            int speed = Integer.parseInt(antSpeed.getText());
            String[] str = antPosition.getText().split(" ");
            ArrayList<Integer> pos = new ArrayList<>();
            for(int i=0;i<num;i++){
                pos.add(Integer.parseInt(str[i]));
            }
           if(length!=0&&num!=0&&speed!=0){
               PlayRoom.start(length,num,speed,pos);
           }
        });
    }

}
