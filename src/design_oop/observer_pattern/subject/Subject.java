package design_oop.observer_pattern.subject;

import design_oop.observer_pattern.observer.Observer;

/**
 *  This interface has 3 abstract methods:
 *      <p>
 *      + Both of {@code registerObserver} & {@code removerObserver} take an {@code Observer} as an argument which is registered or removed.
 *      <p>
 *      + {@code notifyObserver} is to notify all observers when Subject's state has changed
 */

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
