package web.auth;

public interface AuthenicationService {
	boolean isValidLogin(String username,String password);
}
