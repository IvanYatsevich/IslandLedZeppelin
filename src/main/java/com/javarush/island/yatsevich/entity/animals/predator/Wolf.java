package com.javarush.island.yatsevich.entity.animals.predator;

import com.javarush.island.yatsevich.entity.animals.CreatureTypes;
import com.javarush.island.yatsevich.entity.animals.BaseEntity;
import com.javarush.island.yatsevich.smth.PredatorFabric;

public class Wolf extends Predator {

    private PredatorFabric predatorFabric;
    private final int weight;
    private int speed;
    private int maxFood;
    private int groupSize;
    private String name;

    public Wolf(boolean isDead, CreatureTypes creatureTypes, int weight, int speed, int maxFood, int groupSize, String name) {
        super(isDead, creatureTypes);
        this.weight = weight;
        this.speed = speed;
        this.maxFood = maxFood;
        this.groupSize = groupSize;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public void setMaxFood(int maxFood) {
        this.maxFood = maxFood;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BaseEntity reproduce() {
        return predatorFabric.createWolf();
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return "Wolf{" +
                "predatorFabric=" + predatorFabric +
                ", weight=" + weight +
                ", speed=" + speed +
                ", maxFood=" + maxFood +
                ", groupSize=" + groupSize +
                ", name='" + name + '\'' +
                '}';
    }
}

