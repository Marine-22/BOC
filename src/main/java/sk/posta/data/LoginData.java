package sk.posta.data;

/**
 * Data container for login form
 * @author fmo
 *
 */
public class LoginData {
	private String login;
	private String pass;

	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toString(){
		return "LoginData["+login+":"+pass+"]";
	}
}
