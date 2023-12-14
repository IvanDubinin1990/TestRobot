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
            case UP -> x += 1;
            case DOWN -> x -= 1;
            case RIGHT -> y += 1;
            case LEFT -> y -= 1;
        }
    }

    public void printRobotPosition() {
        System.out.println("Координата х: " + getX() + " Координата y: " + getY());
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        int startingPointX = robot.x;
        int startingPointY = robot.y;

        if ((toX > robot.x && robot.direction == Direction.LEFT) || (toX < robot.x && robot.direction == Direction.RIGHT)) {
            robot.turnRight();
        } else if ((toX > robot.x && robot.direction == Direction.RIGHT) || (toX < robot.x && robot.direction == Direction.LEFT)) {
            robot.turnLeft();
        } else if ((toX > robot.x && robot.direction == Direction.DOWN) || (toX < robot.x && robot.direction == Direction.UP)) {
            robot.turnLeft();
            robot.turnLeft();
        }

        if (toX > robot.x) {
            for (int i = 0; i < toX - startingPointX; i++) {
                robot.stepForward();
            }
        } else if (toX < robot.x) {
            for (int i = 0; i < startingPointX - toX; i++) {
                robot.stepForward();
            }
        }


        if ((toY > robot.y && robot.direction == Direction.UP) || (toY < robot.y && robot.direction == Direction.DOWN)) {
            robot.turnRight();
        } else if ((toY > robot.y && robot.direction == Direction.DOWN) || (toY < robot.y && robot.direction == Direction.UP)) {
            robot.turnLeft();
        } else if ((toY > robot.y && robot.direction == Direction.LEFT) || (toY < robot.y && robot.direction == Direction.RIGHT)) {
            robot.turnLeft();
            robot.turnLeft();
        }

        if (toY > robot.y) {
            for (int i = 0; i < toY - startingPointY; i++) {
                robot.stepForward();
            }
        } else if (toY < robot.y) {
            for (int i = 0; i < startingPointY - toY; i++) {
                robot.stepForward();
            }
        }
    }
}
