package com.javarush.island.yatsevich;

import com.javarush.island.yatsevich.island.IslandMap;
import com.javarush.island.yatsevich.utils.tasks.EatingTask;
import com.javarush.island.yatsevich.utils.tasks.MovingTask;
import com.javarush.island.yatsevich.utils.tasks.ReproducingTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Runner {
    public static void main(String[] args) throws InterruptedException {
        IslandMap islandMap = new IslandMap();
        try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
            while (!Thread.currentThread().isInterrupted()) {
                executor.submit(new MovingTask(islandMap));
                executor.submit(new EatingTask(islandMap));
                executor.submit(new ReproducingTask(islandMap));
                islandMap.view();
                islandMap.printAnimalStatistics();
                TimeUnit.SECONDS.sleep(1);
            }
            executor.shutdown();
        }
    }


}






