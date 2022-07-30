package bohnanza;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

//Class Authors - Adam P, Danjie T, and Jesse Z

/* -- This class contains a majority of 'Bohnanza!'s gameplay elements,
 * including the game board GUI, the player's hand, planting fields, etc.
 * 
 */

public class Game extends JFrame implements ActionListener {
	// This stores the turn number
	private int turn = 1;

	//This stores how many beans field each player has
	private int numField1=2;
	private int numField2=2;

	// This arraylist stores the draw pile
	private Pile drawpile = new Pile();

	// This class stores the discarded card pile
	private Pile discardpile = new Pile();
	private Pile field1Player1=new Pile();
	private Pile field2Player1=new Pile();
	private Pile field3Player1=new Pile();
	Pile field1Player2=new Pile();
	Pile field2Player2=new Pile();
	Pile field3Player2=new Pile();

	// This class stores the temporary discarded pile for next player to use during
	// turn 1
	private Pile tempdiscardpile = new Pile();

	// Records the who's turn it is
	private boolean side = true;

	// Both player and their data
	Player player1 = new Player();
	Player player2;

	private ImageIcon backgroundImage;

	// GUI elements
	JPanel menuPanel = new JPanel();
	JPanel plant = new JPanel();
	JLabel label = new JLabel();
	JLabel background = new JLabel();

	// player 1buttons
	JButton p1cardHand = new JButton();
	JButton p1goldStack = new JButton();
	JButton p1Field1 = new JButton();
	JButton p1Field2 = new JButton();
	JButton p1Field3 = new JButton();
	JButton p1BuyField = new JButton();

	//Player 2 buttons
	JButton p2cardHand = new JButton();
	JButton p2goldStack = new JButton();
	JButton p2Field1 = new JButton();
	JButton p2Field2 = new JButton();
	JButton p2Field3 = new JButton();
	JButton p2BuyField = new JButton();

	//Neutral button
	JButton tradeButton = new JButton();
	JButton nextTurn = new JButton();
	JLabel draw=new JLabel();
	JLabel discard=new JLabel();

	//Player 1 
	JLabel coin1=new JLabel(Integer.toString(player1.getGoldCoinNum()));
	JLabel field1Num1=new JLabel(Integer.toString(field1Player1.getArrayList().size()));
	JLabel field2Num1=new JLabel(Integer.toString(field2Player1.getArrayList().size()));
	JLabel field3Num1=new JLabel(Integer.toString(field3Player1.getArrayList().size()));
	JLabel field11=new JLabel();
	JLabel field21=new JLabel();
	JLabel field31=new JLabel();

	//Player 2
	JLabel coin2;
	JLabel field1Num2=new JLabel(Integer.toString(field1Player2.getArrayList().size()));
	JLabel field2Num2=new JLabel(Integer.toString(field2Player2.getArrayList().size()));
	JLabel field3Num2=new JLabel(Integer.toString(field3Player2.getArrayList().size()));
	JLabel field12=new JLabel();
	JLabel field22=new JLabel();
	JLabel field32=new JLabel();

	// Card hand elements
	JLabel turnLabel=new JLabel();
	JButton handLeftHand = new JButton();
	JButton handRightHand = new JButton();
	JButton handExit = new JButton();
	JButton notificationExit=new JButton();
	JFrame playerHandFrame = new JFrame();
	JFrame notification=new JFrame();
	JPanel notificationPanel = new JPanel();
	JButton okButton = new JButton();
	JPanel playerHandPanel = new JPanel();
	JLabel card1Hand = new JLabel();
	JLabel card2Hand = new JLabel();
	JLabel card3Hand = new JLabel();
	JLabel card4Hand = new JLabel();
	JLabel card5Hand = new JLabel();
	JLabel show=new JLabel("Turn "+Integer.toString(turn));

	//Turn 1
	JFrame turn1=new JFrame();
	JButton discardExit=new JButton();
	JPanel discardPanel=new JPanel();
	JButton handLeftDiscard=new JButton();
	JButton handRightDiscard=new JButton();
	JButton button1Turn1=new JButton();
	JButton button2Turn1=new JButton();
	JButton button3Turn1=new JButton();
	JButton button4Turn1=new JButton();
	JButton button5Turn1=new JButton();
	JLabel discardLabel=new JLabel();
	JLabel card1Turn1=new JLabel();
	JLabel card2Turn1=new JLabel();
	JLabel card3Turn1=new JLabel();
	JLabel card4Turn1=new JLabel();
	JLabel card5Turn1=new JLabel();

	//Turn 2
	JFrame turn2=new JFrame();
	JPanel plantPanel=new JPanel();
	JButton plantLeft=new JButton();
	JButton plantRight=new JButton();
	JButton button1Turn2Plant=new JButton();
	JButton button1Turn2=new JButton();
	JButton button2Turn2=new JButton();
	JButton button3Turn2=new JButton();
	JButton button4Turn2=new JButton();
	JButton button5Turn2=new JButton();
	JButton turn2Exit = new JButton();
	JLabel turn2Label = new JLabel();
	JLabel card1Turn2=new JLabel();
	JLabel card2Turn2=new JLabel();
	JLabel card3Turn2=new JLabel();
	JLabel card4Turn2=new JLabel();
	JLabel card5Turn2=new JLabel();

	//Turn 3
	JFrame turn3=new JFrame();
	JPanel drawPanel=new JPanel();
	JButton button1Turn3=new JButton();
	JButton button2Turn3=new JButton();
	JButton button3Turn3=new JButton();
	JButton turn3Exit = new JButton();
	JLabel turn3Label= new JLabel();
	JLabel card1Turn3=new JLabel();
	JLabel card2Turn3=new JLabel();
	JLabel card3Turn3=new JLabel();
	JLabel card1Label3=new JLabel();
	JLabel card2Label3=new JLabel();
	JLabel card3Label3=new JLabel();
	Pile card1=new Pile();
	Pile card2=new Pile();
	Pile card3=new Pile();

	//Turn 4
	JFrame turn4=new JFrame();
	JPanel tradePanel=new JPanel();
	Pile tradeable=new Pile();
	Pile giveCard=new Pile();
	Pile takeCard=new Pile();
	Pile copy=new Pile();
	JButton tradeNextStep=new JButton();
	JButton handLeftTrade=new JButton();
	JButton handRightTrade=new JButton();
	JButton button1Turn4=new JButton();
	JButton button2Turn4=new JButton();
	JButton button3Turn4=new JButton();
	JButton button4Turn4=new JButton();
	JButton button5Turn4=new JButton();
	JButton yes=new JButton();
	JButton no=new JButton();
	JLabel card1Turn4=new JLabel();
	JLabel card2Turn4=new JLabel();
	JLabel card3Turn4=new JLabel();
	JLabel card4Turn4=new JLabel();
	JLabel card5Turn4=new JLabel();
	JLabel notice=new JLabel();
	private int tradeStep=1;
	private int indexTrade=0;

	// This holds the amount of times the player is allowed to browse for more cards in their hand
	private int indexHand = 0;
	private int indexDiscard=0;
	private int indexDraw=0;
	private int plantTime=0;
	private int discardTime=0;
	private boolean choose;

	private Clip menuMusic;

	@SuppressWarnings("unchecked")
	public Game(boolean chooseAI) {
		choose=chooseAI;
		
		// Check if user choose AI
		if (chooseAI) {
			player2 = new AI(field1Player2, field2Player2, field3Player2, drawpile, player1.getHandCard());
			backgroundImage = new ImageIcon("images/gameScreen1P.png");
		} else {
			player2 = new Player();
			backgroundImage = new ImageIcon("images/gameScreen2P.png");
		}
		
		coin2=new JLabel(Integer.toString(player2.getGoldCoinNum()));

		// Set up the game
		startUp();

		// call methods
		p1ButtonSetup();
		p2ButtonSetup();
		middleButtonSetup();
		handFrameSetup();
		notificationSetUp();
		discardFrameSetup();
		plantFrameSetup();
		drawFrameSetup();
		tradeFrameSetup();
		frameSetup(chooseAI);
		nextTurn();
		refresh();
	}

	/**
	 * This method initialized the game pre-none post-The game is initialized and
	 * ready to go
	 */
	@SuppressWarnings("unchecked")
	private void startUp() {
		// Initialize the piles for the game
		StartingDrawPile start = new StartingDrawPile();

		// This initialize the drawing pile
		drawpile.setArrayList(start.getDrawingPile());

		// Draw hand card for both players
		for (int i = 0; i < 5; i++) {
			player1.addHandCard(drawpile.draw());
			player2.addHandCard(drawpile.draw());	
		}
	}

	/**
	 * This method is called when player exits turn 5 pre-none post-If the game
	 * ends, ending method is called, else continue
	 */
	private void checkEnd() {
		if (!continueGame()) {
			// This is run when the game is ending
			// Hide the frame
			setVisible(false);

			DisplayWinner end = new DisplayWinner(endGame());
		}
	}

	/**
	 * This method is called when next turn method is called pre-none post-Next
	 * turn.
	 */
	private void nextTurn() {
		if (turn == 5) {
			checkEnd();
			turn = 1;
			switchPlayer();
		} else {
			turn++;
		}
		refresh();

		if (side) {
			// Indicates it is player 1's turn
			switch (turn) {
			case 1:
				turn1();
				break;
			case 2:
				if(player1.getHandCard().isEmpty()) {
					//Run when player 1 has an empty hand
					nextTurn();
					break;
				}else {
					button1Turn2.setVisible(true);
					button2Turn2.setVisible(true);
					button3Turn2.setVisible(true);
					button4Turn2.setVisible(true);
					button5Turn2.setVisible(true);
					nextTurn.setVisible(false);
					turn1.setVisible(false);
					//Empty the temp discard pile
					int temp=tempdiscardpile.getArrayList().size();
					for(int i=0;i<temp;i++) {
						discardpile.addNewCard(tempdiscardpile.getTopCard());
					}
					tempdiscardpile.empty();
					turn2();
					break;
				}
			case 3:
				plantTime=0;
				discardTime=0;
				turn2.setVisible(false);
				turn3();
				break;
			case 4:
				turn3.setVisible(false);
				break;
			case 5:
				turn5();
				tradeable.empty();
				turn4.setVisible(false);
				
				int num=card1.getArrayList().size();
				for(int i=0;i<num;i++) {
					tempdiscardpile.addNewCard(card1.getTopCard());
				}
				
				num=card2.getArrayList().size();
				for(int i=0;i<num;i++) {
					tempdiscardpile.addNewCard(card2.getTopCard());
				}
				
				num=card3.getArrayList().size();
				for(int i=0;i<num;i++) {
					tempdiscardpile.addNewCard(card3.getTopCard());
				}
				
				card1.empty();
				card2.empty();
				card3.empty();
			}
		} else {
			if(player2 instanceof AI) {
				//AI tries to buy a field
				if(player2.buyBeanField()) {
					notification(6);
				}
				
				//Indicates that this is AI's turn
				switch (turn) {
				case 1:
					player2.turn1(tempdiscardpile.getArrayList());
					turn1();
					button1Turn1.setVisible(false);
					button2Turn1.setVisible(false);
					button3Turn1.setVisible(false);
					button4Turn1.setVisible(false);
					button5Turn1.setVisible(false);
					refresh();
					break;
				case 2:
					button1Turn2.setVisible(true);
					button2Turn2.setVisible(true);
					button3Turn2.setVisible(true);
					button4Turn2.setVisible(true);
					button5Turn2.setVisible(true);
					if(player2.getHandCard().isEmpty()) {
						//Run when AI has an empty hand
						nextTurn();
						refresh();
						break;
					}else {
						//Collect temp discard cards to discard pile
						int temp=tempdiscardpile.getArrayList().size();
						for(int i=0;i<temp;i++) {
							discardpile.addNewCard(tempdiscardpile.getTopCard());
						}
						tempdiscardpile.empty();
						player2.turn2();
						refresh();
						break;
					}
				case 3:
					turn2.setVisible(false);
					if(player2.turn3(tempdiscardpile.getArrayList())) {
						checkEnd();
					}
					refresh();
					break;
				case 4:
					tradeButton.setVisible(false);
					takeCard.empty();
					giveCard.empty();
					((AI) player2).aggressiveTrade(takeCard, giveCard);
					tradeStep=2;
					tradeNextStep();
				case 5:
					turn5();
					tradeable.empty();
				}
			}else {
				// Indicates it is player 2's turn
				switch (turn) {
				case 1:
					turn1();
					break;
				case 2:
					if(player2.getHandCard().isEmpty()) {
						//Run when player2 has an empty hand
						nextTurn();
						break;
					}else {
						//Collect temp discard cards to discard pile
						nextTurn.setVisible(false);
						int temp=tempdiscardpile.getArrayList().size();
						for(int i=0;i<temp;i++) {
							discardpile.addNewCard(tempdiscardpile.getTopCard());
						}
						tempdiscardpile.empty();
						turn2();
						break;
					}
				case 3:
					plantTime=0;
					turn2.setVisible(false);
					turn3();
					break;
				case 4:
					for(int i=0;i<card1.getArrayList().size();i++) {
						tradeable.addNewCard(card1.getTopCard());
					}
					for(int i=0;i<card2.getArrayList().size();i++) {
						tradeable.addNewCard(card2.getTopCard());
					}
					for(int i=0;i<card3.getArrayList().size();i++) {
						tradeable.addNewCard(card3.getTopCard());
					}
					for(int i=0;i<player2.getHandCardNum();i++) {
						tradeable.addNewCard(player2.getHandCard().get(i));
					}

					turn3.setVisible(false);
					player2.turn4();
					break;
				case 5:
					turn5();
					tradeable.empty();
					turn4.setVisible(false);
					if(player2.turn5()) {
						checkEnd();
					}
					
					int num=card1.getArrayList().size();
					for(int i=0;i<num;i++) {
						tempdiscardpile.addNewCard(card1.getTopCard());
					}
					
					num=card2.getArrayList().size();
					for(int i=0;i<num;i++) {
						tempdiscardpile.addNewCard(card2.getTopCard());
					}
					
					num=card3.getArrayList().size();
					for(int i=0;i<num;i++) {
						tempdiscardpile.addNewCard(card3.getTopCard());
					}
					
					card1.empty();
					card2.empty();
					card3.empty();
				}
			}
		}
	}

	/**
	 * This method is called when game ended pre-none post-The game ended
	 */
	public int endGame() {
		if (getGoldCoinHandCard()[0] > getGoldCoinHandCard()[1]) {
			// Player 1 wins
			return 1;
		} else if (getGoldCoinHandCard()[1] > getGoldCoinHandCard()[0]) {
			// Player 2 wins
			return 2;
		} else {
			// Two player has equal number of cards
			if (getGoldCoinHandCard()[2] > getGoldCoinHandCard()[3]) {
				// Player 1 wins
				return 1;
			} else if (getGoldCoinHandCard()[3] > getGoldCoinHandCard()[2]) {
				// Player 2 wins
				return 2;
			} else {
				// Tie
				return 3;
			}
		}
	}

	/**
	 * This method checks if there are still cards in discard pile pre-none post-If
	 * game should continue true is returned
	 */
	public boolean continueGame() {
		if (drawpile.getArrayList().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method switches player pre-none post-The player's turn is switched
	 */
	public void switchPlayer() {
		if (side) {
			side = false;
		} else {
			side = true;
		}
	}

	/**
	 * This method returns how many gold coins and hand card each player has
	 * pre-none post-The gold coin and hand card number is returned.
	 */
	public int[] getGoldCoinHandCard() {
		int[] goldCoins = { player1.getGoldCoinNum(), player2.getGoldCoinNum(), player1.getHandCardNum(),
				player2.getHandCardNum() };

		return goldCoins;
	}

	// set buttons
	private void p1ButtonSetup() {
		// 'view hand' and gold stack buttons
		p1cardHand.addActionListener(this);
		p1cardHand.setFocusPainted(false);
		p1cardHand.setBounds(120, 195, 170, 260);
		p1cardHand
		.setIcon(new ImageIcon(new ImageIcon("images/cardHand.png").getImage().getScaledInstance(170, 260, 0)));
		add(p1cardHand);

		p1goldStack.addActionListener(this);
		p1goldStack.setFocusPainted(false);
		p1goldStack.setBounds(450, 195, 170, 260);
		p1goldStack.setIcon(
				new ImageIcon(new ImageIcon("images/Coin.png").getImage().getScaledInstance(170, 260, 0)));
		add(p1goldStack);

		coin1.setBounds(630, 130, 100, 100);
		Font f=new Font("Helvetica", Font.PLAIN+Font.BOLD, 50);
		coin1.setForeground(Color.WHITE);
		coin1.setFont(f);
		add(coin1);

		show.setBounds(0, 0, 300, 100);
		show.setForeground(Color.WHITE);
		show.setFont(f);
		add(show);

		field1Num1.setBounds(250, 600, 300, 100);
		field1Num1.setForeground(Color.WHITE);
		field1Num1.setFont(f);
		add(field1Num1);

		field2Num1.setBounds(460, 600, 300, 100);
		field2Num1.setForeground(Color.WHITE);
		field2Num1.setFont(f);
		add(field2Num1);

		field3Num1.setBounds(670, 600, 300, 100);
		field3Num1.setForeground(Color.WHITE);
		field3Num1.setFont(f);
		add(field3Num1);

		field11.setBounds(70, 650, 180, 240);
		add(field11);

		field21.setBounds(280, 650, 180, 240);
		add(field21);

		field31.setBounds(490, 650, 180, 240);
		add(field31);

		// planting field buttons
		p1Field1.addActionListener(this);
		p1Field1.setFocusPainted(false);
		p1Field1.setBounds(90, 545, 155, 90);
		p1Field1.setIcon(new ImageIcon(new ImageIcon("images/1.png").getImage().getScaledInstance(155, 90, 0)));
		add(p1Field1);

		p1Field2.addActionListener(this);
		p1Field2.setFocusPainted(false);
		p1Field2.setBounds(300, 545, 155, 90);
		p1Field2.setIcon(new ImageIcon(new ImageIcon("images/2.png").getImage().getScaledInstance(155, 90, 0)));
		add(p1Field2);

		p1Field3.addActionListener(this);
		p1Field3.setFocusPainted(false);
		p1Field3.setBounds(505, 545, 155, 90);
		p1Field3.setIcon(new ImageIcon(new ImageIcon("images/3.png").getImage().getScaledInstance(155, 90, 0)));
		add(p1Field3);

		p1BuyField.addActionListener(this);
		p1BuyField.setFocusPainted(false);
		p1BuyField.setBounds(507, 697, 150, 150);
		p1BuyField
		.setIcon(new ImageIcon(new ImageIcon("images/buyField.png").getImage().getScaledInstance(150, 150, 0)));
		add(p1BuyField);

		p1cardHand.setContentAreaFilled(false);
		p1goldStack.setContentAreaFilled(false);
		tradeButton.setContentAreaFilled(false);
		p1Field1.setContentAreaFilled(false);

	}

	private void middleButtonSetup() {
		// trade button set up
		tradeButton.addActionListener(this);
		tradeButton.setFocusPainted(false);
		tradeButton.setBounds(760, 870, 400, 140);
		tradeButton.setIcon(new ImageIcon(new ImageIcon("images/trade.png").getImage().getScaledInstance(400, 140, 0)));
		tradeButton.setVisible(false);
		add(tradeButton);

		// nextTurn set up
		nextTurn.addActionListener(this);
		nextTurn.setFocusPainted(false);
		nextTurn.setBounds(760, 430, 400, 100);
		nextTurn.setIcon(new ImageIcon(new ImageIcon("images/nextStep.png").getImage().getScaledInstance(400, 100, 0)));
		add(nextTurn);

		Font f=new Font("Helvetica", Font.BOLD+Font.ITALIC, 50);
		turnLabel.setBounds(790, 0, 400, 100);
		turnLabel.setFont(f);
		turnLabel.setForeground(Color.WHITE);
		add(turnLabel);
		
		draw.setBounds(875, 540, 170, 260);
		draw.setIcon(
				new ImageIcon(new ImageIcon("images/Coin.png").getImage().getScaledInstance(170, 260, 0)));
		add(draw);
		
		discard.setBounds(875, 100, 170, 260);
		add(discard);
	}

	private void p2ButtonSetup() {
		// view a.i.'s hand button
		p2cardHand.addActionListener(this);
		p2cardHand.setFocusPainted(false);
		p2cardHand.setBounds(1340, 195, 170, 260);
		p2cardHand
		.setIcon(new ImageIcon(new ImageIcon("images/cardHand.png").getImage().getScaledInstance(170, 260, 0)));
		add(p2cardHand);

		// a.i. gold stack button
		p2goldStack.addActionListener(this);
		p2goldStack.setFocusPainted(false);
		p2goldStack.setBounds(1610, 195, 170, 260);
		p2goldStack.setIcon(
				new ImageIcon(new ImageIcon("images/Coin.png").getImage().getScaledInstance(170, 260, 0)));
		add(p2goldStack);

		coin2.setBounds(1790, 130, 100, 100);
		Font f=new Font("Helvetica", Font.PLAIN+Font.BOLD, 50);
		coin2.setForeground(Color.WHITE);
		coin2.setFont(f);
		add(coin2);

		field1Num2.setBounds(1410, 600, 300, 100);
		field1Num2.setForeground(Color.WHITE);
		field1Num2.setFont(f);
		add(field1Num2);

		field2Num2.setBounds(1630, 600, 300, 100);
		field2Num2.setForeground(Color.WHITE);
		field2Num2.setFont(f);
		add(field2Num2);

		field3Num2.setBounds(1840, 600, 300, 100);
		field3Num2.setForeground(Color.WHITE);
		field3Num2.setFont(f);
		add(field3Num2);

		field12.setBounds(1220, 650, 180, 240);
		add(field12);

		field22.setBounds(1430, 650, 180, 240);
		add(field22);

		field32.setBounds(1640, 650, 180, 240);
		add(field32);

		// planting field buttons
		if(choose) {
			
		}else {
			p2Field1.addActionListener(this);
			p2Field1.setFocusPainted(false);
			p2Field1.setBounds(1255, 545, 155, 90);
			p2Field1.setIcon(new ImageIcon(new ImageIcon("images/1.png").getImage().getScaledInstance(155, 90, 0)));
			add(p2Field1);

			p2Field2.addActionListener(this);
			p2Field2.setFocusPainted(false);
			p2Field2.setBounds(1470, 545, 155, 90);
			p2Field2.setIcon(new ImageIcon(new ImageIcon("images/2.png").getImage().getScaledInstance(155, 90, 0)));
			add(p2Field2);

			p2Field3.addActionListener(this);
			p2Field3.setFocusPainted(false);
			p2Field3.setBounds(1675, 545, 155, 90);
			p2Field3.setIcon(new ImageIcon(new ImageIcon("images/3.png").getImage().getScaledInstance(155, 90, 0)));
			add(p2Field3);

			p2BuyField.addActionListener(this);
			p2BuyField.setFocusPainted(false);
			p2BuyField.setBounds(1678, 697, 150, 150);
			p2BuyField
			.setIcon(new ImageIcon(new ImageIcon("images/buyField.png").getImage().getScaledInstance(150, 150, 0)));
			add(p2BuyField);
		}

		p2cardHand.setContentAreaFilled(false);
		p2goldStack.setContentAreaFilled(false);
		tradeButton.setContentAreaFilled(false);
		p2Field1.setContentAreaFilled(false);
	}

	/**
	 * This method display to user that their purchase was invalid
	 * pre-none
	 * post-Invalid screen is displayed to user
	 */
private void notificationSetUp() {
		
		// Player hand frame attributes 
		notification.setSize(1100, 400);
		notification.setResizable(false);
		notification.setLocationRelativeTo(this);
		notification.setTitle("Invalid Move");
		
		// Panel setup
		notificationPanel.setBounds(0,0,1100,400);
		notificationPanel.setLayout(null); 
		notificationPanel.setOpaque(false); 
		
		// Close panel button
		okButton.addActionListener(this);
		okButton.setFocusPainted(false);
		okButton.setVisible(true);
		okButton.setBounds(500, 290, 90, 60);
		okButton.setIcon(
				new ImageIcon(new ImageIcon("images/confirm.png").getImage().getScaledInstance(90, 60, 0)));
		
		notificationPanel.add(okButton);

	}

	private void notification(int i) {
		switch(i) {
		case 1:
			notification.setContentPane(new JLabel(new ImageIcon("images/sorryField.png")));
			break;
		case 2:
			//This tells player 1 that they need to harvest before planting
			notification.setContentPane(new JLabel(new ImageIcon("images/p1Harvest.png")));
			break;
		case 3:
			//This tells user that the field is empty
			notification.setContentPane(new JLabel(new ImageIcon("images/fieldEmpty.png")));
			break;
		case 4:
			//This tells player 2 need to harvest first
			notification.setContentPane(new JLabel(new ImageIcon("images/p2Harvest.png")));
			break;
		case 5:
			//This tells user that they can't harvest
			notification.setContentPane(new JLabel(new ImageIcon("images/cantHarvest.png")));
			break;
		case 6:
			//This tells user that AI bought a field
			notification.setContentPane(new JLabel(new ImageIcon("images/aiField.png")));
			break;
		case 7:
			//This tells user that they need to buy third field in order to harvest
			notification.setContentPane(new JLabel(new ImageIcon("images/needToBuy.png")));
			break;
		case 8:
			if(side) {
				//This tells user that AI accepted the trade
				notification.setContentPane(new JLabel(new ImageIcon("images/aiAccept.png")));
				break;
			}else {
				break;
			}
		case 9:
			if(side) {
				//This tells user that AI declined the trade
				notification.setContentPane(new JLabel(new ImageIcon("images/aiRefuse.png")));
				break;
			}else {
				break;
			}
		}
		notification.add(notificationPanel);
		notification.setVisible(true);
	}

	private void handFrameSetup() {
		// Player hand frame attributes 
		playerHandFrame.setSize(1100, 400);
		playerHandFrame.setResizable(false);
		playerHandFrame.setLocationRelativeTo(this);
		playerHandFrame.setTitle("Hand");
		playerHandFrame.setLayout(null); // turn off the layout manager
		playerHandFrame.setUndecorated(true);
		playerHandFrame.setContentPane(new JLabel(new ImageIcon("images/fieldBackground.jpg")));
		playerHandFrame.setVisible(false);

		// Player hand option panel attributes
		playerHandPanel.setBounds(0,0,1100,400);
		playerHandPanel.setLayout(null);
		playerHandPanel.setOpaque(false);

		// Hand viewing button setup
		handExit.addActionListener(this);
		handExit.setFocusPainted(false);
		handExit.setBounds(520, 300, 70, 50);
		handExit.setBackground(Color.RED);
		handExit.setIcon(
				new ImageIcon(new ImageIcon("images/exitRed.png").getImage().getScaledInstance(70, 50, 0)));
		playerHandPanel.add(handExit);

		// Hand viewing button setup
		handLeftHand.addActionListener(this);
		handLeftHand.setFocusPainted(false);
		handLeftHand.setBounds(400, 355, 80, 40);
		handLeftHand.setBackground(Color.white);
		handLeftHand.setIcon(
				new ImageIcon(new ImageIcon("images/arrowLeft.png").getImage().getScaledInstance(80, 40, 0)));
		handLeftHand.setVisible(false);
		playerHandPanel.add(handLeftHand);

		// Hand viewing button setup
		handRightHand.addActionListener(this);
		handRightHand.setFocusPainted(false);
		handRightHand.setBounds(610, 355, 80, 40);
		handRightHand.setBackground(Color.white);
		handRightHand.setIcon(
				new ImageIcon(new ImageIcon("images/arrowRight.png").getImage().getScaledInstance(80, 40, 0)));
		handRightHand.setVisible(false);
		playerHandPanel.add(handRightHand);
		playerHandFrame.add(playerHandPanel);
		
		card1Hand.setBounds(40, 50, 180, 240);
		playerHandPanel.add(card1Hand);

		card2Hand.setBounds(250, 50, 180, 240);
		playerHandPanel.add(card2Hand);

		card3Hand.setBounds(460, 50, 180, 240);
		playerHandPanel.add(card3Hand);

		card4Hand.setBounds(670, 50, 180, 240);
		playerHandPanel.add(card4Hand);

		card5Hand.setBounds(880, 50, 180, 240);
		playerHandPanel.add(card5Hand);
	}

	/**
	 * This method opens a new window for user to view their hand card, player 1 hand card
	 * pre-none
	 * post-The hand cards are view.
	 */
	private void viewHand1() {
		playerHandFrame.setVisible(true);

		// This stores the number of hand cards, so it is easier to display the window
		// for
		// Hand card
		int num = player1.getHandCardNum();
		int numPage=num/5+1;

		if(num%5==0) {
			numPage--;
		}

		//If user is not at left most page, then the right button appear
		if(indexHand >= 5)
			handLeftHand.setVisible(true);

		//If user reaches the left most page, then the left button disappear
		if(indexHand==0) {
			handLeftHand.setVisible(false);
		}

		if(num>5&&(indexHand/5)!=numPage) {
			handRightHand.setVisible(true);
		}

		//Indicates user reached the right most page
		if(indexHand==(numPage-1)*5) {
			handRightHand.setVisible(false);
		}

		try {
			card1Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(0+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card1Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card2Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(1+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card2Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card3Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(2+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card3Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card4Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(3+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card4Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card5Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(4+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card5Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}
	}

	/**
	 * This method opens a new window for user to view their hand card, player 1 hand card
	 * pre-none
	 * post-The hand cards are view.
	 */
	private void viewHand2() {
		playerHandFrame.setVisible(true);

		// This stores the number of hand cards, so it is easier to display the window
		// for
		// Hand card
		int num = player2.getHandCardNum();
		int numPage=num/5+1;

		if(num%5==0) {
			numPage--;
		}

		//If user is not at left most page, then the right button appear
		if(indexHand >= 5)
			handLeftHand.setVisible(true);

		//If user reaches the left most page, then the left button disappear
		if(indexHand==0) {
			handLeftHand.setVisible(false);
		}

		if(num>5&&(indexHand/5)!=numPage) {
			handRightHand.setVisible(true);
		}

		//Indicates user reached the right most page
		if(indexHand==(numPage-1)*5) {
			handRightHand.setVisible(false);
		}

		try {
			card1Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(0+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card1Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card2Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(1+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card2Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card3Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(2+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card3Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card4Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(3+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card4Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card5Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(4+indexHand).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch(Exception e) {
			card5Hand.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}
	}

	private void discardFrameSetup() {
		// Player hand frame attributes 
		turn1.setSize(1100, 440);
		turn1.setResizable(false);
		turn1.setLocation(420,120);
		turn1.setTitle("Plant Leftover Cards");
		turn1.setLayout(null); // turn off the layout manager
		turn1.setContentPane(new JLabel(new ImageIcon("images/fieldBackground.jpg")));
		turn1.setVisible(false);

		// Player hand option panel attributes
		discardPanel.setBounds(0,0,1100,400);
		discardPanel.setLayout(null);
		discardPanel.setOpaque(false);
		
		Font f=new Font("Helvetica", Font.BOLD+Font.ITALIC, 30);
		discardLabel.setBounds(460, 0, 300, 50);
		discardLabel.setForeground(Color.WHITE);
		discardLabel.setFont(f);
		discardLabel.setText("Leftover Cards");
		discardPanel.add(discardLabel);
		
		// Hand viewing button setup
		discardExit.addActionListener(this);
		discardExit.setFocusPainted(false);
		discardExit.setBounds(510, 355, 80, 40);
		discardExit.setBackground(Color.RED);
		discardExit.setIcon(
				new ImageIcon(new ImageIcon("images/exitRed.png").getImage().getScaledInstance(80, 40, 0)));
		discardPanel.add(discardExit);

		// Hand viewing button setup
		handLeftDiscard.addActionListener(this);
		handLeftDiscard.setFocusPainted(false);
		handLeftDiscard.setBounds(400, 355, 80, 40);
		handLeftDiscard.setBackground(Color.white);
		handLeftDiscard.setIcon(
				new ImageIcon(new ImageIcon("images/arrowLeft.png").getImage().getScaledInstance(80, 40, 0)));
		handLeftDiscard.setVisible(false);
		discardPanel.add(handLeftDiscard);

		// Hand viewing button setup
		handRightDiscard.addActionListener(this);
		handRightDiscard.setFocusPainted(false);
		handRightDiscard.setBounds(610, 355, 80, 40);
		handRightDiscard.setBackground(Color.white);
		handRightDiscard.setIcon(
				new ImageIcon(new ImageIcon("images/arrowRight.png").getImage().getScaledInstance(80, 40, 0)));
		handRightDiscard.setVisible(false);
		handRightDiscard.setVisible(false);
		discardPanel.add(handRightDiscard);

		// planting buttons for each card
		button1Turn1.addActionListener(this);
		button1Turn1.setFocusPainted(false);
		button1Turn1.setBounds(90, 300, 80, 50);
		button1Turn1.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button1Turn1.setVisible(true);
		discardPanel.add(button1Turn1);

		button2Turn1.addActionListener(this);
		button2Turn1.setFocusPainted(false);
		button2Turn1.setBounds(300, 300, 80, 50);
		button2Turn1.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button2Turn1.setVisible(true);
		discardPanel.add(button2Turn1);

		button3Turn1.addActionListener(this);
		button3Turn1.setFocusPainted(false);
		button3Turn1.setBounds(510, 300, 80, 50);
		button3Turn1.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button3Turn1.setVisible(true);
		discardPanel.add(button3Turn1);

		button4Turn1.addActionListener(this);
		button4Turn1.setFocusPainted(false);
		button4Turn1.setBounds(720, 300, 80, 50);
		button4Turn1.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button4Turn1.setVisible(true);
		discardPanel.add(button4Turn1);

		button5Turn1.addActionListener(this);
		button5Turn1.setFocusPainted(false);
		button5Turn1.setBounds(930, 300, 80, 50);
		button5Turn1.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button5Turn1.setVisible(true);
		discardPanel.add(button5Turn1);

		// labels of each card in the player's deck
		card1Turn1.setBounds(40, 50, 180, 240);
		discardPanel.add(card1Turn1);

		card2Turn1.setBounds(250, 50, 180, 240);
		discardPanel.add(card2Turn1);

		card3Turn1.setBounds(460, 50, 180, 240);
		discardPanel.add(card3Turn1);

		card4Turn1.setBounds(670, 50, 180, 240);
		discardPanel.add(card4Turn1);

		card5Turn1.setBounds(880, 50, 180, 240);
		discardPanel.add(card5Turn1);

		turn1.add(discardPanel);
	}

	private void plantFrameSetup() {
		// Player hand frame attributes 
		turn2.setSize(1100, 440);
		turn2.setResizable(false);
		turn2.setLocation(420,120);
		turn2.setTitle("Plant Cards From Your Hand");
		turn2.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		turn2.setLayout(null); // turn off the layout manager
		turn2.setContentPane(new JLabel(new ImageIcon("images/fieldBackground.jpg")));
		turn2.setVisible(false);

		// Player hand option panel attributes
		plantPanel.setBounds(0,0,1100,400);
		plantPanel.setLayout(null);
		plantPanel.setOpaque(false);
		
		Font f=new Font("Helvetica", Font.BOLD+Font.ITALIC, 30);
		turn2Label.setBounds(470, 0, 300, 50);
		turn2Label.setForeground(Color.WHITE);
		turn2Label.setFont(f);
		turn2Label.setText("Your Hand");
		plantPanel.add(turn2Label);

		// Hand viewing button setup
		plantLeft.addActionListener(this);
		plantLeft.setFocusPainted(false);
		plantLeft.setBounds(400, 355, 80, 40);
		plantLeft.setBackground(Color.white);
		plantLeft.setIcon(
				new ImageIcon(new ImageIcon("images/arrowLeft.png").getImage().getScaledInstance(80, 40, 0)));
		handLeftDiscard.setVisible(false);
		plantLeft.setVisible(false);
		plantPanel.add(plantLeft);

		// Hand viewing button setup
		plantRight.addActionListener(this);
		plantRight.setFocusPainted(false);
		plantRight.setBounds(610, 355, 80, 40);
		plantRight.setBackground(Color.white);
		plantRight.setIcon(
				new ImageIcon(new ImageIcon("images/arrowRight.png").getImage().getScaledInstance(80, 40, 0)));
		plantRight.setVisible(false);
		plantPanel.add(plantRight);

		// planting buttons for each card
		button1Turn2Plant.addActionListener(this);
		button1Turn2Plant.setFocusPainted(false);
		button1Turn2Plant.setBounds(90, 350, 80, 50);
		button1Turn2Plant.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button1Turn2Plant.setVisible(true);
		plantPanel.add(button1Turn2Plant);

		button1Turn2.addActionListener(this);
		button1Turn2.setFocusPainted(false);
		button1Turn2.setBounds(90, 300, 80, 50);
		button1Turn2.setIcon(
				new ImageIcon(new ImageIcon("images/discard.png").getImage().getScaledInstance(80, 50, 0)));
		button1Turn2.setVisible(true);
		plantPanel.add(button1Turn2);

		button2Turn2.addActionListener(this);
		button2Turn2.setFocusPainted(false);
		button2Turn2.setBounds(300, 300, 80, 50);
		button2Turn2.setIcon(
				new ImageIcon(new ImageIcon("images/discard.png").getImage().getScaledInstance(80, 50, 0)));
		button2Turn2.setVisible(true);
		plantPanel.add(button2Turn2);

		button3Turn2.addActionListener(this);
		button3Turn2.setFocusPainted(false);
		button3Turn2.setBounds(510, 300, 80, 50);
		button3Turn2.setIcon(
				new ImageIcon(new ImageIcon("images/discard.png").getImage().getScaledInstance(80, 50, 0)));
		button3Turn2.setVisible(true);
		plantPanel.add(button3Turn2);

		button4Turn2.addActionListener(this);
		button4Turn2.setFocusPainted(false);
		button4Turn2.setBounds(720, 300, 80, 50);
		button4Turn2.setIcon(
				new ImageIcon(new ImageIcon("images/discard.png").getImage().getScaledInstance(80, 50, 0)));
		button4Turn2.setVisible(true);
		plantPanel.add(button4Turn2);

		button5Turn2.addActionListener(this);
		button5Turn2.setFocusPainted(false);
		button5Turn2.setBounds(930, 300, 80, 50);
		button5Turn2.setIcon(
				new ImageIcon(new ImageIcon("images/discard.png").getImage().getScaledInstance(80, 50, 0)));
		button5Turn2.setVisible(true);
		plantPanel.add(button5Turn2);
		
		// planting buttons for each card
		turn2Exit.addActionListener(this);
		turn2Exit.setFocusPainted(false);
		turn2Exit.setBounds(510, 350, 80, 50);
		turn2Exit.setIcon(
				new ImageIcon(new ImageIcon("images/exitRed.png").getImage().getScaledInstance(80, 50, 0)));
		turn2Exit.setVisible(false);
		plantPanel.add(turn2Exit);

		// labels of each card in the player's deck
		card1Turn2.setBounds(40, 50, 180, 240);
		plantPanel.add(card1Turn2);

		card2Turn2.setBounds(250, 50, 180, 240);
		plantPanel.add(card2Turn2);

		card3Turn2.setBounds(460, 50, 180, 240);
		plantPanel.add(card3Turn2);

		card4Turn2.setBounds(670, 50, 180, 240);
		plantPanel.add(card4Turn2);

		card5Turn2.setBounds(880, 50, 180, 240);
		plantPanel.add(card5Turn2);

		turn2.add(plantPanel);
	}

	/**
	 * This method sets up the draw frame
	 * pre-none
	 * post-The draw frame is set
	 */
	private void drawFrameSetup() {
		// Player hand frame attributes 
		turn3.setSize(1100, 440);
		turn3.setResizable(false);
		turn3.setLocation(420,120);
		turn3.setTitle("Plant Drawn Cards");
		turn3.setLayout(null); // turn off the layout manager
		turn3.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		turn3.setContentPane(new JLabel(new ImageIcon("images/fieldBackground.jpg")));
		turn3.setVisible(false);

		// Player hand option panel attributes
		drawPanel.setBounds(0,0,1100,400);
		drawPanel.setLayout(null);
		drawPanel.setOpaque(false);
	
		Font f =new Font("Helvetica", Font.BOLD+Font.ITALIC, 30);
		turn3Label.setBounds(405, 0, 300, 50);
		turn3Label.setForeground(Color.WHITE);
		turn3Label.setFont(f);
		turn3Label.setText("Your Drawn Cards");
		drawPanel.add(turn3Label);
		
		turn3Exit.addActionListener(this);
		turn3Exit.setFocusPainted(false);
		turn3Exit.setBounds(500, 350, 80, 50);
		turn3Exit.setIcon(
				new ImageIcon(new ImageIcon("images/exitRed.png").getImage().getScaledInstance(80, 50, 0)));
		turn2Exit.setVisible(false);
		drawPanel.add(turn3Exit);

		// planting buttons for each card
		button1Turn3.addActionListener(this);
		button1Turn3.setFocusPainted(false);
		button1Turn3.setBounds(195, 300, 80, 50);
		button1Turn3.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button1Turn3.setVisible(true);
		drawPanel.add(button1Turn3);

		button2Turn3.addActionListener(this);
		button2Turn3.setFocusPainted(false);
		button2Turn3.setBounds(500, 300, 80, 50);
		button2Turn3.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button2Turn3.setVisible(true);
		drawPanel.add(button2Turn3);

		button3Turn3.addActionListener(this);
		button3Turn3.setFocusPainted(false);
		button3Turn3.setBounds(785, 300, 80, 50);
		button3Turn3.setIcon(
				new ImageIcon(new ImageIcon("images/plant.png").getImage().getScaledInstance(80, 50, 0)));
		button3Turn3.setVisible(true);
		drawPanel.add(button3Turn3);

		card1Label3.setBounds(345, 0, 300, 100);
		card1Label3.setForeground(Color.WHITE);
		card1Label3.setFont(f);
		turn3.add(card1Label3);

		card2Label3.setBounds(650, 0, 300, 100);
		card2Label3.setForeground(Color.WHITE);
		card2Label3.setFont(f);
		turn3.add(card2Label3);

		card3Label3.setBounds(915, 0, 300, 100);
		card3Label3.setForeground(Color.WHITE);
		card3Label3.setFont(f);
		turn3.add(card3Label3);

		// labels of each card in the player's deck
		card1Turn3.setBounds(145, 50, 180, 240);
		drawPanel.add(card1Turn3);

		card2Turn3.setBounds(450, 50, 180, 240);
		drawPanel.add(card2Turn3);

		card3Turn3.setBounds(735, 50, 180, 240);
		drawPanel.add(card3Turn3);

		turn3.add(drawPanel);
	}

	/**
	 * This method sets up the draw frame
	 * pre-none
	 * post-The draw frame is set
	 */
	private void tradeFrameSetup() {
		// Player hand frame attributes 
		turn4.setSize(1100, 440);
		turn4.setResizable(false);
		turn4.setLocation(420,120);
		turn4.setTitle("Trade");
		turn4.setLayout(null); // turn off the layout manager
		turn4.setContentPane(new JLabel(new ImageIcon("images/fieldBackground.jpg")));
		turn4.setVisible(false);

		// Player hand option panel attributes
		tradePanel.setBounds(0,0,1100,400);
		tradePanel.setLayout(null);
		tradePanel.setOpaque(false);
		
		Font f=new Font("Helvetica", Font.BOLD+Font.ITALIC, 30);
		notice.setBounds(480, 0, 300, 50);
		notice.setForeground(Color.WHITE);
		notice.setFont(f);
		turn4.add(notice);
		
		tradeNextStep.addActionListener(this);
		tradeNextStep.setFocusPainted(false);
		tradeNextStep.setBounds(500, 355, 100, 40);
		tradeNextStep.setBackground(Color.RED);
		tradeNextStep.setIcon(
				new ImageIcon(new ImageIcon("images/confirm.png").getImage().getScaledInstance(100, 40, 0)));
		tradePanel.add(tradeNextStep);

		// Hand viewing button setup
		handLeftTrade.addActionListener(this);
		handLeftTrade.setFocusPainted(false);
		handLeftTrade.setBounds(400, 355, 80, 40);
		handLeftTrade.setBackground(Color.white);
		handLeftTrade.setIcon(
				new ImageIcon(new ImageIcon("images/arrowLeft.png").getImage().getScaledInstance(80, 40, 0)));
		handLeftTrade.setVisible(false);
		tradePanel.add(handLeftTrade);

		// Hand viewing button setup
		handRightTrade.addActionListener(this);
		handRightTrade.setFocusPainted(false);
		handRightTrade.setBounds(610, 355, 80, 40);
		handRightTrade.setBackground(Color.white);
		handRightTrade.setIcon(
				new ImageIcon(new ImageIcon("images/arrowRight.png").getImage().getScaledInstance(80, 40, 0)));
		handRightTrade.setVisible(false);
		tradePanel.add(handRightTrade);
		
		yes.addActionListener(this);
		yes.setFocusPainted(false);
		yes.setBounds(250, 70, 180, 240);
		yes.setIcon(
				new ImageIcon(new ImageIcon("images/yes.png").getImage().getScaledInstance(180, 240, 0)));
		yes.setVisible(false);
		tradePanel.add(yes);
		
		no.addActionListener(this);
		no.setFocusPainted(false);
		no.setBounds(670, 70, 180, 240);
		no.setIcon(
				new ImageIcon(new ImageIcon("images/no.png").getImage().getScaledInstance(180, 240, 0)));
		no.setVisible(false);
		tradePanel.add(no);

		// planting buttons for each card
		button1Turn4.addActionListener(this);
		button1Turn4.setFocusPainted(false);
		button1Turn4.setBounds(90, 300, 80, 50);
		button1Turn4.setIcon(
				new ImageIcon(new ImageIcon("images/tradeCard.png").getImage().getScaledInstance(80, 50, 0)));
		button1Turn4.setVisible(true);
		tradePanel.add(button1Turn4);

		button2Turn4.addActionListener(this);
		button2Turn4.setFocusPainted(false);
		button2Turn4.setBounds(300, 300, 80, 50);
		button2Turn4.setIcon(
				new ImageIcon(new ImageIcon("images/tradeCard.png").getImage().getScaledInstance(80, 50, 0)));
		button2Turn4.setVisible(true);
		tradePanel.add(button2Turn4);

		button3Turn4.addActionListener(this);
		button3Turn4.setFocusPainted(false);
		button3Turn4.setBounds(510, 300, 80, 50);
		button3Turn4.setIcon(
				new ImageIcon(new ImageIcon("images/tradeCard.png").getImage().getScaledInstance(80, 50, 0)));
		button3Turn4.setVisible(true);
		tradePanel.add(button3Turn4);

		button4Turn4.addActionListener(this);
		button4Turn4.setFocusPainted(false);
		button4Turn4.setBounds(720, 300, 80, 50);
		button4Turn4.setIcon(
				new ImageIcon(new ImageIcon("images/tradeCard.png").getImage().getScaledInstance(80, 50, 0)));
		button4Turn4.setVisible(true);
		tradePanel.add(button4Turn4);

		button5Turn4.addActionListener(this);
		button5Turn4.setFocusPainted(false);
		button5Turn4.setBounds(930, 300, 80, 50);
		button5Turn4.setIcon(
				new ImageIcon(new ImageIcon("images/tradeCard.png").getImage().getScaledInstance(80, 50, 0)));
		button5Turn4.setVisible(true);
		tradePanel.add(button5Turn4);

		// labels of each card in the player's deck
		card1Turn4.setBounds(40, 50, 180, 240);
		tradePanel.add(card1Turn4);

		card2Turn4.setBounds(250, 50, 180, 240);
		tradePanel.add(card2Turn4);

		card3Turn4.setBounds(460, 50, 180, 240);
		tradePanel.add(card3Turn4);

		card4Turn4.setBounds(670, 50, 180, 240);
		tradePanel.add(card4Turn4);

		card5Turn4.setBounds(880, 50, 180, 240);
		tradePanel.add(card5Turn4);

		turn4.add(tradePanel);
	}



	/**
	 * This method opens a new window for user to view their hand card, player 1 hand card
	 * pre-none
	 * post-The hand cards are view.
	 */
	private void turn1() {
		turn1.setVisible(true);

		// This stores the number of hand cards, so it is easier to display the window
		// for
		// Hand card
		int num = tempdiscardpile.getArrayList().size();
		int numPage=num/5+1;

		if(num%5==0) {
			numPage--;
		}

		//If user is not at left most page, then the right button appear
		if(indexDiscard >= 5)
			handLeftDiscard.setVisible(true);

		//If user reaches the left most page, then the left button disappear
		if(indexDiscard==0) {
			handLeftDiscard.setVisible(false);
		}

		if(num>5) {
			handRightDiscard.setVisible(true);
		}

		//Indicates user reached the right most page
		if(indexDiscard==(numPage-1)*5||num<5) {
			handRightDiscard.setVisible(false);
		}

		try {
			card1Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/"+tempdiscardpile.getArrayList().get(0+indexDiscard).getCardName()+".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button1Turn1.setVisible(true);
		}catch(Exception e) {
			button1Turn1.setVisible(false);
			card1Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
			if(indexDiscard!=0) {
				indexDiscard-=5;
				turn1();
			}
		}

		try {
			card2Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" + tempdiscardpile.getArrayList().get(1+indexDiscard).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button2Turn1.setVisible(true);
		}catch(Exception e) {
			button2Turn1.setVisible(false);
			card2Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card3Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" + tempdiscardpile.getArrayList().get(2+indexDiscard).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button3Turn1.setVisible(true);
		}catch(Exception e) {
			button3Turn1.setVisible(false);
			card3Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card4Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" + tempdiscardpile.getArrayList().get(3+indexDiscard).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button4Turn1.setVisible(true);
		}catch(Exception e) {
			button4Turn1.setVisible(false);
			card4Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		try {
			card5Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" + tempdiscardpile.getArrayList().get(4+indexDiscard).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button5Turn1.setVisible(true);
		}catch(Exception e) {
			button5Turn1.setVisible(false);
			card5Turn1.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}
	}

	/**
	 * This method is the second step
	 * pre-none
	 * post-The hand cards are view.
	 */
	private void turn2() {
		turn2.setVisible(true);

		// This stores the number of hand cards, so it is easier to display the window
		// for
		// Hand card
		int num;
		if(side) {
			num=player1.getHandCard().size();
		}else {
			num=player2.getHandCard().size();
		}

		int numPage=num/5+1;

		if(num%5==0) {
			numPage--;
		}

		//If user is not at left most page, then the right button appear
		if(indexDraw >= 5)
			plantLeft.setVisible(true);

		//If user reaches the left most page, then the left button disappear
		if(indexDraw==0) {
			plantLeft.setVisible(false);
		}

		if(indexDraw!=0) {
			button1Turn2Plant.setVisible(false);
		}

		if(indexDraw==0) {
			button1Turn2Plant.setVisible(true);
		}

		if(plantTime==2) {
			button1Turn2Plant.setVisible(false);
		}

		if(discardTime==1) {
			button1Turn2.setVisible(false);
			button2Turn2.setVisible(false);
			button3Turn2.setVisible(false);
			button4Turn2.setVisible(false);
			button5Turn2.setVisible(false);
		}

		if(discardTime==0) {
			button2Turn2.setVisible(true);
			button3Turn2.setVisible(true);
			button4Turn2.setVisible(true);
			button5Turn2.setVisible(true);
		}

		if((indexDraw!=0||plantTime!=0)&&discardTime==0) {
			button1Turn2.setVisible(true);
		}else {
			button1Turn2.setVisible(false);
		}

		if(num>5) {
			plantRight.setVisible(true);
		}

		//Indicates user reached the right most page
		if(indexDraw==(numPage-1)*5||num<5) {
			plantRight.setVisible(false);
		}

		if(side) {
			try {
				card1Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/"+player1.getHandCard().get(0+indexDraw).getCardName()+".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button1Turn2Plant.setVisible(false);
				card1Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
				if(indexDraw!=0) {
					indexDraw-=5;
					turn2();
				}
			}

			try {
				card2Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(1+indexDraw).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button2Turn2.setVisible(false);
				card2Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card3Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(2+indexDraw).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button3Turn2.setVisible(false);
				card3Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card4Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(3+indexDraw).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button4Turn2.setVisible(false);
				card4Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card5Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" + player1.getHandCard().get(4+indexDraw).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button5Turn2.setVisible(false);
				card5Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}
		}else {
			try {
				card1Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/"+player2.getHandCard().get(0+indexDraw).getCardName()+".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button1Turn2Plant.setVisible(false);
				card1Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card2Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(1+indexDraw).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button2Turn2.setVisible(false);
				card2Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card3Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(2+indexDraw).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button3Turn2.setVisible(false);
				card3Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card4Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(3+indexDraw).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button4Turn2.setVisible(false);
				card4Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card5Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" + player2.getHandCard().get(4+indexDraw).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button5Turn2.setVisible(false);
				card5Turn2.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}
		}
	}

	/**
	 * This method is the second step
	 * pre-none
	 * post-The hand cards are view.
	 */
	private void turn3() {
		boolean take=true;
		boolean flag2=true;
		boolean flag3=true;

		turn3.setVisible(true);

		try {
			card1.addNewCard(drawpile.draw());
			card2.addNewCard(drawpile.draw());
			
			while(flag2) {
				if(card2.getArrayList().get(0).getCardName().equals(card1.getArrayList().get(0).getCardName())){
					//If card two is same card with card one, card pile one adds one
					card1.addNewCard(card2.getArrayList().get(0));
					card2.getArrayList().remove(0);
					try {
						card2.addNewCard(drawpile.draw());
					}catch(Exception e) {
						checkEnd();
					}
				}else {
					flag2=false;
				}
			}

			try {
				card3.addNewCard(drawpile.draw());
			}catch(Exception e) {
				checkEnd();
			}

			while(flag3) {
				if(card3.getArrayList().get(0).getCardName().equals(card2.getArrayList().get(0).getCardName())){
					//If card two is same card with card one, card pile one adds one
					card2.addNewCard(card3.getArrayList().get(0));
					card3.getArrayList().remove(0);
					try {
						card3.addNewCard(drawpile.draw());
					}catch(Exception e) {
						checkEnd();
					}
				}else if(card3.getArrayList().get(0).getCardName().equals(card1.getArrayList().get(0).getCardName())) {
					card1.addNewCard(card3.getArrayList().get(0));
					card3.getArrayList().remove(0);
					try {
						card3.addNewCard(drawpile.draw());
					}catch(Exception e) {
						checkEnd();
					}
				}else {
					flag3=false;
				}
			}

			while(take) {
				String name=" ";
				try {
					name=discardpile.getTopCard().getCardName();
				}catch(Exception e) {
					
				}
				
				if(name.equals(card1.getTopCard().getCardName())) {
					card1.addNewCard(discardpile.draw());
				}else if(name.equals(card2.getTopCard().getCardName())) {
					card2.addNewCard(discardpile.draw());
				}else if(name.equals(card3.getTopCard().getCardName())) {
					card3.addNewCard(discardpile.draw());
				}else {
					take=false;
				}
			}

			card1Label3.setText(Integer.toString(card1.getArrayList().size()));
			card2Label3.setText(Integer.toString(card2.getArrayList().size()));
			card3Label3.setText(Integer.toString(card3.getArrayList().size()));

			try {
				card1Turn3.setIcon(
						new ImageIcon(new ImageIcon("images/"+card1.getArrayList().get(0).getCardName()+".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button1Turn3.setVisible(false);
				card1Turn3.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card2Turn3.setIcon(
						new ImageIcon(new ImageIcon("images/" + card2.getArrayList().get(0).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button2Turn3.setVisible(false);
				card2Turn3.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}

			try {
				card3Turn3.setIcon(
						new ImageIcon(new ImageIcon("images/" + card3.getArrayList().get(0).getCardName() + ".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}catch(Exception e) {
				button3Turn3.setVisible(false);
				card3Turn3.setIcon(
						new ImageIcon(new ImageIcon("images/" +".png")
								.getImage().getScaledInstance(180, 240, 0)));
			}


			button1Turn3.setVisible(true);
			card1Label3.setVisible(true);
			card1Turn3.setVisible(true);
			button2Turn3.setVisible(true);
			card2Label3.setVisible(true);
			card2Turn3.setVisible(true);
			button3Turn3.setVisible(true);
			card3Label3.setVisible(true);
			card3Turn3.setVisible(true);
		}catch(Exception e) {
			turn3.setVisible(false);
			checkEnd();
		}
		
	}

	/**
	 * This method is the second step
	 * pre-none
	 * post-The hand cards are view.
	 */
	private void turn4(ArrayList<Card> pile) {
		turn4.setVisible(true);
		
		int num;
		
		num=pile.size();

		int numPage=num/5+1;

		if(num%5==0) {
			numPage--;
		}

		//If user is not at left most page, then the right button appear
		if(indexTrade >= 5)
			handLeftTrade.setVisible(true);

		//If user reaches the left most page, then the left button disappear
		if(indexTrade==0) {
			handLeftTrade.setVisible(false);
		}

		if(num>5) {
			handRightTrade.setVisible(true);
		}

		//Indicates user reached the right most page
		if(indexTrade==(numPage-1)*5||num<5) {
			handRightTrade.setVisible(false);
		}

		try {
			card1Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/"+pile.get(0+indexTrade).getCardName()+".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button1Turn4.setVisible(true);
			card1Turn4.setVisible(true);
		}catch(Exception e) {
			button1Turn4.setVisible(false);
			card1Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
			card1Turn4.setVisible(false);
			if(indexTrade!=0) {
				indexTrade-=5;
				turn4(pile);
			}
		}

		try {
			card2Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" + pile.get(1+indexTrade).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button2Turn4.setVisible(true);
			card2Turn4.setVisible(true);
		}catch(Exception e) {
			button2Turn4.setVisible(false);
			card2Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
			card2Turn4.setVisible(false);
		}

		try {
			card3Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" + pile.get(2+indexTrade).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button3Turn4.setVisible(true);
			card3Turn4.setVisible(true);
		}catch(Exception e) {
			button3Turn4.setVisible(false);
			card3Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
			card3Turn4.setVisible(false);
		}

		try {
			card4Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" + pile.get(3+indexTrade).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button4Turn4.setVisible(true);
			card4Turn4.setVisible(true);
		}catch(Exception e) {
			button4Turn4.setVisible(false);
			card4Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
			card4Turn4.setVisible(false);
		}

		try {
			card5Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" + pile.get(4+indexTrade).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
			button5Turn4.setVisible(true);
			card5Turn4.setVisible(true);
		}catch(Exception e) {
			button5Turn4.setVisible(false);
			card5Turn4.setIcon(
					new ImageIcon(new ImageIcon("images/" +".png")
							.getImage().getScaledInstance(180, 240, 0)));
			card5Turn4.setVisible(false);
		}
		
		if(tradeStep==3||tradeStep==4) {
			button1Turn4.setVisible(false);
			button2Turn4.setVisible(false);
			button3Turn4.setVisible(false);
			button4Turn4.setVisible(false);
			button5Turn4.setVisible(false);
		}
	}
	
	private void turn5() {
		if(side) {
			for(int i=0;i<2;i++) {
				try {
					player1.addHandCard(drawpile.draw());
				}catch(Exception e) {
					checkEnd();
				}
			}
		}else {
			for(int i=0;i<2;i++) {
				try {
					player2.addHandCard(drawpile.draw());
				}catch(Exception e) {
					checkEnd();
				}
			}
		}
	}

	// set up and display
	private void frameSetup(boolean chooseAI) {

		// frame size and title
		setSize(1920, 1080);
		setLayout(null);
		setResizable(true);
		getContentPane().setBackground(Color.black);

		// panel display
		add(menuPanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		background.setBounds(0, 0, 1920, 1080);
		add(label);

		label.setIcon(backgroundImage);
		label.setBounds(0, 0, 1920, 1080);
		setVisible(true);

		/*
		 * the section below determines if the play selected '1-player'
		 * or '2-player' mode. Depending on which one the player selects,
		 * a different background will be assigned.
		 */

		if (chooseAI == true) {
			label.setIcon(new ImageIcon(
					new ImageIcon("images/gameScreen1P.png").getImage().getScaledInstance(1920, 1080, 0)));
		}else {
			label.setIcon(new ImageIcon(
					new ImageIcon("images/gameScreen2P.png").getImage().getScaledInstance(1920, 1080, 0)));
		}

	}

	/**
	 * This method refresh everything
	 * pre-none
	 * post-Every thing is refreshed
	 */
	private void refresh() {
		//refresh coin number every time
		coin1.setText(Integer.toString(player1.getGoldCoinNum()));
		coin2.setText(Integer.toString(player2.getGoldCoinNum()));
		try {
			//Just in case that the pile is empty
			discard.setIcon(
					new ImageIcon(new ImageIcon("images/"+discardpile.getArrayList().get(discardpile.getArrayList().size()-1).getCardName()+".png").getImage().getScaledInstance(170, 260, 0)));
		}catch(Exception e) {
			discard.setIcon(
					new ImageIcon(new ImageIcon("images/.png").getImage().getScaledInstance(170, 260, 0)));
		}
		show.setText("Step "+Integer.toString(turn));
		if(side)
			turnLabel.setText("Player 1's Turn");
		else
			turnLabel.setText("Player 2's Turn");
		field1Num1.setText(Integer.toString(field1Player1.getArrayList().size()));
		field2Num1.setText(Integer.toString(field2Player1.getArrayList().size()));
		field3Num1.setText(Integer.toString(field3Player1.getArrayList().size()));
		field1Num2.setText(Integer.toString(field1Player2.getArrayList().size()));
		field2Num2.setText(Integer.toString(field2Player2.getArrayList().size()));
		field3Num2.setText(Integer.toString(field3Player2.getArrayList().size()));

		try {
			field11.setIcon(
					new ImageIcon(new ImageIcon("images/" + field1Player1.getArrayList().get(0).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch (Exception e) {
			field11.setIcon(
					new ImageIcon(new ImageIcon("images/" + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}
		try {
			field21.setIcon(
					new ImageIcon(new ImageIcon("images/" + field2Player1.getArrayList().get(0).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch (Exception e) {
			field21.setIcon(
					new ImageIcon(new ImageIcon("images/" + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}
		try {
			field31.setIcon(
					new ImageIcon(new ImageIcon("images/" + field3Player1.getArrayList().get(0).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch (Exception e) {
			field31.setIcon(
					new ImageIcon(new ImageIcon("images/" + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}
		try {
			field12.setIcon(
					new ImageIcon(new ImageIcon("images/" + field1Player2.getArrayList().get(0).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch (Exception e) {
			field12.setIcon(
					new ImageIcon(new ImageIcon("images/" + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}
		try {
			field22.setIcon(
					new ImageIcon(new ImageIcon("images/" + field2Player2.getArrayList().get(0).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch (Exception e) {
			field22.setIcon(
					new ImageIcon(new ImageIcon("images/" + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}
		try {
			field32.setIcon(
					new ImageIcon(new ImageIcon("images/" + field3Player2.getArrayList().get(0).getCardName() + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}catch (Exception e) {
			field32.setIcon(
					new ImageIcon(new ImageIcon("images/" + ".png")
							.getImage().getScaledInstance(180, 240, 0)));
		}

		if(side) {
			//This is player 1's turn
			switch(turn) {
			case 1:
				nextTurn.setIcon(new ImageIcon(new ImageIcon("images/nextStep.png").getImage().getScaledInstance(400, 100, 0)));
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				tradeButton.setVisible(true);
				break;
			case 5:
				tradeButton.setVisible(false);
				nextTurn.setIcon(new ImageIcon(new ImageIcon("images/nextTurn.png").getImage().getScaledInstance(400, 100, 0)));
			}
		}else {
			//This is player 2's turn
			switch(turn) {
			case 1:
				nextTurn.setIcon(new ImageIcon(new ImageIcon("images/nextStep.png").getImage().getScaledInstance(400, 100, 0)));
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				tradeButton.setVisible(true);
				break;
			case 5:
				tradeButton.setVisible(false);
				nextTurn.setIcon(new ImageIcon(new ImageIcon("images/nextTurn.png").getImage().getScaledInstance(400, 100, 0)));
			}
		}
	}

	// actions
	@Override
	public void actionPerformed(ActionEvent event) {
		buttonSound();
		// if the 'start 1-player' button is pressed,
		// a sound effect will play and a 1-player game will start
		if (event.getSource() == p1cardHand) {
			viewHand1();
		}

		if (event.getSource() == p2cardHand) {
			viewHand2();
		}

		if (event.getSource() == handExit) {
			playerHandFrame.setVisible(false);
			indexHand=0;
		}

		// will shift the cards in hand to the right
		if (event.getSource() == handRightHand) {
			indexHand += 5;
			viewHand1();
		}

		// will shift the cards in hand to the left
		if (event.getSource() == handLeftHand) {
			indexHand -= 5;
			viewHand1();
		}

		if(event.getSource()==handRightDiscard) {
			indexDiscard+=5;
			turn1();
		}

		if(event.getSource()==handLeftDiscard) {
			indexDiscard-=5;
			turn1();
		}
		
		if(event.getSource()==okButton) {
			notification.setVisible(false);
		}
		
		// if the 'start 2-player' button is pressed,
		// a sound effect will play and a 2-player game will start
		if (event.getSource() == p1goldStack) {
			refresh();
		}

		// if the 'start 2-player' button is pressed,
		// a sound effect will play and a 2-player game will start
		if (event.getSource() == p2goldStack) {
			refresh();
		}

		// plays a sound effect and opens a planting window
		if (event.getSource() == p1Field1) {
			harvestBean1(1);
		}

		// plays a sound effect and opens a planting window
		if (event.getSource() == p1Field2) {
			harvestBean1(2);
		}

		// plays a sound effect and opens a planting window
		if (event.getSource() == p1Field3) {
			if(player1.fieldNum==3) {
				harvestBean1(3);
			}else {
				notification(7);
			}
		}

		// plays a sound effect and opens a planting window
		if (event.getSource() == p2Field1) {
			buttonSound();
			harvestBean2(1);
		}

		// plays a sound effect and opens a planting window
		if (event.getSource() == p2Field2) {
			harvestBean2(2);
		}

		// plays a sound effect and opens a planting window
		if (event.getSource() == p2Field3) {
			if(player2.fieldNum==3) {
				harvestBean2(3);
			}else {
				notification(7);
			}
		}

		// plays a sound effect and closed the program
		if (event.getSource() == tradeButton) {
			tradeBeans();
		}

		// plays a sound and starts the next turn
		if (event.getSource() == nextTurn) {
			turn2Exit.setVisible(false);
			nextTurn();
		}

		// field-buying buttons
		if (event.getSource() == p1BuyField) {
			buyField1();
		}

		if (event.getSource() == p2BuyField) {
			buyField2();
		}

		if(event.getSource()==notificationExit) {
			notification.setVisible(false);
		}

		if (event.getSource() == discardExit) {
			turn1.setVisible(false);
			indexDiscard=0;
		}

		if (event.getSource() == button1Turn1) {
			if(side) {
				if(plantBeans1(tempdiscardpile.getArrayList().get(indexDiscard))) {
					tempdiscardpile.getArrayList().remove(indexDiscard);
				}
			}else {
				if(plantBeans2(tempdiscardpile.getArrayList().get(indexDiscard))) {
					tempdiscardpile.getArrayList().remove(indexDiscard);
				}
			}

			turn1();
		}
		if (event.getSource() == button2Turn1) {
			if(side) {
				if(plantBeans1(tempdiscardpile.getArrayList().get(indexDiscard+1))) {
					tempdiscardpile.getArrayList().remove(indexDiscard+1);
				}
			}else {
				if(plantBeans2(tempdiscardpile.getArrayList().get(indexDiscard+1))) {
					tempdiscardpile.getArrayList().remove(indexDiscard+1);
				}
			}
			turn1();
		}
		if (event.getSource() == button3Turn1) {
			if(side) {
				if(plantBeans1(tempdiscardpile.getArrayList().get(indexDiscard+2))) {
					tempdiscardpile.getArrayList().remove(indexDiscard+2);
				}
			}else {
				if(plantBeans2(tempdiscardpile.getArrayList().get(indexDiscard+2))) {
					tempdiscardpile.getArrayList().remove(indexDiscard+2);
				}
			}
			turn1();
		}
		if (event.getSource() == button4Turn1) {
			if(side) {
				if(plantBeans1(tempdiscardpile.getArrayList().get(indexDiscard+3))) {
					tempdiscardpile.getArrayList().remove(indexDiscard+3);
				}
			}else {
				if(plantBeans2(tempdiscardpile.getArrayList().get(indexDiscard+3))) {
					tempdiscardpile.getArrayList().remove(indexDiscard+3);
				}
			}
			turn1();
		}
		if (event.getSource() == button5Turn1) {
			if(side) {
				if(plantBeans1(tempdiscardpile.getArrayList().get(indexDiscard+4))) {
					tempdiscardpile.getArrayList().remove(indexDiscard+4);
				}
			}else {
				if(plantBeans2(tempdiscardpile.getArrayList().get(indexDiscard+4))) {
					tempdiscardpile.getArrayList().remove(indexDiscard+4);
				}
			}
			turn1();
		}

		if(event.getSource()==plantLeft) {
			indexDraw-=5;
			turn2();
		}
		if(event.getSource()==plantRight) {
			indexDraw+=5;
			turn2();
		}
		if (event.getSource() == button1Turn2Plant) {
			if(side) {
				if(plantBeans1(player1.getHandCard().get(indexDraw))) {
					player1.getHandCard().remove(indexDraw);
					plantTime++;
				}
			}else {
				if(plantBeans2(player2.getHandCard().get(indexDraw))) {
					player2.getHandCard().remove(indexDraw);
					plantTime++;
				}
			}
			turn2Exit.setVisible(true);
			nextTurn.setVisible(true);
			turn2();
		}
		
		if (event.getSource() == turn2Exit) {
			turn2.setVisible(false);
		}
		if (event.getSource() == button1Turn2) {
			if(side) {
				player1.getHandCard().remove(indexDraw);
				
			}else {
				player2.getHandCard().remove(indexDraw);
			}
			discardTime++;
			turn2();
		}
		if (event.getSource() == button2Turn2) {
			if(side) {
				player1.getHandCard().remove(indexDraw+1);
			}else {
				player2.getHandCard().remove(indexDraw+1);
			}
			discardTime++;
			turn2();
		}
		if (event.getSource() == button3Turn2) {
			if(side) {
				player1.getHandCard().remove(indexDraw+2);
			}else {
				player2.getHandCard().remove(indexDraw+2);
			}
			discardTime++;
			turn2();
		}
		if (event.getSource() == button4Turn2) {
			if(side) {
				player1.getHandCard().remove(indexDraw+3);
			}else {
				player2.getHandCard().remove(indexDraw+3);
			}
			discardTime++;
			turn2();
		}
		if (event.getSource() == button5Turn2) {
			if(side) {
				player1.getHandCard().remove(indexDraw+4);
			}else {
				player2.getHandCard().remove(indexDraw+4);
			}
			discardTime++;
			turn2();
		}

		if(event.getSource() == button1Turn3) {
			int num=card1.getArrayList().size();
			if(side) {
				for(int i=0;i<num;i++) {
					if(plantBeans1(card1.getTopCard())) {
						card1.draw();
						button1Turn3.setVisible(false);
						card1Label3.setVisible(false);
						card1Turn3.setVisible(false);
					}
				}
			}else {
				for(int i=0;i<num;i++) {
					if(plantBeans2(card1.getTopCard())) {
						card1.draw();
						button1Turn3.setVisible(false);
						card1Label3.setVisible(false);
						card1Turn3.setVisible(false);
					}
				}
			}
		}
		if(event.getSource() == button2Turn3) {
			int num=card2.getArrayList().size();
			if(side) {
				for(int i=0;i<num;i++) {
					if(plantBeans1(card2.getTopCard())) {
						card2.draw();
						button2Turn3.setVisible(false);
						card2Label3.setVisible(false);
						card2Turn3.setVisible(false);
					}
				}
			}else {
				
				for(int i=0;i<num;i++) {
					if(plantBeans2(card2.getTopCard())) {
						card2.draw();
						button2Turn3.setVisible(false);
						card2Label3.setVisible(false);
						card2Turn3.setVisible(false);
					}
				}
			}
		}
		if(event.getSource() == button3Turn3) {
			int num=card3.getArrayList().size();
			if(side) {
				for(int i=0;i<num;i++) {
					if(plantBeans1(card3.getTopCard())) {
						card3.draw();
						button3Turn3.setVisible(false);
						card3Label3.setVisible(false);
						card3Turn3.setVisible(false);
					}
				}
			}else {
				for(int i=0;i<num;i++) {
					if(plantBeans2(card3.getTopCard())) {
						card3.draw();
						button3Turn3.setVisible(false);
						card3Label3.setVisible(false);
						card3Turn3.setVisible(false);
					}
				}
			}
		}
		
		if(event.getSource() == turn3Exit) {
			turn3.setVisible(false);
		}
		
		if(event.getSource() == tradeNextStep) {
			tradeNextStep();
		}
		if(event.getSource() == handLeftTrade) {
			indexTrade-=5;
			if(tradeStep==1) {
				turn4(tradeable.getArrayList());
			}else if(tradeStep==2) {
				turn4(copy.getArrayList());
			}else if(tradeStep==3) {
				turn4(giveCard.getArrayList());
			}else if(tradeStep==4) {
				turn4(takeCard.getArrayList());
			}
		}
		if(event.getSource() == handRightTrade) {
			indexTrade+=5;
			if(tradeStep==1) {
				turn4(tradeable.getArrayList());
			}else if(tradeStep==2) {
				turn4(copy.getArrayList());
			}else if(tradeStep==3) {
				turn4(giveCard.getArrayList());
			}else if(tradeStep==4) {
				turn4(takeCard.getArrayList());
			}
		}
		
		if(event.getSource()==yes) {
			yes();
		}
		if(event.getSource()==no) {
			no();
		}
		if(event.getSource() == button1Turn4) {
			if(tradeStep==1) {
				giveCard.addNewCard(tradeable.getArrayList().get(indexTrade));
				tradeable.getArrayList().remove(indexTrade);
				turn4(tradeable.getArrayList());
			}else if(tradeStep==2) {
				if(side) {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade));
					copy.getArrayList().remove(indexTrade);
					turn4(copy.getArrayList());
				}else {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade));
					copy.getArrayList().remove(indexTrade);
					turn4(copy.getArrayList());
				}
			}
		}
		if(event.getSource() == button2Turn4) {
			if(tradeStep==1) {
				giveCard.addNewCard(tradeable.getArrayList().get(indexTrade+1));
				tradeable.getArrayList().remove(indexTrade+1);
				turn4(tradeable.getArrayList());
			}else if(tradeStep==2) {
				if(side) {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade+1));
					copy.getArrayList().remove(indexTrade+1);
					turn4(copy.getArrayList());
				}else {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade+1));
					copy.getArrayList().remove(indexTrade+1);
					turn4(copy.getArrayList());
				}
			}
		}
		if(event.getSource() == button3Turn4) {
			if(tradeStep==1) {
				giveCard.addNewCard(tradeable.getArrayList().get(indexTrade+2));
				tradeable.getArrayList().remove(indexTrade+2);
				turn4(tradeable.getArrayList());
			}else if(tradeStep==2) {
				if(side) {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade+2));
					copy.getArrayList().remove(indexTrade+2);
					turn4(copy.getArrayList());
				}else {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade+2));
					copy.getArrayList().remove(indexTrade+2);
					turn4(copy.getArrayList());
				}
			}
		}
		if(event.getSource() == button4Turn4) {
			if(tradeStep==1) {
				giveCard.addNewCard(tradeable.getArrayList().get(indexTrade+3));
				tradeable.getArrayList().remove(indexTrade+3);
				turn4(tradeable.getArrayList());
			}else if(tradeStep==2) {
				if(side) {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade+3));
					copy.getArrayList().remove(indexTrade+3);
					turn4(copy.getArrayList());
				}else {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade+3));
					copy.getArrayList().remove(indexTrade+3);
					turn4(copy.getArrayList());
				}
			}
		}
		if(event.getSource() == button5Turn4) {
			if(tradeStep==1) {
				giveCard.addNewCard(tradeable.getArrayList().get(indexTrade+4));
				tradeable.getArrayList().remove(indexTrade+4);
				turn4(tradeable.getArrayList());
			}else if(tradeStep==2) {
				if(side) {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade+4));
					copy.getArrayList().remove(indexTrade+4);
					turn4(copy.getArrayList());
				}else {
					takeCard.addNewCard(copy.getArrayList().get(indexTrade+4));
					copy.getArrayList().remove(indexTrade+4);
					turn4(copy.getArrayList());
				}
			}
		}
	}
	
	//This is trade next step function
	public void tradeNextStep() {
		tradeStep++;
		if(tradeStep==1) {
			notice.setVisible(true);
			turn4(tradeable.getArrayList());
			notice.setText("You give:");
		}else if(tradeStep==2) {
			if(side) {
				turn4(player2.getHandCard());
			}else {
				turn4(player1.getHandCard());
			}
				notice.setText("You get");
		}else if(tradeStep==3) {
			indexTrade=0;
			turn4(giveCard.getArrayList());
			notice.setBounds(450, 0, 300, 50);
			if(side) {
				notice.setText("Player 2 gets:");
			}else {
				notice.setText("Player 1 gets:");
			}
		}else if(tradeStep==4) {
			indexTrade=0;
			turn4(takeCard.getArrayList());
			notice.setBounds(450, 0, 300, 50);
			if(side) {
				notice.setText("Player 2 gives:");
			}else {
				notice.setText("Player 1 gives:");
			}
		}else if(tradeStep==5) {
			if(choose) {
				if(player2.passiveTrade(takeCard, giveCard)) {
					//AI accepted the trade
					notification(8);
					yes();
					refresh();
					turn4.setVisible(false);
				}else {
					no();
					//AI declined the trade
					notification(9);
					refresh();
					turn4.setVisible(false);
				}
			}else {
				indexTrade=0;
				handRightTrade.setVisible(false);
				yes.setVisible(true);
				no.setVisible(true);
				card1Turn4.setVisible(false);
				card2Turn4.setVisible(false);
				card3Turn4.setVisible(false);
				card4Turn4.setVisible(false);
				card5Turn4.setVisible(false);
				notice.setText("Confirm Trade");
				tradeNextStep.setVisible(false);
			}
		}
	}
	
	/**
	 * This method is yes button
	 */
	private void yes() {
		notice.setBounds(480, 0, 300, 50);
		ArrayList<Card> removeGive=new ArrayList<Card>();
		ArrayList<Card> removeTake=new ArrayList<Card>();
		int give=giveCard.getArrayList().size();
		int take=takeCard.getArrayList().size();
		boolean flag=true;
		for(int i=give-1;i>=0;i--) {
			if(side) {
				if(!plantBeans2(giveCard.getArrayList().get(i))) {
					//This means that there is not enough fields to plant for the 
					flag=false;
					break;
				}else {
					player1.getHandCard().remove(giveCard.getArrayList().remove(i));
				}
			}else {
				if(!plantBeans1(giveCard.getArrayList().get(i))) {
					flag=false;
					break;
				}else {
					player1.getHandCard().remove(giveCard.getArrayList().remove(i));
				}
			}
			
		}
		for(int i=take-1;i>=0;i--) {
			if(side) {
				if(!plantBeans1(takeCard.getArrayList().get(i))) {
					//This means that there is not enough bean fields for planting
					flag=false;
					break;
				}else {
					player2.getHandCard().remove(takeCard.getArrayList().remove(i));
				}
			}else {
				if(!plantBeans2(takeCard.getArrayList().get(i))) {
					flag=false;
					break;
				}else {
					player1.getHandCard().remove(takeCard.getArrayList().remove(i));
				}
			}
		}
		
		
		
		//Tell user that they don't have enough fields
		if(flag==false) {
			turn4.setVisible(false);
		}else {
			//Exit
			//This remove trade hand cards from player's hand
			turn4.setVisible(false);
			giveCard.empty();
			takeCard.empty();
			copy.empty();
		}
		
		refresh();
	}
	
	/**
	 * This method is no button
	 */
	private void no() {
		notice.setBounds(480, 0, 300, 50);
		turn4.setVisible(false);
		int num=giveCard.getArrayList().size();
		for(int i=0;i<num;i++) {
			tradeable.addNewCard(giveCard.draw());
		}
		giveCard.empty();
		takeCard.empty();
		copy.empty();
	}

	/**
	 * This method opens a new window for card trading pre-none post-The trade card
	 * is done
	 */
	private void tradeBeans() {
		int num;
		copy.empty();
		takeCard.empty();
		giveCard.empty();
		if(side) {
			num=player2.getHandCardNum();
			for(int i=0;i<num;i++) {
				copy.addNewCard(player2.getHandCard().get(i));
			}
		}else {
			num=player1.getHandCardNum();
			for(int i=0;i<num;i++) {
				copy.addNewCard(player1.getHandCard().get(i));
			}
		}
		button1Turn4.setVisible(true);
		button2Turn4.setVisible(true);
		button3Turn4.setVisible(true);
		button4Turn4.setVisible(true);
		button5Turn4.setVisible(true);
		yes.setVisible(false);
		no.setVisible(false);
		tradeStep=1;
		notice.setVisible(true);
		int num1=card1.getArrayList().size();
		int num2=card2.getArrayList().size();
		int num3=card3.getArrayList().size();
		
		tradeable.empty();
		for(int i=0;i<num1;i++) {
			tradeable.addNewCard(card1.getTopCard());
		}
		for(int i=0;i<num2;i++) {
			tradeable.addNewCard(card2.getTopCard());
		}
		for(int i=0;i<num3;i++) {
			tradeable.addNewCard(card3.getTopCard());
		}
		for(int i=0;i<player1.getHandCardNum();i++) {
			tradeable.addNewCard(player1.getHandCard().get(i));
		}
		notice.setText("You give");
		tradeNextStep.setVisible(true);
		turn4(tradeable.getArrayList());
	}

	/**
	 * This method buys a third bean field, this button will not show if player has
	 * less than 3 coins pre-which player wants to buy a new field post-The new bean
	 * field is brought
	 */
	private void buyField1() {
		if(player1.getGoldCoinNum()>=3) {
			player1.setGoldCoinNum(player1.getGoldCoinNum()-3);
			refresh();
			p1BuyField.setVisible(false);
			numField1++;
		}else {
			notification(1);
		}
	}

	private void buyField2() {
		if(player2.getGoldCoinNum()>=3) {
			player2.setGoldCoinNum(player2.getGoldCoinNum()-3);
			refresh();
			p2BuyField.setVisible(false);
			numField2++;
		}else {
			notification(1);
		}
	}

	// this method is for planting beans in the bean field.
	// an integer is sent to the method to determine which
	// of the 3 places to plant the beans
	private boolean plantBeans1(Card card) {
		//True when there is no place to plant beans
		boolean flag=true;

		//True when the field has beans in it
		boolean field1=true;
		boolean field2=true;
		boolean field3=true;

		if(field1Player1.getArrayList().isEmpty()){
			flag=false;
			field1=false;
		}

		if(field2Player1.getArrayList().isEmpty()){
			flag=false;
			field2=false;
		}

		if(numField1==3) {
			if(field3Player1.getArrayList().isEmpty()){
				flag=false;
				field3=false;
			}
		}

		if(field1&&field1Player1.getArrayList().get(0).getCardName().equals(card.getCardName())) {
			flag=false;
			field1Player1.getArrayList().add(card);
		}else if(field2&&field2Player1.getArrayList().get(0).getCardName().equals(card.getCardName())) {
			flag=false;
			field2Player1.getArrayList().add(card);
		}else if(numField1==3) {
			if(field3&&field3Player1.getArrayList().get(0).getCardName().equals(card.getCardName())) {
				flag=false;
				field3Player1.getArrayList().add(card);
			}
		}else if(field1==false) {
			field1Player1.getArrayList().add(card);
		}else if(field2==false) {
			field2Player1.getArrayList().add(card);
		}else if(numField1==3) {
			if(field3==false) {
				field3Player1.getArrayList().add(card);
			}
		}

		refresh();

		if(flag) {
			notification(2);
			return false;
		}

		return true;
	}

	// this method is for planting beans in the bean field for player 2
	// an integer is sent to the method to determine which
	// of the 3 places to plant the beans
	private boolean plantBeans2(Card card) {
		//True when there is no place to plant beans
		boolean flag=true;

		//True when the field has beans in it
		boolean field1=true;
		boolean field2=true;
		boolean field3=true;

		if(field1Player2.getArrayList().isEmpty()){
			flag=false;
			field1=false;
		}

		if(field2Player2.getArrayList().isEmpty()){
			flag=false;
			field2=false;
		}

		if(numField2==3) {
			if(field3Player2.getArrayList().isEmpty()){
				flag=false;
				field3=false;
			}
		}

		if(field1&&field1Player2.getArrayList().get(0).getCardName().equals(card.getCardName())) {
			flag=false;
			field1Player2.getArrayList().add(card);
		}else if(field2&&field2Player2.getArrayList().get(0).getCardName().equals(card.getCardName())) {
			flag=false;
			field2Player2.getArrayList().add(card);
		}else if(numField2==3) {
			if(field3&&field3Player2.getArrayList().get(0).getCardName().equals(card.getCardName())) {
				flag=false;
				field3Player2.getArrayList().add(card);
			}
		}else if(field1==false) {
			field1Player2.getArrayList().add(card);
		}else if(field2==false) {
			field2Player2.getArrayList().add(card);
		}else if(numField2==3) {
			if(field3==false) {
				field3Player2.getArrayList().add(card);
			}
		}

		refresh();

		if(flag) {
			notification(4);
			return false;
		}

		return true;
	}

	/**
	 * This is harvesting bean method for player 1
	 * pre-none
	 * post-The bean field is harvested
	 */
	private void harvestBean1(int i) {
		//This stores how many beans are harvested
		int size;
		switch(i) {
		case 1:
			size=field1Player1.getArrayList().size();
			break;
		case 2:
			size=field2Player1.getArrayList().size();
			break;
		case 3:
			size=field3Player1.getArrayList().size();
			break;
		default:
			size=0;
		}
		
		boolean flag=false;
		
		if(numField1==2) {
			if(field1Player1.getArrayList().size()<2&&field2Player1.getArrayList().size()<2) {
				flag=true;
			}
		}else {
			if(field1Player1.getArrayList().size()<2&&field2Player1.getArrayList().size()<2&&field3Player1.getArrayList().size()<2) {
				flag=true;
			}
		}
		
		if(size>=2||flag) {
			switch(i) {
			case 1:
				if(field1Player1.getArrayList().isEmpty()) {
					//Display to user that they can't have an empty window
					notification(3);
					break;
				}else {
					if(size<field1Player1.getArrayList().get(0).getLevel1()) {
						player1.addGoldCoinNum(0);
					}else if(size<field1Player1.getArrayList().get(0).getLevel2()) {
						player1.addGoldCoinNum(1);
					}else if(size<field1Player1.getArrayList().get(0).getLevel3()) {
						player1.addGoldCoinNum(2);
					}else if(size<field1Player1.getArrayList().get(0).getLevel4()) {
						player1.addGoldCoinNum(3);
					}else {
						player1.addGoldCoinNum(4);
					}
					field1Player1.empty();
					break;
				}
			case 2:
				if(field2Player1.getArrayList().isEmpty()) {
					//Display to user that they can't have an empty window
					notification(3);
					break;
				}else {
					if(size<field2Player1.getArrayList().get(0).getLevel1()) {
						player1.addGoldCoinNum(0);
					}else if(size<field2Player1.getArrayList().get(0).getLevel2()) {
						player1.addGoldCoinNum(1);
					}else if(size<field2Player1.getArrayList().get(0).getLevel3()) {
						player1.addGoldCoinNum(2);
					}else if(size<field2Player1.getArrayList().get(0).getLevel4()) {
						player1.addGoldCoinNum(3);
					}else {
						player1.addGoldCoinNum(4);
					}
					field2Player1.empty();
					break;
				}
			case 3:
				if(field3Player1.getArrayList().isEmpty()) {
					//Display to user that they can't have an empty window
					if(numField1==2) {
						notification(1);
					}else {
						notification(3);
					}
					break;
				}else {
					if(size<field3Player1.getArrayList().get(0).getLevel1()) {
						player1.addGoldCoinNum(0);
					}else if(size<field3Player1.getArrayList().get(0).getLevel2()) {
						player1.addGoldCoinNum(1);
					}else if(size<field3Player1.getArrayList().get(0).getLevel3()) {
						player1.addGoldCoinNum(2);
					}else if(size<field3Player1.getArrayList().get(0).getLevel4()) {
						player1.addGoldCoinNum(3);
					}else {
						player1.addGoldCoinNum(4);
					}
					field3Player1.empty();
					break;
				}
			}
		}else {
			notification(5);
		}

		refresh();
	}

	/**
	 * This is harvesting bean method for player 2
	 * pre-none
	 * post-The bean field is harvested
	 */
	public void harvestBean2(int i) {
		//This stores how many beans are harvested
		int size;
		switch(i) {
		case 1:
			size=field1Player2.getArrayList().size();
			break;
		case 2:
			size=field2Player2.getArrayList().size();
			break;
		case 3:
			size=field3Player2.getArrayList().size();
			break;
		default:
			size=0;
		}
		
		boolean flag=false;
		
		if(numField1==2) {
			if(field1Player1.getArrayList().size()<2&&field2Player1.getArrayList().size()<2) {
				flag=true;
			}
		}else {
			if(field1Player1.getArrayList().size()<2&&field2Player1.getArrayList().size()<2&&field3Player1.getArrayList().size()<2) {
				flag=true;
			}
		}
		
		if(size>=2||flag) {
			switch(i) {
			case 1:
				if(field1Player2.getArrayList().isEmpty()) {
					//Display to user that they can't have an empty window
					notification(3);
					break;
				}else {
					if(size<field1Player2.getArrayList().get(0).getLevel1()) {
						player2.addGoldCoinNum(0);
					}else if(size<field1Player2.getArrayList().get(0).getLevel2()) {
						player2.addGoldCoinNum(1);
					}else if(size<field1Player2.getArrayList().get(0).getLevel3()) {
						player2.addGoldCoinNum(2);
					}else if(size<field1Player2.getArrayList().get(0).getLevel4()) {
						player2.addGoldCoinNum(3);
					}else {
						player2.addGoldCoinNum(4);
					}
					field1Player2.empty();
					break;
				}
			case 2:
				if(field2Player2.getArrayList().isEmpty()) {
					//Display to user that they can't have an empty window
					notification(3);
					break;
				}else {
					if(size<field2Player2.getArrayList().get(0).getLevel1()) {
						player2.addGoldCoinNum(0);
					}else if(size<field2Player2.getArrayList().get(0).getLevel2()) {
						player2.addGoldCoinNum(1);
					}else if(size<field2Player2.getArrayList().get(0).getLevel3()) {
						player2.addGoldCoinNum(2);
					}else if(size<field2Player2.getArrayList().get(0).getLevel4()) {
						player2.addGoldCoinNum(3);
					}else {
						player2.addGoldCoinNum(4);
					}
					field2Player2.empty();
					break;
				}
			case 3:
				if(field3Player2.getArrayList().isEmpty()) {
					//Display to user that they can't have an empty window
					if(numField2==2) {
						notification(1);
					}else {
						notification(3);
					}
					break;
				}else {
					if(size<field3Player2.getArrayList().get(0).getLevel1()) {
						player2.addGoldCoinNum(0);
					}else if(size<field3Player2.getArrayList().get(0).getLevel2()) {
						player2.addGoldCoinNum(1);
					}else if(size<field3Player2.getArrayList().get(0).getLevel3()) {
						player2.addGoldCoinNum(2);
					}else if(size<field3Player2.getArrayList().get(0).getLevel4()) {
						player2.addGoldCoinNum(3);
					}else {
						player2.addGoldCoinNum(4);
					}
					field3Player2.empty();
					break;
				}
			}
		}else {
			notification(5);
		}

		refresh();
	}

	// this method controls the button sound effect
	private void buttonSound() {
		File buttonClick1 = new File("sounds/buttonClick1.wav");
		try {

			Clip bClick = AudioSystem.getClip();

			bClick.open(AudioSystem.getAudioInputStream(buttonClick1));
			bClick.start();

		} catch (Exception e)

		{

		}

	}

}