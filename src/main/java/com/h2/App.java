package com.h2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    }

    public static int doubleTheNumber(int number) {

        return 2 * number;
    }

    private static int add(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length ; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }


}
