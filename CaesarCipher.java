/*
 * Course: Computer Security ITD3523 OSUIT Spring Semester 2016 Online
 * Assignment: CaesarCipher.java
 * Author: Shannon Beckman
 * Date: Jan 5, 2016 - Jan 7, 2016
 * Instructor: Prof: Dewey  
 * Description: This program is designed to decipher caesar cipher assigned by K. Dewey. A shift value is to be asked 
 * from the program user. That shift value is to be used to attempt to decipher the ciphertext provided by the professor.
 * For this exercise we are to use the ANSI values of the upper case characters between 65 and 90.
 */

/*Please forgive the crudeness of this program. I have nevered programmed in Java so I to try and pick up the basics quickly. I did not perform any input validation.*/

import java.util.Scanner;

public class CaesarCipher
{
	public static void main(String[] args)
	{
		//Create Scanner object named in
		Scanner in = new Scanner(System.in);

		//set var to hold ciphertext from assignment provided by instructor
		String ciphertext = "WKHQHZRUNLQJDQGFBEHUVHFXULWBGHSDUWPHQWDWURVHVWDWHFROOHJHRIIHUVDFHUWLILFDWHSURJUDPLQLQIRUPDWLRQVHFXULWBDWDOOIHGHUDOWUDLQLQJOHYHOVWKHSURJUDPFHUWLILHVWKHVWXGHQWVVDWLVIBLQJSURJUDPUHTXLUHPHQWVDUHWUDLQHGWRWKHIHGHUDOQVWLVVLFQVVLVWDQGDUGVIRULQIRUPDWLRQVBVWHPVVHFXULWBSURIHVVLRQDOVGHVLJQDWHGDSSURYLQJDXWKRULWLHVLQIRUPDWLRQVBVWHPVHFXULWBRIILFHUVVBVWHPVFHUWLILHUVDQGULVNDQDOBVWUHVSHFWLYHOB";
		
		//user info
		System.out.print("This program takes a ciphertext and converts it into plaintext.\n");
		
		//ask user for shift input
		System.out.print("Hint: use -3 for this exercise! Please enter an integer to use as the shift value for the cipher: ");
		
		//int var named shift to hold shift value
		int shift = in.nextInt();
		
		//output to console shift value
		System.out.print("\nYou have entered: " + shift + "\n\n");
		
		//output to console
		System.out.print("The ciphertext is: \n" + ciphertext + "\n\nwhich becomes: \n");

		//varibles used for the while loop
		char decrypted;
		int length = ciphertext.length();
		int count = 0;		

		//Many things are going on in the while loop. The decrypted var is set to the
		//ANSI value of the character and then shifted value supplied by the user.
		//The decrypted var holds the current working char and the count var holds the place value.

		while (count != length)
		{
			decrypted = ((char)((int)ciphertext.charAt(count) + shift));
			decrypted = ((char)((int)decrypted - 'A'));
			decrypted = ((char)((int)decrypted + 26));
			decrypted = ((char)((int)decrypted % 26));
			decrypted = ((char)((int)decrypted + 'A'));
			System.out.print(decrypted);
			count++;
		}

		System.out.print("\n\n");
		System.out.print("Thank you for playing.");
	}
}