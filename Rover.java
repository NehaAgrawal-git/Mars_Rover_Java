/**
 * Class representing the Mars Rover.
 * @param x The x coordinate
 * @param y The y coordinate
 * @param direction Direction in which rover is facing
 * @param grid The grid
 */
public class Rover {
    private int x, y;
    private Direction direction;
    private Grid grid;

    public Rover(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void move() throws ObstacleDetectedException,OutOfBoundsException {
        int newX = x, newY = y;

        switch (direction) {
            case N:
                newY += 1;
                break;
            case E:
                newX += 1;
                break;
            case S:
                newY -= 1;
                break;
            case W:
                newX -= 1;
                break;
        }

        if (grid.isObstacle(newX, newY)) {
            throw new ObstacleDetectedException("Obstacle detected at: (" + newX + ", " + newY + ")");
        }

        if (grid.isWithinBounds(newX, newY)) {
            x = newX;
            y = newY;
            System.out.println("The rover is at " + x + " " + y + " facing " + direction);
        } else {
            throw new OutOfBoundsException("Out of bounds: (" + newX + ", " + newY + ")");
        }
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    public String getStatus() {
        return String.format("Rover is at (%d, %d) facing %s.", x, y, direction);
    }
}
