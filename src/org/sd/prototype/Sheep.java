package org.sd.prototype;

import java.io.Serializable;
import java.util.Date;

public class Sheep implements Cloneable, Serializable {
    private String name;
    private Date date;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    protected Object clone() throws CloneNotSupportedException {
      Object object=super.clone();

     Sheep s=(Sheep)object;
     s.date=(Date)this.date.clone();//把属性也进行克隆
        return  object;
    }

    public Sheep(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Sheep() {

    }
}
