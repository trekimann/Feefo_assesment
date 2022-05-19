package feefo_assessment;

import feefo_assessment.OOP.JobStandardizer;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

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

    }
}
