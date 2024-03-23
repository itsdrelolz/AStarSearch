import java.util.PriorityQueue;
import java.util.Random;

public class AStarSearch {

    private static Node[][] grid;
    private PriorityQueue<Node> openList;
    private boolean[][] closedList;

    static Node startNode;
    static Node goalNode;
    private int blocks;

    public AStarSearch(int sr, int sc, int gr, int gc) {
        grid = new Node[15][15];

        closedList = new boolean[15][15];
        openList = new PriorityQueue<>((n1, n2) -> {
            return n1.getF() < n2.getF() ? -1 : n1.getF() > n2.getF() ? 1 : 0;
        });

        startNode = new Node(sc, sr, 0);
        goalNode = new Node(gc, gr, 0);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Node(i, j, 0);
                grid[i][j].setH(Math.abs(i - goalNode.getRow()) + Math.abs(j - goalNode.getCol()));
                grid[i][j].isGoal = false;
            }
        }

        grid[sc][sr].setG(0);

        Random random = new Random();
        while (blocks < 23) {
            int i = random.nextInt(grid.length);
            int j = random.nextInt(grid[0].length);
            if (grid[i][j].getT() == 0) {
                addBlocks(i, j);
                blocks++;
            }
        }
    }


    public void addBlocks(int i, int j) {
        grid[i][j].setT(1);
    }

    public void updateF(Node current, Node parent, int gValue) {
        if (parent.getT() == 1 || closedList[parent.getRow()][parent.getCol()]) {
            return;
        }

        int pFValue = parent.getF() + gValue;
        boolean oList = openList.contains(parent);

        if (!oList || pFValue < parent.getF()) {
            parent.setG(pFValue); // Update the G value
            parent.setF(); // Recalculate the F value based on updated G and H values
            parent.setParent(current);
            if (!oList) {
                openList.add(parent);
            }
        }
    }
        

    public void createPath() {
        openList.add(grid[startNode.getRow()][startNode.getCol()]);

        Node c;

        while (!openList.isEmpty()) {
            c = openList.poll();

            if (c.getT() == 1) {
                continue;
            }

            closedList[c.getRow()][c.getCol()] = true;

            if (c.equals(grid[goalNode.getRow()][goalNode.getCol()])) {
                return;
            }

            Node temp;

            // Move up
            if (c.getRow() - 1 >= 0) {
                temp = grid[c.getRow() - 1][c.getCol()];
                updateF(c, temp, c.getF() + 10);
            }

            // Move left
            if (c.getCol() - 1 >= 0) {
                temp = grid[c.getRow()][c.getCol() - 1];
                updateF(c, temp, c.getF() + 10);
            }

            // Move down
            if (c.getRow() + 1 < grid.length) {
                temp = grid[c.getRow() + 1][c.getCol()];
                updateF(c, temp, c.getF() + 10);
            }

            // Move right
            if (c.getCol() + 1 < grid[0].length) {
                temp = grid[c.getRow()][c.getCol() + 1];
                updateF(c, temp, c.getF() + 10);
            }

            // Diagonal moves

            // Top-left
            if (c.getRow() - 1 >= 0 && c.getCol() - 1 >= 0) {
                temp = grid[c.getRow() - 1][c.getCol() - 1];
                updateF(c, temp, c.getF() + 14);
            }

            // Top-right
            if (c.getRow() - 1 >= 0 && c.getCol() + 1 < grid[0].length) {
                temp = grid[c.getRow() - 1][c.getCol() + 1];
                updateF(c, temp, c.getF() + 14);
            }

            // Bottom-left
            if (c.getRow() + 1 < grid.length && c.getCol() - 1 >= 0) {
                temp = grid[c.getRow() + 1][c.getCol() - 1];
                updateF(c, temp, c.getF() + 14);
            }

            // Bottom-right
            if (c.getRow() + 1 < grid.length && c.getCol() + 1 < grid[0].length) {
                temp = grid[c.getRow() + 1][c.getCol() + 1];
                updateF(c, temp, c.getF() + 14);
            }
        }
    }


    public void showGrid() {
        System.out.println("Grid:");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == startNode.getRow() && j == startNode.getCol())
                    System.out.print("S ");
                else if (i == goalNode.getRow() && j == goalNode.getCol())
                    System.out.print("G ");
                else if (grid[i][j].getT() == 1)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println();
    }

    
    
    
    
    
    public void showGridPath() {
        if (closedList[goalNode.getRow()][goalNode.getCol()]) {
            System.out.print("Path taken: ");
            Node d = grid[goalNode.getRow()][goalNode.getCol()];
            System.out.println(d.toString());

            grid[d.getRow()][d.getCol()].isGoal = true;

            while (d.getParent() != null) {
                System.out.print(d.getParent().toString() + " <- ");
                grid[d.getParent().getRow()][d.getParent().getCol()].isGoal = true;
                d = d.getParent();
            }

            System.out.println("\n");

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == startNode.getRow() && j == startNode.getCol()) {
                        System.out.print("S ");
                    } else if (i == goalNode.getRow() && j == goalNode.getCol()) {
                        System.out.print("G ");
                    } else if (grid[i][j].isGoal) {
                        System.out.print("1 ");
                    } else if (grid[i][j].getT() == 0) {
                        System.out.print("0 ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        } else {
            System.out.println("No path found");
        }
    }
}    
