package 左神算法.进阶班一.并查集;

/**
 * 岛问题
 */
public class Islands {

    //单cpu下解决岛问题
//    public static int countIslands(int[][] m)
//    {
//        if(m == null || m[0]==null) //注意这里m[0]==null,
//        {
//            return 0;
//        }
//        int N=m.length;
//        int M=m[0].length;
//        int res=0;
//        for(int i=0;i<N;i++)
//        {
//            for(int j=0;j<M;j++)
//            {
//                if(m[i][i]==1)
//                {
//                    res++;
//                    infect(m,i,j,N,M);
//                }
//            }
//        }
//        return res;
//    }
//单cpu下的
public static int countIslands(int[][] m) {
    if (m == null || m[0] == null) {
        return 0;
    }
    int N = m.length;
    int M = m[0].length;
    int res = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (m[i][j] == 1) {
                res++;
                infect(m, i, j, N, M);
            }
        }
    }
    return res;
}
    //判断是否是相同的岛，如果是，便感染这个元素。即：感染算法
    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }


}
