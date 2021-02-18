package entities;

public class AppConstants {


	
	public static final String SESSION_USER = "user";

	public static final String PREFIX = "/pages/";

	public static final String HOME_PAGE = PREFIX + "user-list.jsp";
	
	public static final String REDIRECT_HOME_PAGE = PREFIX + "user-list.jsp";

	public static final String LOGIN_PAGE = PREFIX + "login.jsp";
	
	public static final String LOGOUT_PAGE = PREFIX + "user-list.jsp";

	public static final String CREATE_USER_PAGE = PREFIX + "user-edit.jsp";

	public static final String ERROR_PAGE = PREFIX + "/error.jsp";
	
	public static final String LOGIN_ERROR = "Bad credentials";

	public static final String ACTION_CREATE = "c";
	
	public static final String ACTION_RETRIEVE = "r";
	
	public static final String ACTION_UPDATE = "u";

	public static final String ACTION_DELETE = "d";

	
}
