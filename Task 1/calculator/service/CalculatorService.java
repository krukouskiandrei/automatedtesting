package calculator.service;

import calculator.exception.CalculatorException;

public interface CalculatorService {

	double calculate(double number1, double number2, String operation) throws CalculatorException;
	double addition(double number1, double number2) throws CalculatorException;
	double subtraction(double number1, double number2) throws CalculatorException;
	double division(double number1, double number2) throws CalculatorException;
	double multiplication(double number1, double number2) throws CalculatorException;
}
