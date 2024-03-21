import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;





public class AStarSearch {
    private static final int GRID_SIZE = 15;
    private static final int PATHABLE = 0;
    private static final int BLOCKED = 1;


    private int[][] grid;


    public AStarSearch(int[][] map, Node start, Node goal) {
        grid = new int[GRID_SIZE][GRID_SIZE];
        generateRandomEnvironment();
    }

  // A* search implementation
    public List<Node> findPath(Node start, Node goal) {
        // ... (A* algorithm logic with openList, closedList, etc.)
        
    }


    // Heuristic (Manhattan Distance)
    private int calculateHeuristic(Node current, Node goal) {
       // ...
        
    }


    // User input handling
    private Node getStartNode() {
        // ... (use Scanner to get input)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row and column of the start node: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Node(row, col, PATHABLE);

    }


    private Node getGoalNode() {
        // ... (use Scanner to get input)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row and column of the goal node: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Node(row, col, PATHABLE);
    }


    // Display the environment
    public void displayEnvironment() {
        // ...
    }

    public static Node[][] generateRandomEnvironment() {
        // ...
        Node[][] grid = new Node[GRID_SIZE][GRID_SIZE];
        Random random = new Random();
                
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                int type = random.nextInt(2);
                grid[row][col] = new Node(row, col, type);
            }
        }
    }

    public static void main(String[] args) {
        AStarSearch search = new AStarSearch();
        search.displayEnvironment();


        while (true) {
            Node start = search.getStartNode();
            Node goal = search.getGoalNode();
            List<Node> path = search.findPath(start, goal);
            
             // Display the path (or "path not found" message)
        }
    }


}

