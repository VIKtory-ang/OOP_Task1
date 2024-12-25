package ru.vsu.cs.course1;

import java.util.*;

/*public class Table implements TableOperations {
    private List<List<String>> data;

    public Table(List<String> table) {
        this.data = new ArrayList<>();
    }

    @Override
    public void addRow(List<String> row) {
        data.add(row);
    }

    @Override
    public List<String> getRow(int index) {
        return data.get(index);
    }

    @Override
    public List<String> getColumn(int index) {
        List<String> column = new ArrayList<>();
        for (List<String> row : data) {
            column.add(row.get(index));
        }
        return column;
    }

    @Override
    public Map<String, Integer> groupByColumn(int index) {
        Map<String, Integer> groupCount = new HashMap<>();
        for (List<String> row : data) {
            String key = row.get(index);
            groupCount.put(key, groupCount.getOrDefault(key, 0) + 1);
        }
        return groupCount;
    }

    @Override
    public Map<String, Integer> groupByRow(int rowIndex) {
        Map<String, Integer> groupCount = new HashMap<>();
        List<String> row = data.get(rowIndex);
        for (String value : row) {
            groupCount.put(value, groupCount.getOrDefault(value, 0) + 1);
        }
        return groupCount;
    }

    @Override
    public void addRowsFromArray(String[][] tableData) {
        for (String[] rowArray : tableData) {
            List<String> row = new ArrayList<>();
            for (String cell : rowArray) {
                row.add(cell);
            }
            addRow(row);
        }
    }

    @Override
    public void clearTable() {
        data.clear();
    }
}*/
public class Table implements TableOperations {
    private final List<List<String>> data;

    public Table() {
        this.data = new ArrayList<>();
    }

    @Override
    public void addRow(List<String> row) {
        if (row == null || row.isEmpty()) {
            throw new IllegalArgumentException("Row cannot be null or empty");
        }
        data.add(new ArrayList<>(row)); // Защита от изменения исходного списка
    }

    @Override
    public List<String> getRow(int index) {
        validateRowIndex(index);
        return Collections.unmodifiableList(data.get(index));
    }

    @Override
    public List<String> getColumn(int index) {
        validateColumnIndex(index);
        List<String> column = new ArrayList<>();
        for (List<String> row : data) {
            column.add(row.get(index));
        }
        return column;
    }

    @Override
    public Map<String, Integer> groupByColumn(int index) {
        validateColumnIndex(index);
        return DataGrouper.groupBy(getColumn(index));
    }

    @Override
    public Map<String, Integer> groupByRow(int rowIndex) {
        validateRowIndex(rowIndex);
        return DataGrouper.groupBy(getRow(rowIndex));
    }

    @Override
    public void addRowsFromArray(String[][] tableData) {
        if (tableData == null || tableData.length == 0) {
            throw new IllegalArgumentException("Table data cannot be null or empty");
        }
        for (String[] rowArray : tableData) {
            addRow(List.of(rowArray));
        }
    }


    private void validateRowIndex(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Invalid row index: " + index);
        }
    }

    private void validateColumnIndex(int index) {
        if (data.isEmpty() || index < 0 || index >= data.get(0).size()) {
            throw new IndexOutOfBoundsException("Invalid column index: " + index);
        }
    }
}

class DataGrouper {
    public static Map<String, Integer> groupBy(List<String> items) {
        Map<String, Integer> groupCount = new HashMap<>();
        for (String item : items) {
            groupCount.put(item, groupCount.getOrDefault(item, 0) + 1);
        }
        return groupCount;
    }
}
