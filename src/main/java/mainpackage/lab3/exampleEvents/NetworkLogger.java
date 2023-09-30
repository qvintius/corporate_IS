package mainpackage.lab3.exampleEvents;

import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;


public class NetworkLogger implements Logger {
    /*@Inject
    private LogObserver observer;*/
    @Inject
    private Event<DateSource> event;//событие
    @Override
    public void print(String message) {
        //observer.observe(new DateSource());
        event.fire(new DateSource());//вызов события
        System.out.println("Send log message to remote log system");
    }
    public void logEvent(@Observes DateSource event){
        System.out.println("Message Date: " + event.getDate());//слушатель события
    }
}