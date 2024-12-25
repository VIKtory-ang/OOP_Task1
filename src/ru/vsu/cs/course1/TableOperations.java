package ru.vsu.cs.course1;

import java.util.List;
import java.util.Map;

public interface TableOperations {
    void addRow(List<String> row);
    List<String> getRow(int index);
    List<String> getColumn(int index);
    Map<String, Integer> groupByColumn(int index);
    Map<String, Integer> groupByRow(int rowIndex);

    void addRowsFromArray(String[][] tableData);


}
