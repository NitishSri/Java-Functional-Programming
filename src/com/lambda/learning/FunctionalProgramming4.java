package com.lambda.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming4 {

	public static void main(String[] args) {
		List<String> courseList = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Jenkins", "CI-CD", "Spring MVC",
				"GIT");

		List<String> courseList2 = Arrays.asList("Spring Boot", "Docker", "Kubernetes", "Swing", "CI-CD",
				"Spring MVC", "GIT");

		//System.out.println(flatMapList(courseList));
		System.out.println(flatMapList(courseList,courseList2));
	}

	public static List<String> flatMapList(List<String> courseList) {
		return courseList.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList());

	}

	public static List<List<String>> flatMapList(List<String> courseList1, List<String> courseList2) {
		return courseList1.stream()
				.flatMap(course1 -> courseList2.stream().filter(course2 -> course2.length() == course1.length())
						.map(course2 -> Arrays.asList(course1, course2)))
				.filter(list -> list.get(0).equals(list.get(1))).collect(Collectors.toList());
	}
}
