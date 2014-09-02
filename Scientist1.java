import java.util.*;


public class Scientist1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		int prevNum = 0;
		int numOfNums = console.nextInt();
		int num = console.nextInt();
		
		for (int i = 1; i <= numOfNums; i++) {
			
			for (int j = 1; j <= (num - prevNum); j++) {
				System.out.print(i + " ");
			}
			prevNum = num;
			num = console.nextInt();
			
		}
		System.out.println();
		/*
		while (console.hasNext()) {
			int number = console.nextInt();
			if (number)
			for (int i = 0; i <= number; i++) {
				System.out.print(1);
			}
			System.out.println();
		}
		*/
	}

}
