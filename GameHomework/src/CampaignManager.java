
public class CampaignManager {
	
	public void addCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyam�z ba�lam��t�r, ka��rmay�n!");
	}
	
	public void deleteCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyam�z bitmi�tir, yeni kampanyalar i�in takipte kal�n");
	}
	
	public void updateCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyam�z g�ncellenmi�tir");
	}

}
