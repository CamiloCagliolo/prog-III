package tp4.matrix;

public class Cell {
    private Integer value;
    private boolean north;
    private boolean south;
    private boolean east;
    private boolean west;

    public Cell (Integer v, boolean n, boolean s, boolean e, boolean w){
        value = v;
        north = n;
        south = s;
        east = e;
        west = w;
    }

    public boolean[] validDirections(){
        boolean[] directions = new boolean[4];
        directions[0] = north;
        directions[1] = south;
        directions[2] = east;
        directions[3] = west;
        return directions;
    }

    public Integer getValue(){
        return value;
    }

    public void setValue(Integer v){
        value = v;
    }
}
