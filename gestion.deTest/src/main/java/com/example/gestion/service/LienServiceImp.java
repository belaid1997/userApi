package com.example.gestion.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.gestion.entity.Lien;
import com.example.gestion.entity.TestRapport;
import com.example.gestion.repository.LienRepository;
import com.example.gestion.repository.TestRepository;






@Service

public class LienServiceImp implements LienService{
	
	
	@Autowired
	LienRepository lienrepository;
	@Autowired
	TestRepository testRepository;

	@Override
	public Lien saveLien(Lien lien) {
		// TODO Auto-generated method stub
		return lienrepository.save(lien);
	}

	@Override
	public List<Lien> listLien() {
		// TODO Auto-generated method stub
		return lienrepository.findAll();
	}

	@Override
	public Optional<Lien> findLienbyId(Long id) {
		// TODO Auto-generated method stub
		return lienrepository.findById(id);
	}

	@Override
	public Lien updatLien(Lien c) {
		// TODO Auto-generated method stub
		return lienrepository.save(c);
	}

	@Override
	public void deleteLien(Long id) {
		// TODO Auto-generated method stub
		this.lienrepository.deleteById(id);
	}
	
	@Override
	public Lien loadlienbyUrl(String lien) {
		// TODO Auto-generated method stub
		return lienrepository.findByUrl(lien);
	}
////////////******************************
	////////////partie test des lien
////////////******************************
////////////partie TestRapport des lien
	///// le test est just pour un lien



public static int hhttpcode(String site) throws IOException {
	try {
URL url = new URL(site);
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setRequestMethod("GET");
connection.connect();

int code = connection.getResponseCode();
return code;
	}catch (Exception e)
	{return 0;}

}



@Override

public String lancerTestRapport(Lien lien) throws IOException {
//TODO Auto-generated method stub


String msg="";
String type=lien.getTestType();


if(type.equals("repense")){
 int k=hhttpcode(lien.getUrl());
    if(k>199&k<300) {
    	msg="up";
    	return msg;
    }else { 
    	msg= "down";
    	return msg;
 }
}
else if(type.equals("loop")) {
	
	
     // TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\b.bouaoualten\\\\Downloads\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	

       

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            try {
            driver.get(lien.getUrl());
            
            
     
          //  WebElement username = driver.findElement(By.id("so_username"));
            String e=(lien.getLoopTest().getElement().getIdlocator()).toString();
            
            
          
            

           
            if (!driver.findElements(By.id(e)).isEmpty()) {
            	driver.close();
               return "test passed";
              } else {
            	  driver.close();
            	 
            	 return "test failed";
            
	

    

              }

	}catch (Exception e)
	{
		driver.close();
		return "dozn";
		}

 
}
else {
	
	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\b.bouaoualten\\\\Downloads\\\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        try {
        driver.get(lien.getUrl());
        
        
        String username1=lien.getAuthantificationTest().getUsername().getIdlocator();
        String value1=lien.getAuthantificationTest().getUsername().getValue();
        String pass=lien.getAuthantificationTest().getPassword().getIdlocator();
        String value2=lien.getAuthantificationTest().getPassword().getValue();
        String button=lien.getAuthantificationTest().getBotton().getIdlocator();
 
        WebElement username = driver.findElement(By.id(username1));
        WebElement password = driver.findElement(By.id(pass));
        WebElement login = driver.findElement(By.id(button));

        username.sendKeys(value1);
        password.sendKeys(value2);
        login.click();

        String actualUrl = lien.getAuthantificationTest().getSiterepense();
        String expectedUrl = driver.getCurrentUrl();
        driver.close();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
        	
        	
        	msg="up";
        	return msg;
			 
            
          } else {
        	  msg="down";
        	  return msg;
 			 
         

        }
	}catch (Exception e)
	{
		driver.close();
		return "dozn";}

    
}





}
//////////// lancer test globale

@Override
public Hashtable<Long, String> lancerTest() throws IOException {
	// TODO Auto-generated method stub
	Hashtable<Long, String> my_dict = new Hashtable<Long, String>();
	List<Lien> lien;
	long millis=System.currentTimeMillis();  
    java.sql.Date date=new java.sql.Date(millis);
	lien=lienrepository.findAll();
	for (Lien temp : lien) {
		my_dict.put(temp.getId(),lancerTestRapport(temp));
		TestRapport rapp=new TestRapport(temp,lancerTestRapport(temp),date);
		testRepository.save(rapp);
	}

	
	return my_dict;
}



		
		
		
		
		

}
