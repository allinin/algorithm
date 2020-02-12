package 左神算法.高频面试题.十二十三;

import java.util.HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content: 设计RandomPool结构，设计一种结构，在该结构中有如下三个功能：
 * insert(key):将某个key加入到该结构，做到不重复
 * delete(key）：将原本在结构中的某个key移除
 * getRandom():等概率随机返回结构中的任何一个key.
 * 要求所有的操作的时间复杂度都是O（1）
 * @date 2020/2/6 17:27
 */
public class RandomPool {

    public static class Pool<K>{
        public HashMap<K,Integer>keyIndexMap;
        public HashMap<Integer,K>indexKeyMap;
        public int size;

        public Pool() {
            this.keyIndexMap=new HashMap<>();
            this.indexKeyMap=new HashMap<>();
            this.size=0;
        }

        public void insert(K key){
            if(!this.keyIndexMap.containsKey(key)){
                this.keyIndexMap.put(key,this.size);
                this.indexKeyMap.put(this.size,key);
                size++;

            }
        }
        public void delete(K key) {

            if (this.keyIndexMap.containsKey(key)) {
                int index = keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, index);
                indexKeyMap.put(index, lastKey);
//              keyIndexMap.put(key, lastIndex);
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom(){
            if(this.size==0)
                return null;
            int randomIndex=(int)(Math.random()*this.size);
            return this.indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }
}
