package Gof.Prototype;

public class deepCopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepCopyChild deepCopyChild=new DeepCopyChild("zs",12);
        DeepCopyParent deepCopyParent=new DeepCopyParent("man", deepCopyChild);
        DeepCopyParent deepCopyParent1=deepCopyParent.clone();
        DeepCopyParent deepCopyParent2=deepCopyParent.clone();
        DeepCopyParent deepCopyParent3=deepCopyParent.clone();
        DeepCopyParent deepCopyParent4=deepCopyParent.clone();
        System.out.println(deepCopyParent);
        System.out.println(deepCopyParent1);
        System.out.println(deepCopyParent2);
        System.out.println(deepCopyParent3);



    }
}
