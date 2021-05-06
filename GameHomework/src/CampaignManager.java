
public class CampaignManager {
	
	public void addCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyamýz baþlamýþtýr, kaçýrmayýn!");
	}
	
	public void deleteCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyamýz bitmiþtir, yeni kampanyalar için takipte kalýn");
	}
	
	public void updateCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyamýz güncellenmiþtir");
	}

}
