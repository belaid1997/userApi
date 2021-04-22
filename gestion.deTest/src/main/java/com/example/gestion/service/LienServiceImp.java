package com.example.gestion.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
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

import com.example.gestion.entity.Archive;
import com.example.gestion.entity.Lien;
import com.example.gestion.entity.TestRapport;
import com.example.gestion.repository.ApplicationsRepository;
import com.example.gestion.repository.ArchiveRepository;
import com.example.gestion.repository.LienRepository;
import com.example.gestion.repository.TestRepository;






@Service

public class LienServiceImp implements LienService{
	
	
	@Autowired
	LienRepository lienrepository;
	@Autowired
	TestRepository testRepository;
	@Autowired
	ArchiveRepository archiverepo;
	@Autowired
	ApplicationsRepository apprepo;

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
long millis=System.currentTimeMillis();  
java.sql.Date date=new java.sql.Date(millis);
Time sqlTime = new Time(millis);


if(type.equals("repense")){
 int k=hhttpcode(lien.getUrl());
    if(k>199&k<300) {
    	msg="up";
    	
    }else { 
    	msg="down";
    	
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
               msg="test passed";
              } else {
            	  driver.close();
            	 
            	 msg="test failed";
            
	

    

              }

	}catch (Exception e)
	{
		driver.close();
		msg="dozn";
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
        	
			 
            
          } else {
        	  msg="down";
        	  
 			 
         

        }
	}catch (Exception e)
	{
		driver.close();
		 msg="dozn";}

    
}

//// enregistrer dans larchive
Archive k=new Archive();
k.setStatus(msg);
k.setUrl(lien.getUrl());
k.setTestType(lien.getTestType());
k.setDate_test(date);
k.setTime_test(sqlTime);
k.setApplicationName(apprepo.findById(lien.getApplication()).get().getApplicationName());
k.setDateAjoute(apprepo.findById(lien.getApplication()).get().getDateAjoute());
archiverepo.save(k);
/// enregistrer le test
TestRapport rapp=new TestRapport(lien,msg,date,sqlTime);
testRepository.save(rapp);


return msg;





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
		String k=lancerTestRapport(temp);
		my_dict.put(temp.getId(),k);
		
	}

	
	return my_dict;
}



		
		
		
		
		

}
