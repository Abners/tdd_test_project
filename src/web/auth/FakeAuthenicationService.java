package web.auth;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author baoxing.peng
 *
 * @since 2015年8月25日上午9:33:10
 *
 * @version 1.0.0
 */
public class FakeAuthenicationService implements AuthenicationService{
	private Map<String,String> users = new HashMap<>();
	public void addUser(String user,String pass){
		users.put(user, pass);
	}
	@Override
	public boolean isValidLogin(String username, String password) {
		// TODO Auto-generated method stub
		return users.containsKey(username)&&password.equals(users.get(username));
	}

}
