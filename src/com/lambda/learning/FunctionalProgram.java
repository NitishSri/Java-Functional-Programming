package com.lambda.learning;

import java.util.Arrays;
import java.util.List;

public class FunctionalProgram {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
		List<String> courseList = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Jenkins", "CI-CD", "Spring MVC",
				"GIT");
		// printNumbersInTraditionalForm(numberList);
		// printNumbersInFunctionalProgram(numberList);
		// printEvenNumbersInFunctionalProgram(numberList);
		// printOddNumbersInFunctionalProgram(numberList);
		// printAllCourseInFunctionalProgram(courseList);
		// printParticularCourseInFunctionalProgram(courseList);
		// print4letterCourseInFunctionalProgram(courseList);
		// printCubeOddNumbersInFunctionalProgram(numberList);
		// printCharacterAllCourseInFunctionalProgram(courseList);
		System.out.println(printAllNumberSumInFunctionalProgram(numberList));
	}

	// Traditional printing of numbers
	public static void printNumbersInTraditionalForm(List<Integer> numberList) {
		for (int integer : numberList) {
			System.out.println(integer);
		}
	}

	// Functional Program approach
	public static void printNumbersInFunctionalProgram(List<Integer> numberList) {
		numberList.stream().forEach(FunctionalProgram::print);

	}

	// Functional Program approach print even number
	public static void printEvenNumbersInFunctionalProgram(List<Integer> numberList) {
		numberList.stream()
				// .filter(FunctionalProgram::isEven)
				.filter(number -> number % 2 == 0).forEach(FunctionalProgram::print);

	}

	// Functional Program approach print odd number
	public static void printOddNumbersInFunctionalProgram(List<Integer> numberList) {
		numberList.stream()
				// .filter(FunctionalProgram::isEven)
				.filter(number -> number % 2 != 0).forEach(FunctionalProgram::print);

	}

	// Functional Program approach print cube of odd number
	public static void printCubeOddNumbersInFunctionalProgram(List<Integer> numberList) {
		numberList.stream().filter(number -> number % 2 != 0).map(number -> number * number * number)
				.forEach(FunctionalProgram::print);

	}

	// Functional Program approach to print sum of all numbers in the list using
	// reduce
	public static int printAllNumberSumInFunctionalProgram(List<Integer> numberList) {
		return numberList.stream().reduce(0, (x, y) -> x + y);

		// Also can use static method reference from Integer class
		// return numberList.stream().reduce(0, Integer::sum);
	}

	// Functional Program approach print all courses string
	public static void printAllCourseInFunctionalProgram(List<String> courseList) {
		courseList.parallelStream().forEach(System.out::println);
	}

	// Functional Program approach print all courses string containing spring
	public static void printParticularCourseInFunctionalProgram(List<String> courseList) {
		courseList.parallelStream().filter(course -> course.contains("Spring")).forEach(System.out::println);
	}

	// Functional Program approach print all courses string containing 4 letters
	public static void print4letterCourseInFunctionalProgram(List<String> courseList) {
		courseList.parallelStream().filter(course -> course.length() >= 4).forEach(System.out::println);
	}

	// Functional Program approach print number of characters of each course
	public static void printCharacterAllCourseInFunctionalProgram(List<String> courseList) {
		courseList.parallelStream().map(course -> course + " size is " + course.length()).forEach(System.out::println);
	}

	public static void print(int number) {
		System.out.println(number);
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

}
