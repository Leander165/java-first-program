package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public static void main(String[] args) {
        long loanAmount = Long.parseLong(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate = Float.parseFloat(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount,termInYears,annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());
    }

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
    this.loanAmount = loanAmount;
    this.termInYears = termInYears;
    this.annualRate = annualRate;
    }

    private int getNumberOfPayments(){
        return termInYears * 12;
    }

    private float getMonthlyInterestRate(){
        float interestRate;
        float monthlyInterest;

        interestRate = annualRate / 100;
        monthlyInterest =  interestRate / 12;
        return monthlyInterest;
    }

    public void calculateMonthlyPayment(){
        long p = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();

        double m = (p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1)));

        this.monthlyPayment = m;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return ("monthlyPayments: " + df.format(monthlyPayment));
    }
}
