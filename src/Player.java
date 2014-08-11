
public class Player {
	private char[] guessColors = {'X','X','X','X'};
	private String[] output = new String[4];
	private int[] counts = new int[4];

	
	public Player() {
		
	}
	
	public void guess(char[] input) {
		for (int i = 0; i < input.length; i++) {
			guessColors[i] = input[i];
		}
		
	}
	
	public String[] evaluate(char[] comp, int[] count) {
		counts = count;
		for (int i = 0; i < guessColors.length; i++) {
			if(comp[i] == guessColors[i]) {
				output[i] = "Hit";
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
					counts[0]--;
				}
				else {
					output[i] = "Miss";
				}
			}
			if(comp[i] != guessColors[i] && guessColors[i] == 'G') {
				if(counts[1] != 0) {
					output[i] = "Pseudo Hit";
					counts[1]--;
				}
				else {
					output[i] = "Miss";
				}
			}
			if(comp[i] != guessColors[i] && guessColors[i] == 'B') {
				if(counts[2] != 0) {
					output[i] = "Pseudo Hit";
					counts[2]--;
					}
				else {
					output[i] = "Miss";
				}
			}
			if(comp[i] != guessColors[i] && guessColors[i] == 'Y') {
				if(counts[3] != 0) {
					output[i] = "Pseudo Hit";
					counts[3]--;
				}
				else {
					output[i] = "Miss";
				}
			}
		}
	
		return output;
	}
	
	
	public char[] getColors() {
		return guessColors;
	}
	
	
	
	
	
	
	
	
}
