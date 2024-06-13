package design_oop.strategy_pattern;

import design_oop.strategy_pattern.fly_behaviors.FlyWithNude;
import design_oop.strategy_pattern.quack_behaviors.MuteQuack;

public class GrilledDuck extends Duck {

    public GrilledDuck() {
        this.flyBehavior = new FlyWithNude();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    void display() {
        System.out.println("I am a grilled duck");
    }


}
