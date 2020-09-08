package 公司笔面试真题.猿辅导.二零_2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @content:  2020 校招笔试2
 * 小猿有一台打字机，只能打出‘A’、‘B’、‘C’三种字符。某天，小猿打了一段长度为N的字符串1，然后发现可以通过打字机的快捷操作来快速改写字符串。
已知一次快捷操作必须同时改写K个不同位置的字符，且被改写的字符必须改成打字机可以打出的其他字符。例如，K=2时，"AB"可以被改写为"CA"，也可以被改写为"BC"，但不可以被改写为"AA"(必须恰好改写K个字符)或"EF"。
可以请问通过M次快捷操作，能有多少种将字符串1改写为目标字符串2的方案？输出方案数对1000000007取模的结果。

输入描述:
第一行输入三个整数，N、M、K。
接下来两行输入原始字符串1和目标字符串2。
1 ≤ N ≤ 100
1 ≤ M ≤ 100
0 ≤ K ≤ N

输出描述:
方案数对1000000007取模的结果

输入例子1:
3 2 3
AAA
CCC

输出例子1:
1

例子说明1:
只有 AAA -> BBB -> CCC 一种方案

输入例子2:
2 2 2
AA
AA

输出例子2:
4

例子说明2:
AA->BB->AA

AA->BC->AA

AA->CB->AA

AA->CC->AA

4种方案
 * @date 2020/7/25 17:59
 */
public class Solution2 {

    private static int res=0;
    private static final int M=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//长度
        int m=sc.nextInt();//m次快捷操作
        int k=sc.nextInt();//每次操作修改k个数
        String source=sc.next();
        String target=sc.next();
        if(source.length()!=target.length()){
            System.out.println(0);
            return;
        }
        HashMap<String,Integer>map=new HashMap<>();//key:str val:剩余修改的次数
        char[] chs={'A','B','C'};
        process(source,target,n,m,k,chs,map);
        System.out.println(res);
    }

    public static int process(String source, String target, int n, int m, int k,

                               char[] chs, HashMap<String,Integer>map){


        if(m==0 && source.equals(target)){
            return 1;
        }
        String key=source+"_"+m;
        if(map.containsKey(key))
            return map.get(key);

        int res=0;
        if(m>0){
            String tmp=source;
            for(int i=0;i<=n-k;i++)
                for(int s=i;s<n;s++)
                    for(int j=0;j<k;j++)
                        for(int p=0;p<3;p++){



                        }
        }
    return 1;

    }
    /**
     * c++写法
     */
//    #include<iostream>
//#include<vector>
//#include<queue>
//#include<string>
//#include<functional>
//#define LL long long
//    using namespace std;
//    int main()
//    {
//        LL n, m, k;
//        cin >> n >> m >> k;
//        string s1, s2;
//        cin >> s1 >> s2;
//        int cnt = 0;
//        for (int i = 0; i < n; i++)
//        {
//            if (s1[i] == s2[i])cnt++;
//        }
//        if (k == 0)
//        {
//            if (s1.compare(s2) == 0)
//                cout << "1" << endl;
//            else cout << "0" << endl;
//            return 0;
//        }
//        int mod = 1e9 + 7;
//        vector<vector<LL>>C(n + 1, vector<LL>(n + 1, 0));
//        vector<vector<LL>>change(n + 1, vector<LL>(n + 1, 0));//the coefficient of change[a-i+j] to change[a]
//        vector<LL>mi;
//        mi.push_back(1);
//        for (int i = 0; i <= k; i++)
//        {
//            mi.push_back(mi.back() % mod << 1);
//            //cout << mi.back() << endl;
//        }
//        for (int i = 0; i < n + 1; i++)
//            C[i][0] = 1;
//        for (int i = 1; i < n + 1; i++)
//        {
//            for (int j = 1; j <= i; j++)
//            {
//                C[i][j] = C[i - 1][j] + C[i - 1][j - 1];
//                C[i][j] %= mod;
//            }
//        }
//        for (int a = 0; a <= n; a++)
//        {
//            for (int i = 0; i <= k; i++)
//            {
//                int tmp = mi[i] * C[a][i] % mod * C[n - a][k - i] % mod;
//                for (int j = 0; j <= k - i; j++)
//                {
//                    if (a - i + j >= 0 && a - i + j <= n)
//                        change[a][a - i + j] = (tmp*C[k - i][j]+change[a][a - i + j]) % mod;
//                }
//            }
//        }
//        vector<int>ans(n + 1, 0), mm;
//        ans[n] = 1;
//        while (m--)
//        {
//            mm.clear();
//            for (int i = 0; i <= n; i++)
//            {
//                int tmp = 0;
//                for (int j = 0; j <= n; j++)
//                {
//                    tmp = (change[i][j] * ans[j]+tmp) % mod;
//                }
//                mm.push_back(tmp);
//            }
//            ans = mm;
//        }
//
//        cout << ans[cnt] << endl;
//    }

}
