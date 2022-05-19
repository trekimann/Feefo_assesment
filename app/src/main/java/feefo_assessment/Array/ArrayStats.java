package feefo_assessment.Array;

public class ArrayStats {
    private int median;
    private double mean;
    private int mode;
    private int range;

    // Setters
    public void setMedian(int median){
        this.median = median;
    }
    public void setMean(double mean){
        this.mean = mean;
    }
    public void setMode(int mode){
        this.mode = mode;
    }
    public void setRange(int range){
        this.range = range;
    }

    // Getters
    public int getMedian(){
        return this.median;
    }
    public double getMean(){
        return this.mean;
    }
    public int getMode(){
        return this.mode;
    }
    public int getRange(){
        return this.range;
    }

    public void printStats(){
        System.out.println("Median of array: " + this.median);
        System.out.println("Mean of array: " + this.mean);
        System.out.println("Mean of array: " + this.mode);
        System.out.println("Range of array: " + this.range);
    }
}
