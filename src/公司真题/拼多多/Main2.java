package 公司真题.拼多多;

import java.util.*;

/**
 * @author zbl
 * @version 1.0
 * @content:拼多多 https://www.nowcoder.com/profile/5144852/test/33148289/353474#summary
 * 小多想在美化一下自己的庄园。他的庄园毗邻一条小河，他希望在河边种一排树，共 M 棵。
 * 小多采购了 N 个品种的树，每个品种的数量是 Ai (树的总数量恰好为 M)。但是他希望任意两棵相邻的树
 * 不是同一品种的。小多请你帮忙设计一种满足要求的种树方案。
 * @date 2020/5/3 11:24
 */
public class Main2 {


    static int n, m;
    static int[] tree;
    static List<String> ans;

    static boolean check(int left) {
        for (int i = 1; i <= n; i++) {
            if (tree[i] > (left + 1) / 2) return false;
        }
        return true;
    }

    static boolean dfs(int idx) {
        if (!check(m - idx)) return false;
        if (idx == m) {
            return true;
        } else {
            for (int i = 1; i <= n; i++) {
                if (idx == 0 || (tree[i] != 0 && i != Integer.valueOf(ans.get(idx - 1)))) {
                    tree[i]--;
                    ans.add(i + "");
                    if (dfs(idx + 1)) return true;
                    ans.remove(ans.size() - 1);
                    tree[i]++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            tree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = sc.nextInt();
                m += tree[i];
            }
            ans = new ArrayList<>();
            if (dfs(0)) {
                System.out.println(String.join(" ", ans));
            } else {
                System.out.println("-");
            }
        }
    }


    }

