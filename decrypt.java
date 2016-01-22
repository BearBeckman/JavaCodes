//Shannon Beckman
//ITD 3523 Computer Security
//Prof: Ken Dewey
//Jan  18, 2016 - Jan 20, 2016

//IoW = w^(n-2) mod n

import java.util.Scanner;

public class decrypt{

	public static void main(String[] args){
	//variable declarations
	int iow=0, w=0, n=0, knapsack[]= new int[3];
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
	System.out.print("Please enter the first number from the Simple Knapsack: ");
	knapsack[0] = in.nextInt();

	//second number
	System.out.print("Please enter the second number from the Simple Knapsack: ");
	knapsack[1] = in.nextInt();

	//third number
	System.out.print("Please enter the third number from the Simple Knapsack: ");
	knapsack[2] = in.nextInt();System.out.print("\n");

	//console output
	System.out.print("You have entered: " + knapsack[0] + " " + knapsack[1] + " " + knapsack[2] + " for the  simple knapsack.\n");

	//find Inverse of w		
	iow = (int)((Math.pow((double) w, (double)(n-2)))%n);
	System.out.print("The known Inverse of W is: " + iow + "\n");

	//ciphertext
	int ciphertext[] = new int[3];
	System.out.print("Please enter the first ciphertext you wish to decrypt: ");
	ciphertext[0] = in.nextInt();

	System.out.print("Please enter second the ciphertext you wish to decrypt: ");
	ciphertext[1] = in.nextInt();

	System.out.print("Please enter the  third ciphertext you wish to decrypt: ");
	ciphertext[2] = in.nextInt();

	System.out.print("\nThe Ciphertext you entered is: " + ciphertext[0] + " " + ciphertext[1] + " " + ciphertext[2] + "\n");

	//calculate the hard knapsack
	int hard[] = new int[3];
	hard[0] = (iow*ciphertext[0])%n;
	hard[1] = (iow*ciphertext[1])%n;
	hard[2] = (iow*ciphertext[2])%n;

	System.out.print("Hard knapsack is: " + hard[0] + " " + hard[1] + " " + hard[2] + "\n");

	//calculate the plaintext from the hard knapsack and ciphertext
	//variables for decryption
	int im[]= new int[2]; im[0]=0; im[1]=1;
	int plainText1[] = new int[3], plainText2[] = new int[3], plainText3[] = new int[3]; 
	//1st text decipher
	if(((knapsack[0]*im[1]) + (knapsack[1]*im[1]) + (knapsack[2]*im[1])) == hard[0]){
		plainText1[0]=1;plainText1[1]=1;plainText1[2]=1;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[1]) + (knapsack[2]*im[0])) == hard[0]){
		plainText1[0]=1;plainText1[1]=1;plainText1[2]=0;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[0]) + (knapsack[2]*im[1])) == hard[0]){
		plainText1[0]=1;plainText1[1]=0;plainText1[2]=1;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[0]) + (knapsack[2]*im[0])) == hard[0]){
		plainText1[0]=1;plainText1[1]=0;plainText1[2]=0;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[1]) + (knapsack[2]*im[1])) == hard[0]){
		plainText1[0]=0;plainText1[1]=1;plainText1[2]=1;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[1]) + (knapsack[2]*im[0])) == hard[0]){
		plainText1[0]=0;plainText1[1]=1;plainText1[2]=0;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[0]) + (knapsack[2]*im[1])) == hard[0]){
		plainText1[0]=0;plainText1[1]=0;plainText1[2]=1;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[0]) + (knapsack[2]*im[0])) == hard[0]){
		plainText1[0]=0;plainText1[1]=0;plainText1[2]=0;
	}
	else{		
		System.out.print("No knapsack matches found for ciphertext one.\n");
	}

	//2nd text decipher
	if(((knapsack[0]*im[1]) + (knapsack[1]*im[1]) + (knapsack[2]*im[1])) == hard[1]){
		plainText2[0]=1;plainText2[1]=1;plainText2[2]=1;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[1]) + (knapsack[2]*im[0])) == hard[1]){
		plainText2[0]=1;plainText2[1]=1;plainText2[2]=0;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[0]) + (knapsack[2]*im[1])) == hard[1]){
		plainText2[0]=1;plainText2[1]=0;plainText2[2]=1;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[0]) + (knapsack[2]*im[0])) == hard[1]){
		plainText2[0]=1;plainText2[1]=0;plainText2[2]=0;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[1]) + (knapsack[2]*im[1])) == hard[1]){
		plainText2[0]=0;plainText2[1]=1;plainText2[2]=1;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[1]) + (knapsack[2]*im[0])) == hard[1]){
		plainText2[0]=0;plainText2[1]=1;plainText2[2]=0;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[0]) + (knapsack[2]*im[1])) == hard[1]){
		plainText2[0]=0;plainText2[1]=0;plainText2[2]=1;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[0]) + (knapsack[2]*im[0])) == hard[1]){
		plainText2[0]=0;plainText2[1]=0;plainText2[2]=0;
	}
	else{
		System.out.print("No knapsack matches found for ciphertext two.\n");
	}

	//3rd text decipher
	if(((knapsack[0]*im[1]) + (knapsack[1]*im[1]) + (knapsack[2]*im[1])) == hard[2]){
		plainText3[0]=1;plainText3[1]=1;plainText3[2]=1;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[1]) + (knapsack[2]*im[0])) == hard[2]){
		plainText3[0]=1;plainText3[1]=1;plainText3[2]=0;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[0]) + (knapsack[2]*im[1])) == hard[2]){
		plainText3[0]=1;plainText3[1]=0;plainText3[2]=1;
	}
	else if(((knapsack[0]*im[1]) + (knapsack[1]*im[0]) + (knapsack[2]*im[0])) == hard[2]){
		plainText3[0]=1;plainText3[1]=0;plainText3[2]=0;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[1]) + (knapsack[2]*im[1])) == hard[2]){
		plainText3[0]=0;plainText3[1]=1;plainText3[2]=1;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[1]) + (knapsack[2]*im[0])) == hard[2]){
		plainText3[0]=0;plainText3[1]=1;plainText3[2]=0;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[0]) + (knapsack[2]*im[1])) == hard[2]){
		plainText3[0]=0;plainText3[1]=0;plainText3[2]=1;
	}
	else if(((knapsack[0]*im[0]) + (knapsack[1]*im[0]) + (knapsack[2]*im[0])) == hard[2]){
		plainText3[0]=0;plainText3[1]=0;plainText3[2]=0;
	}
	else{
		System.out.print("No knapsack matches found for ciphertext three.\n");
	}
	//Intermediate plaintext
	System.out.print("The plain text is: "+plainText1[0]+plainText1[1]+plainText1[2]+" "+plainText2[0]+plainText2[1]+plainText2[2]+" "+plainText3[0]+plainText3[1]+plainText3[2]+"\n\n");
	System.out.print("End of program. Thank you for using this simple decryption progrom.\n\n");
	}
}