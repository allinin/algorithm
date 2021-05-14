package 重温设计模式.行为模式.观察者模式.示例;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zbl
 * @version 1.0
 * @content:观察者模式在文本编辑器对象之间建立了间接的合作关系。每当编辑器对象改变时，他都会通知其他订阅者
 * 订阅者类不与编辑器类直接耦合，且能在需要时在其他应用中复用。编辑器类仅依赖于抽象订阅者接口，这样就能允许在不改变编辑器代码的
 * 的情况下添加新的订阅者类型
 * @date 2021/5/8 13:38
 */
public class EventManager {

    //key:订阅的事件，value:订阅者
    Map<String,List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations){
        for(String operation : operations){
            this.listeners.put(operation,new ArrayList<>());
        }
    }

    public void subscribe(String eventType,EventListener listener){
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.add(listener);
    }

    public void unSubscribe(String eventType,EventListener eventListener){
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.remove(eventListener);
    }

    public void notify(String eventType,File file){
        List<EventListener> eventListeners = listeners.get(eventType);
        for(EventListener eventListener : eventListeners){
            eventListener.update(eventType,file);
        }
    }


}
