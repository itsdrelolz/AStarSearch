import java.util.Random;

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
