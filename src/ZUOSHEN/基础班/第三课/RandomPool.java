package ZUOSHEN.基础班.第三课;

import java.util.HashMap;

public class RandomPool {

    public static class Pool<K>{
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key)
        {
            if(!this.keyIndexMap.containsKey(key))
            {
                this.keyIndexMap.put(key,size);
                this.indexKeyMap.put(this.size++,key);
            }
        }

        public K getRandom()
        {
            if(this.size==0)
                return null;
            int index=(int)(Math.random()*this.size);//0-size-1
            return this.indexKeyMap.get(index);//真正的随机了

        }


        //!!!!!!!!!!!!!!!!!!!!!!!!!!
        public void delete(K key)
        {
            if(!this.keyIndexMap.containsKey(key))
                return;
            int deleteIndex=keyIndexMap.get(key);
            int lastIndex=--size;
            K lastKey=indexKeyMap.get(lastIndex);
            this.keyIndexMap.put(lastKey,deleteIndex);
            this.indexKeyMap.put(deleteIndex,lastKey);
            keyIndexMap.remove(key);
            indexKeyMap.remove(lastIndex);

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
