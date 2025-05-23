import java.util.Scanner;
import java.io.File;

public class ReadData {
    // I hard-coded the number of rows and columns so
    // I could use a 2D array
    private double[][] data = new double[21907][14];

    // This should read in the csv file and store the data in a 2D array,
    // data -- don't forget to skip the header line and parse everything
    // as doubles
    public void read() {
        try {
            Scanner scanner = new Scanner(new File("cps.csv"));
            int row = 0;
            scanner.nextLine(); // Skip the header line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArr = line.split(",");
                for (int col = 0; col < lineArr.length; col++) {
                    data[row][col] = Double.parseDouble(lineArr[col]);
                    // System.out.println(data[row][col]);
                }
                row++;
            }
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // this should return the column of data based
    // on the column number passed in -- the column number
    // is 0 indexed, so the first column is 0, the second
    // is 1, etc.
    // this should return a double array of the column
    // of data
    public double[][] getColumns(int col1, int col2) {
        double[][] columns = new double[data.length][2];
        for (int row1 = 0; row1 < data.length; row1++) {
            columns[row1][0] = data[row1][col1];
        }
        for (int row2 = 0; row2 < data.length; row2++) {
            columns[row2][1] = data[row2][col2];
        }
        // print(columns);
        return columns;
    }

    // this returns the standard deviation of the x and y column
    // of data passed in
    // the standard deviation is the square root of the variance
    // the variance is the sum of the squares of the differences
    // between each value and the mean,
    // divided by the number of values - 1(sample variance)
    // Use Math.pow to square the difference
    // and Math.sqrt to take the square root
    // return an array with two values -- standard deviation
    // for the x column and y column
    public double[] stdDeviation(double[][] xy){
        double sum = 0;
        double stdDev = 0.0;
        double[] mean = mean(xy);
        double[] standardDeviation = new double[xy[0].length];
        for(int col = 0; col < xy[0].length; col++){
            for(int row = 0; row < xy.length; row++){
                sum = 0;
                sum += Math.pow((xy[row] - mean[col]), 2);
            }
            stdDev = Math.sqrt(sum / (xy.length -1));
            standardDeviation[col] = stdDev;
        }
        return standardDeviation; //sample variance!
    }

    // this returns the mean of each columns of data passed in
    // the mean is the sum of the values divided by the number
    // of values
    // take mean of each column and return in a 1d array
    public double[] mean(double[][] xy){
        double sum = 0;
        double colMean;
        double[] mean = new double[xy[0].length];
        for(int col = 0; col < xy[0].length; col++){
            for(int row = 0; row < xy.length; row++){
                sum = 0;
                sum += xy[row][col];
            }
            colMean = sum / xy[0].length;
            mean[col] = colMean;
        }
        //print1D(mean);
        return mean;
    }

    // this returns the values of each column in standard units
    // the standard units are the value minus the mean divided by the standard
    // deviation
    // this should return a double 2D array of the standard units
    public double[][] standardUnits(double[][] xy){
        double[][] stdArr = ...
        double[] stdDeviation = ...;
        double[] mean = ...;
        ...
        return stdArr;
    }

    // this returns the correlation between the two columns of data passed in
    // the correlation is the sum of the products of the standard units
    // of the two columns divided by the number of values - 1
    // this should return a double
    // the correlation is a measure of the strength of the linear relationship
    // between the two columns of data
    // the correlation is between -1 and 1
    public double correlation(double[][] xy){
        double sum = 0;
        ...
        return ...;    
    }

    public void runRegression() {
        // double[][] xy = getColumns(7,9);
        // double[][] xyStd = standardUnits(xy);
        // double correlation = correlation(xyStd);
        // double slope = correlation * xyStd[1] / xyStd[0];
        // double[] means = mean(xy)
        // double intercept = means[1] - slope * means[0];
        // System.out.println("Correlation: " + correlation);
        // System.out.println("Slope: " + slope);
        // System.out.println("Intercept: " + intercept);
        // Scatter s = new Scatter();
        // s.displayScatterPlot(xy[0], xy[1]);
    }

    // this prints the array passed in - you may want this for debugging
    public void print(double[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void print1D(double[] arr) {
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[col] + " ");
            }
            System.out.println();
        }
    

    public static void main(String[] args) {
        ReadData rd = new ReadData();
        rd.read();
        // rd.getColumns(1, 2);
        rd.mean(rd.getColumns(1, 2));
        // rd.runRegression();
    }

}
