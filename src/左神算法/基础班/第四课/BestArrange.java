package 左神算法.基础班.第四课;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {

    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    //比较器，用来排序给定的数组，根据会议的结束时间来实行相应的贪心策略
    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end-o2.end;
        }
    }

    public  static int bestArrange(Program[] programs,int cur){ //cur表示当前时间，刚开始的时候也就是开始时间

        Arrays.sort(programs,new ProgramComparator());
        int result=0;
        for(int i=0;i<programs.length;i++)
        {
            if(cur<=programs[i].start)
            {
                result++;
                cur+=programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
