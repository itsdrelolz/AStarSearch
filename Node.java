public class Node {
    private int row, col, f, g, h, type;
    public boolean isGoal;
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
    public void setT(int value) {
		type = value;
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
    public int getT() {

		return type;
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