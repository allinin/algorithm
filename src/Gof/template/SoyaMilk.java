package Gof.template;

public abstract class SoyaMilk {

    final void make(){
        select();
        if(customerWantCondiments())
            addCondiments();
        soak();
        beat();
    }

    void select()
    {
        System.out.println("第一部：选择豆子");
    }

    //添加不同的配料
    abstract void addCondiments();

    //浸泡
    void soak()
    {
        System.out.println("第三步：黄豆和配料开始浸泡，需要3小时");
    }

    void beat(){
        System.out.println("第四步：黄豆和配料打碎");
    }

    //钩子方法
    public boolean customerWantCondiments()
    {
        return true;
    }

}
