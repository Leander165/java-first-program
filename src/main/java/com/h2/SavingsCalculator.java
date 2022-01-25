package com.h2;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class SavingsCalculator {

    private float[] credits;
    private float[] debits;

    public static void main(String[] args) {

        String[] creditsAsString = args[0].split(",");
        String[] debitAsString = args[1].split(",");


        float[] credits = new float[creditsAsString.length];
        for (int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        float[] debits = new float[debitAsString.length];
        for (int i = 0; i < debitAsString.length; i++) {
            debits[i] = Float.parseFloat(debitAsString[i]);
        }


        SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        Float netSavings = calculator.calculate();

        System.out.println("Your net savings are " + netSavings + " , the remaining days in this month are "
        + remainingDaysInMonth(LocalDate.now()) + " days.");
    }

    public SavingsCalculator(float[] credits, float[] debits){
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits(){
        float sum = 0.0f;
        for (int i = 0; i < credits.length ; i++) {
            sum = sum + credits[i];
        }
        return sum;
    }

    private float sumOfDebits(){
        float sum = 0.0f;
        for (int i = 0; i < debits.length ; i++) {
            sum = sum + debits[i];
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }
    public float calculate(){
        float netSavings = sumOfCredits() - sumOfDebits();
        return netSavings;
    }
}
