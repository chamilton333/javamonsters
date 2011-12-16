import java.util.ArrayList;


public class Game {
	
	 private ArrayList<Battle> Battles=new ArrayList<Battle>();
	 private int currentBattleNum=0;
	 public Game(){
		 
		 for(int i=0;i<=3;i++){
			Javamon myMon=new Javamon("Charizard"+i,100+10*(i));
			Javamon theirMon= new Javamon("Squirtle"+1,100+10*(i-1));
			Battles.add(new Battle(myMon, theirMon));
		 }
		 currentBattleNum=0;
	 }
	 
	 
	public void nextBattle(){
		if(currentBattleNum<3){
			currentBattleNum++;
		}
	}
	
	public Battle getCurrentBattle(){
		return Battles.get(currentBattleNum);
	}
	 
	public ArrayList<Battle> getBattles() {
		return Battles;
	}
	public int getCurrentBattleNum() {
		return currentBattleNum;
	}
	public void setBattles(ArrayList<Battle> battles) {
		Battles = battles;
	}
	public void setCurrentBattleNum(int currentBattle) {
		this.currentBattleNum = currentBattle;
	}
	 
	 
}
