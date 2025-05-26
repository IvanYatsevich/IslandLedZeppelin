package com.javarush.island.yatsevich.utils.tasks;

import com.javarush.island.yatsevich.island.IslandMap;

public class EatingTask implements Runnable {

    private final IslandMap islandMap;

    public EatingTask(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    @Override
    public void run() {
        try {
            islandMap.simulateEating(islandMap);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
