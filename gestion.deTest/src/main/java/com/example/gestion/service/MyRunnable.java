package com.example.gestion.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestion.entity.Archive;
import com.example.gestion.entity.Lien;
import com.example.gestion.entity.TestRapport;
import com.example.gestion.repository.ApplicationsRepository;
import com.example.gestion.repository.ArchiveRepository;


//@Component
public class MyRunnable implements Runnable {
	@Autowired
	private final Lien lien;
	public static String message="";
	

	@Autowired
	LienService lienrepository;
	@Autowired
	@Resource
	TestService testRepository;
	@Autowired
	ArchiveRepository archiverepo;
	@Autowired
	ApplicationsRepository apprepo;
	MyRunnable(Lien url) {
		
		this.lien = url;
	}
	
	
	public static int hhttpcode(String site) throws IOException {
		try {
	URL url = new URL(site);
	HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	connection.setRequestMethod("GET");
	connection.connect();

	int code = connection.getResponseCode();
	return code;
		}catch (Exception e)
		{return 0;}}
	
	
	private String dotest() {
		// TODO Auto-generated method stub
				String msg="";
				String type=lien.getTestType();
				


				if(type.equals("repense")){
				 int k;
				try {
					URL url = new URL(lien.getUrl());
					HttpURLConnection connection = (HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.connect();
					k = connection.getResponseCode();
					 if(k>199&k<300) {
					    	msg="up";
					    	
					    }else { 
					    	msg="down";
					    	
					 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
				return msg;
	}



	@Transactional
	private void enregistrertest(String msg) {
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		Time sqlTime = new Time(millis);
		/// enregistrer le test
				TestRapport rapp=new TestRapport(lien,msg,date,sqlTime);
				testRepository.saveTest(rapp); 
		
	}


	@Override
	@PostConstruct
	
	public void run() {
		String msg=dotest();
		enregistrertest(msg);
	
		/*
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		Time sqlTime = new Time(millis);
	//// enregistrer dans larchive
	/*
		Archive k=new Archive();
		k.setStatus(msg);
		k.setUrl(lien.getUrl());
		k.setTestType(lien.getTestType());
		k.setDate_test(date);
		k.setTime_test(sqlTime);
		k.setApplicationName(apprepo.findById(lien.getApplication()).get().getApplicationName());
		k.setDateAjoute(apprepo.findById(lien.getApplication()).get().getDateAjoute());
		archiverepo.save(k);
		*/
		/*
		/// enregistrer le test
		TestRapport rapp=new TestRapport(lien,msg,date,sqlTime);
		testRepository.saveTest(rapp);   
	
		*/
	
	
		
}
	
	
	
	
	/*
	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis);
	Time sqlTime = new Time(millis);
////enregistrer dans larchive
	
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
		TestRapport rapp=new TestRapport(lien,message,date,sqlTime);
		testRepository.saveTest(rapp);
	*/

	
	
}

