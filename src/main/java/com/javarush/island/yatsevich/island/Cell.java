package com.javarush.island.yatsevich.island;

import com.javarush.island.yatsevich.entity.entities.AnimalEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final List<AnimalEntity> animals = Collections.synchronizedList(new ArrayList<>());
    private final ReentrantLock lock = new ReentrantLock();
    public final int MAX_ANIMALS = 3;

    public Cell() {
    }

    public void addAnimal(AnimalEntity animal) throws IllegalStateException {
        lock.lock();
        try {
            if (animals.size() >= MAX_ANIMALS) {
                return;
            }
            animals.add(animal);
        } finally {
            lock.unlock();
        }
    }

    public void removeAnimal(AnimalEntity animal) {
        lock.lock();
        try {
            boolean removed = animals.remove(animal);
            if (!removed) {
                throw new IllegalStateException();
            }
        } finally {
            lock.unlock();
        }
    }

    public List<AnimalEntity> getAnimals() {
        lock.lock();
        try {
            return new ArrayList<>(animals);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        synchronized (animals) {
            return " "+animals+" ";
        }
    }
}
