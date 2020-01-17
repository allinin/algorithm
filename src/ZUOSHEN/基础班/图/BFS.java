package ZUOSHEN.基础班.图;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void bfs(Node node){
        if(node==null)
            return;
        Queue<Node>queues=new LinkedList<>();
        HashSet<Node> sets=new HashSet<>();
        queues.add(node);
        sets.add(node);
        while(!queues.isEmpty())
        {
            Node temp=queues.poll();
            System.out.println(temp.value);
            for(Node next:temp.nexts)
            {
                if(!sets.contains(next))
                {
                    queues.add(next);
                    sets.add(next);
                }
            }

        }
    }
}
