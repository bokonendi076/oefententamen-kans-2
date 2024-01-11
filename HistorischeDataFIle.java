import java.io.*;
import java.util.Arrays;

class HistoricData {
    private Double[] data;

    public HistoricData() {
        data = new Double[24];
    }

    public void addLog(int hour, Double value) {
        data[hour] = value;
    }

    public Double getAverageValue() {
        double sum = 0;
        int count = 0;

        for (Double value : data) {
            if (value != null) {
                sum += value;
                count++;
            }
        }

        return (count > 0) ? sum / count : null;
    }

    public Double getMinValue() {
        Double minValue = null;

        for (Double value : data) {
            if (value != null && (minValue == null || value < minValue)) {
                minValue = value;
            }
        }

        return minValue;
    }

    public Double getMaxValue() {
        Double maxValue = null;

        for (Double value : data) {
            if (value != null && (maxValue == null || value > maxValue)) {
                maxValue = value;
            }
        }

        return maxValue;
    }

    public void storeData(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] != null) {
                    writer.println(i + ";" + data[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void retrieveData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Arrays.fill(data, null); // Clear existing data

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    int index = Integer.parseInt(parts[0]);
                    double value = Double.parseDouble(parts[1]);
                    data[index] = value;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Double[] getData() {
        return data.clone();
    }
}

public class HistoricDataFile {
    private String fileName;

    public HistoricDataFile(String name) {
        this.fileName = name + ".txt";
    }

    public static void main(String[] args) {
        HistoricData historicData = new HistoricData();
        historicData.retrieveData("Temperatuur.txt");

        // Test: add some logs
        historicData.addLog(1, 20.0);
        historicData.addLog(2, 22.5);
        historicData.addLog(3, 21.8);
        historicData.addLog(3, 23.0); // Overwriting log at hour 3
        historicData.addLog(8, 18.5);

        // Test: print statistics
        System.out.println("Average: " + historicData.getAverageValue());
        System.out.println("Min: " + historicData.getMinValue());
        System.out.println("Max: " + historicData.getMaxValue());

        // Test: store data
        historicData.storeData("Temperatuur.txt");

        // Test: retrieve data again
        historicData.retrieveData("Temperatuur.txt");
        System.out.println(Arrays.toString(historicData.getData()));
    }
}
