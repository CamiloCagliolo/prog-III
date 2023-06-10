package tp4.matrix;

//Ejercicio 2: Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural
//y cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este,
//sur y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud
//de un camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría
//representarse el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y
//cuatro booleanos, uno para cada dirección a la que se permite ir desde allí.

import java.util.ArrayList;

public class Matrix {
    private Cell[][] matrix;
    private int rows;
    private int columns;
    private int minPathValue;

    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        matrix = new Cell[rows][columns];
    }

    public void setCell(int row, int column, Cell c){
        matrix[row][column] = c;
    }

    public ArrayList<Cell> minPathFromC1toC2(int startingRow, int startingColumn, int finalRow, int finalColumn){
        ArrayList<Cell> path = new ArrayList<>();
        if(startingRow == finalRow && startingColumn == finalColumn){
            return path;
        }
        return minPathFromC1toC2(startingRow, startingColumn, finalRow, finalColumn, path, "none");
    }

    private ArrayList<Cell> minPathFromC1toC2(int startingRow, int startingColumn, int finalRow, int finalColumn, ArrayList<Cell> currentPath, String origin){
        Cell startingCell = matrix[startingRow][startingColumn];
        currentPath.add(startingCell);
        int currentPathLength = pathLength(currentPath);

        //Condición de poda
        if(currentPathLength > minPathValue && minPathValue != 0){
            return currentPath;
        }

        //Condición de corte
        if(startingRow == finalRow && startingColumn == finalColumn){
            if(minPathValue == 0 || currentPathLength < minPathValue){
                minPathValue = currentPathLength;
            }
            return currentPath;
        }

        //Planteo recursivo
        boolean[] directions = startingCell.validDirections();
        ArrayList<Cell>[] paths = new ArrayList[4];
        if (directions[0] && !origin.equals("north")){
            ArrayList<Cell> northPath = minPathFromC1toC2(startingRow-1, startingColumn, finalRow, finalColumn, new ArrayList<Cell>(currentPath), "south");
            paths[0] = northPath;
        }
        if (directions[1] && !origin.equals("south")){
            ArrayList<Cell> southPath = minPathFromC1toC2(startingRow+1, startingColumn, finalRow, finalColumn, new ArrayList<Cell>(currentPath), "north");
            paths[1] = southPath;
        }
        if (directions[2] && !origin.equals("east")){
            ArrayList<Cell> eastPath = minPathFromC1toC2(startingRow, startingColumn-1, finalRow, finalColumn, new ArrayList<Cell>(currentPath), "west");
            paths[2] = eastPath;
        }
        if (directions[3] && !origin.equals("west")){
            ArrayList<Cell> westPath = minPathFromC1toC2(startingRow, startingColumn+1, finalRow, finalColumn, new ArrayList<Cell>(currentPath), "east");
            paths[3] = westPath;
        }

        //Decide cual es el camino más corto y lo retorna
        for(int i = 0; i < 4; i++){
            if(paths[i] != null){
                if(pathLength(paths[i]) < pathLength(currentPath)){
                    currentPath = paths[i];
                }
            }
        }
        
        return currentPath;
    }

    private Integer pathLength(ArrayList<Cell> path){
        Integer length = 0;
        for(Cell c : path){
            length += c.getValue();
        }
        return length;
    }


}
