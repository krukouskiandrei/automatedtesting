package calculator.service.impl;

import calculator.exception.CalculatorException;
import calculator.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {
	
	public double calculate(double number1, double number2, String operation) throws CalculatorException{
		char symbol = operation.charAt(0);
		switch(symbol){
			case '+':
				return addition(number1, number2);
			case '-':
				return subtraction(number1, number2);
			case '/':
				return division(number1, number2);
			case '*':
				return multiplication(number1, number2);
			default:
				throw new ClassCastException();
		}
	}
	
	public double addition(double number1, double number2) throws CalculatorException{
		return number1 + number2;
	}
	
	public double subtraction(double number1, double number2) throws CalculatorException{
		return number1 - number2;
	}
	public double division(double number1, double number2) throws CalculatorException{
		if(number2 != 0.0){
			return number1 / number2;
		}else{
			throw new CalculatorException();
		}
	}
	public double multiplication(double number1, double number2) throws CalculatorException{
		return number1 * number2;
	}
}
