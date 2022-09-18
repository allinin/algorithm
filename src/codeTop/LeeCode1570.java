package codeTop;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Dot product of two sparse vectors(稀疏数组：指数组中有很多元素的值为0的数组)
 * Given two sparse vectors,compute their dot product
 * implement class SparseVector:
 * SparseVector(nums) initializes the object with vector nums
 * dotProduct(vec).compute the dot product of the two sparse vectors
 *
 */
public class LeeCode1570 {


    class SparseVector{
        //auxiliary array,used to register the index and value of the sparse vector's element which is not zero
        public List<Pair<Integer,Integer>> helpList;

        //因为数组中大多数元素都是0，所以我们可以用一个辅助数组来记录非零元素的位置以及值，然后仅对这些非零元素进行dot product compute
        public SparseVector(int[] nums){
            this.helpList = new ArrayList<>();
            for(int i = 0;i < nums.length;i++){
                if(nums[i] != 0){
                    Pair<Integer,Integer> pair = new Pair<>(i,nums[i]);
                    helpList.add(pair);
                }
            }
        }
        int dotProduct(SparseVector vector){
            int first = 0,second = 0;
            int sum = 0;
            while(first < this.helpList.size() && second < vector.helpList.size()){
                if(this.helpList.get(first).getKey() < vector.helpList.get(second).getKey()){
                    first++;
                }else if(this.helpList.get(first).getKey() > vector.helpList.get(second).getKey()){
                    second++;
                }else{
                    sum += this.helpList.get(first).getValue() * vector.helpList.get(second).getValue();
                    first++;
                    second++;
                }
            }
            return sum;
        }
    }
}


