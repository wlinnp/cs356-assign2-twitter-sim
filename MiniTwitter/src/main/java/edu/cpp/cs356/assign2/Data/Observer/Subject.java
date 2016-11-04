package edu.cpp.cs356.assign2.Data.Observer;

/**
 * @author william
 */
public interface Subject {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void notifyObservers();
    
}
