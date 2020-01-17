package ZUOSHEN.基础班.图;

import java.util.HashSet;
import java.util.Stack;

public class DFS {

    public static void dfs(Node node){
        if(node==null)
            return;
        Stack<Node>stacks=new Stack<>();
        HashSet<Node>sets=new HashSet<>();
        stacks.push(node);
        sets.add(node);
        System.out.println(node.value);
        while(!stacks.isEmpty())
        {
            Node cur = stacks.pop();
            for(Node next:cur.nexts)
            {
                if(!sets.contains(next))
                {
                    stacks.push(cur);
                    stacks.push(next);
                    sets.add(next);
                    System.out.println(next.value);
                    break;
                }
            }

        }
    }
}
