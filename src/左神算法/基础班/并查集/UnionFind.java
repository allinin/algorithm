package 左神算法.基础班.并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//并查集
public class UnionFind {

    public static class Node{

    }


    public static class DisjoinSets{
        private HashMap<Node,Node> fatherMap; //key:child,value:father
        private HashMap<Node,Integer>rankMap;//只有当结点是代表结点的时候，value的值才有意义，
                                           //当不是代表结点的时候不负责把value值更新成对的，保持原来的值即可,此时这个值已经不起作用了，不是代表结点的value值不再使用。
        public DisjoinSets(){
            this.fatherMap=new HashMap<>();
            this.rankMap=new HashMap<>();
        }

           //用并查集进程操作，开始的时候，每一个元素各自成一个集合
        public void makeSets(List<Node> nodes)
        {
            fatherMap.clear();
            rankMap.clear();
            for(Node node:nodes)
            {
                fatherMap.put(node,node);
                rankMap.put(node,1);
            }
        }
        //长的树变成扁平的树，即：将查询过程中的相关结点直接挂在他的父结点下
        public  Node findFather(Node n)
        {
            Node father=fatherMap.get(n);
            if(father!=n)
            {
                father=findFather(father);
            }
            fatherMap.put(n,father);
            return father;
        }
        //非递归实现，-----》递归改为非递归的时候，通常需要借助栈这个结构来保存现场
        public Node fatherFindUnRec(Node n)
        {
            Stack<Node>stack=new Stack<>();
            Node cur=n;
            Node father=fatherMap.get(cur);
            while(father!=cur)
            {
                stack.push(cur);
                cur=father;
                father=fatherMap.get(cur);
            }
            while(!stack.isEmpty())
            {
                fatherMap.put(stack.pop(),father);
            }
            return father;

        }

        //判断是否是同一个集合
        public  boolean isSameSet(Node a,Node b)
        {
            return findFather(a)==findFather(b);
        }


        //合并集合
        public void union(Node a,Node b)
        {
            if(a==null||b==null)
            {
                return;
            }
            Node aFather=findFather(a);
            Node bFather=findFather(b);
            if(aFather!=bFather)
            {
                int aFrank=rankMap.get(a);
                int bFrank=rankMap.get(b);
                if(aFrank<=bFrank)
                {
                    fatherMap.put(aFather,bFather);
                    rankMap.put(aFather,aFrank+bFrank);
                }else {
                    fatherMap.put(bFather, aFather);
                    rankMap.put(aFather, aFrank + bFrank);
                }
            }
        }



    }
}
