//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
		int countRight = 0;
		int countLeft = 0;
		int countDown = 0;
		int countUp = 0;
		int[] rightCoordinates = new int[2];
		int[] leftCoordinates = new int[2];
		int[] downCoordinates = new int[2];
		int[] upCoordinates = new int[2];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (i<field.length-2 && field[i][j]=='c' && field[i+1][j]=='o'&& field[i+2][j]=='w') {
					countRight++;
					rightCoordinates[1] = i;
					rightCoordinates[0] = j;
				}
				if (i>1 && field[i][j]=='c' && field[i-1][j]=='o'&& field[i-2][j]=='w') {
					countLeft++;
					leftCoordinates[1] = i;
					leftCoordinates[0] = j;
				}
				if (j>1 && field[i][j]=='c' && field[i][j-1]=='o'&& field[i][j-2]=='w') {
					countDown++;
					downCoordinates[0] = j;
					downCoordinates[1] = i;
					
				}
				if (j<field[i].length-2 && field[i][j]=='c' && field[i][j+1]=='o'&& field[i][j+2]=='w') {
					countUp++;
					upCoordinates[0] = j;
					upCoordinates[1] = i;
				}
				
			}
			
		}
		
		System.out.println(rightCoordinates[0]);
		System.out.println(rightCoordinates[1]);
		if (countRight == 1) {
			return rightCoordinates;
		}
		System.out.println(leftCoordinates[0]);
		System.out.println(leftCoordinates[1]);
		if (countLeft == 1) {
			return leftCoordinates;
		}
		System.out.println(downCoordinates[0]);
		System.out.println(downCoordinates[1]);
		
		if (countDown == 1) {
			return downCoordinates;
		}
		System.out.println(upCoordinates[0]);
		System.out.println(upCoordinates[1]);
		return upCoordinates;
       
    }
}
