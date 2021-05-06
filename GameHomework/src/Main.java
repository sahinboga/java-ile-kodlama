
public class Main {

	public static void main(String[] args) {
		
		Game game1=new Game(1,"Sniper","2$");
		Game game2=new Game(2,"Hyper","3$");
		Game game3=new Game(3,"Death Warrior","4$");
		Game game4=new Game(4,"Lethal Animal","5$");
		
		Player player1=new Player("10173332202","Þahin","Boða","01/01/2000");
		Player player2=new Player("10207774433","Yasin","Torun","01/04/1998");
		Player player3=new Player("120143332253","Mutlu","Azar","01/01/2000");
		Player player4=new Player();
		player4.setFirstName("Engin");
		
		Campaign campaign1=new Campaign(1,"Kara Cuma");
		Campaign campaign2=new Campaign(2,"Yýlbaþý");
		Campaign campaign3=new Campaign(3,"Büyük Yaz Ýndirimi");
		
		UserCheckManager userCM=new UserCheckManager();
		userCM.Authentication(player1);
		
		GameSaleManager gSM=new GameSaleManager();
		gSM.kampanyaliSatis(game4, player3, campaign3);
		
		CampaignManager campaignManager=new CampaignManager();
		campaignManager.deleteCampaign(campaign3);
		campaignManager.addCampaign(campaign2);
		campaignManager.updateCampaign(campaign1);
		
		userCM.changeIdInformation(player1,player4);
		
	}

}

