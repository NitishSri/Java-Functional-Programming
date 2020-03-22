package com.lambda.learning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import com.lambda.functional_interface.Calculator;

public class FunctionalProgramming5 {

	// Read text from a file
	public static void main(String[] args) throws IOException {
		Stream<String> lines = Files.lines(Paths.get("file.txt"));
		// lines.forEach(System.out::println);
		lines.map(str -> str.split(" ")).flatMap(Arrays::stream).distinct().sorted().forEach(System.out::println);

		// To print everything in this root path
		Files.list(Paths.get(".")).forEach(System.out::println);

		// To print everything that is directory in this root path
		Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

		// Creating custom functional interface
		Calculator calc = new Calculator() {
			@Override
			public long calculate(long num1, long num2) {
				return num1 + num2;
			}
		};
		System.out.println(calc.calculate(2, 2));

		// Creating custom functional interface using lambda
		Calculator calc2 = (long num1, long num2) -> {
			return num1 + num2;
		};
		
		System.out.println(calc2.calculate(2, 2));

	}

}
