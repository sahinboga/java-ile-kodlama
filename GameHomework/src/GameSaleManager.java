
public class GameSaleManager {
	public void normalSatis(Game game,Player player) {
		System.out.println(game.getGameName()+" oyunu "+player.getFirstName()+" "+player.getLastName()+" taraf�ndan sat�n al�nm��t�r.");
	}
	
	public void kampanyaliSatis(Game game,Player player,Campaign campaign) {
		System.out.println(game.getGameName()+" oyunu "+player.getFirstName()+" "+player.getLastName()+" taraf�ndan "+campaign.getCampaignType()+" kampanyas� ile sat�n al�nm��t�r.");
	}
	
}
