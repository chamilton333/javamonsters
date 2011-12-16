/**********************************************************
 * 
 *This class defines the interactions between javamon.
 *Most methods take both javamon involved as parameters and use their attributes to alter a certain stat, usually HP, in a certain way.
 *This is the class that will house all attacks the javamon can know.
 *All attacks are static methods so they can be used without creating an Action object. 
 *Attacks will have their own Attributes such as damage and accuracy that are used as a base to start from when calculating total damage dealt or if an attack is a hit or a miss.
 *Most attacks should have some random factor in accuracy and damage.
 *
 *
 *
 *
 *
 */

import java.util.Random;
public class Action {
	
	public static String message=null;
	
	
	
	/****************DO NOT DELETE EVEN IF COMPLETED. THIS SECTION LAYS OUT FUTURE PLANS/GOALS FOR ATTACKS IN CLASS************
	 * 
	 * This basicAttack1 method defines the first attack made. Eventually there should be different types of attacks such as
	 * waterAttack1, fireAttack1, powerfulAttack1 vs. accurateAttack1, etc. For every type of attack, there should be 1-4, each
	 * version being stronger. This way, level 1 can use all attacks that have a 1 on the name, in level 2, javamon will be able
	 * to use attacks with a 2, etc. For example, the method directly after basicAttack1 should be basicAttack2 and the damage might
	 * be 20 instead of 10.
	 * 
	 * For all attacks, when types are incorporated we need multipliers if attack type matches javamon type, and if it is super 
	 * effective (the type of the attack is strong against the type of the defending javamon).
	 * 
	 */
	public static void basicAttack1(Javamon att, Javamon def){   
		int damage = 10;
		int accuracy = 9;
		int hit = 0;
		Random gen = new Random();
		
		damage = (damage*att.getAttackAtt()/def.getDefenseAtt()) + gen.nextInt(11)-5 ;				 //ADD MODIFIER
		
		accuracy = accuracy*att.getAccuracyAtt()/def.getEvasivenessAtt()*10;
		
		hit = gen.nextInt(100)+1;
		
		if(hit>=1 && hit<= accuracy){
			def.setHP(def.getHP()-damage);
			att.setActionResult(att.getName() + " dealt " + damage + " damage to " + def.getName()); //Temporary line for simulation.
			def.setActionResult(att.getName() + " dealt " + damage + " damage to " + def.getName());
		}else{
			att.setActionResult(att.getName() + " missed!");
			def.setActionResult(att.getName() + " missed!");
		}
		
		if(def.getHP()<0){
			def.setHP(0);
			att.setActionResult(def.getName()+" Already dead.");
		}
		
	}
	
	public static void basicAttack2(Javamon att, Javamon def){	//level two version of basic attack
		
	}
	
	
	
	public static void heal(Javamon healer){
		if(healer.getPercentHP()<100){
			healer.setHP(healer.getHP() + healer.getHealAmount() + healer.getAttackAtt()/4);
		}
		
		if(healer.getPercentHP()>100){
			healer.setHP(healer.getMAX_HP());
		}
		
	}	
	
}
