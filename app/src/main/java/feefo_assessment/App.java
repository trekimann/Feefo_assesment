package feefo_assessment;

import java.util.Random;

import feefo_assessment.OOP.ArrayManipulator;
import feefo_assessment.OOP.JobStandardizer;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        String jt = "Java engineer";
        JobStandardizer s = new JobStandardizer();
        String standardizedTitle = s.standardize(jt);
        //output standardizedTitle 

        jt = "C# engineer";
        standardizedTitle = s.standardize(jt);
        //output standardizedTitle

        jt = "Chief Accountant";
        standardizedTitle = s.standardize(jt); 
        //output standardizedTitle


        //load the results from a big computation into mybigarray
        int[] mybigarray = generateSomeHugeArray(); 
        //now print out some basic stats on the array
        ArrayManipulator arrayManipulator = new ArrayManipulator();
        arrayManipulator.getStats(mybigarray);
    }

    public static int[] generateSomeHugeArray(){
        Random random = new Random();
        
        // how many numbers in array?
        int minSizeOfArray = 1000;
        int maxSizeOfArray = 10000;
        int numberOfNumbers = random.nextInt(maxSizeOfArray-minSizeOfArray)+minSizeOfArray;

        // populate array
        int[] hugeArray = new int[numberOfNumbers];
        
        for(int i = 0;i<numberOfNumbers; i++){
            hugeArray[i] = random.nextInt(maxSizeOfArray);
        }

        return hugeArray;
    }
}
