package 左神算法.简单实现hash表;


/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/8/24 16:30
 */
public class MyHashMap<K,V> {

    private static int default_length=16;
    private MyEntry<K,V>[] entries;

    public MyHashMap(){
        entries=new MyEntry[default_length];
    }
    //头插法
    public void put(K key, V val){
        int index=key.hashCode() & default_length;
        MyEntry<K,V> previous=entries[index];
        for(MyEntry<K,V> entry=entries[index];entry!=null;entry=entry.next){
            if(entry.key.equals(key)){
                entry.val=val;
                return;
            }
        }
        MyEntry<K,V> entry=new MyEntry<>(key,val);//构建entry,使用头插法
        entry.next=previous;
        entries[index]=entry;
    }

    public V get(K key){
        int index=key.hashCode()%default_length;
        for(MyEntry<K,V> entry=entries[index];entry!=null;entry=entry.next){
            if(entry.key.equals(key)){
                return entry.val;
            }
        }
        return null;
    }



    private final class MyEntry<K,V>{
        public K key;
        public V val;
        public MyEntry next;

        public MyEntry(){

        }

        public MyEntry(K key,V val){
            this.key=key;
            this.val=val;

        }
        public  MyEntry(K key,V val,MyEntry next){
            this.key=key;
            this.val=val;
            this.next=next;
        }
    }
}
