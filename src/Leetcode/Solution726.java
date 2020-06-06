package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zbl
 * @version 1.0
 * @content:给定一个化学式formula（作为字符串），返回每种原子的数量。

原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。

如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。

两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。

一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。

给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。

示例 1:

输入:
formula = "H2O"
输出: "H2O"
解释:
原子的数量是 {'H': 2, 'O': 1}。

示例 2:

输入:
formula = "Mg(OH)2"
输出: "H2MgO2"
解释:
原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。

示例 3:

输入:
formula = "K4(ON(SO3)2)2"
输出: "K4N2O14S4"
解释:
原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-atoms
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/5 17:38
 */
public class Solution726 {

    private  static Integer index;
    private  static HashMap<String,Integer> map;

    public static String countOfAtoms(String formula) {
        int len=formula.length();
        map=new HashMap<>();
        index=0;
        while(index<len){
            char c=formula.charAt(index++);
            if(c=='('){//遇到“(”，交给process计算
                HashMap<String,Integer> help=process(formula,index);
                //将括号中的元素统计进入map.
                for(Map.Entry<String,Integer> entry: help.entrySet()){
                    String key=entry.getKey();
                    Integer value=entry.getValue();
                    if(!key.equals("index"))
                    map.put(key,map.getOrDefault(key,0)+value);
                }
                index=help.get("index");
                continue;
            }else if(c>='A' && c<='Z'){
                //int pos=index++;
                StringBuilder sb=new StringBuilder();
                sb.append(c);
                while(index<len){
                    if(formula.charAt(index)>='a' && formula.charAt(index)<='z')
                        sb.append(formula.charAt(index++));
                    else
                        break;
                }
                String key=sb.toString();
                //当因为到了最后，或者遇到（，或者遇到大写字目停止的时候，直接加入到map
                if(index==len || formula.charAt(index)=='(' || (formula.charAt(index)>='A' && formula.charAt(index)<='Z')){
                    map.put(key,map.getOrDefault(key,0)+1);
                }else{
                    //当遇到数字停止的时候
                    int pos=index++;
                    while(index<len){
                        if(formula.charAt(index)>='0' && formula.charAt(index)<='9')
                            index++;
                        else
                            break;
                    }
                    Integer val=Integer.valueOf(formula.substring(pos,index));
                    map.put(key,map.getOrDefault(key,0)+val);

                }

            }


        }

        String[] strs=new String[map.size()];
        int start=0;
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            String key=entry.getKey();
            strs[start++]=key;
        }

        Arrays.sort(strs);//字典序排序
        StringBuilder res=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            res.append(strs[i]);
            res.append(map.get(String.valueOf(strs[i])));
        }
        return res.toString();
    }

    //结算递归函数
    private static HashMap<String,Integer> process(String s,Integer index){//index:（后的坐标
        HashMap<String,Integer> res=new HashMap<>();
        int len=s.length();
        while(index<s.length()){
            char c=s.charAt(index++);
            if(c=='('){
                HashMap<String,Integer>help=process(s,index);
                for(Map.Entry<String,Integer> entry: help.entrySet()){
                    String key=entry.getKey();
                    Integer value=entry.getValue();
                    if(!key.equals("index"))
                    res.put(key,res.getOrDefault(key,0)+value);
                }
                index=help.get("index");
                continue;
            }else if(c>='A' && c<='Z'){
                //int pos=index++;
                StringBuilder sb=new StringBuilder();
                sb.append(c);
                while(index<len){
                    if(s.charAt(index)>='a' && s.charAt(index)<='z')
                        sb.append(s.charAt(index++));
                    else
                        break;
                }
                String key=sb.toString();
                //当因为到了最后，或者遇到（，或者遇到大写字目停止的时候，直接加入到map
                if( s.charAt(index)=='(' || (s.charAt(index)>='A' && s.charAt(index)<='Z')){
                    res.put(key,res.getOrDefault(key,0)+1);
                }else if(s.charAt(index)>='0' && s.charAt(index)<='9'){
                    //当遇到数字停止的时候
                    int pos=index++;
                    while(index<len){
                        if(s.charAt(index)>='0' && s.charAt(index)<='9')
                            index++;
                        else
                            break;
                    }
                    Integer val=Integer.valueOf(s.substring(pos,index));
                    res.put(key,res.getOrDefault(key,0)+val);
                }else if(s.charAt(index)==')'){
                    res.put(key,res.getOrDefault(key,0)+1);
                    int pos=++index;
                    while(index<len){
                        if(s.charAt(index)>='0' && s.charAt(index)<='9')
                            index++;
                        else break;
                    }
                    Integer val=Integer.valueOf(s.substring(pos,index));
                    for(Map.Entry<String,Integer> entry: res.entrySet()){
                        String key1=entry.getKey();
                        Integer value=entry.getValue();
                        res.put(key1,val*value);
                    }
                    break;
                }

            }else if(c==')'){
                int pos=index++;
                while(index<len){
                    if(s.charAt(index)>='0' && s.charAt(index)<='9')
                        index++;
                    else break;
                }
                Integer val=Integer.valueOf(s.substring(pos,index));
                for(Map.Entry<String,Integer> entry: res.entrySet()){
                    String key=entry.getKey();
                    Integer value=entry.getValue();
                    res.put(key,val*value);
                }
                break;
            }

        }
        res.put("index",index);
        return res;

    }

    public static void main(String[] args) {
        String str = "Mg(OH)2";
        System.out.println(countOfAtoms(str));
    }


}
