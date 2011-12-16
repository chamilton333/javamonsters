
public class Battle {
	private Javamon myMon,theirMon;
	private boolean isMyTurn=true;
	
	
	public Battle(Javamon myMonster, Javamon theirMonster){
		myMon=myMonster;
		theirMon=theirMonster;
	}

	public boolean isBattleOver(){
		boolean isOver=false;
		if (myMon.getHP()<=0||theirMon.getHP()<=0){
			isOver=true;
			setMyTurn(true);
		}
		return isOver;
	}
	public Javamon getMyMon() {
		return myMon;
	}


	public Javamon getTheirMon() {
		return theirMon;
	}
	public boolean isMyTurn() {
		return isMyTurn;
	}
	
	public void nextTurn(){
		if(isBattleOver()==false)
		isMyTurn=!isMyTurn;
	}
	
	
	public void setMyMon(Javamon myMon) {
		this.myMon = myMon;
	}


	public void setTheirMon(Javamon theirMon) {
		this.theirMon = theirMon;
	}


	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}
	
	
	
}
