import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;


public class Node {
    private int row, col, f, g, h, type;
    private Node parent;
    public Node(int r, int c, int t) {
    row = r;
    col = c;
    type = t;
    parent = null;
    }
    //mutator methods to set values
    public void setF() {
    f = g + h;
    }
    public void setG(int value) {
    g = value;
    }
    public void setH(int value) {
    h = value;
    }
    public void setParent(Node n) {
    parent = n;
    }
    //accessor methods to get values
    public int getF() {
    return f;
    }
    public int getG() {
    return g;
    }
    public int getH() {
    return h;
    }
    public Node getParent() {
    return parent;
    }
    public int getRow() {
    return row;
    }
    public int getCol() {
    return col;
    }
    public boolean equals(Object in) {
    //typecast to Node
    Node n = (Node) in;
    return row == n.getRow() && col == n.getCol();
    }
    public String toString() {
    return "Node: " + row + "_" + col;
    }
}


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
    }


    private Node getGoalNode() {
        // ... (use Scanner to get input)
    }


    // Display the environment
    public void displayEnvironment() {
        // ...
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


