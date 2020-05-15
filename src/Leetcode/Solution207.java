package Leetcode;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/5/5 12:25
 */
public class Solution207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0) return true;
        int len=prerequisites.length;
        int tmp=len;
        //if(len>=numCourses) return false;
        int[] res=new int[]{prerequisites[0][0],prerequisites[0][1]};
        int i=1;
        while(tmp!=1){
            tmp--;
            for(i=1;i<len;i++){
                if(prerequisites[i][0]==res[1]){
                    res[1]=prerequisites[i][1];
                    prerequisites[i][0]=-1;
                    prerequisites[i][1]=-1;
                    break;
                }
            }
            if(i==len)
                return true;
        }
        if(res[0]==res[1]) return false;
        return true;

    }

    public static void main(String[] args) {
        int[][] arr=new int[][]{{0,1},{0,2},{1,2}};
        System.out.println(canFinish(3,arr));
    }
}
