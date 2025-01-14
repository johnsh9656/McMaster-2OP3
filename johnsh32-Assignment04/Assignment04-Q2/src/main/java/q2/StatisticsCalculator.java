package q2;

import java.util.Arrays;

public class StatisticsCalculator {

    private int[] data = {};
    
    // constructor to initialize StatisticsCalculator with int array
    // throws IllegalArgumentException if array is empty or null
    public StatisticsCalculator(int[] data) throws IllegalArgumentException {
        // validate data
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Invalid input. Array cannot be null or empty.");
        }
    
        // clone to avoid external modification
        this.data = data.clone();
    }

    // calculates and returns average of elements in data array
    // throws ArithmeticException if array is empty
    public double calculateAverage() throws ArithmeticException {
        if (data.length == 0) {
            throw new ArithmeticException("Array is empty. Cannot perform operation.");
        }

        // get sum of elements in the array
        double sum = 0;
        for (int num : data) {
            sum += num;
        }

        double average = sum / data.length;

        // return average formatted to 2 decimal places
        return Math.round(average * 100.0) / 100.0;
    }

    // calculates and returns median of elements in data array
    // throws ArithmeticException if array is empty
    public double calculateMedian() throws ArithmeticException {
        if (data.length == 0) {
            throw new ArithmeticException("Array is empty. Cannot perform operation.");
        }

        // sort array
        int[] sortedData = data.clone();
        Arrays.sort(sortedData);
        int middleIndex = sortedData.length / 2;

        double median = (sortedData.length % 2 == 0) ? 
            ((sortedData[middleIndex - 1] + sortedData[middleIndex])/2.0) : 
            (sortedData[middleIndex]);

        // return median formatted to 2 decimal places
        return Math.round(median * 100.0) / 100.0;
    }

    // updates data array with a new array of ints
    // throws IllegalArgumentException if array is empty or null
    public void updateArray(int[] newData) throws IllegalArgumentException {
        // validate data
        if (newData == null || newData.length == 0) {
            throw new IllegalArgumentException("Invalid input. Array cannot be null or empty.");
        }
    
        // clone to avoid external modification
        this.data = newData.clone();
    }

    // returns a copy of the current data array
    public int[] getArray() {
        return data.clone();
    }
}
