package com.javarush.island.yatsevich.entity.predator;

import com.javarush.island.yatsevich.entity.entities.AnimalEntity;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalName;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalType;

public class Bear extends AnimalEntity {
    public Bear(boolean isDead, double weight, int speed, double maxFood, int maxGroupSize, AnimalType animalType, AnimalName animalName, String icon, double currentWeight) {
        super(isDead, weight, speed, maxFood, maxGroupSize, animalType, animalName, icon, currentWeight);
    }
}
