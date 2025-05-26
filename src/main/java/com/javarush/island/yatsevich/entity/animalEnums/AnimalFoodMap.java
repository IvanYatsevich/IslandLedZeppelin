package com.javarush.island.yatsevich.entity.animalEnums;

import java.util.Map;

public enum AnimalFoodMap {

    WOLF(Map.of(
            AnimalName.HORSE, 50,
            AnimalName.DEER, 15,
            AnimalName.RABBIT, 60,
            AnimalName.MOUSE, 80,
            AnimalName.GOAT, 60,
            AnimalName.SHEEP, 70,
            AnimalName.BOAR, 15,
            AnimalName.BUFFALO, 10,
            AnimalName.DUCK, 40)),
    BOA(Map.of(
            AnimalName.FOX, 15,
            AnimalName.RABBIT, 20,
            AnimalName.MOUSE, 40,
            AnimalName.DUCK, 40)),
    FOX(Map.of(
            AnimalName.RABBIT, 70,
            AnimalName.BUG, 70,
            AnimalName.MOUSE, 90)),
    BEAR(Map.of(
            AnimalName.BOA, 80,
            AnimalName.HORSE, 40,
            AnimalName.DEER, 80,
            AnimalName.RABBIT, 80,
            AnimalName.MOUSE, 90,
            AnimalName.GOAT, 70,
            AnimalName.SHEEP, 90,
            AnimalName.BOAR, 50,
            AnimalName.BUFFALO, 20,
            AnimalName.DUCK, 10)),
    EAGLE(Map.of(
            AnimalName.FOX, 10,
            AnimalName.MOUSE, 90,
            AnimalName.RABBIT, 90,
            AnimalName.DUCK, 90)),
    HORSE(Map.of(
            AnimalName.GRASS, 100)),
    DEER(Map.of(
            AnimalName.GRASS, 100)),
    RABBIT(Map.of(
            AnimalName.GRASS, 100)),
    GOAT(Map.of(
            AnimalName.GRASS, 100)),
    SHEEP(Map.of(
            AnimalName.GRASS, 100)),
    BUFFALO(Map.of(
            AnimalName.GRASS, 100)),
    BUG(Map.of(
            AnimalName.GRASS, 100)),
    MOUSE(Map.of(
            AnimalName.BUG, 90,
            AnimalName.GRASS, 100)),
    BOAR(Map.of(
            AnimalName.MOUSE, 50,
            AnimalName.BUG, 90,
            AnimalName.GRASS, 100)),
    DUCK(Map.of(
            AnimalName.BUG, 90,
            AnimalName.GRASS, 100)),
    GRASS(Map.of());

    private final Map<AnimalName, Integer> preyProbabilities;

    AnimalFoodMap(Map<AnimalName, Integer> preyProbabilities) {
        this.preyProbabilities = preyProbabilities;
    }

    public int getProbabilityToEat(AnimalName prey) {
        return preyProbabilities.getOrDefault(prey, 101);
    }

    }
