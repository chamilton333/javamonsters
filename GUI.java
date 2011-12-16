import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI extends JFrame {

	//EDIT FOR GUI TO TAKE GAME OBJECT, ALL SUBPANELS WITH TWO JAVAMON TAKE BATTLE OBJECT

	private FlowLayout myLayout=new FlowLayout();
	
	private Game myGame;

	Javamon Charizard=new Javamon("Charizard", 100,50);
	Javamon Squirtle= new Javamon("Squirtle",100,100);
	public CreaturePanel creaturePanel;
	public ControlPanel controlPanel;
	public ConsolePanel console;
	public String message="Game Started";
	public GUI(Game theGame){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myGame=theGame;
		this.setLayout(myLayout);
		controlPanel=new ControlPanel (theGame.getCurrentBattle());
		creaturePanel=new CreaturePanel (theGame.getCurrentBattle());
		console=new ConsolePanel (theGame.getCurrentBattle());
		this.add(controlPanel);
		this.add(creaturePanel);
		this.add(console);
		this.pack();
		this.setVisible(true);
		run();
	}
	public void run(){
		while(1==1){
			creaturePanel.update();
			console.update();
			if(myGame.getCurrentBattle().isMyTurn()==false){
				AI.act(myGame.getCurrentBattle());
			}
			if(myGame.getCurrentBattle().isBattleOver()){
				nextBattle();
			}
		}
	}
	
	public void nextBattle(){
		myGame.nextBattle();
		controlPanel.setBattle(myGame.getCurrentBattle());
		creaturePanel.setBattle(myGame.getCurrentBattle());
		console.setBattle(myGame.getCurrentBattle());
	}
}
class CreaturePanel extends JPanel{
	private Battle myBattle;
	private MonPanel Creature1;
	private MonPanel Creature2;
	
	public CreaturePanel(Battle theBattle){
	myBattle=theBattle;
	Creature1=new MonPanel(myBattle.getMyMon(), "Charizard.jpg");
	Creature2= new MonPanel(myBattle.getTheirMon(), "Squirtle.jpg");	

	this.setLayout(new BoxLayout(this,1));
	this.add(Creature1);
	this.add(Creature2);
	}
	
	public void setBattle(Battle theBattle){
		myBattle=theBattle;
		Creature1.setMon(myBattle.getMyMon());
		Creature2.setMon(myBattle.getTheirMon());
	}
	
	public void update(){
		Creature1.update();
		Creature2.update();
	}
}
class MonPanel extends JPanel{
	private int health=100;
	private int stamina=100;
	private JLabel picture=new JLabel();
	private ImageIcon theCharizard;
	private StatusBar myStatus= null;
	private Javamon myMon;

	public MonPanel(){

		ImageIcon charizard= new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Charizard.jpg")));
		theCharizard= charizard;

		picture.setIcon(charizard);

		this.add(picture);
		this.add(myStatus);

		this.setSize(200,800);
		repaint();
	}

	public MonPanel(Javamon myMonster, String imageName){
		myStatus= new StatusBar(myMonster);
		ImageIcon charizard= new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(imageName)));
		//ImageIcon charizard=new ImageIcon("C:\\Users\\engineering 20\\Pictures\\Charizard.jpg");
		theCharizard= charizard;

		picture.setIcon(charizard);

		this.add(picture);
		myStatus.setMon(myMonster);
		this.add(myStatus);

		this.setSize(200,800);
		repaint();
	}
	
	public void update(){
		myStatus.update();
		repaint();
	}

	public void setMon(Javamon myMonster){
		myMon=myMonster;
		myStatus.setMon(myMon);
		repaint();
	}

	public  Javamon getMon(){
		return myMon;
	}
}

class ControlPanel extends JPanel{  //Holds action buttons, is passed two Javamon to control
	private Battle myBattle;
	private ActionButton action1;
	private Action2Button action2;
	
	private class ActionButton extends JButton implements ActionListener{ //Action button that only uses BasicAttack
		protected Battle myBattle;
		public String consoleMessage="Game Started";
		
		public ActionButton(String name, Battle battle){
			this.setName(name);
			this.setText(name);
			this.addActionListener(this);
			myBattle=battle;
		}
		public void setBattle(Battle theBattle){
			myBattle=theBattle;
		}

		public void actionPerformed(ActionEvent arg0) {
			Action.basicAttack1(myBattle.getMyMon(),myBattle.getTheirMon());
			System.out.println(myBattle.getTheirMon().getHP());
			nextTurn();
		}
		public void nextTurn(){
			myBattle.nextTurn();
			
		}
		
	}
	private class Action2Button extends ActionButton{
		public Action2Button(String name, Battle myBattle) {
			super(name, myBattle);
			// TODO Auto-generated constructor stub
		}

		public void actionPerformed(ActionEvent arg0){
			Action.heal(myBattle.getMyMon());
			nextTurn();
		}
	}
	public ControlPanel(Battle theBattle){
		myBattle=theBattle;
		action1=new ActionButton("Attack", myBattle);
		action2=new Action2Button("Heal",myBattle);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(action1);
		add (action2);
		//add(action3);
		//add(action4);
	}
	public void setBattle(Battle theBattle){
		myBattle=theBattle;
		action1.setBattle(myBattle);
		action2.setBattle(myBattle);
	}
}

class StatusBar extends JPanel {
	private int MAX_HP=100;
	private int hp=100;
	private int percentHP=hp/MAX_HP;
	private Javamon myMon=null;

	public StatusBar() {


		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(100, 100));

		JPanel rightPanel = new JPanel(new BorderLayout());
		// rightPanel.add(new JLabel(new AngledLinesWindowsCornerIcon()), BorderLayout.SOUTH);
		//  rightPanel.setOpaque(false);

		// add(rightPanel, BorderLayout.EAST);
		setBackground(SystemColor.control);
	}

	public StatusBar(Javamon theMon) {
		myMon=theMon;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(100, 100));
		JPanel rightPanel = new JPanel(new BorderLayout());
		setBackground(SystemColor.control);
	}

	public void update(){
		repaint();
	}
	public void setMon(Javamon theMon){
		myMon=theMon;
	}

	public int getPercentHP(){
		MAX_HP=myMon.getMAX_HP();
		hp=myMon.getHP();
		percentHP=(int)(100*((double)hp)/(MAX_HP));
		return percentHP;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int y = 0;
		
		g.setColor(Color.BLACK);
		g.drawString("Health:"+myMon.healthString(), 10,20);

		g.fillRect(0, 30, getPercentHP(),(int)(this.getPreferredSize().getHeight())/4); //Fills status bar, using (0,0) as starting point and (hpPercent,panelHeight/4) as endpoint

		g.setColor(new Color(156, 154, 140));
		g.drawLine(0, y, getWidth(), y);
		y++;
		g.setColor(new Color(196, 194, 183));
		g.drawLine(0, y, getWidth(), y);
		y++;
		g.setColor(new Color(218, 215, 201));
		g.drawLine(0, y, getWidth(), y);
		y++;
		g.setColor(new Color(233, 231, 217));
		g.drawLine(0, y, getWidth(), y);

		y = getHeight() - 3;
		g.setColor(new Color(233, 232, 218));
		g.drawLine(0, y, getWidth(), y);
		y++;
		g.setColor(new Color(233, 231, 216));
		g.drawLine(0, y, getWidth(), y);
		y = getHeight() - 1;
		g.setColor(new Color(221, 221, 220));
		g.drawLine(0, y, getWidth(), y);	
	}

}

class ConsolePanel extends JPanel{
	private String display="Game Started";
	private Javamon myMon;
	private Javamon theirMon;
	private Battle myBattle;
	
	public ConsolePanel(Battle theBattle){
		setBattle(theBattle);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 100));
	}
	
	public void setBattle(Battle theBattle){
		myBattle=theBattle;
		myMon=myBattle.getMyMon();
		theirMon=myBattle.getTheirMon();
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int y = 0;
		
		g.setColor(Color.BLACK);
		g.drawString(display, 10,15);

	}
	public void update(){
		setDisplay();
		this.repaint();
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay() {
		display=myMon.getActionResult();
		System.out.println("setDisplay called"+myMon.getActionResult());
	}
	
}