package test.pattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.WeakHashMap;

public class Hunter implements Subject{

    private Collection<Observer> observers = new ArrayList<Observer>();
    private Collection<Job> jobs  = Collections.newSetFromMap(
            new WeakHashMap<Job, Boolean>());
    
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        for(Observer o :observers){
            o.notify(this);
        }
    }
    
    public void addJob(Job job) {
        System.out.println("add job====="+job);
        this.jobs.add(job);
        notifyAllObservers();
    }
 
    public Collection<Job> getJobs() {
        return jobs;
    }
 
    
    public String toString(){
        return jobs.toString();
    }

}
