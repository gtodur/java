package com.patterns.structural;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {

	public static void main(String[] args) {
        RaceCarClient raceCars[] = {
                new RaceCarClient("Midget"),
                new RaceCarClient("Midget"),
                new RaceCarClient("Midget"),
                new RaceCarClient("Sprint"),
                new RaceCarClient("Sprint"),
                new RaceCarClient("Sprint")
        };
        raceCars[0].moveCar(29, 3112);
        raceCars[1].moveCar(39, 2002);
        raceCars[2].moveCar(49, 1985);
        raceCars[3].moveCar(59, 2543);
        raceCars[4].moveCar(69, 2322);
        raceCars[5].moveCar(79, 2135);
       /*Output and observe the number of instances created*/
       System.out.println("Midget Car Instances: " + FlyweightMidgetCar.num);
       System.out.println("Sprint Car Instances: " + FlyweightSprintCar.num);

	}

}

/**
 * Flyweight 
 * Abstract class or interface for flyweight objects. 
 * Declares method through which flyweights can receive and act on extrinsic state. 
 * Although Flyweight enables sharing, it is not mandatory that all Flyweight subclasses must be shared.
 */
abstract class RaceCar {
    /*Intrinsic state  stored and shared in the Flyweight object*/
    String name;
    int speed;
    int horsePower;
   /* Extrinsic state is stored or computed by client objects, and passed to the Flyweight.*/
    abstract void moveCar(int currentX, int currentY, int newX ,int newY);
}

/**
 * ConcreteFlyweight
 * Extends/Implements Flyweight to represent flyweight objects that can be shared.
 */
class FlyweightMidgetCar extends RaceCar {
    /*Track number of flyweight instantiation*/
        public static int num;
        public FlyweightMidgetCar()
        {
            num++;
        }
    /*This method accepts car location (extrinsic). No reference to current
    *or new location is maintained inside the flyweight implementation*/
        @Override
        public void moveCar(int currentX, int currentY, int newX ,int newY)
        {
            System.out.println("New location of "+this.name+" is X"+newX + " - Y"+newY);
        }
    }

/**
 * ConcreteFlyweight
 * Extends/Implements Flyweight to represent flyweight objects that can be shared.
 */
class FlyweightSprintCar extends RaceCar{
    /*Track number of flyweight instantiation*/
    public static int num;
    public FlyweightSprintCar()
    {
        num++;
    }
   /*This method accepts car location (extrinsic). No reference to current
    *or new location is maintained inside the flyweight implementation*/
    @Override
    public void moveCar(int currentX, int currentY, int newX ,int newY)
    {
        System.out.println("New location of "+this.name+" is X"+newX + " - Y"+newY);
    }
}

/*
 * FlyweightFactory
 * Creates and manages flyweight objects. 
 * When a client requests a flyweight object, 
 * FlyweightFactory provides an existing one or creates a new one, if it does not exists.
 */
class CarFactory {
    private static Map<String, RaceCar> flyweights = new HashMap<>();
    /*If key exist, return flyweight from Map*/
    public static RaceCar getRaceCar(String key) {
        if(flyweights.containsKey(key)){
            return flyweights.get(key);
        }
        RaceCar raceCar;
        /*If key does not exist in Map, create flyweight, put it in Map, and return the object*/
        switch (key)
        {
            case "Midget":
                raceCar = new FlyweightMidgetCar();
                raceCar.name="Midget Car";
                raceCar.speed=140;
                raceCar.horsePower=400;
                break;
            case "Sprint":
                raceCar = new FlyweightSprintCar();
                raceCar.name="Sprint Car";
                raceCar.speed=160;
                raceCar.horsePower=1000;
                break;
            default:
                throw new IllegalArgumentException("Unsupported car type.");
        }
        flyweights.put(key, raceCar);
        return raceCar;
    }
}

/*
 * Client
 * Requests FlyweightFactory for a flyweight object, and then computes and passes the extrinsic data to it.
 */
class RaceCarClient {
    private RaceCar raceCar;
    public RaceCarClient(String name) {
        /*Ask factory for a RaceCar*/
        raceCar = CarFactory.getRaceCar(name);
    }
     /**
     * The extrinsic state of the flyweight is maintained by the client
     */
    private int currentX = 0;
    private int currentY=0;
    public void moveCar(int newX, int newY){
    /*Car movement is handled by the flyweight object*/
        raceCar.moveCar(currentX,
                currentY, newX, newY);
        currentX = newX;
        currentY = newY;
    }
}