import java.util.Arrays;
import java.util.Scanner;

public class QuickUnionAlgorithm {

	private static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		arr = new int[N];

		new QuickUnionAlgorithm(N);

		System.out.println("Passes: ");
		union(4, 3);
		afterUnion(4, 3);
		union(3, 8);
		afterUnion(3, 8);
		union(6, 5);
		afterUnion(6, 5);
		union(9, 4);
		afterUnion(9, 4);
		union(2, 1);
		afterUnion(2, 1);
		isConnected(8, 9);
		isConnected(5, 0);
		union(5, 0);
		afterUnion(5, 0);
		union(7, 2);
		afterUnion(7, 2);
		union(6, 1);
		afterUnion(6, 1);

	}

	// Constructor to initialize the array
	private QuickUnionAlgorithm(int N) {
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
	}

	// Method to find root of an element
	private static int findRoot(int element) {
		while (arr[element] != element) {
			element = arr[element];
		}
		return element;
	}

	// Method to find if two objects are connected
	private static boolean isConnected(int p, int q) {
		if (findRoot(p) == findRoot(q)) {
			System.out.println(p + " and " + q + " are Connected");
			return true;
		} else {
			System.out.println(p + " and " + q + " are not Connected");
			return false;
		}
	}

	// Method to union two objects
	private static void union(int p, int q) {
		int rootp = findRoot(p);
		int rootq = findRoot(q);

		arr[rootp] = rootq;
	}

	// Method to print array after performing Union
	public static void afterUnion(int p, int q) {
		System.out.println("Array -- " + Arrays.toString(arr));
	}
}

/*
10
Passes: 
Array -- [0, 1, 2, 3, 3, 5, 6, 7, 8, 9]
Array -- [0, 1, 2, 8, 3, 5, 6, 7, 8, 9]
Array -- [0, 1, 2, 8, 3, 5, 5, 7, 8, 9]
Array -- [0, 1, 2, 8, 3, 5, 5, 7, 8, 8]
Array -- [0, 1, 1, 8, 3, 5, 5, 7, 8, 8]
8 and 9 are Connected
5 and 0 are not Connected
Array -- [0, 1, 1, 8, 3, 0, 5, 7, 8, 8]
Array -- [0, 1, 1, 8, 3, 0, 5, 1, 8, 8]
Array -- [1, 1, 1, 8, 3, 0, 5, 1, 8, 8]
 */
