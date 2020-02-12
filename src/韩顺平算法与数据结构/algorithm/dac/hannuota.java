package 韩顺平算法与数据结构.algorithm.dac;

public class hannuota {

    public static void main(String[] args) {
       hannuota(5, 'A', 'B', 'C');
    }

    public static void hannuota(int num,char a,char b,char c)
    {
        if(num==1)
        {
            System.out.println("第一个盘子从："+a+"->"+c);
        }else {
            //将前num-1个盘子看做是一个盘子，最下面的看做是一个盘子。
            //1.先把最上面的所有盘子a->b，移动过程中会使用到c
            hannuota(num-1,a,c,b);
            //最下面的盘子移动到c
            System.out.println("第"+num+"个盘子从："+a+"->"+c);
            //将b上的盘子移动到c
            hannuota(num-1,b,a,c);

        }
    }
}
