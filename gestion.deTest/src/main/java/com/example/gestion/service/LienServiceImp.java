package com.example.gestion.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
	private static final int MYTHREADS = 3;
	
	
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
            String a=(lien.getLoopTest().getElement().getIdlocator()).toString();
            String b=lien.getLoopTest().getElement().getCssSelector();
            
            
            
          
            

           
            if (!driver.findElements(By.id(a)).isEmpty()) {
            	driver.close();
               msg="test passed";
              }
            else if(!driver.findElements(By.cssSelector(b)).isEmpty()) {
            	driver.close();
                msg="test passed";
            }
            else if(!driver.findElements(By.name(lien.getLoopTest().getElement().getNamelocator())).isEmpty()) {
            	driver.close();
                msg="test passed";
            }
            else if(!driver.findElements(By.tagName(lien.getLoopTest().getElement().getTagenamelocator())).isEmpty()) {
            	driver.close();
                msg="test passed";
            }
            else if(!driver.findElements(By.name(lien.getLoopTest().getElement().getNamelocator())).isEmpty()) {
            	driver.close();
                msg="test passed";
            }else if(!driver.findElements(By.name(lien.getLoopTest().getElement().getXpath())).isEmpty()) {
            	driver.close();
                msg="test passed";
            }
            else {
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
        String value1=lien.getAuthantificationTest().getUsername().getValue();
        String value2=lien.getAuthantificationTest().getPassword().getValue();
        /////partie username
        if(lien.getAuthantificationTest().getUsername().getIdlocator()!=null ) {
        String username1=lien.getAuthantificationTest().getUsername().getIdlocator();
        WebElement username = driver.findElement(By.id(username1));
        username.sendKeys(value1);
        }
        else if(lien.getAuthantificationTest().getUsername().getCssSelector()!=null) {
        	 String username1=lien.getAuthantificationTest().getUsername().getCssSelector();
             WebElement username = driver.findElement(By.cssSelector(username1));
             username.sendKeys(value1);
        }
        else if(lien.getAuthantificationTest().getUsername().getNamelocator()!=null) {
       	 String username1=lien.getAuthantificationTest().getUsername().getNamelocator();
            WebElement username = driver.findElement(By.name(username1));
            username.sendKeys(value1);
       }
        else if(lien.getAuthantificationTest().getUsername().getTagenamelocator()!=null) {
          	 String username1=lien.getAuthantificationTest().getUsername().getTagenamelocator();
               WebElement username = driver.findElement(By.tagName(username1));
               username.sendKeys(value1);
          }
        else {
        	 String username1=lien.getAuthantificationTest().getUsername().getXpath();
             WebElement username = driver.findElement(By.xpath(username1));
             username.sendKeys(value1);
        }
        /////partie password
          if(lien.getAuthantificationTest().getPassword().getIdlocator()!=null ) {
        	  String pass=lien.getAuthantificationTest().getPassword().getIdlocator();
              WebElement password = driver.findElement(By.id(pass));
              password.sendKeys(value2);            }
            else if(lien.getAuthantificationTest().getPassword().getCssSelector()!=null) {
            	String pass=lien.getAuthantificationTest().getPassword().getCssSelector();
                 WebElement password = driver.findElement(By.cssSelector(pass));
                 password.sendKeys(value2);            }
            else if(lien.getAuthantificationTest().getPassword().getNamelocator()!=null) {
            	String pass=lien.getAuthantificationTest().getPassword().getNamelocator();
                WebElement password = driver.findElement(By.name(pass));
                password.sendKeys(value2);           }
            else if(lien.getAuthantificationTest().getPassword().getTagenamelocator()!=null) {
            	String pass=lien.getAuthantificationTest().getPassword().getTagenamelocator();
                   WebElement password = driver.findElement(By.tagName(pass));
                   password.sendKeys(value2);              }
            else {
            	String pass=lien.getAuthantificationTest().getPassword().getXpath();
                 WebElement password = driver.findElement(By.xpath(pass));
                 password.sendKeys(value2);
            }
          //////partie button
          if(lien.getAuthantificationTest().getBotton().getIdlocator()!=null ) {
        	  String button=lien.getAuthantificationTest().getBotton().getIdlocator();
              WebElement login = driver.findElement(By.id(button));
              login.click();            }
            else if(lien.getAuthantificationTest().getBotton().getCssSelector()!=null) {
            	 String button=lien.getAuthantificationTest().getBotton().getCssSelector();
                 WebElement login = driver.findElement(By.cssSelector(button));
                 login.click();            }
            else if(lien.getAuthantificationTest().getBotton().getNamelocator()!=null) {
            	 String button=lien.getAuthantificationTest().getBotton().getNamelocator();
                WebElement login = driver.findElement(By.name(button));
                login.click();           }
            else if(lien.getAuthantificationTest().getBotton().getTagenamelocator()!=null) {
            	 String button=lien.getAuthantificationTest().getBotton().getTagenamelocator();
                   WebElement login = driver.findElement(By.tagName(button));
                   login.click();
                   }
            else {
            	 String button=lien.getAuthantificationTest().getBotton().getXpath();
                 WebElement login = driver.findElement(By.xpath(button));
                 login.click();
                 }
        
        
        

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
@Scheduled(cron = "0 51 09 * * ?")
@Scheduled(cron = "0 54 09 * * ?")
public Hashtable<Long, String> lancerTest() throws IOException {
	// TODO Auto-generated method stub
	Hashtable<Long, String> my_dict = new Hashtable<Long, String>();
	List<Lien> lien;
	
	lien=lienrepository.findAll();
	for (Lien temp : lien) {
		String k=lancerTestRapport(temp);
		my_dict.put(temp.getId(),k);
		
	}

	
	return my_dict;
}
///////////////lancer test with multitread
public String lancerTestMultiThread() throws IOException,Exception {
	ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
	Hashtable<Long, String> my_dict = new Hashtable<Long, String>();
	List<Lien> lien;
	
	lien=lienrepository.findAll();
	for (Lien temp : lien) {
		Runnable worker = new MyRunnable(temp);
		
	

		executor.execute(worker);
		
		
	}
	executor.shutdown();
	// Wait until all threads are finish
	while (!executor.isTerminated()) {

	}
	return "test done";
	
	
}




//////////////////////////////////another  try


		
		
		

}
