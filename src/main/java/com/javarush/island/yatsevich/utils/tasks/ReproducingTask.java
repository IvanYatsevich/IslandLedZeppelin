package com.javarush.island.yatsevich.utils.tasks;

import com.javarush.island.yatsevich.island.IslandMap;

public class ReproducingTask implements Runnable {

    private final IslandMap islandMap;

    public ReproducingTask(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    @Override
    public void run() {
        try {
            islandMap.simulateReproduce(islandMap);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
