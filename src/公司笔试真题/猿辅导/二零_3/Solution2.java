package 公司笔试真题.猿辅导.二零_3;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:猿辅导课程中需要记录各个班的同学们的出勤情况并进行班级排名，授予冠军班级的奖励。

但是今天粗心的小猿出公司门的时候摔了一跤，把榜单给弄丢了，幸好考勤记录还没丢，但是顺序被弄乱了，现在他把考勤记录和班级名册整理了一下，请你写个程序，帮他把班级排名恢复吧！

排名规则是各班的出勤率，即老师在教室时同学们在教室听讲的比例，具体为：班级同学有效出勤分钟数之和/(老师在教室时间*班级人数)，出勤率相同的班级，按班级名称的字典序进行排序。
其中，有效出勤分钟数表示该同学与老师同在教室内的时间和，即各个区间的结束时间(分)与开始时间(分)之差的和。

输入描述:
第一行为两个数字N，M，以空格分隔，分别表示总考勤记录数和班级个数。

接下来M行，每行表示一个班级的情况，其中第i+1行数据为：

数字Ki表示该班级人数，数字ti表示该班老师的用户id，namei表示班级的名称，接下来Ki个数字表示该班的同学的用户id。

例如：3 999 yuanxiaoyiban 0001 0002 0004

表示yuanxiaoyiban班的老师id为999，3位同学的用户id分别为0001，0002，0004

接下来N行表示乱序的考勤记录，每一行表示一条记录，记录由命令cmdj表示进出教室情况，有IN和OUT两种，数字idj表示进出教室的用户id，timej表示该记录发生的时间距2000年1月1日的分钟数。

例如：IN 999 1表示id为999的用户在2000年1月1日00:01进入了教室。

数据保证，
所有人开始和结束记录时都不在教室内；
每个班级的老师在教室时间和班级人数不为0；同一个用户在同一分钟可以进出教室各一次；班级名称各不相同。

输出描述:
共M行，第i行为排名为i的班级的名称。

输入例子1:
12 2
3 999 yuanxiaoyiban 0001 0002 0004
2 9988 yuanxiaoerban 0003 0009
IN 0001 9001
OUT 0001 9006
IN 999 8888
OUT 999 8888
IN 999 9003
OUT 999 9004
IN 9988 9005
OUT 9988 9006
IN 0003 9001
OUT 0003 9002
IN 0003 9005
OUT 0003 9006

输出例子1:
yuanxiaoerban
yuanxiaoyiban

例子说明1:
yuanxiaoyiban出勤率为1/3，yuanxiaoerban出勤率为1/2，因此yuanxiaoerban比yuanxiaoyiban出勤率高
 * @date 2020/7/25 21:57
 */
public class Solution2 {


    public static class ClassName{
        public int k;//班级人数
        public int tid;//教师id
        public String name;//班级名称
        public int[] nums=new int[k];//班级同学编号
    }

    public static class Person{
        public String inOut;//进出
        public int  id;//用户id
        public long time;//分钟数
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//总考勤记录
        int m=sc.nextInt();//班级数
        ClassName[] classes=new ClassName[m];
        Person[] persons=new Person[n];
        for(int i=0;i<m;i++){
            classes[i]=new ClassName();
            classes[i].k=sc.nextInt();
            classes[i].tid=sc.nextInt();
            classes[i].name=sc.next();

            for(int j=0;j<classes[i].k;j++){
                classes[i].nums=new int[classes[i].k];
                classes[i].nums[j]=sc.nextInt();
            }
        }

        for(int i=0;i<n;i++) {
            persons[i] = new Person();
            persons[i].inOut = sc.next();
            persons[i].id = sc.nextInt();
            persons[i].time = sc.nextLong();
        }
        String[] res=process(persons,classes,m,n);
    }

    public static String[] process(Person[] persons,ClassName[] classes,int m,int n){

        for(int i=0;i<m;i++){
            int tid=classes[i].tid;
            int[] stus=classes[i].nums;

        }
        return null;
    }

    /**
     * c++写法
     */
//    #include <vector>
//#include <iostream>
//#include <unordered_map>
//#include <set>
//#include <map>
//#include <string>
//#include <functional>
//#include <algorithm>
//
//    using namespace std;
//
//    bool compare(pair<double, string>& p1, pair<double, string>& p2)
//    {
//        if (p1.first == p2.first){
//            return p1.second < p2.second;
//        }
//
//        return p1.first > p2.first;
//    }
//
//    int main()
//    {
//        int N, M;
//        cin >> N;
//        cin >> M;
//
//        unordered_map<int, pair<string, int>> tMap;
//        unordered_map<int, int> sMap;
//        for(int i = 0; i < M; i++){
//            int num;
//            int tId;
//            string name;
//            cin >> num;
//            cin >> tId;
//            cin >> name;
//            tMap[tId] = {name, num};
//            for(int j = 0; j < num; j++){
//                int sId;
//                cin >> sId;
//                sMap[sId] = tId;
//            }
//        }
//
//        unordered_map<int, multiset<pair<int, int>>> tTime;
//        unordered_map<int, multiset<pair<int, int>>> sTime;
//        for(int i = 0; i < N; i++){
//            string dir;
//            int id;
//            int time;
//            cin >> dir;//IN
//            cin >> id;
//            cin >> time;
//
//            if(tMap.count(id)){//是老师
//                if(dir == "IN"){
//                    tTime[id].insert({time, 0});
//                }else{
//                    tTime[id].insert({time, 1});
//                }
//            }else{//是学生
//                if(dir == "IN"){
//                    sTime[sMap[id]].insert({time, 0});
//                }else{
//                    sTime[sMap[id]].insert({time, 1});
//                }
//            }
//        }
//
//        //cout << "pass" << endl;
//        unordered_map<int, vector<vector<int>>> ttTime;
//        for(auto &c : tTime){
//        int id = c.first;
//        int left = 0;
//        for(auto &v : c.second){
//            if(v.second == 0){
//                ttTime[id].push_back({v.first});
//            }else{
//                ttTime[id][left++].push_back(v.first);
//            }
//        }
//    }
//
//
//        unordered_map<int, vector<vector<int>>> ssTime;
//        for(auto &c : sTime){
//        int id = c.first;
//        int left = 0;
//        for(auto &v : c.second){
//            if(v.second == 0){
//                ssTime[id].push_back({v.first});
//            }else{
//                ssTime[id][left++].push_back(v.first);
//            }
//        }
//    }
//
//
//        vector<pair<double, string>> ret;
//        for(auto &c : ttTime){
//        int tId = c.first;
//        long long tSum = 0;
//        long long sum = 0;
//        for(auto &t : c.second){
//            tSum += t[1] - t[0];
//            for(auto &s : ssTime[tId]){
//                if(s[0] >= t[1] || s[1] <= t[0]){
//                    continue;
//                }
//                sum += min(t[1], s[1]) - max(t[0], s[0]);
//            }
//        }
//        ret.push_back({(double)sum / (double)(tSum * tMap[tId].second), tMap[tId].first});
//    }
//
//        sort(ret.begin(), ret.end(), compare);
//        for(auto &v : ret){
//        cout << v.second << endl;
//    }
//
//        return 0;
//    }
}
