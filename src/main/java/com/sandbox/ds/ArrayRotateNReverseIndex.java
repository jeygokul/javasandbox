package com.sandbox.ds;

/**
 * Question: http://www.programcreek.com/2015/03/rotate-array-in-java/ Rotate an
 * array of n elements to the right by k steps. For example, with n = 7 and k =
 * 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * @author jeygokul
 *
 */
public class ArrayRotateNReverseIndex {

	public static void main(String... args) {

		int k = 2;

		args = new String[] { "1", "2", "3", "4", "5", "6", "7" };

		if (args.length == 0) {
			System.err.println("Empty Array");
		}

		if (k > args.length - 1) {
			System.err.println("Can't reverse of lenghth more than length of array");
		}

		args = reverse(k, Direction.BACKWARD, args);
		args = reverse(args.length, Direction.FORWARD, args);
		args = reverse((args.length - k), Direction.BACKWARD, args);

		for (String arg : args) {
			System.out.println(arg);
		}

	}

	private static String[] reverse(int index, Direction direction, String... strings) {

		int front = 0;
		int back = 0;

		if (direction == Direction.FORWARD) {
			front = 0;
			back = index - 1;
		} else if (direction == Direction.BACKWARD) {
			front = strings.length - index;
			back = strings.length - 1;
		}

		while (front < back) {
			String temp = strings[front];
			strings[front] = strings[back];
			strings[back] = temp;
			front++;
			back--;
		}

		return strings;
	}

}

enum Direction {
	FORWARD, BACKWARD
}
