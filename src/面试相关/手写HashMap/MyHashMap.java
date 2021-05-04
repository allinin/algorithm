package 面试相关.手写HashMap;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/2/12 9:45
 */
public class MyHashMap<K,V> {

    private Entry<K,V>[] table;
    private static final Integer CAPACITY=8;
    private int size;

    public void put(K k,V v){

        if(table==null){
            inflate();
        }
        //存entry

        int hashCode=hash(k);
        int index=indexFor(hashCode);
        for(Entry<K,V> entry=table[index];entry!=null;entry=entry.next){
            if(entry.key.equals(k)){
                entry.value=v;
                return;
            }
        }
        addEntry(k,v,index);
    }

    public V get(K k){
        int hashCode=hash(k);
        int index=indexFor(hashCode);
        for(Entry<K,V> entry=table[index];entry!=null;entry=entry.next){
            if(entry.key.equals(k)){
               return entry.value;
            }
        }
        return null;
    }

    private void inflate(){
        table=new Entry[CAPACITY];
    }

    public int size(){
        return size;
    }

    private void addEntry(K k,V v,int index){
        Entry entry=new Entry(k,v,table[index]);
        table[index]=entry;
        size++;
    }

    private int hash(K k){
        return k.hashCode();
    }
    private int indexFor(int hashCode){
        return hashCode % table.length;
    }





    class Entry<K,V>{
        public K key;
        public V value;
        public Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public Entry(K key, V value,Entry next) {
            this.key = key;
            this.value = value;
            this.next=next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        MyHashMap<Integer,Integer> myHashMap=new MyHashMap<>();
        myHashMap.put(1,2);
        myHashMap.put(2,3);
        System.out.println(myHashMap.get(1));;
        myHashMap.put(1,4);
        System.out.println(myHashMap.get(1));
    }
}
