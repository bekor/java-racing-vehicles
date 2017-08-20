package com.car_race;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Car extends Vehicle{
    private static int speedLimit = 111;
    ReadUrl reader = new ReadUrl();
    private List<String> name_array = new ArrayList<>();

    public Car() throws Exception {
        name_array = reader.getCar_names();
        this.normalSpeed = ThreadLocalRandom.current().nextInt(80, 111);
        this.distanceTraveled = 0;
        this.name += name_array.get(ThreadLocalRandom.current().nextInt(name_array.size())) + " ";
        this.name += name_array.get(ThreadLocalRandom.current().nextInt(name_array.size()));
    }

    static void setSpeedLimit(int limit){
        speedLimit = limit;
    }

    public void moveForAnHour(){
        distanceTraveled += Math.min(speedLimit, normalSpeed);
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getName() {
        return name;
    }
}
                       