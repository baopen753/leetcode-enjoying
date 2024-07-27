#design-pattern #behavioral-pattern 


![[Pasted image 20240727135932.png]]


---
## 1. Intent
+ Define a relationship like One-to-many between objects so that once an object has change on its state, all the objects (in Many-side) will be informed to updated automatically


## 2. Also known as
+ Dependencies, Publish - Subscribers


## 3. Motivation\
+ Collection of cooperated classes has a side-effect is that maintaining consistency between related objects
+ We don't aim our classes is tight-coupled because of low re-usability

![[Pasted image 20240714225602.png]]


--> the display interface contains data stemming from data object. Therefore should be notified of any change in its state.

-->  That's how we use [[Observer Pattern]] because it describes how to establish these relationships which can be illustrate that: **Subject and Observer**
or Publish-Subscribe



## 4. Applicability

+ When an abstraction has 2 aspects, one dependent on the other.  Each object is a separate objects lets you vary and reuse them independently

+ When a change to an object requires changing others, and you don't know how many objects to be changed

+ When an object should be able to notify other objects without making assumptions about who these are. In other word, you don't want these object tightly coupled 

## 5. Structure

![[Screenshot from 2024-07-23 15-22-15.png]]


## 6. Participants

+ Subject: 
		+ know its observers. Any number of Observer objects may observe a subject
		+ provides an interface for attaching & detaching Observer objects
+ Observer:
		+ defines an updating interface for objects that should be notified of changes in a subject
+ ConcreteSubject:
		+ stores state of **interest** to ConcreteObserver objects
		+ sends a notification to its observers when its state changes
+ ConcreteObserver:
		+ maintains a reference to a ConcreteSubject object
		+ stores state that should stay consistent with the subject's
		+ implements the Observer updating interface to keep its state consistent with the subject's


## 7. Code

```java
public interface Subject {
   void attach(Observer observer);
   void detach(Observer observer);
   void notifyObservers();
}


public interface Observer {
	void update(String weatherStatus);     
	// in this case: intertest of Observer is weatherStatus - it can be another information that Observer follows from Subject
}


public class WebDisplay implements Observer{
	private String weatherStatus;  // the 'interest' of ConcreteObserver

	@Override
	public void update(String weatherStatus){
		this.weatherStatus = weatherStatus;
	}
}


public class WeatherStation implements Subject{
	List<Observer> listObservers = new ArrayList<>();
	private String weatherStatus;  // information followed by ConcreteObserver

    public void update(String newWeatherStatus){
	    this.weatherStatus = newWeatherStatus;  // update in Subject
	    notifyObservers();                      // notify for all Observers
    }

	@Override
	public void notifyObservers(){
		for (Observer observer : listObservers){
			observer.update(this.weatherStatus);
		}
	}

	@Override
	public void attach(Observer observer){
	   listObservers.add(observer);
	}

	@Override 
	public void detach(Observer observer){
		listObservers.remove(observer);
	}	
}


```

