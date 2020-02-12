package 左神算法.基础班.第四课;

public class PageFolding {

    public static void printAllFolds(int N){
        printProcess(1,N,true);
    }
    //i表示是第几次打印，N表示是一共几次折，down表示是否是往下
    public static void printProcess(int i,int N,boolean down)
    {
        if(i>N)
            return;
        printProcess(i+1,N,true);
        System.out.println(down?"下":"上");
        printProcess(i+1,N,false);
    }
    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);

    }
}
