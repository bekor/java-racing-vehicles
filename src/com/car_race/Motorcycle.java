package com.car_race;

import java.util.concurrent.ThreadLocalRandom;

public class Motorcycle extends Vehicle{
    private static int speedLimit = 110;
    private static int nameNumber = 0;

    public Motorcycle(){
        this.normalSpeed = 100;
        this.name = "Motorcycle " + (++nameNumber);
        this.distanceTraveled = 0;
    }
    // speed is 100km/h. If rains, travels with 5-50km/h slower (randomly).
    public void moveForAnHour(){
        distanceTraveled += Math.min(speedLimit, normalSpeed);
    }

    public void setSpeedLimit(boolean isLimited){
        if(isLimited) {
            speedLimit = ThreadLocalRandom.current().nextInt(50, 96);
        } else {
            speedLimit = 110;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
