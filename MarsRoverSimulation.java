import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Main Class for mars rover simulation.
*/
public class MarsRoverSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking grid size input
        System.out.println("Enter the grid size (width and height): ");
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        // Create grid
        Grid grid = new Grid(width, height);

        // Taking obstacle positions input
        System.out.println("Enter the number of obstacles: ");
        int numberOfObstacles = scanner.nextInt();
        for (int i = 0; i < numberOfObstacles; i++) {
            System.out.println("Enter obstacle position (x, y): ");
            int obsX = scanner.nextInt();
            int obsY = scanner.nextInt();
            grid.addObstacle(obsX, obsY);
        }

        // Taking initial position and direction input
        System.out.println("Enter the initial position (x, y) and direction (N, S, E, W): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        char directionChar = scanner.next().charAt(0);
        Direction direction = Direction.valueOf(String.valueOf(directionChar));

        // Create the rover
        Rover rover = new Rover(x, y, direction, grid);

        // Taking commands input
        System.out.println("Enter the commands (M for move, L for turn left, R for turn right): ");
        scanner.nextLine();
        String commandsStr = scanner.nextLine();
        List<Command> commands = createCommands(commandsStr, rover);
        System.out.println("The path that rover followed was : ");
        // Execute commands
        for (Command command : commands) {
            command.execute();
        }

        System.out.println("The final place rover is at :");
        // Print final status
        System.out.println(rover.getStatus());

        scanner.close();
    }

    private static List<Command> createCommands(String commandsStr, Rover rover) {
        return commandsStr.chars()
                .mapToObj(c -> {
                    switch (c) {
                        case 'M':
                            return new MoveCommand(rover);
                        case 'L':
                            return new TurnLeftCommand(rover);
                        case 'R':
                            return new TurnRightCommand(rover);
                        default:
                            throw new IllegalArgumentException("Invalid command: " + (char) c);
                    }
                })
                .collect(Collectors.toList());
    }
}
