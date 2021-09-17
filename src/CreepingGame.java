import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int i1 = ((Ant)o1).position;
        int i2 = ((Ant)o2).position;
        return Integer.compare(i1, i2);
    }
}


public class CreepingGame {

    //属性
    int tick = 0;
    private Stick stick; // 一根杆
    private ArrayList<Ant> onAnts;// 还在杆上的蚂蚁们
    //private ArrayList<Ant> fallenAnts;  掉了的蚂蚁们
    private int curClock;
    public boolean ifEnd;


    //每局游戏开始
    public int play(ArrayList<Ant> ants,Stick stick){
        //一局游戏需要传入的数据只有dir
        curClock = 0;
        onAnts=ants;
        while(onAnts.size()!=0){
            //判断哪些蚂蚁在杆上
            for(int i=0;i<onAnts.size();i++){
                if(onAnts.get(i).position<=0 || onAnts.get(i).position>=stick.length)
                    onAnts.remove(i);
            }
            drive(onAnts);
            curClock++;
        }
        return curClock;
    }

    //每走一步，drive一次
    public void drive(ArrayList<Ant> ants){
        //不知道这段代码写的有没有问题哈！
        //先排序，按postion排
        Collections.sort(ants,new MyComparator());
        System.out.println(ants);
        //让所有蚂蚁先移动
        for (Ant ant : ants) {
            ant.creeping();
        }
        ArrayList<Integer> c1 =new ArrayList<>();
        ArrayList<Integer> c2 =new ArrayList<>();
        for(int i = 0; i<ants.size()-1; i++){
            int j = i + 1;
                int distance = ants.get(j).position-ants.get(i).position;
                if(ants.get(i).direction==1 && ants.get(j).direction==-1 && distance<=0){
                    //左边的蚂蚁向左，右边的蚂蚁向右，distance为负数会撞
                    //同位置会撞
                    if(distance==0){
                        c1.add(i);
                        c1.add(j);
                    }
                    else {
                        c2.add(i);
                        c2.add(j);
                    }
            }
        }
        //恢复撞的蚂蚁到正确的位置
        for(int i = 0;i < c1.size();i++) {
            ants.get(i).collision_1();
        }
        for(int i = 0;i < c2.size();i++) {
            ants.get(i).collision_2();
        }
    }
}
