package com.javarush.island.yatsevich.island;

import com.javarush.island.yatsevich.entity.entities.AnimalEntity;
import com.javarush.island.yatsevich.entity.factory.AnimalFactory;
import com.javarush.island.yatsevich.utils.random.Rnd;
import com.javarush.island.yatsevich.entity.animalEnums.AnimalName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class IslandMap {
    private final int WIDTH = 100;
    private final int HEIGHT = 20;
    private final Cell[][] cells;
    private final ReentrantLock[][] locks;
    final int VIEW_LIMIT = 5;

    public IslandMap() {
        this.cells = new Cell[WIDTH][HEIGHT];
        this.locks = new ReentrantLock[WIDTH][HEIGHT];
        mapInitialization(this.WIDTH, this.HEIGHT);
        AnimalFactory animalFactory = new AnimalFactory();
        fillTheMap(animalFactory, this);
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) {
            throw new IllegalArgumentException("Wrong coordinates! X: " + x + ", Y: " + y);
        }
        lockCell(x, y);
        try {
            return cells[x][y];
        } finally {
            unlockCell(x, y);
        }
    }

    private void mapInitialization(int width, int height) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell();
                locks[x][y] = new ReentrantLock();
            }
        }
    }

    public int[] findCellPosition(Cell cell) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (cells[x][y] == cell) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    public void view() {
        System.out.println(this);
    }

    public void printAnimalStatistics() {
        Map<String, Integer> animalCount = new ConcurrentHashMap<>();
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                for (AnimalEntity animal : getCell(x, y).getAnimals()) {
                    String name = animal.getAnimalName().name();
                    animalCount.put(name, animalCount.getOrDefault(name, 0) + 1);
                }
            }
        }
        System.out.println("Actual animal count: ");
        for (Map.Entry<String, Integer> entry : animalCount.entrySet()) {
            System.out.printf("%s -> %d|", entry.getKey(), entry.getValue());

        }
        System.out.println();
    }

    public static void fillTheMap(AnimalFactory animalFactory, IslandMap islandMap)  {
        final int MAX_AMOUNT_OF_FILLED_CELLS = 15000;
        int filledCells = 0;
        while (filledCells < MAX_AMOUNT_OF_FILLED_CELLS) {
            int x = Rnd.random(0, islandMap.getWidth() - 1);
            int y = Rnd.random(0, islandMap.getHeight() - 1);
            Cell cell = islandMap.getCell(x, y);
            int animalCount = Rnd.random(1, 3);
            for (int i = 0; i < animalCount; i++) {
                int type = Rnd.random(1, 34);
                switch (type) {
                    case 1, 2 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.WOLF));
                    case 3, 4 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.FOX));
                    case 5, 6 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.HORSE));
                    case 7, 8 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.EAGLE));
                    case 9, 10 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.BEAR));
                    case 11, 12 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.BOA));
                    case 13, 14 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.DEER));
                    case 15, 16 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.RABBIT));
                    case 17, 18 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.MOUSE));
                    case 19, 20 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.GOAT));
                    case 21, 22 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.SHEEP));
                    case 23, 24 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.BOAR));
                    case 25, 26 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.BUFFALO));
                    case 27, 28 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.DUCK));
                    case 29, 30 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.BUG));
                    case 31, 32 -> cell.addAnimal(animalFactory.createAnimal(AnimalName.GRASS));
                }
            }
            filledCells++;
        }
    }


    public void simulateEating(IslandMap map) throws InterruptedException {
        for (int row = 0; row < map.getWidth(); row++) {
            for (int col = 0; col < map.getHeight(); col++) {
                Cell cell = map.getCell(row, col);
                List<AnimalEntity> animals = new ArrayList<>(cell.getAnimals());
                for (AnimalEntity animal : animals) {
                    animal.eat(cell);
                }
            }
        } Thread.sleep(500);
    }

    public void simulateMoving(IslandMap map) throws InterruptedException {
        for (int row = 0; row < map.getWidth(); row++) {
            for (int col = 0; col < map.getHeight(); col++) {
                Cell cell = map.getCell(row, col);
                int x = map.findCellPosition(cell)[0];
                int y = map.findCellPosition(cell)[1];
                List<AnimalEntity> animals = cell.getAnimals();
                for (AnimalEntity animal : animals) {
                    animal.move(this, x, y );
                }
            }
        } Thread.sleep(500);
    }

    public void simulateReproduce(IslandMap map) throws InterruptedException {
            for (int row = 0; row < map.getWidth(); row++) {
                for (int col = 0; col < map.getHeight(); col++) {
                    Cell cell = map.getCell(row, col);
                    int x = map.findCellPosition(cell)[0];
                    int y = map.findCellPosition(cell)[1];
                    List<AnimalEntity> animals = cell.getAnimals();
                    for (AnimalEntity animal : animals) {
                        animal.reproduce(map.getCell(x, y));
                    }
                }
            } Thread.sleep(500);
        }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < VIEW_LIMIT; y++) {
            for (int x = 0; x < VIEW_LIMIT; x++) {
                sb.append(cells[x][y].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public synchronized int getWidth() {
        return WIDTH;
    }

    public synchronized int getHeight() {
        return HEIGHT;
    }

    public void lockCell(int x, int y) {
        locks[x][y].lock();
    }

    public void unlockCell(int x, int y) {
        locks[x][y].unlock();
    }

}
