package bohnanza;

public class Card {
	private String cardName;
	private int level1;
	private int level2;
	private int level3;
	private int level4;
	
	public Card(String cardName, int level1, int level2, int level3, int level4) {
		this.cardName=cardName;
		this.level1=level1;
		this.level2=level2;
		this.level3=level3;
		this.level4=level4;
	}
	
	public String getCardName() {
		return cardName;
	}
	
	public void setCardName(String cardName) {
		this.cardName=cardName;
	}
	
	public int getLevel1() {
		return level1;
	}
	
	public void setCardName(int level1) {
		this.level1=level1;
	}
	
	public int getLevel2() {
		return level2;
	}
	
	public void setLevel2(int level2) {
		this.level2=level2;
	}
	
	public int getLevel3() {
		return level3;
	}
	
	public void setlLevel3(int level3) {
		this.level3=level3;
	}
	
	public int getLevel4() {
		return level4;
	}
	
	public void setlLevel4(int level4) {
		this.level4=level4;
	}
}
