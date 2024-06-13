package design_oop.strategy_pattern;

import design_oop.strategy_pattern.fly_behaviors.FlyBehavior;
import design_oop.strategy_pattern.quack_behaviors.QuackBehavior;

public abstract class Duck {
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    void performQuack() {
        quackBehavior.quack();
    }

    void display() {
    }

    void performFly() {
        flyBehavior.fly();
    }


}
