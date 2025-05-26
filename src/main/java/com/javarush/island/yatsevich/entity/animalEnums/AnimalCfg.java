package com.javarush.island.yatsevich.entity.animalEnums;

import com.javarush.island.yatsevich.utils.random.Rnd;

public enum AnimalCfg {
    WOLF(false, 50.0, 3,8,30,AnimalType.PREDATOR, AnimalName.WOLF, "\uD83D\uDC3A",Rnd.random(50.0*0.9, 50.0) ),
    BOA(false, 15.0, 1,3,30,AnimalType.PREDATOR, AnimalName.BOA, "\uD83D\uDC0D", Rnd.random(15.0*0.9, 15.0)),
    FOX(false, 8.0, 3,8,30,AnimalType.PREDATOR, AnimalName.FOX, "\uD83E\uDD8A", Rnd.random(8.0*0.9, 8.0)),
    BEAR(false, 500.0, 2,80,5,AnimalType.PREDATOR, AnimalName.BEAR, "\uD83D\uDC3B", Rnd.random(500.0*0.9, 500.0)),
    EAGLE(false, 6.0, 3,1,20,AnimalType.PREDATOR, AnimalName.EAGLE, "\uD83E\uDD85", Rnd.random(6.0*0.9, 6.0)),

    HORSE(false, 400.0, 4,60,20,AnimalType.HERBIVORE, AnimalName.HORSE, "\uD83D\uDC34", Rnd.random(400.0*0.9, 400.0)),
    DEER(false, 300.0, 4,50,20,AnimalType.HERBIVORE, AnimalName.DEER, "\uD83E\uDD8C", Rnd.random(300.0*0.9, 300.0)),
    RABBIT(false, 2.0, 2,0.45,150,AnimalType.HERBIVORE, AnimalName.RABBIT, "\uD83D\uDC30", Rnd.random(2.0*0.9, 2.0)),
    MOUSE(false, 0.05, 1,0.01,500,AnimalType.HERBIVORE, AnimalName.MOUSE, "\uD83D\uDC2D", Rnd.random(0.05*9, 0.05)),
    GOAT(false, 60.0, 3,10,140,AnimalType.HERBIVORE, AnimalName.GOAT, "\uD83D\uDC0F", Rnd.random(60.0*9, 60.0)),
    SHEEP(false, 70.0, 3,15,140,AnimalType.HERBIVORE, AnimalName.SHEEP, "\uD83D\uDC11", Rnd.random(70.0*9, 70.0)),
    BOAR(false, 400.0, 2,50,20,AnimalType.HERBIVORE, AnimalName.BOAR, "\uD83D\uDC17", Rnd.random(400.0*9, 400.0)),
    BUFFALO(false, 700.0, 3,100,20,AnimalType.HERBIVORE, AnimalName.BUFFALO, "\uD83D\uDC02", Rnd.random(700.0*9, 700.0)),
    DUCK(false, 1.0, 4,0.15,20,AnimalType.HERBIVORE, AnimalName.DUCK, "\uD83E\uDD86", Rnd.random(9, 1.0)),
    BUG(false, 0.01, 0,0,20,AnimalType.HERBIVORE, AnimalName.BUG, "\uD83D\uDC1B", 0.01),
    GRASS(false, 6.0, 0,0,20,AnimalType.GRASS, AnimalName.GRASS, "\uD83E\uDEB4", 1.0);

    private final boolean isDead;
    private final double maxWeight;
    private final int speed;
    private final double maxFood;
    private final int maxGroupSize;
    private final AnimalType animalType;
    private final AnimalName animalName;
    private final String icon;
    private final double currentWeight;

    AnimalCfg(boolean isDead, double maxWeight, int speed, double maxFood, int maxGroupSize, AnimalType animalType, AnimalName animalName, String icon, double currentWeight) {
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

    public boolean isDead() {
        return isDead;
    }

    public double getMaxWeight() {
        return maxWeight;
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

    public String getIcon() {
        return icon;
    }

    public double getCurrentWeight() {return currentWeight;}
}
