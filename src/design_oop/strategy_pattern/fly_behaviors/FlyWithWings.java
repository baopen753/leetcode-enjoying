package design_oop.strategy_pattern.fly_behaviors;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly With Wings");
    }
}
