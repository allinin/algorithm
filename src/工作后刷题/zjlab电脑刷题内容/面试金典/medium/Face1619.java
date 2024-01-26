package 工作后刷题.zjlab电脑刷题内容.面试金典.medium;

import java.util.*;

/**
 * @Author: ZBL
 * @Date: 2024-01-15  11:13
 * 水域大小
 * 你有一个用于表示一片土地的整数矩阵land，
 * 该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。
 * 由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 */
public class Face1619 {

    List<Integer> list = new ArrayList<>();

    public int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    list.add(process(i, j, land));
                }
            }
        }
        int[] ans = new int[list.size()];
        int idx = 0;
        for(int num : list) {
            ans[idx++] = num;
        }
        Arrays.sort(ans);
        return ans;
    }

    private int process(int i, int j, int[][] land) {
        if(i < 0 || j < 0 || i >= land.length || j >= land[0].length || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = 1;
        int res = 1;
        res += process(i + 1,j,land);
        res += process(i - 1,j,land);
        res += process(i,j + 1,land);
        res += process(i,j - 1,land);
        res += process(i - 1,j - 1,land);
        res += process(i + 1,j + 1,land);
        res += process(i - 1,j + 1,land);
        res += process(i + 1,j - 1,land);
        return res;
    }


}
