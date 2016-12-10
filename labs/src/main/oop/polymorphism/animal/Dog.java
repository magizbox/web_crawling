package main.oop.polymorphism.animal;

/**
 * Created by rain on 12/10/2016.
 */
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof woof!");
    }
}
