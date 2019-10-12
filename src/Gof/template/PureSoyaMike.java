package Gof.template;

public class PureSoyaMike extends SoyaMilk {

    @Override
    void addCondiments() {

    }

    @Override
    public boolean customerWantCondiments() {
        return false;
    }
}
