package com.example.polycalc;

import java.util.ArrayList;


public class Calc {

	double lowerBound;
	double upperBound;
	double rightValue;
    double leftValue;
    double zero;
    double value1;
    double value2;
    double scale;
    double decrementScale;
    ArrayList<Double> coefficients;
    ArrayList<Double> powers;
    ArrayList<Double> answers;
    String exit = "n";
    boolean isPos;
	int rootNum;
	
	
	public Calc(double lowerBound, double upperBound, ArrayList<Double> coefficients, ArrayList<Double> powers){
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		rightValue = upperBound;
		leftValue = lowerBound;
		zero = 0;
		this.coefficients = coefficients;
		this.powers = powers;
		value1 = getAns(upperBound, coefficients, powers);
		value2 = getAns(lowerBound, coefficients, powers);
		scale = 0.1;
		decrementScale = 10;
		answers = new ArrayList<Double>();
		rootNum = 0;
		isPos = true;
		
		
		
		if(coefficients.get(0) < 0) {
			for(int i = 0; i < coefficients.size(); ++i) {
				double temp = coefficients.get(i);
				temp *= -1;
				coefficients.set(i, temp);
			}
			
		} 
	}
	
	public ArrayList<Double> getRoots() {
	    while(rightValue >= lowerBound) {
	        if(checkAccuracy(value1)){
	        	++rootNum;
	        	answers.add(rightValue);
	            isPos = !isPos;
	            scale = 0.1;
	            rightValue -= scale;
				value1 = getAns(rightValue, coefficients, powers);
	        }

	        if(isPos) {
	            if(value1 > zero) {
	            	rightValue -= scale;
	                value1 = getAns(rightValue, coefficients, powers);
		        }
		        if(value1 < zero) {
		        	rightValue += scale;
		        	scale /= decrementScale;
		        	value1 = getAns(rightValue, coefficients, powers);
		        }
	        } else {
	            if(value1 < zero) {
	            	rightValue -= scale;
	            	value1 = getAns(rightValue, coefficients, powers);
	            }
	            if(value1 > zero) {
	            	rightValue += scale;
	            	scale /= decrementScale;
	            	value1 = getAns(rightValue, coefficients, powers);
	            }
	       }
	                
	   }
	   return answers;
	}

	//return true if the input is close to 0 to the 13th decimal place
	private static boolean checkAccuracy(double input) {
	    double accuracy = 1/(Math.pow(10, 13));
	    double num = Math.abs(input);
	    if (num <= accuracy) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	//returns the answer for the certain cubic equation
	private static double getAns(double x, ArrayList<Double> coefficients, ArrayList<Double> powers) {
		double ans = 0;
		for(int i = 0; i < coefficients.size(); ++i) {
			ans += (coefficients.get(i) * Math.pow(x, powers.get(i)));
		}
		return ans;
	}
}