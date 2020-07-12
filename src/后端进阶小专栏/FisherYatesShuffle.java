package 后端进阶小专栏;

import java.util.Random;

/**
 * @author zbl
 * @version 1.0
 * @content:用于随机打乱一组数，并且时间复杂度为 O(N)。

算法的基本思想是，每次从一组数中随机选出一个数，然后与最后一个数交换位置，并且不再考虑最后一个数。
 * @date 2020/7/5 10:47
 */
public class FisherYatesShuffle {

    public static void shuffle(int[] nums){
        Random random=new Random();
        for(int i=nums.length-1;i>=0;i--){
            int j=random.nextInt(i+1);//选择[0,i]之间的某个随机位置
            swap(nums,i,j);
        }
    }

    private static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
