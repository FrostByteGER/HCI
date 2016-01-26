package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Settings {
	
	//CORE
	public static final int EP_PER_KILL = 2;
	public static final int EP_START = 100;
	public static final int EP_FOR_NEXT_LEVEL_MUL = 2;
	
	public static final int ATK_EP = 10;
	public static final int DEF_EP = 1;
	
	public static final int UNIT_CAP_FIELD = 3000;
	public static final int UNIT_CAP_PLAYER = 99;
	
	public static final int UNIT_MAX_DAMAGE = 15;
	public static final int UNIT_MIN_DAMAGE = 10;
	public static final int UNIT_HP = 100;
	
	public static final int ITEM_CAP_UNITGROUP = 3;
	public static final int ITEM_USES = 10;
	
	public static final int GROUP_AMOUNT = 2;
	public static final int PLAYER_PER_GROUP = 20;
	public static final int BLUE = 0;
	public static final int RED = 1;
	
	public static final int MAP_SIZE = 50;
	public static final boolean SHOW_EXTENDET = true; 
	
	public static final int TICK_AMOUNT = 2000;
	public static final int FIGHTS_PER_TICK = 5;
	public static final int UNIT_COST = 5;
	public static final int MONEY_PER_TICK = 10;
	public static final int MONEY_CAP = 500;
	public static final int MONEY_PER_FIELD = 10; // Prozent
	
	public static final int MORE_MONEY_PER_LEVEL = 10;
	public static final int MORE_UNITS_PER_LEVEL = 5;
	
	//GUI
	public static final int MAX_ZOOM = 100;
	public static final int MIN_ZOOM = 25;
	
	public static final int TICK_SPEED = 5000;
	
	public static final Color LIGHT_BLUE = new Color(200,200,255);
	public static final Color LIGHT_RED = new Color(255,200,200);
	
	//Fonts
	public static final Font SMALL_FONT = new Font("Arial", Font.PLAIN, 12);
	public static final Font MID_FONT = new Font("Arial", Font.PLAIN, 20);
	public static final Font BIG_FONT = new Font("Arial", Font.PLAIN, 32);
	
	//Icons
	public static final ImageIcon SHIELD = new ImageIcon("../Tingress/Images/ShieldIcon.png"); 
	public static final ImageIcon SWORD = new ImageIcon("../Tingress/Images/SwordIcon.png"); 
	public static final ImageIcon PERSON = new ImageIcon("../Tingress/Images/PersonIcon.png");
	public static final ImageIcon CHAT = new ImageIcon("../Tingress/Images/IconChat.png");
	public static final ImageIcon HAUS = new ImageIcon("../Tingress/Images/IconHaus.png");
	public static final ImageIcon OPTION = new ImageIcon("../Tingress/Images/IconSchraubenschluessel.png");
	public static final ImageIcon CLAN = new ImageIcon("../Tingress/Images/IconCommunity.png");
	public static final ImageIcon LOG = new ImageIcon("../Tingress/Images/IconReport.png");
	public static final ImageIcon ARCHER = new ImageIcon("../Tingress/Images/bow.png");
	public static final ImageIcon LANCER = new ImageIcon("../Tingress/Images/Lanze_Klein.png");
	public static final ImageIcon HORSEMAN = new ImageIcon("../Tingress/Images/horsman.png");
	public static final ImageIcon ITEM = new ImageIcon("../Tingress/Images/HexagonIcon.png");

	
}
