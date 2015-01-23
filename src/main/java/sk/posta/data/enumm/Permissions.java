package sk.posta.data.enumm;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum Permissions {
	ADD_PREDPIS("addPredpis"),
	UPDATE_PASS("updatePass"),
	UPDATE_USER("updateUser"),
	ADD_USER("addUser"),
	USER_VIEW("user"),
	ADMIN_VIEW("superuser"),
	SEARCH_USERS("searchUsers"),
	SEARCH_MY_PREDPIS("searchPredpis"),
	SEARCH_ALL_PREDPIS("searchPredpis"),
	GET_URAD("getUrad"),
	SEARCH_URAD("searchUrad"),
	GET_SLUZBA("getSluzba"),
	SEARCH_SLUZBA("searchSluzba"),
	RESEND_PREDPIS("resendPredpis"),
	SYNC_ENUMS("syncEnums"),
	TEST_CONN("testConn"),
	PEP_REFRESH("pepRefresh"),
	GET_DEFAULT_SLUZBY("getDefaultSluzby");
	
	private String methodName;
	
	private static final Map<String, Set<Permissions>> lookup;
	
	static{
		lookup = new HashMap<String, Set<Permissions>>();
		for(Permissions p : EnumSet.allOf(Permissions.class)){
			if(lookup.containsKey(p.methodName)){
				Set<Permissions> s = lookup.get(p.methodName);
				s.add(p);
			}
			else{
				Set<Permissions> s = new HashSet<Permissions>();
				s.add(p);
				lookup.put(p.methodName, s);
			}
		}
	}
	
	private Permissions(String methodName){
		this.methodName = methodName;
	}
	
	public static Set<Permissions> get(String methodName){
		if(lookup.containsKey(methodName)){
			return lookup.get(methodName);
		}
		return null;
	}
}
