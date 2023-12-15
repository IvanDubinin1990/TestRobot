package Robot;

public class Main {
    public static void main(String[] args) {

        Robot r2d2 = new Robot(-5, 4, Direction.UP);

        Robot.moveRobot(r2d2, 100, 15);

        r2d2.printRobotPosition();

        Robot r2d4 = new Robot(2, 0, Direction.RIGHT);

        Robot.moveRobot(r2d4, -100, -10);

        r2d4.printRobotPosition();

    }
}
