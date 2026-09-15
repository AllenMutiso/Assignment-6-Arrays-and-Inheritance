import java.lang.Math;

public class NumberUtils {

    // A private, empty-bodied constructor prevents NumberUtil from being created.
    private NumberUtils() {

    }

    /*
    Given a number that is n digits in length, maps the digits to an array length n. 
    e.g. given the number 5678, the result is the array {5, 6, 7, 8}. 
    */
    public static int[] toArray(int number){
        // finding the number of digits in the number.
        Integer num = Math.abs(number); 
        int digits = num.toString().length();

        // intArray will store the digits of a given number.
        int[] intArray = new int[digits];

        // Adding each digit to intArray.
        for (int i = 0; i < digits; i ++) {
            char charDigit = num.toString().charAt(i);
            String stringDigit = String.valueOf(charDigit);
            intArray[i] = Integer.parseInt(stringDigit);
        }
        return intArray;
    }

    /*
    Given two numbers, count the quantity of matching digits – those with the same value and 
    position. For example, given 39628 and 79324, there are 2 digits in common: x9xx2x. 
    It is assumed that the numbers are the same length and have no repeating digits. 
    */
    public static int countMatches(int numberA, int numberB) {
        // If the numbers are equal we return the length/number of digits
        if (numberA == numberB) {
            Integer intNumberA = numberA;
            return (intNumberA.toString().length());
        } 

        int[] arrayA = toArray(numberA);
        int[] arrayB = toArray(numberB);
        int count = 0;

        int i = 0;
        while (i < arrayA.length) {
            if(arrayA[i] == arrayB[i]) {
                count += 1;
                i += 1;
            } else {
                i += 1;
                continue;
            }
        }
        return count;
    }

    /*
    Count the quantity of digits that two numbers have in common, regardless of position. 
    For example, given 39628 and 97324, there are 3 digits in common: 3, 9, 2. 
    It is assumed that the numbers are the same length and have no repeating digits.
    */
    public static int countIntersect(int numberA, int numberB) {
        // If the numbers are equal, return the number of digits.
        if (numberA == numberB) {
            Integer intNumberA = numberA;
            return (intNumberA.toString().length());
        } 

        int[] arrayA = toArray(numberA);
        int[] arrayB = toArray(numberB);
        int count = 0;

        for (int i = 0; i < arrayA.length; i++) {
            //arrayB.toString() returns a string representaion of the memory address of arrayB.
            String stringArrayB = java.util.Arrays.toString(arrayB);
            Integer digitA = arrayA[i];
            String stringDigit = digitA.toString();

            if (stringArrayB.contains(stringDigit)) {
                count += 1;
            }
        }
        return count;
    }

    /* 
    public static void main (String[] args) {
        int[] testArray = NumberUtils.toArray(4567); //return {4, 5, 6, 7}
        int match = NumberUtils.countMatches(4567, 4712); // return 1
        int intersect = NumberUtils.countIntersect(3467, 1234); // return 2
        System.out.println(intersect);
    } 
    */
}