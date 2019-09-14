package Gof.Factory.simpleFactory;

public abstract class Pizza {
    protected String name;

    //原料不同，所以我们做成抽象方法
    public abstract void prepare();

    public void bake()
    {
        System.out.println(name+"  baking ");
    }
    public void cut()
    {
        System.out.println(name+" cut ");
    }
    public void box()
    {
        System.out.println(name +" box");
    }

    public void  setName(String name)
    {
        this.name=name;
    }
}
