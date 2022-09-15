package studio2;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startAmount = 100;
		double winChance = 0.51;
		int winLimit = 200;
		int totalSimulations = 500;
		double chance;
		int games = 0;
		int curAmount = startAmount;
		int ruin = 0;
		//int winCount = 0;
		for(int i = 0; i <= totalSimulations; i++) {
			while(curAmount < winLimit && curAmount > 0) {
				chance = Math.random();
				if(chance <= winChance) {
					curAmount++;
				}
				else {
					curAmount--;	
				}
				games++;
				//
			}//end of while
			if(curAmount == 0 ) {
				System.out.println("Simulation " + i + ": " +  games + " LOSE");
				ruin++;
				
			}
			else {
				System.out.println("Simulation " + i + ": " +  games + " WIN");
			}
			games = 0;
			curAmount = startAmount;
			
		}//end of for
		double a = (1 - winChance)/winChance;
		double expRuin = 0;
		if(winChance == 0.5) {
			expRuin = 1 - (startAmount/winChance);
		}
		else {
			expRuin = (Math.pow(a,startAmount) - Math.pow(a,winLimit))/ (1 - Math.pow(a, winLimit));
		}
		System.out.println("Ruin Rate from Simulation: " + (ruin/500.00) + " Expected Ruin Rate: " + expRuin);
	}//end of main

}// end of class
