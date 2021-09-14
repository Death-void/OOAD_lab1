import java.util.ArrayList;

public class CreepingGame {
    int tick = 0;



    public void drive(ArrayList<Ant> ants){
        //先排序，按postion排
        //让所有蚂蚁先移动
        for(int i = 0; i<ants.size(); i++){
            ants.get(i).creeping();
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
