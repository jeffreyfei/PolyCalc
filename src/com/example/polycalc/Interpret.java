package com.example.polycalc;

import java.util.ArrayList;


public class Interpret {
	private ArrayList<Double> coefficient;
	private ArrayList<Double> powers;
	private String equation;
	
	public Interpret(String equation) {
		coefficient = new ArrayList<Double>();
		powers = new ArrayList<Double>();
		this.equation = equation;
	}
	
	public void readEquation() {
		String temp = "";
		for(int i = 0; i < equation.length(); ++i) {
			if(equation.charAt(i) == '+' || equation.charAt(i) == '-') {
				temp += "/" + equation.charAt(i);
			} else {
				temp += equation.charAt(i) + "";
			}
		}
		temp = temp.toLowerCase();
		String[] equationArr = temp.split("/");
		
		for(String degree : equationArr) {
			String[] numArr = null;
			String stCoef = "0";
			String stPow = "0";
			double tempCoef = 0;
			double tempPow = 0;

			//determine none constants
			if(!isDouble(degree)) {
				if(degree.equals("+x")) {
					numArr = splitValue(degree);
					stCoef = "1";
					stPow = "1";
				}
				if(degree.equals("-x")) {
					numArr = splitValue(degree);
					stCoef = "-1";
					stPow = "1";
				}
				if(degree.charAt(0) == '-' || degree.charAt(0) == '+') {
					if(degree.charAt(1) == 'x' && isDouble(degree.charAt(degree.length() - 1) + "")) {
						numArr = splitValue(degree);
						stCoef = "1";
						stPow = numArr[0];
					} 
					if(degree.charAt(1) == '-' && degree.charAt(1) == 'x' && isDouble(degree.charAt(degree.length() - 1) + "")) {
						numArr = splitValue(degree);
						stCoef = "-1";
						stPow = numArr[0];
					} 
					if(isDouble(degree.charAt(1) + "") && isDouble(degree.charAt(degree.length() - 1) + "")) {
						numArr = splitValue(degree);
						stCoef = numArr[0];
						stPow = numArr[1];
					}
					if(isDouble(degree.charAt(1) + "") && degree.charAt(degree.length() - 1) == 'x') {
						numArr = splitValue(degree);
						stCoef = numArr[0];
						stPow = "1";
					}
					
				} else {
					if(degree.charAt(0) == 'x' && isDouble(degree.charAt(degree.length() - 1) + "")) {
						numArr = splitValue(degree);
						stCoef = "1";
						stPow = numArr[0];
					} 
					if(degree.charAt(0) == '-' && degree.charAt(1) == 'x' && isDouble(degree.charAt(degree.length() - 1) + "")) {
						numArr = splitValue(degree);
						stCoef = "-1";
						stPow = numArr[0];
					} 
					if(isDouble(degree.charAt(0) + "") && isDouble(degree.charAt(degree.length() - 1) + "")) {
						numArr = splitValue(degree);
						stCoef = numArr[0];
						stPow = numArr[1];
					}
					if(isDouble(degree.charAt(0) + "") && degree.charAt(degree.length() - 1) == 'x') {
						numArr = splitValue(degree);
						stCoef = numArr[0];
						stPow = "1";
					}
				}
				
				

			//determine constants
			} else {
				stCoef = degree;
				stPow = "0";
			}
			
			tempCoef = Double.parseDouble(stCoef);
			tempPow = Double.parseDouble(stPow);
			coefficient.add(tempCoef);
			powers.add(tempPow);
		}
	}
	
	
	private boolean isDouble(String st) {
		try {
			Double db = Double.parseDouble(st);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
	
	public ArrayList<Double> getCoefficients() {
		return coefficient;
	}
	
	public ArrayList<Double> getPowers() {
		return powers;
	}
	
	//split the coefficients and the powers from other parts of the 
	private String[] splitValue(String input) {
		ArrayList<String> values = new ArrayList<String>();
		String currentSt = "";
		for(int i = 0; i < input.length(); ++i) {
			//splitting the coefficient
			if(isDouble(input.charAt(i) + "")) {
				currentSt += input.charAt(i) + "";
			}
			//splitting the power
			if(!isDouble(input.charAt(i) + "") || i == (input.length() - 1)) {
				if(!currentSt.equals("")) {
					values.add(currentSt);
				}
				currentSt = "";
			}
		}
		return values.toArray(new String[values.size()]);
	}

}

