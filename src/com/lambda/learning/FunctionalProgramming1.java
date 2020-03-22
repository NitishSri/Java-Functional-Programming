package com.lambda.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalProgramming1 {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 5);
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
		// System.out.println(printAllNumberSumInFunctionalProgram(numberList));
		// System.out.println(printMinNumberInFunctionalProgram(numberList));
		// System.out.println(printSumOfSquaresInFunctionalProgram(numberList));
		// System.out.println(printSumOfOddNumInFunctionalProgram(numberList));
		// printDistinctSortedNumInFunctionalProgram(numberList);
		// printAllCourseInOrderProgram(courseList);
		// System.out.println(printListWithEvenNumInFunctionalProgram(numberList));
		// System.out.println(prinListWithLengthOfAllCourseInFunctionalProgram(courseList));
	}

	// Traditional printing of numbers
	public static void printNumbersInTraditionalForm(List<Integer> numberList) {
		for (int integer : numberList) {
			System.out.println(integer);
		}
	}

	// Functional Program approach
	public static void printNumbersInFunctionalProgram(List<Integer> numberList) {
		numberList.stream().forEach(FunctionalProgramming1::print);

	}

	// Functional Program approach print even number
	public static void printEvenNumbersInFunctionalProgram(List<Integer> numberList) {
		numberList.stream()
				// .filter(FunctionalProgram::isEven)
				.filter(number -> number % 2 == 0).forEach(FunctionalProgramming1::print);

	}

	// Functional Program approach print odd number
	public static void printOddNumbersInFunctionalProgram(List<Integer> numberList) {
		numberList.stream()
				// .filter(FunctionalProgram::isEven)
				.filter(number -> number % 2 != 0).forEach(FunctionalProgramming1::print);

	}

	// Functional Program approach print cube of odd number
	public static void printCubeOddNumbersInFunctionalProgram(List<Integer> numberList) {
		numberList.stream().filter(number -> number % 2 != 0).map(number -> number * number * number)
				.forEach(FunctionalProgramming1::print);

	}

	// Functional Program approach to print sum of all numbers in the list using
	// reduce
	public static int printAllNumberSumInFunctionalProgram(List<Integer> numberList) {
		return numberList.stream().reduce(0, (x, y) -> x + y);

		// Also can use static method reference from Integer class
		// return numberList.stream().reduce(0, Integer::sum);
	}

	// Functional Program approach to print minimum number in the list using
	// reduce
	public static int printMinNumberInFunctionalProgram(List<Integer> numberList) {
		return numberList.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);

		// Print max number
		// return numberList.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x :
		// y);
	}

	// Functional Program approach to print sum of square of all number
	public static int printSumOfSquaresInFunctionalProgram(List<Integer> numberList) {
		return numberList.stream().map(number -> number * number).reduce(0, (x, y) -> x + y);
	}

	// Functional Program approach to print sum of odd number
	public static int printSumOfOddNumInFunctionalProgram(List<Integer> numberList) {
		return numberList.stream().filter(number -> number % 2 != 0).reduce(0, (x, y) -> x + y);
	}

	// Functional Program approach to print distinct sorted numbers
	public static void printDistinctSortedNumInFunctionalProgram(List<Integer> numberList) {
		numberList.stream().distinct().sorted().forEach(System.out::println);
	}

	// Functional Program approach to print a list containg only even numbers
	public static List<Integer> printListWithEvenNumInFunctionalProgram(List<Integer> numberList) {
		return numberList.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
	}

	// Functional Program approach print all courses string
	public static void printAllCourseInFunctionalProgram(List<String> courseList) {
		courseList.parallelStream().forEach(System.out::println);
	}

	// Functional Program approach print a list containing length of all course
	public static List<Integer> prinListWithLengthOfAllCourseInFunctionalProgram(List<String> courseList) {
		return courseList.parallelStream().map(str -> str.length()).collect(Collectors.toList());
	}

	// Functional Program approach print all courses in normal order, reverse order,
	// custom order based on length
	public static void printAllCourseInOrderProgram(List<String> courseList) {
		// courseList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		// courseList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		courseList.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
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
