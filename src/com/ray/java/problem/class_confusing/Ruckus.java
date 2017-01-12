package com.ray.java.problem.class_confusing;

/**
 * Created by 80107442 on 2017-01-10.
 */
public class Ruckus {
    public static void main(String[] args) {
        Dog dogs[] = {new Dog(), new Dog()};
        for (int i = 0; i < dogs.length; i++) {
            dogs[i].woof();
        }
        Cat cats[] = {new Cat(), new Cat(), new Cat()};
        for (int i = 0; i < cats.length; i++) {
            cats[i].meow();
        }
        System.out.print(Dog.getCount() + " woofs and ");
        System.out.println(Cat.getCount() + " meows");
    }

    public static class Counter {
        private static int count = 0;

        public static final synchronized void increment() {
            count++;
        }

        public static final synchronized int getCount() {
            return count;
        }
    }

    public static class Dog extends Counter {
        public Dog() {
        }

        public void woof() {
            increment();
        }
    }

    public static class Cat extends Counter {
        public Cat() {
        }

        public void meow() {
            increment();
        }
    }
}


