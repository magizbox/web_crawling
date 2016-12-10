package main.oop.polymorphism.deer;

/**
 * Created by rain on 12/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        Deer deer = new Deer();
        Animal animal = deer;
        Vegetarian vegetarian = deer;
    }
}
