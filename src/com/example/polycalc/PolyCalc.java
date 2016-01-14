package com.example.polycalc;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class PolyCalc extends Activity {

	Display display;
	Point size;
	ScrollView scroll;
	LinearLayout main;
	LinearLayout header;
	LinearLayout boundHeaderRow;
	LinearLayout boundRow;
	LinearLayout buttonRow1;
	LinearLayout buttonRow2;
	LinearLayout buttonRow3;
	LinearLayout buttonRow4;
	LinearLayout buttonRow5;
	LinearLayout buttonRow6;
	EditText equation;
	EditText upperBound;
	EditText lowerBound;
	TextView banner;
	TextView equationHeader;
	TextView upperBoundHeader;
	TextView lowerBoundHeader;
	TextView ans1;
	TextView ans2;
	TextView ans3;
	Button calculate;
	Button clear;
	Button powerSign;
	Button variable;
	Button add;
	Button subtract;
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	Button backspace;
	
	//////////////////
	TextView spacing1;
	TextView spacing2;
	TextView spacing3;
	TextView spacing4;
	TextView spacing5;
	TextView spacing6;
	TextView spacing7;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		display = getWindowManager().getDefaultDisplay();
		size = new Point();
		scroll = new ScrollView(this);
		main = new LinearLayout(this);
		header = new LinearLayout(this);
		boundHeaderRow = new LinearLayout(this);
		boundRow = new LinearLayout(this);
		buttonRow1 = new LinearLayout(this);
		buttonRow2 = new LinearLayout(this);
		buttonRow3 = new LinearLayout(this);
		buttonRow4 = new LinearLayout(this);
		buttonRow5 = new LinearLayout(this);
		buttonRow6 = new LinearLayout(this);
		equation = new EditText(this);
		upperBound = new EditText(this);
		lowerBound = new EditText(this);
		banner = new TextView(this);
		equationHeader = new TextView(this);
		upperBoundHeader = new TextView(this);
		lowerBoundHeader = new TextView(this);
		ans1 = new TextView(this);
		ans2 = new TextView(this);
		ans3 = new TextView(this);
		calculate = new Button(this);
		clear = new Button(this);
		powerSign = new Button(this);
		variable = new Button (this);
		add = new Button(this);
		subtract = new Button(this);
		one = new Button(this);
		two = new Button(this);
		three = new Button(this);
		four = new Button(this);
		five = new Button(this);
		six = new Button(this);
		seven = new Button(this);
		eight = new Button(this);
		nine = new Button(this);
		zero = new Button(this);
		backspace = new Button(this);
		
		
		/////////////////////////////////////////////
		spacing1 = new TextView(this);
		spacing2 = new TextView(this);
		spacing3 = new TextView(this);
		spacing4 = new TextView(this);
		spacing5 = new TextView(this);
		spacing6 = new TextView(this);
		
		spacing1.setText(" ");
		spacing2.setText(" ");
		spacing3.setText("                         ");
		spacing4.setText("");
		spacing5.setText("");
		spacing6.setText("                         ");
		
		/////////////////////////////////////////////
		
		scroll.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		
		banner.setGravity(Gravity.CENTER_HORIZONTAL);
		banner.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
	    banner.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		banner.setText("PolyCalc");
	    banner.setTextColor(Color.WHITE);
	    banner.setPadding(0, 15, 0, 15);
	    
		header.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 140));
		header.setOrientation(LinearLayout.VERTICAL);
		header.setBackgroundColor(Color.DKGRAY);
		header.addView(banner);
		header.setOrientation(LinearLayout.HORIZONTAL);
		
		
		equationHeader.setGravity(Gravity.CENTER_HORIZONTAL);
		equationHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		equationHeader.setText("Equation");
		
		equation.setLayoutParams(new LinearLayout.LayoutParams(800, 100));
		equation.setText("");
		equation.setGravity(Gravity.CENTER_HORIZONTAL);
		
		upperBoundHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		upperBoundHeader.setText("Upper Bound             ");
		
		lowerBoundHeader.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		lowerBoundHeader.setText("Lower Bound");
		
		boundHeaderRow.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 100));
		boundHeaderRow.setGravity(Gravity.CENTER_HORIZONTAL);
		boundHeaderRow.addView(upperBoundHeader);
		boundHeaderRow.addView(lowerBoundHeader);
		
		upperBound.setLayoutParams(new LinearLayout.LayoutParams(300, 100));
		upperBound.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
		
		lowerBound.setLayoutParams(new LinearLayout.LayoutParams(300, 100));
		lowerBound.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
		
		boundRow.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 100));
		boundRow.setGravity(Gravity.CENTER_HORIZONTAL);
		boundRow.addView(upperBound);
		boundRow.addView(spacing3);
		boundRow.addView(lowerBound);
		
		//border drawables
		
	    GradientDrawable border = new GradientDrawable();
	    border.setShape(GradientDrawable.RECTANGLE);
	    border.setStroke(5, Color.WHITE);
	    border.setColor(Color.DKGRAY);
		  
	    //width&height of the screen
	    display.getSize(size);
	    int width = size.x;
	    int height = size.y;
	    
	    
		int buttonHeight = height/9;
		int buttonWidth = width/3;
		int buttonWidthFirstRow = width/4;
		int buttonWidthClear = width;
		int buttonPadding = buttonHeight/5;
		
		
		//Calculate Button
		calculate.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		calculate.setText("=");
		calculate.setGravity(Gravity.CENTER_HORIZONTAL);
		calculate.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		calculate.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		calculate.setPadding(0, buttonPadding, 0, 0);
		calculate.setTextColor(Color.WHITE);
		calculate.setOnClickListener(calc);
		calculate.setBackgroundDrawable(border);
		
		//Button to type "x"
		variable.setLayoutParams(new LinearLayout.LayoutParams(buttonWidthFirstRow, buttonHeight));
		variable.setText("x");
		variable.setGravity(Gravity.CENTER_HORIZONTAL);
		variable.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		variable.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		variable.setPadding(0, buttonPadding, 0, 0);
		variable.setTextColor(Color.WHITE);
		variable.setOnClickListener(addVariable);
		variable.setBackgroundDrawable(border);
		
		//Button to type "^"
		powerSign.setLayoutParams(new LinearLayout.LayoutParams(buttonWidthFirstRow, buttonHeight));
		powerSign.setText("^");
		powerSign.setGravity(Gravity.CENTER_HORIZONTAL);
		powerSign.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		powerSign.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		powerSign.setPadding(0, buttonPadding, 0, 0);
		powerSign.setTextColor(Color.WHITE);
		powerSign.setOnClickListener(addPower);
		powerSign.setBackgroundDrawable(border);
		
		//Button to type "+"
		add.setLayoutParams(new LinearLayout.LayoutParams(buttonWidthFirstRow, buttonHeight));
		add.setText("+");
		add.setGravity(Gravity.CENTER_HORIZONTAL);
		add.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		add.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		add.setPadding(0, buttonPadding, 0, 0);
		add.setTextColor(Color.WHITE);
		add.setOnClickListener(addPlusSign);
		add.setBackgroundDrawable(border);
		
		//Button to type "-"
		subtract.setLayoutParams(new LinearLayout.LayoutParams(buttonWidthFirstRow, buttonHeight));
		subtract.setText("-");
		subtract.setGravity(Gravity.CENTER_HORIZONTAL);
		subtract.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		subtract.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		subtract.setPadding(0, buttonPadding, 0, 0);
		subtract.setTextColor(Color.WHITE);
		subtract.setOnClickListener(addSubSign);
		subtract.setBackgroundDrawable(border);
		
		//Clear Button
		clear.setLayoutParams(new LinearLayout.LayoutParams(buttonWidthClear, buttonHeight));
		clear.setText("C");
		clear.setGravity(Gravity.CENTER_HORIZONTAL);
		clear.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		clear.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		clear.setPadding(0, buttonPadding, 0, 0);
		clear.setTextColor(Color.WHITE);
		clear.setOnClickListener(clr);
		clear.setBackgroundDrawable(border);
		
		//Button to type "1"
		one.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		one.setText("1");
		one.setGravity(Gravity.CENTER_HORIZONTAL);
		one.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		one.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		one.setPadding(0, buttonPadding, 0, 0);
		one.setTextColor(Color.WHITE);
		one.setOnClickListener(addOne);
		one.setBackgroundDrawable(border);
		
		//Button to type "2"
		two.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		two.setText("2");
		two.setGravity(Gravity.CENTER_HORIZONTAL);
		two.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		two.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		two.setPadding(0, buttonPadding, 0, 0);
		two.setTextColor(Color.WHITE);
		two.setOnClickListener(addTwo);
		two.setBackgroundDrawable(border);
		
		//Button to type "3"
		three.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		three.setText("3");
		three.setGravity(Gravity.CENTER_HORIZONTAL);
		three.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		three.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		three.setPadding(0, buttonPadding, 0, 0);
		three.setTextColor(Color.WHITE);
		three.setOnClickListener(addThree);
		three.setBackgroundDrawable(border);
		
		//Button to type "4"
		four.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		four.setText("4");
		four.setGravity(Gravity.CENTER_HORIZONTAL);
		four.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		four.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		four.setPadding(0, buttonPadding, 0, 0);
		four.setTextColor(Color.WHITE);
		four.setOnClickListener(addFour);
		four.setBackgroundDrawable(border);
		
		//Button to type "5"
		five.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		five.setText("5");
		five.setGravity(Gravity.CENTER_HORIZONTAL);
		five.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		five.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		five.setPadding(0, buttonPadding, 0, 0);
		five.setTextColor(Color.WHITE);
		five.setOnClickListener(addFive);
		five.setBackgroundDrawable(border);
		
		//Button to type "6"
		six.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		six.setText("6");
		six.setGravity(Gravity.CENTER_HORIZONTAL);
		six.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		six.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		six.setPadding(0, buttonPadding, 0, 0);
		six.setTextColor(Color.WHITE);
		six.setOnClickListener(addSix);
		six.setBackgroundDrawable(border);
		
		//Button to type "7"
		seven.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		seven.setText("7");
		seven.setGravity(Gravity.CENTER_HORIZONTAL);
		seven.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		seven.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		seven.setPadding(0, buttonPadding, 0, 0);
		seven.setTextColor(Color.WHITE);
		seven.setOnClickListener(addSeven);
		seven.setBackgroundDrawable(border);
		
		//Button to type "8"
		eight.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		eight.setText("8");
		eight.setGravity(Gravity.CENTER_HORIZONTAL);
		eight.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		eight.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		eight.setPadding(0, buttonPadding, 0, 0);
		eight.setTextColor(Color.WHITE);
		eight.setOnClickListener(addEight);
		eight.setBackgroundDrawable(border);
		
		//Button to type "9"
		nine.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		nine.setText("9");
		nine.setGravity(Gravity.CENTER_HORIZONTAL);
		nine.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		nine.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		nine.setPadding(0, buttonPadding, 0, 0);
		nine.setTextColor(Color.WHITE);
		nine.setOnClickListener(addNine);
		nine.setBackgroundDrawable(border);
		
		//Button to remove the last character from the string
		zero.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		zero.setText("0");
		zero.setGravity(Gravity.CENTER_HORIZONTAL);
		zero.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		zero.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		zero.setPadding(0, buttonPadding, 0, 0);
		zero.setTextColor(Color.WHITE);
		zero.setOnClickListener(addZero);
		zero.setBackgroundDrawable(border);
		
		backspace.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth, buttonHeight));
		backspace.setText("<--");
		backspace.setGravity(Gravity.CENTER_HORIZONTAL);
		backspace.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
		backspace.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
		backspace.setPadding(0, buttonPadding, 0, 0);
		backspace.setTextColor(Color.WHITE);
		backspace.setOnClickListener(useBackspace);
		backspace.setBackgroundDrawable(border);
		
		
		//Layout to organize buttons in a role
		buttonRow1.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		buttonRow1.setGravity(Gravity.CENTER_HORIZONTAL);
		buttonRow1.addView(add);
		buttonRow1.addView(subtract);
		buttonRow1.addView(variable);
		buttonRow1.addView(powerSign);
		
		buttonRow2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		buttonRow2.setGravity(Gravity.CENTER_HORIZONTAL);
		buttonRow2.addView(one);
		buttonRow2.addView(two);
		buttonRow2.addView(three);
		
		buttonRow3.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		buttonRow3.setGravity(Gravity.CENTER_HORIZONTAL);
		buttonRow3.addView(four);
		buttonRow3.addView(five);
		buttonRow3.addView(six);
		
		buttonRow4.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		buttonRow4.setGravity(Gravity.CENTER_HORIZONTAL);
		buttonRow4.addView(seven);
		buttonRow4.addView(eight);
		buttonRow4.addView(nine);
		
		buttonRow5.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		buttonRow5.setGravity(Gravity.CENTER_HORIZONTAL);
		buttonRow5.addView(calculate);
		buttonRow5.addView(zero);
		buttonRow5.addView(backspace);
		
		buttonRow6.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		buttonRow6.setGravity(Gravity.CENTER_HORIZONTAL);
		buttonRow6.addView(clear);
		
		//Answer displaying
		GradientDrawable ansBG = new GradientDrawable();
		ansBG.setShape(GradientDrawable.RECTANGLE);
		ansBG.setStroke(5, Color.DKGRAY);
		ansBG.setColor(Color.LTGRAY);
		
		int ansFontSize = 25;
		
		ans1.setTextSize(TypedValue.COMPLEX_UNIT_SP,ansFontSize);
		ans1.setText("00");
		ans1.setBackground(ansBG);
		ans1.setGravity(Gravity.CENTER_HORIZONTAL);
		ans1.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		/*
		ans2.setTextSize(TypedValue.COMPLEX_UNIT_SP,ansFontSize);
		ans2.setText("0");
		ans2.setBackground(ansBG);
		ans2.setGravity(Gravity.CENTER_HORIZONTAL);
		
		ans3.setBackground(ansBG);
		ans3.setTextSize(TypedValue.COMPLEX_UNIT_SP,ansFontSize);
		ans3.setText("0");
		ans3.setGravity(Gravity.CENTER_HORIZONTAL);*/
		
		
		//Main Layout setup
		main.setOrientation(LinearLayout.VERTICAL);
		main.setBackgroundColor(Color.LTGRAY);
		main.setGravity(Gravity.CENTER_HORIZONTAL);
		main.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	    
	    main.addView(header);
	    main.addView(spacing1);
	    main.addView(equationHeader);
	    main.addView(equation);
	    main.addView(spacing2);
	    main.addView(boundHeaderRow);
	    main.addView(boundRow);
	    main.addView(spacing4);
	    main.addView(buttonRow1);
	    main.addView(buttonRow2);
	    main.addView(buttonRow3);
	    main.addView(buttonRow4);
	    main.addView(buttonRow5);
	    main.addView(buttonRow6);
	    main.addView(spacing5);
	    main.addView(ans1);
	    //main.addView(ans2);
	    //main.addView(ans3);
	    main.addView(spacing6);
	    
	    scroll.addView(main, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

	    
		setContentView(scroll);
	}
	
	private OnClickListener calc = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Interpret inter = new Interpret(equation.getText().toString());
			inter.readEquation();
			ArrayList<Double> coefficient = inter.getCoefficients();
			ArrayList<Double> power = inter.getPowers();
			/*
			//storing the value of the coefficientsyy
			double co1 = 0;
			double co2 = 0;
			double co3 = 0;
			//storing the index position of the coefficient
			int indco0 = -1;
			int indco1 = -1;
			int indco2 = -1;
			
			if(power.contains(3)) {
				indco0 = power.indexOf(3);
				co0 = coefficient.get(indco0);
			}
			if(power.contains(2)) {
				indco1 = power.indexOf(2);
				co1 = coefficient.get(indco1);
			}
			if(power.contains(1)) {
				indco2 = power.indexOf(3);
				co2 = coefficient.get(indco2);
			}
			for(int i = 0; i < coefficient.size(); ++i) {
				if(i != indco0 && i != indco1 && i != indco2) {
					co3 = coefficient.get(i);
				}
			}
			for(int i = 0; i < coefficient.size(); ++i) {
				System.out.print(coefficient.get(i) + " ");
			}
			System.out.println();
			for(int i = 0; i < power.size(); ++i) {
				System.out.print(power.get(i) + " ");
			}*/
			Calc cal = new Calc(Double.parseDouble(lowerBound.getText().toString()), Double.parseDouble(upperBound.getText().toString()), coefficient, power);
			ArrayList<Double> ans = cal.getRoots();
			System.out.println(ans.size());
			
			String printAns = "";
			for(int i = 0; i < ans.size(); ++i) {
				printAns += ans.get(i) + "\n ";
			}
			ans1.setText(printAns);
			
		}
		
	};
	
	private OnClickListener clr = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			equation.setText("");
			ans1.setText("0");
			ans2.setText("0");
			ans3.setText("0");
		}
	};
	
	private OnClickListener addPower = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			String temp = equation.getText().toString();
			equation.setText(temp + "^");	
		}
	};
	
	private OnClickListener addVariable = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "x");		
		}
	};
	
	private OnClickListener addPlusSign = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "+");		
		}
	};

	private OnClickListener addSubSign = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "-");		
		}	
	};

	private OnClickListener addOne = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "1");	
		}	
	};
	
	private OnClickListener addTwo = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "2");		
		}	
	};
	
	private OnClickListener addThree = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "3");		
		}	
	};
	
	private OnClickListener addFour = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "4");		
		}	
	};
	
	private OnClickListener addFive = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "5");		
		}	
	};
	
	private OnClickListener addSix = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "6");		
		}	
	};
	
	private OnClickListener addSeven = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "7");		
		}	
	};
	
	private OnClickListener addEight = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "8");	
		}	
	};
	
	private OnClickListener addNine = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "9");		
		}	
	};
	
	private OnClickListener addZero = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String temp = equation.getText().toString();
			equation.setText(temp + "0");		
		}	
	};
	
	private OnClickListener useBackspace = new OnClickListener() {

		@Override
		public void onClick(View v) {
			try{
				String temp = equation.getText().toString();
				equation.setText(temp.substring(0, (temp.length()-1)));
			}catch(StringIndexOutOfBoundsException siobe) {
				equation.setText("");
			}
		}	
	};
}
