package design_oop.strategy_pattern.fly_behaviors;

public class FlyWithNude implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly in nude");
    }
}
