import java.util.*;

class Spreadsheet {
    private int[][] grid;  // rows × 26 columns

    public Spreadsheet(int rows) {
        grid = new int[rows][26]; // initialized to 0 by default
    }
    
    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }
    
    public int getValue(String formula) {
        // formula always in format "=X+Y"
        String expr = formula.substring(1); // remove '='
        String[] parts = expr.split("\\+");
        
        int left = evaluate(parts[0]);
        int right = evaluate(parts[1]);
        
        return left + right;
    }
    
    // helper: evaluate operand (either number or cell reference)
    private int evaluate(String token) {
        if (Character.isDigit(token.charAt(0))) {
            return Integer.parseInt(token);
        } else {
            int[] pos = parseCell(token);
            return grid[pos[0]][pos[1]];
        }
    }
    
    // helper: parse "B12" → [rowIndex, colIndex]
    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}
