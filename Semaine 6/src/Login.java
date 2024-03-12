public class Login {
   
 	private String login;
	
 	public Login(String login)throws IllegalArgumentException{
		if(login==null || login.length() != 7 || (!login.substring(0,4).equals("info")&&
				!login.substring(0,4).equals("mark")&&!login.substring(0,4).equals("admi")))
			throw new IllegalArgumentException("login incorrect");
		this.login = login;
	}

	public String toString(){
		return "/n"+login +"   "+login;
	}

	// renvoie un entier >= 0
	// cet entier represente de façon unique le login courant!
	public int hashCode(){
		if (login.substring(0,4).equals("info")) {
			if (Integer.parseInt(login.substring(4, 7)) > 137)
				throw new IllegalArgumentException();
			return Integer.parseInt(login.substring(4, 7)) - 1;
		}
		if (login.substring(0,4).equals("mark")) {
			if (Integer.parseInt(login.substring(4, 7)) > 73)
				throw new IllegalArgumentException();
			return Integer.parseInt(login.substring(4, 7)) + 136;
		}
		return Integer.parseInt(login.substring(4,7))+209;
	}
	
}

