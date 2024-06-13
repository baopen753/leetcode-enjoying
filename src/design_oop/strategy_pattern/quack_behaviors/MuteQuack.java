package design_oop.strategy_pattern.quack_behaviors;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Mute Quack");
    }
}
