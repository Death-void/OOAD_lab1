import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayRoom {
    public static int incTime = 1;
    public static int maxTime = 0;
    public static int minTime = Integer.MAX_VALUE;
    private static void createGUI()
    {
        MyFrame frame = new MyFrame("Creeping Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1600,800);
        frame.setLocation(200,200);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                createGUI();
                //最终结果输出
            }
        });
    }
    public static void start(int stickLength,int antCount,int antSpeed,ArrayList<Integer> pos){
        //此处需要初始化pos，velocity，stick长度length,蚂蚁的数量；
        Scanner input=new Scanner(System.in);
//        //1.输入stick长度
//        System.out.println("请输入木杆的长度：\n");
//        int stickLength = input.nextInt();
        Stick stick=new Stick(stickLength);
//        //2.输入蚂蚁数量
//        System.out.println("请输入蚂蚁的数量：\n");
//        int antCount = input.nextInt();
//        //3.输入蚂蚁的速度
//        System.out.println("请输入蚂蚁的速度：\n");
//        int antSpeed = input.nextInt();
        //4.输入蚂蚁的位置

//        System.out.println("请输入蚂蚁的位置：\n");
//        ArrayList<Integer> pos  = new ArrayList<>();
//        for(int x=0;x<antCount;x++){
//            pos.add(input.nextInt());
//        }
        //5.枚举每局游戏
        for(int i = 0; i<Math.pow(2,antCount); i++){
            //6.自动初始化方向
            ArrayList<Integer> dir = buildDirection(antCount,i);
            //7.初始化蚂蚁
            ArrayList<Ant> ants = new ArrayList<>();
            for(int j=0;j<antCount;j++){
                ants.add(new Ant(j+1,pos.get(j),dir.get(j),antSpeed));
            }
            CreepingGame game = new CreepingGame();
            int tick = game.play(ants,stick);
            System.out.println("本次用时："+tick*incTime);
            if(tick * incTime < minTime){
                minTime = tick * incTime;
            }
            if(tick * incTime > maxTime){
                maxTime = tick * incTime;
            }
        }
        System.out.println("maxtime:"+maxTime);
        System.out.println("mintime:"+minTime);
    }
    static ArrayList<Integer> buildDirection(int antCount,int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < antCount; i++){
            if((n^0) == 0){
                res.add(1);
            }
            else
                res.add(-1);
            n=n>>>1;
        }
        return res;
    }
}
