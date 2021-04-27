import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> changesMap = new HashMap<>();
        SudokuGenerator sudokuGenerator = new SudokuGenerator(changesMap);
        Block[][] sudoku = sudokuGenerator.generate();
        SudokuSolver sudokuSolver = new SudokuSolver();

    }





}