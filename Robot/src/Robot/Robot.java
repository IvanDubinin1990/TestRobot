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

        int startingPointX = robot.getX();
        int startingPointY = robot.getY();

        if ((toX > robot.getX() && robot.getDirection() == Direction.LEFT) || (toX < robot.getX() && robot.getDirection() == Direction.RIGHT)) {
            robot.turnRight();
        } else if ((toX > robot.getX() && robot.getDirection() == Direction.RIGHT) || (toX < robot.getX() && robot.getDirection() == Direction.LEFT)) {
            robot.turnLeft();
        } else if ((toX > robot.getX() && robot.getDirection() == Direction.DOWN) || (toX < robot.getX() && robot.getDirection() == Direction.UP)) {
            robot.turnLeft();
            robot.turnLeft();
        }

        if (toX > robot.getX()) {
            for (int i = 0; i < toX - startingPointX; i++) {
                robot.stepForward();
            }
        } else if (toX < robot.getX()) {
            for (int i = 0; i < startingPointX - toX; i++) {
                robot.stepForward();
            }
        }


        if ((toY > robot.getY() && robot.getDirection() == Direction.UP) || (toY < robot.getY() && robot.getDirection() == Direction.DOWN)) {
            robot.turnRight();
        } else if ((toY > robot.getY() && robot.getDirection() == Direction.DOWN) || (toY < robot.getY() && robot.getDirection() == Direction.UP)) {
            robot.turnLeft();
        } else if ((toY > robot.getY() && robot.getDirection() == Direction.LEFT) || (toY < robot.getY() && robot.getDirection() == Direction.RIGHT)) {
            robot.turnLeft();
            robot.turnLeft();
        }

        if (toY > robot.getY()) {
            for (int i = 0; i < toY - startingPointY; i++) {
                robot.stepForward();
            }
        } else if (toY < robot.getY()) {
            for (int i = 0; i < startingPointY - toY; i++) {
                robot.stepForward();
            }
        }
    }
}
