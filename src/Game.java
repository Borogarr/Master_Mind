import java.util.Scanner;
public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String guess = "";
		String cont;
		String[] eval = {"X","X","X","X"};
		boolean x = true;
		boolean win = false;
		boolean validMove = false;
		int guessCount = 0;
		
		Player player = new Player();
		Computer comp = new Computer();
		
		System.out.println("Welcome to Master Mind!");
		System.out.println("In this game, you will try to guess the color of four balls that the computer has.");
		System.out.println("The colors can be Red, Green, Blue or Yellow.");
		System.out.println("Let the game begin!");
		
		Scanner scanner = new Scanner(System.in);
		
		while(x) {
			System.out.println("Randomizing the computers colors...");
			comp.randomize();
			
			while (!win) {
				System.out.println("Please make your guess. Enter R,G,B or Y without any spaces in all capital Letters. Ex: RRGB.");
				System.out.println("Number of guesses so far: " + guessCount);
				validMove = false;
				while(!validMove) {
					guess = scanner.next();
					if(guess.length() != 4) {
						System.out.println("Please enter a valid guess.");
					}
					else {
						validMove = true;
					}
				
				}
				player.guess(guess);
				guessCount++;
			
			
				eval = player.evaluate(comp.getColors(), comp.getCounts());
				player.print();
				win = player.win(eval);
			
				if (win == true) {
					System.out.println("Congratulations! You Win!");
					break;
				}
				
				System.out.println("Incorrect guess.");
				player.clear();
			}
			
			System.out.println("Would you like to play again? Y for yes, all others will exit.");
			cont = scanner.next();
		
			if(cont.equals("Y")) {
				x = true;
				guessCount = 0;
				win = false;
				player.clear();
			}
			else {
				x = false;	
				scanner.close();
			}
		
		}

	}
}
