import java.util.Arrays;
import java.util.Scanner;

public class QuickFindAlgorithm {
	
	static int[] arr;

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		//Size of array
		int N=sc.nextInt();
		
		arr=new int[N];
		
		new QuickFindAlgorithm(N);
		
		union(4,3);
		afterUnion(4,3);
		union(3,8);
		afterUnion(3,8);
		union(6,5);
		afterUnion(6,5);	
		union(9,4);
		afterUnion(9,4);
		union(2,1);
		afterUnion(2,1);
		isConnected(8,9);
		isConnected(5,0);
		union(5,0);
		afterUnion(5,0);
		union(7,2);
		afterUnion(7,2);
		union(6,1);
		afterUnion(6,1);
		
	}
	
	//constructor to initialize array of N elements
	//O(N)
	public QuickFindAlgorithm(int N){
		for(int i=0;i<N;i++){
			arr[i]=i;
			System.out.println(arr[i]+"  "+i);

		}
		
		}
	
	//Method to check if two objects are connected
	//O(1)
	public static boolean isConnected(int p,int q){
		if(arr[p]==arr[q]){
			System.out.println(p+" and "+q+" are Connected");
			return true;
		}
		else
			System.out.println(p+" and "+q+" are not Connected");
			return false;
	}
	
	//Method to connect two objects 
	//O(N)
	public static void union(int p,int q){
		int pvalue=arr[p];
		int qvalue=arr[q];
		
		if(isConnected(p,q)==false){
			for(int i=0;i<arr.length;i++){
				if(arr[i]==pvalue){
					arr[i]=qvalue;
				}
			}
		}
		System.out.println(p+" and "+q+" are Connected");
	}
	
	//Method to print array after performing Union
	public static void afterUnion(int p,int q){
		System.out.println("Array -- "+Arrays.toString(arr));
	}
}

/*  OUTPUT
10
0  0
1  1
2  2
3  3
4  4
5  5
6  6
7  7
8  8
9  9
4 and 3 are not Connected
4 and 3 are Connected
Array -- [0, 1, 2, 3, 3, 5, 6, 7, 8, 9]
3 and 8 are not Connected
3 and 8 are Connected
Array -- [0, 1, 2, 8, 8, 5, 6, 7, 8, 9]
6 and 5 are not Connected
6 and 5 are Connected
Array -- [0, 1, 2, 8, 8, 5, 5, 7, 8, 9]
9 and 4 are not Connected
9 and 4 are Connected
Array -- [0, 1, 2, 8, 8, 5, 5, 7, 8, 8]
2 and 1 are not Connected
2 and 1 are Connected
Array -- [0, 1, 1, 8, 8, 5, 5, 7, 8, 8]
8 and 9 are Connected
5 and 0 are not Connected
5 and 0 are not Connected
5 and 0 are Connected
Array -- [0, 1, 1, 8, 8, 0, 0, 7, 8, 8]
7 and 2 are not Connected
7 and 2 are Connected
Array -- [0, 1, 1, 8, 8, 0, 0, 1, 8, 8]
6 and 1 are not Connected
6 and 1 are Connected
Array -- [1, 1, 1, 8, 8, 1, 1, 1, 8, 8]

Logic:
Connected objects have the same value
To connect two objects change all elements values as arr[p] to arr[q]
 */
