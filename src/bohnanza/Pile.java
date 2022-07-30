package bohnanza;

import java.util.ArrayList;

public class Pile {
	private ArrayList<Card> arraylist=new ArrayList<Card>();
	
	public void setArrayList(ArrayList<Card> list) {
		arraylist=list;
	}
	
	/**
	 * This method returns the pile of card
	 * pre-none
	 * post-The arraylist repersenting the pile is returned
	 */
	public ArrayList<Card> getArrayList() {
		return arraylist;
	}
	
	/**
	 * This method adds a new card to the pile
	 * pre-none
	 * post-A new card is added to the pile
	 */
	public void addNewCard(Card newCard) {
		arraylist.add(newCard);
	}
	
	/**
	 * This method returns the card at the top
	 * pre-none
	 * post-The card at the top is returned
	 */
	public Card getTopCard() {
		return arraylist.get(arraylist.size()-1);
	}
	
	/**
	 * This method removes the entire pile
	 * pre-none
	 * post-The pile of cards is gone
	 */
	public void empty() {
		int size=arraylist.size();
		for(int i=0;i<size;i++) {
			arraylist.remove(0);
		}
	}
	
	/**
	 * This method is helper method for turn 1 that finds how many types of card are in discard pile
	 * pre-none
	 * post-The total number of types of card is returned
	 */
	public int getCardTypeNum() {
		int num=0;
		//True if the the card type already exist
		boolean flag;
		ArrayList<String> types=new ArrayList<String>();

		for(int i=0;i<arraylist.size();i++) {
			flag=false;
			for(int j=0;j<types.size();j++) {
				if(types.get(j).equals(arraylist.get(i).getCardName())) {
					flag=true;
				}
			}
			if(flag==false) {
				types.add(arraylist.get(i).getCardName());
				num++;
			}
		}

		return num;
	}
	
	/**
	 * This method draws a card from draw pile
	 * pre-none
	 * post-One card is draw from draw pile
	 * @return
	 */
	public Card draw() {
		try {
			Card card=arraylist.get(arraylist.size()-1);
			arraylist.remove(arraylist.size()-1);
			return card;
		}catch(Exception e) {
			Card card=null;
			return card;
		}
	}
}
