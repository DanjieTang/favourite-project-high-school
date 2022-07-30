package bohnanza;

import java.util.ArrayList;

public class StartingDrawPile {
	private ArrayList<Card> cardpile=new ArrayList<Card>();
	private ArrayList<Card> drawpile=new ArrayList<Card>();
	
	public StartingDrawPile() {
		initializedPile();
		shuffleCards();
	}
	
	/**
	 * This method initial the card pile without shuffle
	 * pre-none
	 * post-The card pile is initialized
	 */
	public void initializedPile() {
		//Red Bean
		for(int i=0;i<8;i++) {
			Card redBean=new Card("Red Bean", 2, 3, 4, 5);
			cardpile.add(redBean);
		}
		
		//Black eyed bean
		for(int i=8;i<18;i++) {
			Card blackeyedBean=new Card("Black Eyed Bean", 2, 4, 5, 6);
			cardpile.add(blackeyedBean);
		}
		
		//Soy Bean
		for(int i=18;i<30;i++) {
			Card soyBean=new Card("Soy Bean", 2, 4, 6, 7);
			cardpile.add(soyBean);
		}
		
		//Grean Bean
		for(int i=30;i<44;i++) {
			Card greenBean=new Card("Grean Bean", 3, 5, 6, 7);
			cardpile.add(greenBean);
		}
		
		//Stink Bean
		for(int i=44;i<60;i++) {
			Card stinkBean=new Card("Stink Bean", 3, 5, 7, 8);
			cardpile.add(stinkBean);
		}
		
		//Chill Bean
		for(int i=60;i<78;i++) {
			Card chillBean=new Card("Chill Bean", 3, 6, 8, 9);
			cardpile.add(chillBean);
		}
		
		//Blue Bean
		for(int i=78;i<98;i++) {
			Card blueBean=new Card("Blue Bean", 4, 6, 8, 10);
			cardpile.add(blueBean);
		}
	}
	
	/**
	 * Shuffle the cards
	 * pre-none
	 * post-Suffle the cards
	 */
	public void shuffleCards() {
		int randomNum;
		boolean[] flag=new boolean[98];
		for(int i=0;i<98;i++) {
			flag[i]=true;
		}
		
		for(int i=0;i<98;i++) {
			do{
				randomNum=(int)((98)*Math.random());
				if(flag[randomNum]) {
					flag[randomNum]=false;
					drawpile.add(cardpile.get(randomNum));
					break;
				}
			}while(flag[randomNum]==false);
		}
	}
	
	/**
	 * This method returns the array list that stores the drawing pile
	 * pre-none
	 * post-The array list representing the drawing pile is returned
	 */
	public ArrayList<Card> getDrawingPile() {
		return drawpile;
	}
}
