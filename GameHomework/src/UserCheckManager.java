
public class UserCheckManager {
	public boolean Authentication(Player player) {
		if(player.getIdentityNo()=="10173332202" && player.getFirstName()=="�ahin" && player.getLastName()=="Bo�a" &&
				player.getDateOfBirth()=="01/01/2000") {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void changeIdInformation(Player player1,Player player2) {
		System.out.println(player1.getFirstName()+" "+player1.getLastName()+" adl� �ye ad�n� "+player2.getFirstName()+" olarak g�ncelledi");
	}
}
