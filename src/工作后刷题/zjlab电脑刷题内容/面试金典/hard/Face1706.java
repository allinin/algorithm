package 工作后刷题.zjlab电脑刷题内容.面试金典.hard;

/**
 * @Author: ZBL
 * @Date: 2024-01-16  10:57
 * 2出现的次数
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 * <p>
 * 示例:
 * <p>
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 * <p>
 * n <= 10^9
 */
public class Face1706 {

    // TODO
    public int numberOf2sInRange(int n) {
        int ans = 0, time = 0, mod = 0,preMod = 0;
        int origin = n;
        while (n != 0) {
            mod = n % 10;
            n /= 10;
            if (mod != 0) {
                if (time > 0) {
                    ans += mod  * Math.pow(10, time - 1);
                }
                //还有上一位
                if (mod > 2) {
                    ans += Math.pow(10, time);
                }
                if(mod == 2) {
                    ans += (preMod);
                }

            }
            preMod = mod;
            time++;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Face1706().numberOf2sInRange(60));
        try{
            int id = 0;
            while (id < 5) {
                try{
                    try{
                        System.out.println(1 / 0);
                    }catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }finally {
                        System.out.println("first finally");
                        id++;
                    }
                }  finally{
                    System.out.println("second finally..");
                }
            }
            System.out.println("----------------");
        }finally {
            System.out.println("last finally");
        }
    }
}
