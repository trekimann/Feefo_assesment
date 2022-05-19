package feefo_assessment.Array;

import java.util.Arrays;

public class ArrayManipulator {
    public ArrayStats getStats(int[] input){
        ArrayStats arrayStats = new ArrayStats();
        
        // sort the array
        Arrays.sort(input);
        int inputLength = input.length;
        // Median is the middle number of a set, so just get the middle number in the array
        int middleOfArray = (int) Math.ceil(inputLength - 1/2); // might be a fraction so round up
        arrayStats.setMedian(input[middleOfArray]);
        
        // Mean is the sum of a set divided by the number in the set
        int sum = 0;

        for (int i : input) {
            sum = sum + i;
        }
        arrayStats.setMean(sum / inputLength);
           
        // Mode of a set is the most frequent number in that set so group the array by unique occurences, which ever is the least unique is the Mode.
        
        // 
        
        // Range of a set is the difference between the smallest and highest numbers in the set. Subtract the first element of the array from the last.
        arrayStats.setRange(input[inputLength+1] - input[0]);
       
        //print stats
        arrayStats.printStats();

        return arrayStats;
    }
}
