import java.util.Map;
import java.util.Random;

public class SudokuGenerator {
    private final Map<String, Integer> changesMap;

    public SudokuGenerator(Map<String, Integer> changesMap) {
        this.changesMap = changesMap;
    }

    private boolean validator(int from, int to) {
        if (from != to && mapValidator(from, to)) {
            if (from <= 2) {
                return to <= 2;
            } else if (from <= 5) {
                return to >= 3 && to <= 5;
            } else if (from <= 8) {
                return to >= 6 && to <= 8;
            }
        }
        return false;
    }

    public Block[][] generate() {
        Block[][] blocks = new Block[9][9];
        fillSudoku(blocks);
        for (int i = 0; i < 9; i++) {
            int from = RandomNumberGenerator.generateRandomNumber(9,true);
            int to = RandomNumberGenerator.generateRandomNumber(9,true);
            while (!validator(from, to)) {
                from = RandomNumberGenerator.generateRandomNumber(9,true);
                to = RandomNumberGenerator.generateRandomNumber(9,true);
            }
            if (i % 2 == 0) {
                permuteThings(blocks, 'r', from, to);
            } else {
                permuteThings(blocks, 'c', from, to);
            }
        }
        printSudoku(blocks);
        System.out.println();
        hideElements(blocks);
        System.out.println();
        printSudoku(blocks);
        return blocks;
    }

    private boolean mapValidator(int from, int to) {
        if (changesMap.containsKey("c" + from) && changesMap.get("c" + from) == to) {
            return false;
        } else return !changesMap.containsKey("r" + from) || changesMap.get("r" + from) != to;
    }

    private void hideElements(Block[][] blocks) {
        int quantityOfValuesToHide = new Random().nextInt(40) + 1;
        for (int i = 0; i < quantityOfValuesToHide; i++) {
            int row = RandomNumberGenerator.generateRandomNumber(9,false);
            int column = RandomNumberGenerator.generateRandomNumber(9,false);
            if (blocks[row][column].getValue() != 0) {
                blocks[row][column].setValue(0);
            }
            else {
                i--;
            }
        }
    }

    private void fillSudoku(Block[][] blocks) {
        fillFirstLine(blocks);
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!(i == 3 || i == 6)) {
                    blocks[i][j] = new Block(blocks[i - 1][(j + 3) % 9].getValue());
                }
            }
        }
    }

    private void fillFirstLine(Block[][] blocks) {
        for (int i = 0; i < 9; i++) {
            blocks[0][i] = new Block(((i + 1) % 9) + 1);
            blocks[3][i] = new Block(((i + 2) % 9) + 1);
            blocks[6][i] = new Block(((i + 3) % 9) + 1);
        }
    }

    private void printSudoku(Block[][] blocks) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(blocks[i][j]);
            }
            System.out.println();
        }
    }

    private void permuteThings(Block[][] blocks, char whatToPermute, int from, int to) {
        int swap;
        if (whatToPermute == 'r' || whatToPermute == 'R') {
            for (int i = 0; i < 9; i++) {
                swap = blocks[from][i].getValue();
                blocks[from][i].setValue(blocks[to][i].getValue());
                blocks[to][i].setValue(swap);
            }
        } else if (whatToPermute == 'c' || whatToPermute == 'C') {
            for (int i = 0; i < 9; i++) {
                swap = blocks[i][from].getValue();
                blocks[i][from].setValue(blocks[i][to].getValue());
                blocks[i][to].setValue(swap);
            }
        }
        changesMap.put(whatToPermute + "" + from, to);
    }
}
