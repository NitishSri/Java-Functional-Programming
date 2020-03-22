package com.lambda.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}

public class FunctionalProgramming3 {

	public static void main(String[] args) {
		List<Course> courses = Arrays.asList(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;

		Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;

		Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));

		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);

		Comparator<Course> comparingByNoOfStudentsDescreasing = Comparator.comparingInt(Course::getNoOfStudents)
				.reversed();

		Comparator<Course> comparingByNoOfStudentsDescThenReviews = Comparator.comparingInt(Course::getNoOfStudents)
				.thenComparingInt(Course::getReviewScore).reversed();

		// Sorting on basis of increasing number of students
		System.out.println("===============================");
		courses.stream().sorted(comparingByNoOfStudentsIncreasing).forEach(System.out::println);

		// Sorting on basis of decreasing number of students
		System.out.println("===============================");
		courses.stream().sorted(comparingByNoOfStudentsDescreasing).forEach(System.out::println);

		// Sorting on basis of first decreasing number of students and then decreasing
		// number of reviews
		System.out.println("===============================");
		courses.stream().sorted(comparingByNoOfStudentsDescThenReviews).forEach(System.out::println);

		// Sorting on basis of decreasing number of students and then decreasing number
		// of reviews using parallel stream and for each ordered
		System.out.println("===============================");
		courses.parallelStream().sorted(comparingByNoOfStudentsDescThenReviews).forEachOrdered(System.out::println);

		// Print the records first skip first 2 and then fetch only top 5 meeting the
		// criteria
		System.out.println("===============================");
		courses.parallelStream().sorted(comparingByNoOfStudentsIncreasing).skip(2).limit(5)
				.forEachOrdered(System.out::println);

		// This will give you the first element from the stream fulfilling the
		// comparator
		// condition result. The result use Optional meaning you an also get
		// Optional.Empty if no result found
		System.out.println("===============================");
		System.out.println(courses.stream().min(comparingByNoOfStudentsIncreasing));

		// This will give you the last element from the stream fulfilling the comparator
		// condition result. The result use Optional meaning you an also get
		// Optional.Empty if no result found
		System.out.println("===============================");
		System.out.println(courses.stream().max(comparingByNoOfStudentsIncreasing));

		// The findfirst also gives you the first element fulfilling the filter criteria
		// result. It also gives Optional object. If no element found then gives
		// Optional.Empty. You can also use orElse to give the default result if no
		// element found.
		System.out.println("===============================");
		System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate).findFirst()
				.orElse(new Course("Default Course", "Default", 0, 0)));

		// FindAny gives any random element meeting the criteria or Optional.Empty
		System.out.println("===============================");
		System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate).findAny());

		// This is mapToInt which should be used for primitives (int in this case)
		// instead of map. The average function is used which will give the average of
		// all the students with score > 95.
		System.out.println("===============================");
		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).average());

		// This is mapToInt which should be used for primitives (int in this case)
		// instead of map. The count function is used which will give the count of
		// all the course with score > 95.
		System.out.println("===============================");
		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).count());

		// This is mapToInt which should be used for primitives (int in this case)
		// instead of map. The max function is used which will give the max number of
		// student in any course
		System.out.println("===============================");
		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).max());

		// Group all the course as per the category they belong
		System.out.println("===============================");
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));

		// Group all the course as per the category they belong and give the count of
		// course
		System.out.println("===============================");
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

		// Group all the course as per the category they belong and print the maximum
		// review score
		System.out.println("===============================");
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

		// Group all the course as per the category they belong and print only the
		// course name in a list
		System.out.println("===============================");
		System.out.println(courses.stream().collect(
				Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));

		// Example of higher order function
		System.out.println("================================");
		Predicate<Course> reviewScoreGreaterThan95Predicate2 = higherOrderFunctExample(95);
		courses.stream().filter(reviewScoreGreaterThan95Predicate2).forEach(System.out::println);

	}

	// Example of higher order function
	private static Predicate<Course> higherOrderFunctExample(int offimit) {
		return course -> course.getReviewScore() > offimit;
	}

}
