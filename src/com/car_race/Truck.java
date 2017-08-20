package com.car_race;

import java.util.concurrent.ThreadLocalRandom;

public class Truck extends Vehicle{
    private int breakdownTurnsLeft;

    public Truck(){
        this.name += ThreadLocalRandom.current().nextInt(0, 1001);
        this.distanceTraveled = 0;
        this.normalSpeed = 100;
        this.breakdownTurnsLeft = 0;
    }

    public void moveForAnHour(){
        if(breakdownTurnsLeft > 0){
            breakdownTurnsLeft--;
        } else{
            distanceTraveled += normalSpeed;
        }
    }

    public void setBreakdownTurnsLeft(int breakdownTurnsLeft) {
        this.breakdownTurnsLeft = breakdownTurnsLeft;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getName() {
        return name;
    }
}
