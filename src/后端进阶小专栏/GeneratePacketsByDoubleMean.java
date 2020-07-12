package 后端进阶小专栏;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zbl
 * @version 1.0
 * @content: 抢红包算法之二倍均值法
 * @date 2020/7/5 15:02
 */
public class GeneratePacketsByDoubleMean {

    public List<Integer> generatePackets(int people,int money){
        Random random=new Random();
        List<Integer>list=new ArrayList<>();
        while(people>1){
            int p=random.nextInt(2*money/people);
            people--;
            money-=p;
            list.add(p);
        }
        list.add(money);
        return list;
    }
}
