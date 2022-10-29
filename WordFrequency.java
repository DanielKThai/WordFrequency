import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WordFrequency {
	/**
	 * Prompts user for input and returns said input
	 * @return the string representing user input
	 */
	private static String promptInput() {
		System.out.println("Please input a line of text:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		return input;
	}
	
	/**
	 * Given string input, returns a hash map that pairs a word and the number of times it occurred
	 * @param input the string representing user input
	 * @return the map pairing words and their frequencies
	 */
	private static Map<String, Integer> countFrequencies(String input) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (String s : input.split("\\s+")) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		
		return map;
	}
	
	/**
	 * Given map representing word frequencies, returns a sorted queue of the word/count pairs
	 * @param frequencies
	 * @return the queue sorted by frequencies in descending order
	 */
	private static Queue<Map.Entry<String, Integer>> sortFrequencies(Map<String, Integer> frequencies) {
		PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		queue.addAll(frequencies.entrySet());
		return queue;
	}
	
	/**
	 * Prints the word frequencies output
	 * @param sortedFrequencies the queue sorted by frequencies in descending order
	 */
	private static void printOutput(Queue<Map.Entry<String, Integer>> sortedFrequencies) {
		while (!sortedFrequencies.isEmpty()) {
			Map.Entry<String, Integer> frequency = sortedFrequencies.poll();
			System.out.println(frequency.getValue() + " " + frequency.getKey());
		}
	}
	
	/**
	 * Prompts user for text input, and outputs the frequencies of words in descending order
	 */
	public static void main(String[] args) {
		String input = promptInput();
		Map<String, Integer> frequencies = countFrequencies(input);
		Queue<Map.Entry<String, Integer>> sortedFrequencies = sortFrequencies(frequencies);	
		printOutput(sortedFrequencies);
	}
}
