
public class CampaignManager {
	
	public void addCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyamız başlamıştır, kaçırmayın!");
	}
	
	public void deleteCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyamız bitmiştir, yeni kampanyalar için takipte kalın");
	}
	
	public void updateCampaign(Campaign campaign) {
		System.out.println(campaign.getCampaignType()+" kampanyamız güncellenmiştir");
	}

}
