package 左神算法.进阶班一.树相关.高度套路题树形dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/1/6 12:51
 */
public class MaxHappy {

    public static class Node{
        public int huo;
        public List<Node> nexts;

        public Node(int huo) {
            this.huo = huo;
            this.nexts=new ArrayList<>();
        }
    }

    //构建成树形结构后，来的活跃度与不来的活跃度
    public static class ReturnType{
        public int lai_huo;
        public int bu_lai_huo;

        public ReturnType(int lai_huo, int bu_lai_huo) {
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }
    
    public static int getMaxHappy(Node head){
        ReturnType returnData = process(head);
        return Math.max(returnData.bu_lai_huo,returnData.lai_huo);
    }

    public static ReturnType process(Node head){

        List<Node> list=head.nexts;
        int lai_huo=head.huo;
        int bu_lai_huo=0;
        for(int i=0;i<list.size();i++){
            ReturnType process = process(list.get(i));
            lai_huo+=process.bu_lai_huo;
            bu_lai_huo+=Math.max(process.bu_lai_huo,process.lai_huo);
        }
        return new ReturnType(lai_huo,bu_lai_huo);

    }

}
