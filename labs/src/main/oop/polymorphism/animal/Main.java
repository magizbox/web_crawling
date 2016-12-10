package main.oop.polymorphism.animal;

/**
 * Created by rain on 12/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        Bear bear = new Bear();
        Dog dog = new Dog();
        bear.makeSound();
        dog.makeSound();
    }
}
