package calculator.util;

import java.util.Scanner;

import calculator.exception.CalculatorException;
import calculator.service.CalculatorService;
import calculator.service.impl.CalculatorServiceImpl;

public class Calculator {
	
	private double num1;
	private double num2;
	private String operation;
	
	public Calculator(){}
	public void runCalculator(){
		System.out.println("Input first number: ");
		inputFirstNum();
		System.out.println("Input operation(+, -, /, *): ");
		inputOperation();
		System.out.println("Input second number: ");
		inputSecondNum();
		CalculatorService calculatorService = new CalculatorServiceImpl();
		try{
			double result = calculatorService.calculate(this.num1, this.num2, this.operation);
			System.out.println(this.num1 + " " + this.operation+ " " + this.num2 + " = " + result);
		}catch(CalculatorException e){
			System.out.println(this.num1 + " " + this.operation + " " + this.num2 + " = NULL");
		}
				
	}
	private void inputFirstNum(){
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNextDouble()){
			this.num1 = scanner.nextDouble();
		}else{
			System.out.println("Don't correct input. Try again");
			inputFirstNum();
		}
		
	}
	private void inputSecondNum(){
		Scanner scanner = new Scanner(System.in);
		if(scanner.hasNextDouble()){
			this.num2 = scanner.nextDouble();
		}else{
			System.out.println("Don't correct input. Try again");
			inputSecondNum();
		}
		
	}
	private void inputOperation(){
		Scanner scanner = new Scanner(System.in);
		String operation = null;
		if(scanner.hasNext()){
			operation = scanner.next();
			if(checkOperation(operation)){
				this.operation = operation;
			}else{
				System.out.println("Don't correct input. Try again");
				inputOperation();
			}
		}else{
			System.out.println("Don't correct input. Try again");
			inputOperation();
		}
	}
	
	private boolean checkOperation(String oper){
		boolean result = false;
		String[] symbols = {"+", "/", "*", "-"};
		for(int i = 0; i < symbols.length; i++){
			if(symbols[i].equals(oper)){
				result = true;
				break;
			}
		}
		return result;
	}
	
}
