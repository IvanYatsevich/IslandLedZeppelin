package com.javarush.island.yatsevich.entity.herbivore;

import com.javarush.island.yatsevich.entity.entities.AnimalEntity;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalName;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalType;

public class Rabbit extends AnimalEntity {

    public Rabbit(boolean isDead, double weight, int speed, double maxFood, int maxGroupSize, AnimalType animalType, AnimalName animalName, String icon, double currentWeight) {
        super(isDead, weight, speed, maxFood, maxGroupSize, animalType, animalName, icon, currentWeight);
    }


}
