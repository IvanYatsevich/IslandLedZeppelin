package com.javarush.island.yatsevich.entity.entities;

import com.javarush.island.yatsevich.api.Eatable;
import com.javarush.island.yatsevich.api.Movable;
import com.javarush.island.yatsevich.api.Reproducible;
import com.javarush.island.yatsevich.entity.factory.AnimalFactory;
import com.javarush.island.yatsevich.island.Cell;
import com.javarush.island.yatsevich.island.IslandMap;
import com.javarush.island.yatsevich.utils.random.Rnd;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalFoodMap;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalName;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalType;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AnimalEntity implements Eatable, Movable, Reproducible {
    private static final AtomicInteger idGenerator = new AtomicInteger();
    private final int id;
    boolean isDead;
    private final double maxWeight;
    private final int speed;
    private final double maxFood;
    private final int maxGroupSize;
    private final AnimalType animalType;
    private final AnimalName animalName;
    private final String icon;
    private double currentWeight;
    protected final double MOVING_COEFFICIENT = 0.01;

    public AnimalEntity(boolean isDead, double maxWeight, int speed, double maxFood, int maxGroupSize, AnimalType animalType, AnimalName animalName, String icon, double currentWeight) {
        this.id = idGenerator.incrementAndGet();
        this.isDead = isDead;
        this.maxWeight = maxWeight;
        this.speed = speed;
        this.maxFood = maxFood;
        this.maxGroupSize = maxGroupSize;
        this.animalType = animalType;
        this.animalName = animalName;
        this.icon = icon;
        this.currentWeight = currentWeight;
    }

    @Override
    public synchronized void move(IslandMap map, int currentX, int currentY) {
        int couldMove = this.getSpeed();
        int couldMoveByX = Rnd.random(-couldMove, +couldMove);
        int couldMoveByY = Rnd.random(-couldMove, +couldMove);
        int destinationX = currentX + couldMoveByX;
        int destinationY = currentY + couldMoveByY;
        if (!(destinationX < 0 || destinationY < 0 || destinationX >= map.getWidth() || destinationY >= map.getHeight())) {
            Cell currentCell = map.getCell(currentX, currentY);
            Cell destinationCell = map.getCell(destinationX, destinationY);
            if (currentCell != destinationCell) {
                currentCell.removeAnimal(this);
                destinationCell.addAnimal(this);
                this.setWeightAfterMove(this.getCurrentWeight());
            } else {
                setWeightAfterMove(this.getCurrentWeight());
            }
        }

    }

    @Override
    public synchronized void eat(Cell currentCell) {
        for (AnimalEntity animal : currentCell.getAnimals()) {
            if (Rnd.random(1, 100) >= calculateChance(animal)) {
                this.setWeightAfterMeal(animal);
                currentCell.removeAnimal(animal);
                break;
            }
        }
    }

    public int calculateChance(AnimalEntity animal) {
        return AnimalFoodMap.valueOf(this.getAnimalName().name())
                .getProbabilityToEat(animal.getAnimalName());
    }


    @Override
    public void reproduce(Cell currentCell) {
        for (AnimalEntity animal : currentCell.getAnimals()) {
            if (this.getCurrentWeight() >= this.getMaxWeight()) {
                currentCell.addAnimal(new AnimalFactory().createAnimal(animal.getAnimalName()));
            }
        }
    }

    public void setWeightAfterMeal(AnimalEntity animal) {
        if (animal.getCurrentWeight() > this.maxFood)
            this.currentWeight = this.getMaxWeight();
        else {
            this.currentWeight += animal.getCurrentWeight();
        }
    }

    public void setWeightAfterMove(double currentWeight) {
        this.currentWeight -= (currentWeight * MOVING_COEFFICIENT);
    }

    public boolean isDead() {
        return isDead;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public String getIcon() {
        return icon;
    }

    public int getSpeed() {
        return speed;
    }

    public double getMaxFood() {
        return maxFood;
    }

    public int getMaxGroupSize() {
        return maxGroupSize;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public AnimalName getAnimalName() {
        return animalName;
    }

    public AnimalEntity getEntity() {
        return this;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    @Override
    public String toString() {
        return icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalEntity entity = (AnimalEntity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isDead, maxWeight, speed, maxFood, maxGroupSize, animalType, animalName, icon);
    }


}
