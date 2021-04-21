package com.example.gestion.entity;

import org.openqa.selenium.remote.RemoteWebDriver;

public class A {
	  
	    public String url = "https://www.lambdatest.com/";
	    public static final String  username= "naroto1997.bb";
	    public static final String auth_key = "zUymhCJ2sIJWHyIsyuV9mXNiwGh5uYwqdmrNoHWVTSW5bN5VG9";
	    public static final String URL = "@hub.lambdatest.com/wd/hub";
	    
		
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		
		public static String getUsername() {
			return username;
		}
		public static String getAuthKey() {
			return auth_key;
		}
		public static String getUrls() {
			return URL;
		}
	    

}
