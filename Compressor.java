import java.util.*;

public class Compressor {

	static int[][] array;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		int count = 1;
		int numberIn = console.nextInt();
		while (numberIn != 0) {
			int width = numberIn;
			int threshold = console.nextInt();
			array = makeArray(width, threshold, console);
			//compress(array, threshold, 0, width);
			compress(array, threshold, width, 0, 0);
			showArray(array, width, console, count);
			count++;
			numberIn = console.nextInt();
		}

	}

	private static void compress(int[][] array, int threshold, int width, int x,
			int y) {
		// if base case
		if (width == 1) {
			return;
		}
		double white = 0;
		double black = 0;
		for (int i = x; i < width + x; i++) {
			for (int j = y; j < width + y; j++) {
				if (array[i][j] == 0) {
					white++;
				} else {
					black++;
				}
			}
		}
		
		if (white/(width * width) >= ((double) threshold)/100) {
			for (int i = x; i < width + x; i++) {
				for (int j = y; j < width + y; j++) {
					array[i][j] = 0;
					System.out.println("Bazooka! " + (width) + ((double) threshold)/100);
				}
			}
			return;
		}
		
		else if (black/(width * width) >= ((double)threshold)/100) {
			for (int i = x; i < width + x; i++) {
				for (int j = y; j < width + y; j++) {
					array[i][j] = 1;
				}
			}
			return;
		} else {
		
		compress(array, threshold, width/2, x, y);
		compress(array, threshold, width/2, width/2 + x, y);
		compress(array, threshold, width/2, width/2 + x, width/2 + y);
		compress(array, threshold, width/2, x, width/2 + y);
		}
	}
	

	private static void showArray(int[][] array, int width, Scanner console,
			int count) {
		System.out.println("Image " + count + ": ");
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] makeArray(int width, int threshold, Scanner console) {
		int[][] myArray = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				myArray[i][j] = console.nextInt();
			}
		}
		return myArray;
	}
}
