
public class AI {

	
	public static void act(Battle myBattle){
		if(myBattle.getTheirMon().getPercentHP()<20){
			Action.heal(myBattle.getTheirMon());
		}else{		
		Action.basicAttack1(myBattle.getTheirMon(),myBattle.getMyMon());
		}
		myBattle.nextTurn();
	}
}