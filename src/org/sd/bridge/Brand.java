package org.sd.bridge;

public interface Brand {
    void sale();
}
class lenovo implements Brand
{

    @Override
    public void sale() {
        System.out.println("销售联想笔记本");
    }
}
class Dell implements Brand{


    @Override
    public void sale() {
        System.out.println("销售戴尔笔记本");
    }
}
