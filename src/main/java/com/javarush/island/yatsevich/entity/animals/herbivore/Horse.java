package com.javarush.island.yatsevich.entity.animals.herbivore;

import com.javarush.island.yatsevich.entity.animals.BaseEntity;
import com.javarush.island.yatsevich.entity.animals.CreatureTypes;
import com.javarush.island.yatsevich.entity.map.Cell;

public class Horse extends Herbivore{
    private  int weight;
    private int speed;
    private int maxFood;
    private int groupSize;
    private String name;

    public Horse(boolean isDead, CreatureTypes creatureTypes, int weight, int speed, int maxFood, int groupSize, String name) {
        super(isDead, creatureTypes);
        this.weight = weight;
        this.speed = speed;
        this.maxFood = maxFood;
        this.groupSize = groupSize;
        this.name = name;
    }

    public Horse(boolean isDead, CreatureTypes creatureTypes) {
        super(isDead, creatureTypes);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void eat(BaseEntity baseEntity, Cell cell) {
        super.eat(baseEntity, cell);
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Horse{" +", dead?=" + isDead()+ " " +
                "" +"weight=" + weight +
                ", speed=" + speed +
                ", maxFood=" + maxFood +
                ", groupSize=" + groupSize +
                ", name='" + name + '\'' +
                '}';
    }
}
