import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class AStarSearch {
    private Node[][] grid;
    private int numRows;
    private int numCols;

    public AStarSearch(Node[][] grid) {
        this.grid = grid;
        this.numRows = grid.length;
        this.numCols = grid[0].length;
    }

    // A* search algorithm implementation

    // Other necessary methods: generateSuccessors, calculateHeuristic, reconstructPath

    // Implement the A* search algorithm as described previously
}

public class Environment {
    private static final int GRID_SIZE = 15;
    private static final double OBSTACLE_PROBABILITY = 0.1;

    private Node[][] grid;

    public Environment() {
        grid = generateRandomGrid(GRID_SIZE, GRID_SIZE, OBSTACLE_PROBABILITY);
    }

    private Node[][] generateRandomGrid(int rows, int cols, double obstacleProbability) {
        Node[][] grid = new Node[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int type = random.nextDouble() < obstacleProbability ? 1 : 0; // 1 for obstacle, 0 for empty
                grid[i][j] = new Node(i, j, type);
            }
        }

        return grid;
    }

    public void displayEnvironment() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j].getType() == 1 ? "X " : "_ "); // X for obstacle, _ for empty
            }
            System.out.println();
        }
    }

    public Node[][] getGrid() {
        return grid;
    }
}

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
