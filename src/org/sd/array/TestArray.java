package org.sd.array;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray {

    public static void main(String[] args) {
//        int[] arr=new int[]{1,2,3,4,5,6,76};
//////        int dst=4;
//////        //创建一个新数组
//////        int [] newArr=new int[arr.length-1];
//////        for(int i=0;i<newArr.length;i++)
//////        {
//////            if(i<dst)
//////            {
//////                newArr[i]=arr[i];
//////            }else {
//////                newArr[i]=arr[i+1];
//////            }
//////        }
//////        //旧数组指向新数组
//////        arr=newArr;
//////        System.out.println(Arrays.toString(arr));
        String str = " a    b ";
        String str1 = str.trim(); //String表示一个不可变的字符串.去掉空格之后生成了一个新的字符串,原来的字符串并没有改变
        System.out.println("!"+str1+"!");

    }


}
