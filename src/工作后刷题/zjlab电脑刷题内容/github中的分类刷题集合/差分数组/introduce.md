# 简介
- 适用场景

    1、频繁的去修改某个区间的元素，同时去增加or同时去减少。
    差分数组可以对某个区间内所有数进行增加/减少操作，变为对2个端点的操作，时间复杂度O(1)
    
    2、对于原数组每一个位置的值，只需要遍历一遍差分数组求前缀和即可恢复原数组。最终时间复杂度O(N)



- 核心
    差分数组是能把原来的数组还原出来的！原来的数组操作后可以得到差分数组


- 注意点
  
    使用差分数组的过程中可能需要进行离散化操作从而起到节约内存的作用(如leetCode 2251)


- 题目参考链接
    
    https://leetcode.cn/problems/living-people-lcci/solutions/568126/chai-fen-shu-zu-zhe-lei-ti-bi-jiao-dian-hpz8t/

  - 差分数组代码定义参考：

          class DiffArray {

          //差分数组
          int[] diffArr;

          //构建一个初始值为0的差分数组
          public DiffArray(int n) {
              this.diffArr = new int[n];
          }

          //根据原数组arr构建差分数组
          public DiffArray(int[] arr) {
              this.diffArr = new int[arr.length];
              diffArr[0] = arr[0];
              for (int i = 1; i < arr.length; i++) {
                  diffArr[i] = arr[i] - arr[i + 1];
              }
          }

          //原数组[i,j]范围的元素增加delta
          public void update(int i, int j, int delta) {
              diffArr[i] += delta;
              if (j + 1 < diffArr.length) {
                  diffArr[j + 1] -= delta;
              }
          }

          //获取更新后的原数组
          public int[] getOriginArr() {
              int[] origin = new int[diffArr.length];
              origin[0] = diffArr[0];
              for (int i = 1; i < origin.length; i++) {
                  origin[i] = origin[i - 1] + diffArr[i];
              }
              return origin;
          }

          //获取不断更新操作后，原数组最大值所在的索引，如果有多个，返回最小的索引
          public int getMaxIndex() {
              int ans = 0;
              int maxValue = diffArr[0],nowValue = diffArr[0];
              for (int i = 1; i < diffArr.length; i++) {
                  nowValue += diffArr[i];
                  if (nowValue > maxValue) {
                      maxValue = nowValue;
                      ans = i;
                  }
              }
              return ans;
          }
        }