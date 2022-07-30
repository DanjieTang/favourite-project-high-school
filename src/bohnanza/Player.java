package bohnanza;

import java.util.ArrayList;

public class Player {
	int fieldNum=2;
	int goldCoinNum=0;
	ArrayList<Card> handcard=new ArrayList<Card>();
	ArrayList<Card> field1=new ArrayList<Card>();
	ArrayList<Card> field2=new ArrayList<Card>();
	ArrayList<Card> field3;

	/**
	 * This method returns the total number of gold coin
	 * pre-none
	 * post-The total number of gold coin is returned
	 */
	public int getGoldCoinNum() {
		return goldCoinNum;
	}

	/**
	 * This method sets the total number of gold coin
	 * pre-none
	 * post-The total number of gold coin is returned
	 */
	public void setGoldCoinNum(int goldCoinNum) {
		this.goldCoinNum=goldCoinNum;
	}

	/**
	 * This method adds the total number of gold coin
	 * pre-none
	 * post-The total number of gold coin is added
	 */
	public void addGoldCoinNum(int goldCoinNum) {
		this.goldCoinNum+=goldCoinNum;
	}

	/**
	 * This method returns the hand cards represented by array list
	 * pre-none
	 * post-An array of string has be returned
	 */
	public ArrayList<Card> getHandCard() {
		return handcard;
	}

	/**
	 * This method returns the hand cards represented by string
	 * pre-none
	 * post-An array of string has be returned
	 */
	public String[] getHandCardName() {
		String[] handcards=new String[handcard.size()];

		for(int i=0;i<handcard.size();i++) {
			handcards[i]=handcard.get(i).getCardName();
		}

		return handcards;
	}

	/**
	 * This method add hand card of user just by using a string
	 * pre-none
	 * post-The hand card is added
	 */
	public void addHandCardByName(String[] handcards) {
		for(int i=0;i<handcards.length;i++) {
			Card card;
			if(handcards.equals("Red Bean")) {
				card=new Card("Red Bean", 2, 3, 4, 5);
			}else if(handcards.equals("Black Eyed Bean")) {
				card=new Card("Black Eyed Bean", 2, 4, 5, 6);
			}else if(handcards.equals("Soy Bean")) {
				card=new Card("Soy Bean", 2, 4, 6, 7);
			}else if(handcards.equals("Grean Bean")) {
				card=new Card("Grean Bean", 3, 5, 6, 7);
			}else if(handcards.equals("Chill Bean")) {
				card=new Card("Chill Bean", 3, 6, 8, 9);
			}else{
				card=new Card("Blue Bean", 4, 6, 8, 10);
			}
			handcard.add(card);
		}
	}

	/**
	 * This method adds one card to user's hand
	 * pre-The Card 
	 * post-The card is added to hand card
	 */
	public void addHandCard(Card card) {
		handcard.add(card);
	}

	public int getHandCardNum() {
		return handcard.size();
	}

	/**
	 * This method is helper method for turn 1 that finds how many types of card are in discard pile
	 * pre-none
	 * post-The total number of types of card is returned
	 */
	private int getCardTypeNum(ArrayList<Card> discardCardsByOtherPlayer) {
		int num=0;
		//True if the the card type already exist
		boolean flag;
		ArrayList<String> types=new ArrayList<String>();

		for(int i=0;i<discardCardsByOtherPlayer.size();i++) {
			flag=false;
			for(int j=0;j<types.size();j++) {
				if(types.get(j).equals(discardCardsByOtherPlayer.get(i))) {
					flag=true;
				}
			}
			if(flag==false) {
				types.add(discardCardsByOtherPlayer.get(i).getCardName());
				num++;
			}
		}

		return num;
	}

	private ArrayList<ArrayList<Card>> getCardsInAPiles(ArrayList<Card> listToCheck) {
		ArrayList<ArrayList<Card>> list=new ArrayList<ArrayList<Card>>();
		ArrayList<Card> redBean=new ArrayList<Card>();
		ArrayList<Card> blackeyedBean=new ArrayList<Card>();
		ArrayList<Card> soyBean=new ArrayList<Card>();
		ArrayList<Card> greenBean=new ArrayList<Card>();
		ArrayList<Card> stinkBean=new ArrayList<Card>();
		ArrayList<Card> chillBean=new ArrayList<Card>();
		ArrayList<Card> blueBean=new ArrayList<Card>();

		for(int i=0;i<listToCheck.size();i++) {
			if(listToCheck.get(i).getCardName().equals("Red Bean")) {
				redBean.add(listToCheck.get(i));
			}else if(listToCheck.get(i).getCardName().equals("Black Eyed Bean")) {
				blackeyedBean.add(listToCheck.get(i));
			}else if(listToCheck.get(i).getCardName().equals("Soy Bean")) {
				soyBean.add(listToCheck.get(i));
			}else if(listToCheck.get(i).getCardName().equals("Grean Bean")) {
				greenBean.add(listToCheck.get(i));
			}else if(listToCheck.get(i).getCardName().equals("Stink Bean")) {
				stinkBean.add(listToCheck.get(i));
			}else if(listToCheck.get(i).getCardName().equals("Chill Bean")) {
				chillBean.add(listToCheck.get(i));
			}else if(listToCheck.get(i).getCardName().equals("Blue Bean")) {
				blueBean.add(listToCheck.get(i));
			}else {
				System.out.print("Some thing is wrong with card name");
			}
		}

		list.add(redBean);
		list.add(blackeyedBean);
		list.add(soyBean);
		list.add(greenBean);
		list.add(stinkBean);
		list.add(chillBean);
		list.add(blueBean);

		return list;
	}

	/**
	 * This method is the turn 1 of player
	 * pre-Turn, representing which player it is
	 * post-The turn 1 phase of user ended
	 */
	public void turn1(ArrayList<Card> discardPile) {
		
	}

	/**
	 * This method is the turn 2 of player
	 * pre-Turn, representing which player it is
	 * post-The turn 2 phase of user ended
	 */
	public void turn2() {
		
	}

	/**
	 * This method is the turn 3 of player
	 * pre-Turn, representing which player it is
	 * post-The turn 3 phase of user ended
	 * @return 
	 */
	public boolean turn3(ArrayList<Card> discardPile) {
		return false;
	}

	/**
	 * This method is the turn 4 of player
	 * pre-Turn, representing which player it is
	 * post-The turn 4 phase of user ended
	 */
	public void turn4() {
		
	}

	/**
	 * This method is the turn 5 of player
	 * pre-Turn, representing which player it is
	 * post-The turn 5 phase of user ended
	 */
	public boolean turn5() {
		return false;
	}
	
	public boolean passiveTrade(Pile take, Pile give) {
		return false;
	}

	/**
	 * This method plants one type on card into a field
	 * pre-none
	 * post-The card is added to the bean field
	 */
	public void plantBean(Card card, int fieldnum) {
		if(fieldnum==1) {
			if(field1.isEmpty()){
				//Run when the bean planted in empty bean field
				field1.add(card);
			}else if(card.getCardName().equals(field1.get(0).getCardName())) {
				//Run when the bean planted is the same bean type as the bean planted before.
				field1.add(card);
			}else {
				//Tell user to harvest first before planting
			}
		}else if(fieldnum==2) {
			if(field2.isEmpty()){
				//Run when the bean planted in empty bean field
				field2.add(card);
			}else if(card.getCardName().equals(field2.get(0).getCardName())) {
				//Run when the bean planted is the same bean type as the bean planted before.
				field2.add(card);
			}else {
				//Tell user to harvest first before planting
			}
		}else {
			if(field3.isEmpty()){
				//Run when the bean planted in empty bean field
				field3.add(card);
			}else if(card.getCardName().equals(field3.get(0).getCardName())) {
				//Run when the bean planted is the same bean type as the bean planted before.
				field3.add(card);
			}else {
				//Tell user to harvest first before planting
			}
		}
	}

	/**
	 * This method harvest the bean field
	 * pre-none
	 * post-The coin gain is returned
	 */
	public int harvestField(int fieldNum) {
		int num;
		if(fieldNum==1) {
			num=field1.size();
			if(num>field1.get(0).getLevel4()) {
				return 4;
			}else if(num>field1.get(0).getLevel3()) {
				return 3;
			}else if(num>field1.get(0).getLevel2()) {
				return 2;
			}else if(num>field1.get(0).getLevel1()) {
				return 1;
			}
			//Only reach here is no coin is gained by harvesting
			return 0;
		}else if(fieldNum==2) {
			num=field2.size();
			if(num>field2.get(0).getLevel4()) {
				return 4;
			}else if(num>field2.get(0).getLevel3()) {
				return 3;
			}else if(num>field2.get(0).getLevel2()) {
				return 2;
			}else if(num>field2.get(0).getLevel1()) {
				return 1;
			}
			//Only reach here is no coin is gained by harvesting
			return 0;
		}else {
			num=field3.size();
			if(num>field3.get(0).getLevel4()) {
				return 4;
			}else if(num>field3.get(0).getLevel3()) {
				return 3;
			}else if(num>field3.get(0).getLevel2()) {
				return 2;
			}else if(num>field3.get(0).getLevel1()) {
				return 1;
			}
			//Only reach here is no coin is gained by harvesting
			return 0;
		}
	}

	/**
	 * This method buys a new bean field
	 * pre-none
	 * post-The third bean field is bought
	 */
	public boolean buyBeanField() {
		if(goldCoinNum>=3) {
			field3=new ArrayList<Card>();
			goldCoinNum-=3;
			fieldNum=3;
			return true;
		}else {
			return false;
		}
	}

	/**
	 * This metho returns the number of fields for the player
	 * pre-none
	 * post-The number of fields is returned
	 */
	public int getFieldNum() {
		return fieldNum;
	}
}
