/**
 * Command to move the rover.
 * @param rover The rover which is to be moved.
 */
public class MoveCommand implements Command {
    private Rover rover;

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        try {
            rover.move();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
