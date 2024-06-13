package design_oop.strategy_pattern;

public class Restaurant {
    public static void main(String[] args) {

        Duck grilledDuck = new GrilledDuck();
        grilledDuck.performFly();
        grilledDuck.performQuack();
        grilledDuck.display();

        var seondSkyDuck = new SkyDuck();
        seondSkyDuck.performFly();
        seondSkyDuck.performQuack();
        seondSkyDuck.display();

    }
}
