package Gof.observer;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class WetherData implements Gof.observer.Subject {

    private float temperture;
    private float pressure;
    private float humidity;

    public float getTemperture() {
        return temperture;
    }

    public void setTemperture(float temperture) {
        this.temperture = temperture;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    List<Observer> observerList=new ArrayList<>();


    public void dataChange()
    {
        notifyObservers();
    }

    @Override
    public void registObserver(Observer o) {

        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
          if(observerList.contains(o))
              observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
       for(int i=0;i<observerList.size();i++)
       {
           observerList.get(i).update(this.temperture,this.pressure,this.humidity);
       }
    }

    public void setData(float temperture,float pressure,float humidity){
        this.temperture=temperture;
        this.pressure=pressure;
        this.humidity=humidity;
        dataChange();
    }
}
