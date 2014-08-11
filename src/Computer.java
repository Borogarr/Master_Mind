import java.util.Random;
public class Computer {
	private char[] compColors = {'X','X','X','X'};
	private Random random = new Random();
	private int randomNum;
	private char randomChar;
	private int redCount = 0;
	private int blueCount = 0;
	private int greenCount = 0;
	private int yellowCount = 0;
	
	public Computer() {
		
	}
	
	public void randomize() {
		for (int i = 0; i < compColors.length; i++) {
			randomNum = random.nextInt(4);
			compColors[i] = colorGen(randomNum);
		}
		
	}
	
	public char colorGen(int randomNum) {
		if (randomNum == 0) {
			randomChar = 'R';
			redCount++;
			return randomChar;
			
		}
		else if (randomNum == 1) {
			randomChar = 'G';
			greenCount++;
			return randomChar;
		}
		else if (randomNum == 2) {
			randomChar = 'B';
			blueCount++;
			return randomChar;
		}
		else {
			randomChar = 'Y';
			yellowCount++;
			return randomChar;
		}
	}
	
	public int[] getCounts() {
		int[] counts = {redCount,greenCount,blueCount,yellowCount};
		return counts;
	}
	
	public void resetCounts() {
		redCount = 0;
		greenCount = 0;
		blueCount = 0;
		yellowCount = 0;
	}
	
	public char[] getColors() {
			return compColors;
	}
	
	
	
	
	
}
