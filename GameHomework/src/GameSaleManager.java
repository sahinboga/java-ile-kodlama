
public class GameSaleManager {
	public void normalSatis(Game game,Player player) {
		System.out.println(game.getGameName()+" oyunu "+player.getFirstName()+" "+player.getLastName()+" tarafýndan satýn alýnmýþtýr.");
	}
	
	public void kampanyaliSatis(Game game,Player player,Campaign campaign) {
		System.out.println(game.getGameName()+" oyunu "+player.getFirstName()+" "+player.getLastName()+" tarafýndan "+campaign.getCampaignType()+" kampanyasý ile satýn alýnmýþtýr.");
	}
	
}
