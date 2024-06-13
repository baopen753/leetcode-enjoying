package design_oop.strategy_pattern.quack_behaviors;

public class StrongQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Strong quack");
    }
}
