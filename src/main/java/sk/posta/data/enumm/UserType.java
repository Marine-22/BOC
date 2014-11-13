package sk.posta.data.enumm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sk.posta.boc.HomeController;

public enum UserType {
	ADMIN,
	USER,
	SUPER_USER;

	
	private static final Logger logger = LoggerFactory.getLogger(UserType.class.getName());
	
	static Map<UserType, Set<Permissions>> permap;
	
	static{
		permap = new HashMap<UserType, Set<Permissions>>();
		// ADMIN PERMISSIONS
		Set<Permissions> s = new HashSet<Permissions>();
		s.add(Permissions.ADD_USER);
		s.add(Permissions.ADMIN_VIEW);
		s.add(Permissions.SEARCH_USERS);
		s.add(Permissions.UPDATE_USER);
		permap.put(ADMIN, s);
		// USER PERMISSIONS
		s = new HashSet<Permissions>();
		s.add(Permissions.ADD_PREDPIS);
		s.add(Permissions.GET_SLUZBA);
		s.add(Permissions.GET_URAD);
		s.add(Permissions.SEARCH_MY_PREDPIS);
		s.add(Permissions.SEARCH_SLUZBA);
		s.add(Permissions.SEARCH_URAD);
		s.add(Permissions.UPDATE_PASS);
		s.add(Permissions.USER_VIEW);
		permap.put(USER, s);
		// SUPER_USER PERMISSIONS		
		s = new HashSet<Permissions>();
		s.add(Permissions.ADD_PREDPIS);
		s.add(Permissions.GET_SLUZBA);
		s.add(Permissions.GET_URAD);
		s.add(Permissions.SEARCH_ALL_PREDPIS);
		s.add(Permissions.SEARCH_SLUZBA);
		s.add(Permissions.SEARCH_URAD);
		s.add(Permissions.UPDATE_PASS);
		s.add(Permissions.USER_VIEW);
		permap.put(SUPER_USER, s);
	}
	
	public static boolean checkPermission(Object userType, Permissions p){
		if(!(userType instanceof UserType)) return false;
		return permap.get((userType)).contains(p);
	}
	
	
	public static boolean checkPermission(Object userType, String methodName){
		for(Permissions p : Permissions.get(methodName)){
			if(checkPermission(userType, p)) return true;
		}
		return false;
	}
}


