package Gof.Prototype;

import com.sun.org.apache.regexp.internal.RE;

import java.io.*;

public class DeepCopyParent implements Serializable,Cloneable{
    String sex;
    DeepCopyChild deepCopyChild;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public DeepCopyParent(String sex, DeepCopyChild deepCopyChild) {
        this.sex = sex;
        this.deepCopyChild = deepCopyChild;
    }

    @Override
    public String toString() {
        return "DeepCopyParent{" +
                "sex='" + sex + '\'' +
                ", deepCopyChild=" + deepCopyChild +
                '}';
    }


    protected DeepCopyParent clone1() throws CloneNotSupportedException {
        ByteArrayOutputStream bao=null;
        ObjectOutputStream oos=null;
        ByteArrayInputStream bis=null;
        ObjectInputStream ois=null;
        try {
               bao=new ByteArrayOutputStream();
              oos=new ObjectOutputStream(bao);
             oos.writeObject(this);
            bis=new ByteArrayInputStream(bao.toByteArray());
              ois=new ObjectInputStream(bis);
             Object object = ois.readObject();
             return (DeepCopyParent) object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                bao.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    protected DeepCopyParent clone() throws CloneNotSupportedException {
       DeepCopyParent deepCopyParent=null;
        deepCopyParent =(DeepCopyParent) super.clone();
        //对引用类型单独处理
        deepCopyParent.deepCopyChild=deepCopyChild.clone();
        return deepCopyParent;

    }
}
