package lesson8;

public class Human implements Participant {
    private String name;
    private int runningLimit;
    private int jumpingLimit;

    public Human(String name, int runningLimit, int jumpingLimit) {
        this.name = name;
        this.runningLimit = runningLimit;
        this.jumpingLimit = jumpingLimit;
    }

    @Override
    public boolean run(Obstacle obstacle) {
        if (obstacle.getSize() <= runningLimit) {
            System.out.println(this.name + " пробежал дорожку " + obstacle);
            return true;
        } else {
            System.out.println(this.name + " не смог пробежать дорожку " + obstacle);
            return false;
        }
    }

    @Override
    public boolean jump(Obstacle obstacle) {
        if (obstacle.getSize() <= jumpingLimit) {
            System.out.println(this.name + " перепрыгнул через стену " + obstacle);
            return true;
        } else {
            System.out.println(this.name + " не смог перепрыгнуть через стену " + obstacle);
            return false;
        }
    }

    @Override
    public boolean passingThroughObstacles(Obstacle obstacle) {

        if (obstacle.getName() == "track") {
            return run(obstacle);
        }
        else {
            return jump(obstacle);
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
