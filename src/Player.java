
public class Player {
	private char[] guessColors = {'X','X','X','X'};
	private String[] output = {"X","X","X","X"};
	private int[] counts = new int[4];
	private int hits = 0;
	private int pseudo = 0;
	private int miss = 0;

	
	public Player() {
		
	}
	
	public void guess(String input) {
		for (int i = 0; i < guessColors.length; i++) {
			guessColors[i] = input.charAt(i);
		}
		
	}
	
	public String[] evaluate(char[] comp, int[] count) {
		counts = count;
		for (int i = 0; i < guessColors.length; i++) {
			if(comp[i] == guessColors[i]) {
				output[i] = "Hit";
				hits++;
				if (guessColors[i] == 'R') {
					counts[0]--;
				}
				else if (guessColors[i] == 'G') {
					counts[1]--;
				}
				else if (guessColors[i] == 'B') {
					counts[2]--;
				}
				else {
					counts[3]--;
				}
			}
		}
		
		for (int i = 0; i < guessColors.length; i++) {
			if(comp[i] != guessColors[i] && guessColors[i] == 'R') {
				if(counts[0] != 0) {
					output[i] = "Pseudo Hit";
					pseudo++;
					counts[0]--;
				}
				else {
					output[i] = "Miss";
					miss++;
				}
			}
			if(comp[i] != guessColors[i] && guessColors[i] == 'G') {
				if(counts[1] != 0) {
					output[i] = "Pseudo Hit";
					pseudo++;
					counts[1]--;
				}
				else {
					output[i] = "Miss";
					miss++;
				}
			}
			if(comp[i] != guessColors[i] && guessColors[i] == 'B') {
				if(counts[2] != 0) {
					output[i] = "Pseudo Hit";
					pseudo++;
					counts[2]--;
					}
				else {
					output[i] = "Miss";
					miss++;
				}
			}
			if(comp[i] != guessColors[i] && guessColors[i] == 'Y') {
				if(counts[3] != 0) {
					output[i] = "Pseudo Hit";
					pseudo++;
					counts[3]--;
				}
				else {
					output[i] = "Miss";
					miss++;
				}
			}
		}
	
		return output;
	}
	
	public boolean win(String[] eval) {
		int winCount = 0;
		for (int i = 0; i < eval.length; i++) {
			if(eval[i].equals("Hit")) {
				winCount++;
			}
			
		}
		if (winCount == 4) {
			return true;
		}
		
		return false;
	}
	
	
	public char[] getColors() {
		return guessColors;
	}
	
	public int getHits() {
		return hits;
	}
	
	public int getPseudo() {
		return pseudo;
	}
	
	public int getMiss() {
		return miss;
	}
	
	public void clear() {
		hits = 0;
		pseudo = 0;
		miss = 0;
	}
	
	public void print() {
		System.out.println("Number of Hits: " + hits);
		System.out.println("Number of PseudoHits: " + pseudo);
		System.out.println("Number of Misses: " + miss);
	}
	
	
	
	
	
	
	
	
}
