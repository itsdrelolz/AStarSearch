import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting node value for rows: ");    
        int startingRow = scanner.nextInt();
        System.out.println("Enter starting node value for columns: ");
        int startingCol = scanner.nextInt();
        System.out.println("Enter goal node value for rows: ");
        int goalRow = scanner.nextInt();
        System.out.println("Enter goal node value for columns: ");
        int goalCol = scanner.nextInt();
        AStarSearch a = new AStarSearch(startingRow, startingCol, goalRow, goalCol);
        a.showGrid();
        a.createPath();
        scanner.close();
    }
    

    }