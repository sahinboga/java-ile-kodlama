
public class Game implements IEntity {
	
	private int gameId;
	private String gameName;
	private String gamePrice;
	
	public Game() {
		
	}
	
public Game(int gameId,String gameName,String gamePrice) {
		this.gameId=gameId;
		this.gameName=gameName;
		this.gamePrice=gamePrice;
	}

	public int getGameId() {
		return gameId;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public String getGamePrice() {
		return gamePrice;
	}
	
	public void setGamePrice(String gamePrice) {
		this.gamePrice = gamePrice;
	}
	

}
