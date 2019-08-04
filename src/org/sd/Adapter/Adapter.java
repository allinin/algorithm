package org.sd.Adapter;

public class Adapter  implements Target{

    private Adaptee adaptee;


   public Adapter(Adaptee adaptee)
   {
       this.adaptee=adaptee;
   }
    public void handleReq() {
        this.adaptee.request();
    }
}
