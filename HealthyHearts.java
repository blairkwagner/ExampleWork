/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.summartiveone;

/**
 *
 * @author blair
 */
import java.util.Scanner;

public class HealthyHearts {
        public static void main(String[] args) {
        double userAge, maxHeartRate;
        int minHeartTarget, maxHeartTarget, displayMaxHeartRate;
        Scanner input = new Scanner(System.in);
        
        // ask for users age & compute 220 - inputed age & take the max rate *.5 
        
        System.out.println("What is your age?");
        userAge = input.nextInt();
        maxHeartRate = 220 - userAge;
        displayMaxHeartRate = (int) maxHeartRate;
        minHeartTarget = (int) Math.round(maxHeartRate * .5);
        maxHeartTarget = (int) Math.round(.85 * maxHeartRate);
        
        System.out.println("Your maximum heart rate should be " + displayMaxHeartRate + " beats per minute.");
        System.out.println("Your target heart rate zone is " + minHeartTarget + " - " + maxHeartTarget + " beats per minute.");
    }
}

