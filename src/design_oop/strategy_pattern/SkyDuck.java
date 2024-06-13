package design_oop.strategy_pattern;

import design_oop.strategy_pattern.fly_behaviors.FlyWithWings;
import design_oop.strategy_pattern.quack_behaviors.StrongQuack;


public class SkyDuck extends Duck {

    public SkyDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new StrongQuack();
    }

    @Override
    void display() {
        System.out.println("I'm a SkyDuck");
    }
}
