import java.util.Iterator;
import java.util.List;

public class BlockInfo {
    private final List<Integer> rowColumnList;
    private final List<Integer> boxesContainsList;
    private final List<Integer> boxesAvailableList;
    private final List<Integer> possibleRowColumnPairsList;

    public BlockInfo(List<Integer> rowColumnList, List<Integer> boxesContains, List<Integer> boxesAvailable, List<Integer> possibleRowColumnPairsList) {
        this.rowColumnList = rowColumnList;
        this.boxesContainsList = boxesContains;
        this.boxesAvailableList = boxesAvailable;
        this.possibleRowColumnPairsList = possibleRowColumnPairsList;
    }

    public List<Integer> getRowColumnList() {
        return rowColumnList;
    }

    public List<Integer> getBoxesContainsList() {
        return boxesContainsList;
    }

    public List<Integer> getBoxesAvailableList() {
        return boxesAvailableList;
    }

    public List<Integer> getPossibleRowColumnPairsList() {
        return possibleRowColumnPairsList;
    }

    private void fillBoxesAvailableList() {
        for (int i = 0 ; i < 9 ; i++) {
            boxesAvailableList.add(i+1);
        }
        for (int i : boxesContainsList) {
            if (boxesAvailableList.contains(i)) {
                boxesAvailableList.remove(i);
            }
        }
    }

    private void fillPossibleRowColumnList() {

    }

}
