package ua.training.task1.model.ammunition;

public interface WarObject extends Comparable<Ammunition>  {
    String name();
    double price();
    double weight();
    double sliceDamage();
    double pierceDamage();
    double impactDamage();

}
