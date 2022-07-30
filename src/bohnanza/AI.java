package bohnanza;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class AI extends Player {
	Pile card1=new Pile();
	Pile card2=new Pile();
	Pile card3=new Pile();

	// This arraylist stores the draw pile
	Pile drawpile = new Pile();
	
	ArrayList<Card> oppHandCard=new ArrayList<Card>();

	public AI(Pile field1pass, Pile field2pass, Pile field3pass, Pile draw, ArrayList opp) {
		field1=field1pass.getArrayList();
		field2=field2pass.getArrayList();
		field3=field3pass.getArrayList();
		drawpile=draw;
		oppHandCard=opp;
	}

	/**
	 * This method is the turn 1 of AI
	 * pre-none
	 * post-The turn 1 phase of user ended
	 */
	public void turn1(ArrayList<Card> discardPile) {
		boolean flag;
		int discard=discardPile.size();
		//AI will choose which card to take
		//Check cards one by one
		for(int i=discard-1;i>=0;i--) {
			flag=true;
			if(fieldNum==2) {
				//Run when there is 2 fields
				//Check if field 1 is empty
				try {
					if((discardPile.get(i)).getCardName().equals(field1.get(0).getCardName())){
						//Check if it is the same card type with field 1
						field1.add(discardPile.get(i));
						discardPile.remove(i);
						flag=false;
					}
				}catch(Exception e) {
					
				}
				
				if(flag) {
					try {
						if((discardPile.get(i)).getCardName().equals(field2.get(0).getCardName())){
							//Check if it is the same card type with field 2
							field2.add(discardPile.get(i));
							discardPile.remove(i);
							flag=false;
						}
					}catch(Exception e) {
						
					}
				}
				
				if(flag) {
					if(field1.isEmpty()) {
						field1.add(discardPile.get(i));
						discardPile.remove(i);
						flag=false;
					}
				}
				
				if(flag) {
					if(field2.isEmpty()) {
						field2.add(discardPile.get(i));
						discardPile.remove(i);
						flag=false;
					}
				}
			}else if(fieldNum==3) {
				//Run when there is 3 fields
				//Run when there is 2 fields
				//Check if field 1 is empty
				try {
					if((discardPile.get(i)).getCardName().equals(field1.get(0).getCardName())){
						//Check if it is the same card type with field 1
						field1.add(discardPile.get(i));
						discardPile.remove(i);
						flag=false;
					}
				}catch(Exception e) {
					
				}
				
				if(flag) {
					try {
						if((discardPile.get(i)).getCardName().equals(field2.get(0).getCardName())){
							//Check if it is the same card type with field 2
							field2.add(discardPile.get(i));
							discardPile.remove(i);
							flag=false;
						}
					}catch(Exception e) {
						
					}
				}
				
				if(flag) {
					try {
						if((discardPile.get(i)).getCardName().equals(field3.get(0).getCardName())){
							//Check if it is the same card type with field 2
							field3.add(discardPile.get(i));
							discardPile.remove(i);
							flag=false;
						}
					}catch(Exception e) {
						
					}
				}
				
				if(flag) {
					if(field1.isEmpty()) {
						field1.add(discardPile.get(i));
						discardPile.remove(i);
						flag=false;
					}
				}
				
				if(flag) {
					if(field2.isEmpty()) {
						field2.add(discardPile.get(i));
						discardPile.remove(i);
						flag=false;
					}
				}
				
				if(flag) {
					if(field3.isEmpty()) {
						field3.add(discardPile.get(i));
						discardPile.remove(i);
						flag=false;
					}
				}
			}else {
				//Run when the number of fields is not normal
				System.out.print("The number of bean fields is abnormal, there are "+fieldNum+" number of field");
			}

		}

	}

	/**
	 * This method is the turn 2 of player
	 * pre-Turn, representing which player it is
	 * post-The turn 2 phase of user ended
	 */

	public void turn2() {
		//If flag is false, it means an action has been taken
		boolean flag;

		//This plants one card, and only plant second card if allowed
		for(int i=0;i<2;i++) {
			flag=true;
			
			try {
				if((handcard.get(i)).getCardName().equals(field1.get(0).getCardName())){
					//Check if it is the same card type with field 1
					field1.add(handcard.get(i));
					handcard.remove(i);
					flag=false;
				}
			}catch(Exception e) {

			}

			if(flag) {
				try {
					if((handcard.get(i)).getCardName().equals(field2.get(0).getCardName())){
						//Check if it is the same card type with field 2
						field2.add(handcard.get(i));
						handcard.remove(i);
						flag=false;
					}
				}catch(Exception e) {

				}
			}
			
			if(flag) {
				if((!field1.isEmpty())&&(!field2.isEmpty()&&(i==0))){
					//Only harvest when both fields are full
					if(field1.size()>field2.size()) {
						harvestBean(2);
					}else {
						harvestBean(1);
					}
				}
			}

			if(flag) {
				if(field1.isEmpty()) {
					field1.add(handcard.get(i));
					handcard.remove(i);
					flag=false;
				}else if(field2.isEmpty()) {
					//Check if field 2 is empty
					field2.add(handcard.get(i));
					handcard.remove(i);
					flag=false;
				}
			}

			if(flag&&i==1) {
				//This discards the second card if the second card is not planted
				//The logic behind it is that if the card is not plant, then it is a unless card
				handcard.remove(i);
			}
		}
	}

	/**
	 * This method is the turn 3 of player
	 * pre-Turn, representing which player it is
	 * post-The turn 3 phase of user ended
	 */

	public boolean turn3(ArrayList<Card> discardPile) {
		boolean take=true;
		boolean flag2=true;
		boolean flag3=true;

		try {
			//These codes intialized the 3 piles
			card1.addNewCard(drawpile.draw());
			card2.addNewCard(drawpile.draw());
			while(flag2) {
				if(card2.getArrayList().get(0).getCardName().equals(card1.getArrayList().get(0).getCardName())){
					//If card two is same card with card one, card pile one adds one
					card1.addNewCard(card2.getArrayList().get(0));
					card2.getArrayList().remove(0);
					card2.addNewCard(drawpile.draw());
				}else {
					flag2=false;
				}
			}

			card3.addNewCard(drawpile.draw());

			while(flag3) {
				if(card3.getArrayList().get(0).getCardName().equals(card2.getArrayList().get(0).getCardName())){
					//If card two is same card with card one, card pile one adds one
					card2.addNewCard(card3.getArrayList().get(0));
					card3.getArrayList().remove(0);
					card3.addNewCard(drawpile.draw());
				}else if(card3.getArrayList().get(0).getCardName().equals(card1.getArrayList().get(0).getCardName())) {
					card1.addNewCard(card3.getArrayList().get(0));
					card3.getArrayList().remove(0);
					card3.addNewCard(drawpile.draw());
				}else {
					flag3=false;
				}
			}
			
			int num1=card1.getArrayList().size();
			int num2=card2.getArrayList().size();
			int num3=card3.getArrayList().size();

			for(int i=0;i<num1;i++) {
				plantBeans2(card1.getArrayList().get(0));
			}
			for(int i=0;i<num2;i++) {
				plantBeans2(card2.getArrayList().get(0));
			}
			for(int i=0;i<num3;i++) {
				plantBeans2(card3.getArrayList().get(0));
			}
			
			int num=card1.getArrayList().size();
			for(int i=0;i<num;i++) {
				discardPile.add(card1.getTopCard());
			}
			
			num=card2.getArrayList().size();
			for(int i=0;i<num;i++) {
				discardPile.add(card2.getTopCard());
			}
			
			num=card3.getArrayList().size();
			for(int i=0;i<num;i++) {
				discardPile.add(card3.getTopCard());
			}
			
			return false;
		}catch(Exception e) {
			return true;
		}
	}


	/**
	 * This method is run only when player trade with AI
	 * pre-none
	 * post-The trade is declined or accepted
	 */
	public boolean passiveTrade(Pile take, Pile give) {
		int valid1=0;
		int valid2=0;
		int takeNum=take.getArrayList().size();
		int giveNum=give.getArrayList().size();
		
		for(int i=0;i<takeNum;i++) {
			if(checkValid(take.getArrayList().get(i))) {
				//If even one card is not wanted, then do not trade
				valid1++;
			}
		}
		for(int i=0;i<giveNum;i++) {
			if(checkValid(give.getArrayList().get(i))) {
				//If even one card is wanted, then do not trade
				valid2++;
			}
		}
		
		//If more valuable cards are gained in the trade, than lost. Then trade
		if(valid1<=valid2) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean aggressiveTrade(Pile take, Pile give) {
		int num=oppHandCard.size();
		for(int i=0;i<num;i++) {
			if(!checkValid(oppHandCard.get(i))) {
				give.addNewCard(oppHandCard.get(i));
			}
		}
		
		if(give.getArrayList().size()==0) {
			return false;
		}
		
		int num2=handcard.size();
		for(int i=0;i<num2;i++) {
			if(checkValid(handcard.get(i))) {
				take.addNewCard(handcard.get(i));
			}
		}
		
		return true;
	}
	

	/**
	 * This is harvesting bean method for player 2
	 * pre-none
	 * post-The bean field is harvested
	 */
	public void harvestBean(int i) {
		//This stores how many beans are harvested
		int size;
		switch(i) {
		case 1:
			size=field1.size();
			break;
		case 2:
			size=field2.size();
			break;
		case 3:
			size=field3.size();
			break;
		default:
			size=0;
		}

		boolean flag=false;

		if(fieldNum==2) {
			if(field1.size()<2&&field2.size()<2) {
				flag=true;
			}
		}else {
			if(field1.size()<2&&field2.size()<2&&field3.size()<2) {
				flag=true;
			}
		}

		if(size>=2||flag) {
			switch(i) {
			case 1:
				if(field1.isEmpty()) {
					//Display to user that they can't have an empty window
					break;
				}else {
					if(size<field1.get(0).getLevel1()) {
						goldCoinNum+=0;
					}else if(size<field1.get(0).getLevel2()) {
						goldCoinNum+=1;
					}else if(size<field1.get(0).getLevel3()) {
						goldCoinNum+=2;
					}else if(size<field1.get(0).getLevel4()) {
						goldCoinNum+=3;
					}else {
						goldCoinNum+=4;
					}
					field1.clear();
					break;
				}
			case 2:
				if(field2.isEmpty()) {
					//Display to user that they can't have an empty window
					break;
				}else {
					if(size<field2.get(0).getLevel1()) {
						goldCoinNum+=0;
					}else if(size<field2.get(0).getLevel2()) {
						goldCoinNum+=1;
					}else if(size<field2.get(0).getLevel3()) {
						goldCoinNum+=2;
					}else if(size<field2.get(0).getLevel4()) {
						goldCoinNum+=3;
					}else {
						goldCoinNum+=4;
					}
					field2.clear();
					break;
				}
			case 3:
				if(field3.isEmpty()) {
					//Display to user that they can't have an empty window

					break;
				}else {
					if(size<field3.get(0).getLevel1()) {
						goldCoinNum+=0;
					}else if(size<field3.get(0).getLevel2()) {
						goldCoinNum+=1;
					}else if(size<field3.get(0).getLevel3()) {
						goldCoinNum+=2;
					}else if(size<field3.get(0).getLevel4()) {
						goldCoinNum+=3;
					}else {
						goldCoinNum+=4;
					}
					field3.clear();
					break;
				}
			}
		}
	}

	private boolean plantBeans2(Card card) {
		//True when there is no place to plant beans
		boolean flag=true;

		//True when the field has beans in it
		boolean field1Boo=true;
		boolean field2Boo=true;
		boolean field3Boo=true;

		if(field1.isEmpty()){
			flag=false;
			field1Boo=false;
		}

		if(field2.isEmpty()){
			flag=false;
			field2Boo=false;
		}

		if(fieldNum==3) {
			if(field3.isEmpty()){
				flag=false;
				field3Boo=false;
			}
		}

		if(field1Boo&&field1.get(0).getCardName().equals(card.getCardName())) {
			flag=false;
			field1.add(card);
		}else if(field2Boo&&field2.get(0).getCardName().equals(card.getCardName())) {
			flag=false;
			field2.add(card);
		}else if(fieldNum==3) {
			if(field3Boo&&field3.get(0).getCardName().equals(card.getCardName())) {
				flag=false;
				field3.add(card);
			}
		}else if(field1Boo==false) {
			field1.add(card);
		}else if(field2Boo==false) {
			field2.add(card);
		}else if(fieldNum==3) {
			if(field3Boo==false) {
				field3.add(card);
			}
		}

		if(flag) {
			return false;
		}

		return true;
	}
	
	//If the card is good card, true is returned
	private boolean checkValid(Card card) {
		try {
			switch(fieldNum) {
			case 2:
				if(card.getCardName().equals(field1.get(0).getCardName())) {
					return true;
				}
				if(card.getCardName().equals(field2.get(0).getCardName())) {
					return true;
				}
				return false;
			case 3:
				if(card.getCardName().equals(field1.get(0).getCardName())) {
					return true;
				}
				if(card.getCardName().equals(field2.get(0).getCardName())) {
					return true;
				}
				if(card.getCardName().equals(field3.get(0).getCardName())) {
					return true;
				}
				return false;
			default:
				return false;
			}
		}catch(Exception e) {
			return true;
		}
	}
}