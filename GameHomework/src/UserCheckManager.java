
public class UserCheckManager {
	public boolean Authentication(Player player) {
		if(player.getIdentityNo()=="10173332202" && player.getFirstName()=="Þahin" && player.getLastName()=="Boða" &&
				player.getDateOfBirth()=="01/01/2000") {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void changeIdInformation(Player player1,Player player2) {
		System.out.println(player1.getFirstName()+" "+player1.getLastName()+" adlý üye adýný "+player2.getFirstName()+" olarak güncelledi");
	}
}
