package com.lambda.learning;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class FunctionalProgramming2 {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 5);
		List<String> courseList = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Jenkins", "CI-CD", "Spring MVC",
				"GIT");

		// printCubeOddNumbersUsingFIInFunctionalProgram(numberList);
		// printNumbersInFunctionalProgram(numberList, x -> x % 2 != 0);
		// printRandonNumberUsingSupplier();
		// printStringUsingStaticReference(courseList);
		intStreamTest();

	}

	// Functional Program approach to cube of odd number using implemented
	// predicate, consumer, filter
	public static void printCubeOddNumbersUsingFIInFunctionalProgram(List<Integer> numberList) {

		Predicate<Integer> testPredicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer number) {
				return number % 2 != 0;
			}

		};

		Function<Integer, Integer> testFunction = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer number) {
				return number * number * number;
			}

		};

		Consumer<Integer> testConsumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer number) {
				System.out.println(number);

			}
		};

		BinaryOperator<Integer> testBooleanOp = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer x, Integer y) {
				return x + y;
			}

		};

		numberList.stream().filter(testPredicate).map(testFunction).forEach(testConsumer);
		// System.out.println(numberList.stream().filter(testPredicate).map(testFunction).reduce(testBooleanOp));
	}

	// Functional Program approach print even number predicate passed as an
	// arguement
	public static void printNumbersInFunctionalProgram(List<Integer> numberList, Predicate<Integer> predicate) {
		numberList.stream().filter(predicate).forEach(System.out::println);

	}

	public static void printRandonNumberUsingSupplier() {
		// Print directly as below
		// Supplier<Integer> testSupplier = () -> 2;

		// Print using a return
		Supplier<Integer> testSupplier = () -> {
			Random random = new Random();
			return random.nextInt(100);
		};
		System.err.println(testSupplier.get());
	}

	// Here method reference is being used for non static method i.e. String
	// toUpperCase
	public static void printStringUsingStaticReference(List<String> courseList) {
		courseList.parallelStream().map(String::toUpperCase).forEach(System.out::println);

		// Method reference can also be used for constructor. Here new object of string
		// will be created
		Supplier<String> strSupplier = String::new;
	}

	public static void intStreamTest() {
		IntStream stream = IntStream.range(6, 10);
		stream.forEach(System.out::println);
	}

}
