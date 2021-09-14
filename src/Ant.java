public class Ant {
    int id=0;//编号
    int velocity=5;
    int position=-1;//初始化为-1
    int direction=0;//1是右，-1是左，0是出局

    public Ant(int id, int position, int direction) {
        this.id = id;
        this.position = position;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void creeping(){
        position+=velocity*direction;
    }

    public void changeDirection(){
        this.direction=this.direction*-1;
    }

    public void collision_1(){
        //两只蚂蚁相隔2*velocity cm，直接变向，不用移动
        changeDirection();
    }

    public void collision_2(){
        //相隔velocity cm，先掉头，再走回原来的位置，相当于恢复到正确
        changeDirection();
        creeping();
    }
}
