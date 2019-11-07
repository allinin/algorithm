package org.sd;

import java.util.Scanner;

public class Exercise {

    public static int getLength(String str)
    {
        if(str==null || str.length()==0)
            return 0;
        String[] strArray=str.split(" ");
        int len=strArray.length;
        return strArray[len-1].length();
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine())
        {
            String str=scanner.nextLine();
            int len=getLength(str);
            System.out.println(len);
        }
    }
}
