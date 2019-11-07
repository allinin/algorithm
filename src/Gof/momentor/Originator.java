package Gof.momentor;

public class Originator {

    private String state;

    public Originator(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Momentor saveStateMomnentor()
    {
        return new Momentor(state);
    }

    public void getStateFromMomentor(Momentor momentor)
    {
        state=momentor.getState();
    }

}
