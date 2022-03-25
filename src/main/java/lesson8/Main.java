package lesson8;

public class Main {
    public static void main(String[] args) {

        Participant cat = new Cat("Коржик", 55, 100);
        Participant human = new Human("Саша", 260, 100);
        Participant robot = new Robot("ЕЕT9", 300, 0);
        Participant[] participants = {cat, human, robot};

        Obstacle wall1 = new Wall("\"Стена 1\"",60);
        Obstacle wall2 = new Wall("\"Стена 2\"",100);
        Obstacle wall3 = new Wall("\"Стена 3\"",120);
        Obstacle wall4 = new Wall("\"Стена 4\"",400);
        Obstacle track1 = new Track("\"Дорожка 1\"",70);
        Obstacle track2 = new Track("\"Дорожка 2\"",100);
        Obstacle track3 = new Track("\"Дорожка 3\"",200);
        Obstacle track4 = new Track("\"Дорожка 4\"",150);
        Obstacle[] obstacles = {wall1, track1, wall2, track2, wall3, track3, wall4, track4};

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (!participants[i].passingThroughObstacles(obstacles[j])){
                    break;
                }
            }

        }
    }
}
