/*
* This program gets the type of food and number of food,
* calculates and display the time to reheat in the microwave.
*
* @author  Jay Lee
* @version 1.0
* @since   2020-04-26
*/
// package ca.mths.unit1.unit04.java.main;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;


public final class HeatingTime {
    // Constant
    /** Pizza: 45 seconds.*/
    static final float PIZZA_TIME = 0.75f;
    /** Sub : 1 minute.*/
    static final float SUB_TIME = 1.0f;
    /** Soup: 1 minute 45 seconds.*/
    static final float SOUP_TIME = 1.75f;
    /** Max number of food to reheat.*/
    static final int MAX_FOOD = 3;
    /** 1 min : 60 sec. */
    static final int MIN_IN_SEC = 60;

    private HeatingTime() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }
    /**
    * This method get the type of food, number of food and
    * prints out the time to reheat in the microwave.
    * @param args
    */
    public static void main(final String[] args) {
        Scanner myObj = new Scanner(System.in);
        List<String> foodTypesList = Arrays.asList("PIZZA", "SUB", "SOUP");
        float individualTime = 0f;

        // String input
        System.out.print("Are you heating  a sub, pizza, or soup? ");
        String foodType = myObj.nextLine();

        // Check user's food is sub, pizza or soup
        if (foodTypesList.contains(foodType.toUpperCase())) {

            if (foodTypesList.indexOf(foodType.toUpperCase()) == 0) {
                individualTime = PIZZA_TIME;
            } else if (foodTypesList.indexOf(foodType.toUpperCase()) == 1) {
                individualTime = SUB_TIME;
            } else {
                individualTime = SOUP_TIME;
            }

            System.out.print("How many " + foodType + "(s) are you heating "
                             + "(max 3 and they must all be the same items)? ");
            int foodNumber = myObj.nextInt();
            if (foodNumber <= MAX_FOOD) {
                // Process
                float cookTime = (individualTime / foodNumber)
                                 * (float) Math.pow(MAX_FOOD, (foodNumber - 1));

                // convert float minutes to minutes and seconds
                int cookTimeMin = (int) Math.floor(cookTime);
                float cookTimeSec = (cookTime - cookTimeMin) * MIN_IN_SEC;

                // Output
                System.out.println("The total cook time is " + cookTimeMin
                                   + " min " + cookTimeSec + " sec.");
            } else {
                System.out.println("Max number of food is 3.");
            }
        } else {
            System.out.println("Invalid input.");
        }
        System.out.println("\nDone.");
    }
}
