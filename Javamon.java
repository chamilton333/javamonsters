/********************************************
 * 
 * This class is used for the sole purpose of creating javamon, and getting, or editing their attributes. 
 * 
 * This class does NOT handle interjavamon interactions. The Action class defines how the javamon interact with attacks and other actions.
 * 
 * 
 *
 */

public class Javamon {
	
	
	
	
	
	
	
	enum type {fire, earth, water, air}
	
	private int MAX_HP = 100;
	private String name = null;
	private type type = null;
	private int hp = 100;
	private int attackAtt = 10;
	private int defenseAtt = 10;
	private int accuracyAtt = 10;		
	private int evasivenessAtt = 10;	// likelihood of opponent missing
	private boolean canHeal = false;
	private int healAmount = 10;
	
	//---------------------------------------------------------------------------------------------------------------------------------
	//IMPORTANT!!! - If any instance data is added, make sure to add it to the custom constructor (labeled below as Custom Constructor
	//Also make sure to add getter and setter methods in the labeled sections.
	//---------------------------------------------------------------------------------------------------------------------------------
	
	
	
	public Javamon(){	//Default constructor creates javamon with values above
	
	}
	
	public Javamon(String nam){		//Creates default javamon with name of choice.
		name = nam;	
	}
	
	public Javamon(String nam, int h){	//Creates javamon with specified name and HP, all else are default
		name = nam;
		MAX_HP = h;
		hp = h;
	}
	
	public Javamon(String nam, type typ){	//Creates javamon with name and type of choice
		
		nam = name;
		type = typ;
	}
	
	
	
	
	/***********************************
	 * Custom Constructor below
	 ****************************************/
	
	public Javamon(String nam, type typ, int h, int a, int d, boolean heal, int healamoun, int acc, int evade){		//Creates custom javamon with all instance data specified
		name = nam;
		type = typ;
		hp = h;
		attackAtt = a;
		defenseAtt = d;
		MAX_HP = h;
		healAmount = healamoun;
		canHeal = heal;
		accuracyAtt = acc;
		evasivenessAtt = evade;
	}
	

	
	
	/**************************************************************************************
	 * Getters!
	 *************************************************************************/
	
	public int getAttackAtt(){
		return attackAtt;
	}
	public int getDefenseAtt(){
		return defenseAtt;
	}
	public int getHP(){
		return hp;
	}
	public int getHealAmount(){
		return healAmount;
	}
	public boolean getCanHeal(){
		return canHeal;
	}
	public type getType(){
		return type;
	}
	public String getName(){
		return name;
	}
	public int getMAX_HP(){
		return MAX_HP;
	}
	public int getAccuracyAtt(){
		return accuracyAtt;
	}
	public int getEvasivenessAtt(){
		return evasivenessAtt;
	}
	
	
	
	/***************************************************************************************
	 * Setters!
	 * *********************************************************************************/
	
	public void setAttackAtt(int a){
		attackAtt = a;
	}
	public void setDefenseAtt(int d){
		defenseAtt = d;
	}
	public void setHP(int h){
		hp=h;
	}
	public void setHealAmount(int ha){
		healAmount = ha;
	}
	public void setCanHeal(boolean c){
		canHeal = c;
	}
	public void setType(type t){
		type = t;
	}
	public void setName(String str){
		name = str;
	}
	public void setMAX_HP(int m){
		MAX_HP = m;
	}
	public void setAccuracyAtt(int acc){
		accuracyAtt = acc;
	}
	public void setEvasivenessAtt(int evade){
		evasivenessAtt = evade;
	}
	
	
	
	// MIGHT WANT TO MODIFY toString() TO INCLUDE ALL DATA, OR MAYBE MAKE TWO DIFFERENT toString METHODS, ONE TO BE BASIC AND ONE TO BE MORE COMPLEX.
	
	/**************************************************************
	 * Returns, in a String, information about a javamon.
	 **************************************************************/
	
	public String toString(){
		return name+": "+ "  Hitpoints: "+ hp +"  AttackAtt: "+attackAtt+"  DefenseAtt: "+ defenseAtt+"  Type: "+type;
		
	}
	
}
