package Robot;

public class Robot {

    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (direction) {
            case UP -> direction = Direction.LEFT;
            case LEFT -> direction = Direction.DOWN;
            case DOWN -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.UP;
        }
    }

    public void turnRight() {
        switch (direction) {
            case UP -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.DOWN;
            case DOWN -> direction = Direction.LEFT;
            case LEFT -> direction = Direction.UP;
        }
    }

    public void stepForward() {
        switch (direction) {
            case UP -> y += 1;
            case DOWN -> y -= 1;
            case RIGHT -> x += 1;
            case LEFT -> x -= 1;
        }
    }

    public void printRobotPosition() {
        System.out.println("Координата х: " + getX() + " Координата y: " + getY());
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        switch (robot.getDirection()) {
            case LEFT -> robot.turnRight();
            case RIGHT -> robot.turnLeft();
            case DOWN -> {
                robot.turnRight();
                robot.turnRight();
            }
        }

        while (toY > robot.getY()) {
            robot.stepForward();
        }

        if (toY < robot.getY()) {
            robot.turnLeft();
            robot.turnLeft();
            while (toY < robot.getY()) {
                robot.stepForward();
            }
        }

        switch (robot.getDirection()) {
            case DOWN -> {
                robot.turnRight();
                robot.turnRight();
            }
        }

        if (toX > robot.getX()) {
            robot.turnRight();
            while (toX > robot.getX()) {
                robot.stepForward();
            }
        } else if (toX < robot.getX()) {
            robot.turnLeft();
            while (toX < robot.getX()) {
                robot.stepForward();
            }
        }
    }
}
