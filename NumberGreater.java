import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
class NumberGreater{
	public static void main(String[] args) {
		int specialnum = 0;
		int playerscore = 0;
		int computerscore = 0;
		int tiescore = 0;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Integer> intListComp = new ArrayList<Integer>();
		for(int x = 0; x < 9; x++){
			int numbers;
			numbers = (int) ((Math.random() * 100) + 1);
			intList.add(numbers);
		}
		for(int xc = 0; xc < 9; xc++){
			int numbersComp;
			numbersComp = (int) ((Math.random() * 100) + 1);
			intListComp.add(numbersComp);
		}
		while(intListComp.size() != 0 || intList.size() != 0){
			specialnum++;
			System.out.println("This is the computer's list: ");
			System.out.println(intListComp);
			System.out.println("This is your list: ");
			System.out.println(intList);
			System.out.println("Which card would you like to play(position)?");
			int playpos = scanner.nextInt();
			int comppos = (int) (Math.random() * (10 - specialnum));
			int intnum = intList.get(playpos);
			int compnum = intListComp.get(comppos);
			System.out.println("This is what you entered:" + intnum);
			System.out.println("This is what the computer chose: " + compnum + "\n");
			if(intnum > compnum){
				System.out.println("You win this round!");
				intList.remove(playpos);
				intListComp.remove(comppos);
				playerscore += 1;
				if(tiescore != 0){
					playerscore += tiescore;
					tiescore = 0;
				}
			}
			if(intnum < compnum){
				System.out.println("You lost this round!");
				intList.remove(playpos);
				intListComp.remove(comppos);
				computerscore += 1;
				if(tiescore != 0){
					playerscore += tiescore;
					tiescore = 0;
				}
			}
			if(intnum == compnum){
				System.out.println("It was a tie");
				intList.remove(playpos);
				intListComp.remove(comppos);
				tiescore += 1;
			}
		}
		System.out.println(computerscore);
		System.out.println(playerscore);
		if(playerscore > computerscore){
			System.out.println("You win!");
		}
		if(computerscore > playerscore){
			System.out.println("You lost");
		}
		if(computerscore == playerscore){
			System.out.println("It was a tie");
		}
	}
}
