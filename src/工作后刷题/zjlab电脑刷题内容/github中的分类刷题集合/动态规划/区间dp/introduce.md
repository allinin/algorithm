## 简介
- 区间dp基本步骤：

  1.区间dp的状态转移方程一般是：int[][] dp = new int[len + 1][len + 1];表示从i-j之间的值

  2.定义区间长度range:1-len或者区间长度为1时单独处理，区间长度定义为2-len,for(int range = 2;range <= len;range++)

  3.区间起始位置start:for(int start = 1;start <= len;start++)

  4.区间中点位置end:end = start + range - 1;如果end > len 直接break;

  5.区间[start,end]中间处理位置mid:for(int mid = start;mid <= end;mid++)

  6.一共三层for循环,在最内层for循环中写状态转移。

