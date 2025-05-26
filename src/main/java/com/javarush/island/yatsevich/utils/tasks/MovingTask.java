package com.javarush.island.yatsevich.utils.tasks;

import com.javarush.island.yatsevich.island.IslandMap;

public class MovingTask implements Runnable {


    private final IslandMap islandMap;

    public MovingTask(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    @Override
    public void run() {
        try {
            islandMap.simulateMoving(islandMap);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
