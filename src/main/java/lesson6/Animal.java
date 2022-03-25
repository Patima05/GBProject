package lesson6;

public abstract class Animal {


    public static int numberOfAnimals = 0;

    private String title;
    int limitOfRunning;
    int limitOfSwimming;

    public Animal(String title, int limitOfRunning, int limitOfSwimming) {
        this.limitOfRunning = limitOfRunning;
        this.limitOfSwimming = limitOfSwimming;
        this.title = title;
        numberOfAnimals++;
    }

    public void run(int obstacleLength){
        int distance = 0;
        if (obstacleLength > limitOfRunning) {
            distance = limitOfRunning;
        } else {
            distance = obstacleLength;
        }
        System.out.printf("%s пробежал(а) %d м.\n", title, distance);
    }

    public void swim(int obstacleLength){
        if (limitOfSwimming == 0) {
            System.out.printf("%s не умеет плавать!\n", title);
        } else {
            int distance = 0;
            if (obstacleLength > limitOfSwimming) {
                distance = limitOfSwimming;
            } else {
                distance = obstacleLength;
            }
            System.out.printf("%s проплыл(а) %d м.\n", title, distance);
        }
    }

    public static int getNumberOfAnimals(){

        return numberOfAnimals;
    }

}
