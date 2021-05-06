
public class Campaign implements IEntity {
	private int campaignId;
	private String campaignType;
	
	public Campaign() {}
	
	public Campaign(int campaignId,String campaignType) {
		this.campaignId=campaignId;
		this.campaignType=campaignType;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignType() {
		return campaignType;
	}

	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}
}
