package Gof.momentor;

public class Momentor {

    private String state;

    public Momentor(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
