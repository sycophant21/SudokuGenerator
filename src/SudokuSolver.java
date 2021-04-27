public class SudokuSolver {
    public SudokuSolver() {

    }

    public Block[][] solve(Block[][] blocks) {
        Block block = getEmptyBlock(blocks);
        if (block != null) {

        }
        return blocks;
    }
    private Block getEmptyBlock(Block[][] blocks) {
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (blocks[i][j].getValue() == 0) {
                    return blocks[i][j];
                }
            }
        }
        return null;
    }
    private boolean validateColumn(Block[][] blocks, Block block, int column) {
        for (int i = 0 ; i < 9 ; i++) {
            if (blocks[i][column].getValue() == block.getValue()) {
                return false;
            }
        }
        return true;
    }
    private boolean validateRow(Block[][] blocks, Block block, int row) {
        for (int i = 0 ; i < 9 ; i++) {
            if (blocks[row][i].getValue() == block.getValue()) {
                return false;
            }
        }
        return true;
    }
/*    private boolean validateBox(Block[][] blocks, Block block, int box) {

    }*/
}
