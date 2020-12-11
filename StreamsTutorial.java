import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsTutorial {

	// Objective :: Count the number of names starting with Alphabet A in the list
	public void regular() {
		List<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Abhinav");
		names.add("Adam");
		names.add("Rahul");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);

	}

	// optimising the regular() method logic using Streams.
	public void streamFilter() {
		List<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Abhinav");
		names.add("Ada");
		names.add("Rahul");
		// Using Lambda expression to optimize the code(filter() is intermediate
		// operation and count() is terminal operation)
		// There is no life for Intermediate operation if there is no terminal operation
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		// You can also directly create a stream having all names, rather than creating
		// collection.The syntax is written below.
		// Terminal operation will execute only if intermediate operation(filter)
		// returns true.
		long d = Stream.of("Abhijeet", "Don", "Abhinav", "Adam", "Rahul").filter(s -> {
			s.startsWith("A");
			return false;
		}).count();

		System.out.println(d);
		// Print all the names of the ArrayList having length greater than 4
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		// Get only first name having length greater than 4
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

	public void streamMap() {
		// Printing names which have last letter as "A" and convert them to Uppercase
		// and print
		// filter() function will grab the names having last letter A.
		// map() function helps to modify the content to UpperCase
		Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Print names which have firstletter as "A" with Uppercase and sorted
		// let us convert arrays into arraylist here just for learning purpose
		List<String> names = Arrays.asList("Azhijeet", "Don", "Alekhya", "Adam", "Rama");
		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}

	public void mergeTwoLists() {
		// List1
		List<String> names = new ArrayList<String>();
		names.add("Java");
		names.add("Pyhton");
		names.add("C++");
		// List2
		List<String> names1 = Arrays.asList("Azhijeet", "Don", "Alekhya", "Adam", "Rama");
		// Converting both the arrayList into streams and concatenating both the streams
		// Merging 2 different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		// newStream.sorted().forEach(s->System.out.println(s));
		// anyMatch() method demo. CHecking whether adam is present in merged list
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	public void streamcollect() {
		//after modification collecting all the results through collect() method and storing it in new List
		List<String> ls = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
		.collect(Collectors.toList());
		//Getting the first element of the new list.
		System.out.println(ls.get(0));
	}
	
	//Task given by Rahul Shetty
	public void task() {
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		//print unique numbers from this array
		//sort the array
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> newList= values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("-------------After sorting------");
		System.out.println(newList);
		//Printing the 3rd element of the list
		System.out.println(newList.get(2));
		
	}

	public static void main(String[] args) {
		StreamsTutorial c = new StreamsTutorial();
		c.task();
	}
}
