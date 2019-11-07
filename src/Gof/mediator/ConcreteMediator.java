package Gof.mediator;

import java.util.HashMap;

public class ConcreteMediator extends Mediator {

   private HashMap<String,Object> colleagueMap;
   private HashMap<String,String> interMap;

    public ConcreteMediator() {
       colleagueMap=new HashMap<>();
       interMap=new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName,colleague);

        if(colleague instanceof Alarm)
            interMap.put("Alarm",colleagueName);
        else if (colleague instanceof CoffeeMachine) {
            interMap.put("CoffeeMachine", colleagueName);
        }
        else if (colleague instanceof Curtains) {
            interMap.put("Curtains", colleagueName);
        }

    }

    @Override
    public void getMessage(String colleagueName, int stateChange) {

        if(colleagueMap.get(colleagueName) instanceof Alarm)
        {
            if(stateChange==0){
                ((CoffeeMachine) (colleagueMap.get(interMap
                        .get("CoffeeMachine")))).startCoffee();
            }
        }
    }

    @Override
    public void sendMessage() {

    }
}
