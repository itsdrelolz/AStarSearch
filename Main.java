import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Environment environment = new Environment();
        AStarSearch aStarSearch = new AStarSearch(environment.getGrid());

        while (true) {
            System.out.println("Generated Environment:");
            environment.displayEnvironment();

            System.out.println("Enter starting node coordinates (row col):");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();

            System.out.println("Enter goal node coordinates (row col):");
            int goalRow = scanner.nextInt();
            int goalCol = scanner.nextInt();

            // Run A* algorithm to find path
            Node startNode = environment.getGrid()[startRow][startCol];
            Node goalNode = environment.getGrid()[goalRow][goalCol];
            List<Node> path = aStarSearch.findPath(startNode, goalNode);

            if (!path.isEmpty()) {
                System.out.println("Path found:");
                for (Node node : path) {
                    System.out.print("[" + node.getRow() + ", " + node.getCol() + "] ");
                }
                System.out.println();
            } else {
                System.out.println("No path found.");
            }

            System.out.println("Do you want to continue? (yes/no)");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
