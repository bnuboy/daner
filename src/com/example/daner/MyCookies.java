package com.example.daner;

import org.apache.http.client.CookieStore;

public class MyCookies {
	private static CookieStore cookies;  
    public static CookieStore getCookie(){   
        return cookies;
    }
    public static void setCookie(CookieStore cks){
        cookies = cks;
    }
}
