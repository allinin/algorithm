package 韩顺平算法与数据结构.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建电台的集合
        HashMap<String, HashSet<String>> broadcast=new HashMap<>();
        //创建单个电台
        HashSet<String> hashSet1=new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2=new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3=new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4=new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5=new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcast.put("k1",hashSet1);
        broadcast.put("k2",hashSet2);
        broadcast.put("k3",hashSet3);
        broadcast.put("k4",hashSet4);
        broadcast.put("k5",hashSet5);

        //存放所有的地区
        HashSet<String>allAreas =new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //存放选择出来的电台
        ArrayList<String >selects=new ArrayList<>();
        String maxKey=null;
        HashSet<String> temp=new HashSet<>();//临时变量用来存放遍历过程中电台覆盖的地区和当前还没有覆盖地区的交集
        while(allAreas.size()!=0)
        {   //每进行一次while都将maxKey置空
            maxKey=null;
            for(String key:broadcast.keySet())
            {
                temp.clear();//每次循环都要清空temp。
                HashSet<String> area=broadcast.get(key);
                temp.addAll(area);
                temp.retainAll(allAreas);//求交集，结果保存在temp中。
                if(temp.size()>0 && (maxKey==null || temp.size()>broadcast.get(maxKey).size()))
               {
                   maxKey=key;
               }
            }
            if(maxKey!=null)
            {
                selects.add(maxKey);
                //将maxkey所指向的广播电台覆盖的地区，从allareas中去电
                allAreas.removeAll(broadcast.get(maxKey));//removeAll:删除二者的交集
            }


        }

        System.out.println(selects);





    }

}
