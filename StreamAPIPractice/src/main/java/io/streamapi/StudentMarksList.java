package io.streamapi;

import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentMarksList {

	
	private static ScoreInfo[] scoreData = new ScoreInfo[] {
	        new ScoreInfo("Smith","John",70),
	        new ScoreInfo("Doe","Mary",85),
	        new ScoreInfo("Page","Alice",82),
	        new ScoreInfo("Cooper","Jill",97),
	        new ScoreInfo("Flintstone","Fred",66),
	        new ScoreInfo("Rubble","Barney",80),
	        new ScoreInfo("Smith","Judy",48),
	        new ScoreInfo("Dean","James",90),
	        new ScoreInfo("Russ","Joe",55),
	        new ScoreInfo("Wolfe","Bill",73),
	        new ScoreInfo("Dart","Mary",54),
	        new ScoreInfo("Rogers","Chris",78),
	        new ScoreInfo("Toole","Pat",51),
	        new ScoreInfo("Khan","Omar",93),
	        new ScoreInfo("Smith","Ann",95)
	};
	
	public static void main(String[] args) {
//		print the number of students (without using scoreData.length)
		lengthOfData();
//		print the average score for all of the students
		averageScore();
//		print the number of students who got an A (score greater than or equal to 90)
		studentsGotAandAbove();
//		use the collect() stream operation to create a List<String> that contains the names of students whose score was less than 70; the names should be in the form first name followed by last name
		studentNameScoreLessThan70();
//		print the names from the List that was generated in the previous task
//		print out the student's names and scores, ordered last name
		sortingLastName();
//		print out the student's names and scores, ordered by score
		sortByScore();
		
	}

	private static void lengthOfData() {
		
		long count = Arrays.stream(scoreData).count();
		System.out.println("The number of Students are "+count);
	}
	
	private static void averageScore() {
		int sum = Arrays.stream(scoreData).parallel().mapToInt(e->e.score).sum();
		System.out.println("The average score for all students "+sum);
	}
	
	private static void studentsGotAandAbove() {
		long sum = Arrays.stream(scoreData).parallel()
			.filter(e->e.score > 90)
			.map(e->e.firstName)
			.count();
		System.out.println("No of Students Got above 90 "+sum);
	}
	
	private static void  studentNameScoreLessThan70() {
		Arrays.stream(scoreData)
		.filter(s->s.score <=70)
		.map( s-> (s.firstName +"  "+s.lastName))
		.collect(Collectors.toList()).forEach(System.out::println);
		//System.out.println("Students Names :"+names);
		
	}
	
	private static void sortingLastName() {
		Arrays.stream(scoreData)
		.sorted((s1,s2)->s1.lastName.compareTo(s2.lastName))
		.forEach(s -> System.out.printf("%s,%s : %d%n", s.lastName, s.firstName,s.score));
	}
	
	private static void sortByScore() {
		Arrays.stream(scoreData)
		.sorted((s1,s2)->s1.score-s2.score)
		.forEach(s->System.out.printf("%s,%s :%d%n",s.firstName, s.lastName, s.score));
	}
	
	
}
