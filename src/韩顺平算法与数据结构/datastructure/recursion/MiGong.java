package 韩顺平算法与数据结构.datastructure.recursion;

public class MiGong {
    public static void main(String[] args) {
        //设置迷宫局部
        int[][] m=new int[8][7];

        for(int i=0;i<7;i++)
        {
            m[0][i]=1;
            m[7][i]=1;
        }
        for(int j=0;j<8;j++)
        {
            m[j][0]=1;
            m[j][6]=1;
        }
        m[3][1]=m[3][2]=1;
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(m, 1, 1);
        //setWay2(map, 1, 1);

        //输出新的地图, 小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的 地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

    }


    //设置小球的行走路线
    //map:迷宫的路线，ij小球的初始位置
    //int[][]=0:说明还没有该点还没有走；=1；说明是墙；in=2；说明通路可以走，3，表示该点已经走过，但是走不通
    //int[6][5]==2;说明通路已经找到
    //确定小球的行走路线：这个行走策略可以自己来安排。下-》右-》左-上的顺序
    public static boolean setWay(int[][] map,int i,int j) {
        if (map[6][5] == 2) {
            return true;//通路已经找到
        } else {
            if (map[i][j] == 0) {//说明该点还没有走
                map[i][j] = 2;//假设该点可以走的同
                //继续往下走
                if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }

            } else { //map[i][j]=1,2,3
                return false;

            }
        }


    }
}