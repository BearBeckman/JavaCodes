//Shannon Beckman
//ITD 3523 Computer Security
//Prof: Ken Dewey
//Jan  18, 2016 - Jan 20, 2016

//IoW = w^(n-2) mod n

import java.util.Scanner;

public class InverseOfW{

	public static void main(String[] args){
		//variable declarations
		int iow=0, w=0, n=0, knapsack[]= new int[3], encrypt[] = new int[9];
		Scanner in = new Scanner(System.in);
		System.out.print("\n");

		//Enter integer for w
		System.out.print("Please enter a whole integer for w: ");
		w = in.nextInt();
		System.out.print("You have entered: " + w + "\n");

		//Enter integer for n
		System.out.print("Please enter a whole integer for n: ");
		n = in.nextInt();
		System.out.print("You have entered: " + n + "\n");

		//Enter the increasing knapsack
		System.out.print("Assingment example uses 1 3 6 as knapsack.\n");
		System.out.print("Please enter the first number from the Knapsack: ");
		knapsack[0] = in.nextInt();

		//second number
		System.out.print("Please enter the second number from the Knapsack: ");
		knapsack[1] = in.nextInt();

		//third number
		System.out.print("Please enter the third number from the Knapsack: ");
		knapsack[2] = in.nextInt();System.out.print("\n");

		//console output
		System.out.print("You have entered: "+knapsack[0]+" "+knapsack[1]+" "+knapsack[2]+" for the knapsack.\n");

		//verify if knapsack is superincreasing
		char superIn = 'n';
		if (knapsack[1] > knapsack[0]){
			if((knapsack[0] + knapsack[1]) < knapsack[2]){
				superIn = 'y';
			}
		}
		if (superIn == 'n'){
			System.out.print("The knapsack you entered is NOT superincreasing.\n");
		}
		else if(superIn == 'y'){
			System.out.print("The knapsack you entered IS superincreasing.\n");
		}

		//find Inverse of w		
		iow = (int)((Math.pow((double) w, (double)(n-2)))%n);		
		
		//find intermediate numbers
		int h[] = new int[3];
		h[0]= (knapsack[0]*w)%n; h[1]= (knapsack[1]*w)%n; h[2]= (knapsack[2]*w)%n;

		//console output
		System.out.print("The IoW is: "+iow+"\n");
		System.out.print("The hard knapsack is: "+h[0]+" "+h[1]+" "+h[2]+"\n\n");
		
		//enter binary to encrypt
		System.out.print("(one at a time) Please enter the 9 numbers you with to encrypt: \n" + "Assingment example numbers are: 101 010 011\n");
		System.out.print("1st number: "); encrypt[0] = in.nextInt();
		System.out.print("2nd number: "); encrypt[1] = in.nextInt();
		System.out.print("3rd number: "); encrypt[2] = in.nextInt();
		System.out.print("4th number: "); encrypt[3] = in.nextInt();
		System.out.print("5th number: "); encrypt[4] = in.nextInt();
		System.out.print("6th number: "); encrypt[5] = in.nextInt();
		System.out.print("7th number: "); encrypt[6] = in.nextInt();
		System.out.print("8th number: "); encrypt[7] = in.nextInt();
		System.out.print("9th number: "); encrypt[8] = in.nextInt();
		System.out.print("You entered: " + encrypt[0] + encrypt[1] + encrypt[2] + " " + encrypt[3] + encrypt[4] + encrypt[5] + " " + encrypt[6] + encrypt[7] + encrypt[8] + "\n");
		
		//encryption process
		int enText[] = new int[9];
		enText[0]= encrypt[0]*h[0];
		enText[1]= encrypt[1]*h[1];
		enText[2]= encrypt[2]*h[2];
		enText[3]= encrypt[3]*h[0];
		enText[4]= encrypt[4]*h[1];
		enText[5]= encrypt[5]*h[2];
		enText[6]= encrypt[6]*h[0];
		enText[7]= encrypt[7]*h[1];
		enText[8]= encrypt[8]*h[2];
		//cipher
		int cipherText[] = new int[3];
		cipherText[0]= enText[0] + enText[1] + enText[2];
		cipherText[1]= enText[3] + enText[4] + enText[5];
		cipherText[2]= enText[6] + enText[7] + enText[8];
		//console output
		System.out.print("The encrypted message is: "+cipherText[0]+" "+cipherText[1]+" "+cipherText[2]+"\n\n");
		System.out.print("Thank you for using this simple encryption program.\nTry the decryption program to validate ciphertext.\n");
		System.out.print("End of program.\n\n");
	}
}