public class Stick {
    int length;
//    int left=0;
//    int right=1;

    // Stick类的构造器
    public Stick(int length){
        this.length = length;
    }
//    public Stick(int length, int left,int right){
//        this.length = length;
//        this.left = left;
//        this.right = right;
//    }

    // 判断蚂蚁是否掉出
    public void isOutOfRange(int ant_id,int position,int min_pos,int max_pos){
        if(position < min_pos || position > max_pos){
            System.out.println("编号为"+ant_id+"的蚂蚁掉下木杆！");
        }
        else{
            System.out.println("编号为"+ant_id+"的蚂蚁仍在木杆上");
        }
    }
}
