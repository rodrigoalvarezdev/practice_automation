package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviderDemo {
	@DataProvider
	  public Object[][] dataSet() {
		  Object[][] dataset = new Object[4][4];
		  
		  dataset[0][0]="user1";
		  dataset[0][1]="mail1@mail.com";
		  dataset[0][2]="dir1";
		  dataset[0][3]="bar1";
		  
		  dataset[1][0]="user2";
		  dataset[1][1]="mail2@mail.com";
		  dataset[1][2]="dir2";
		  dataset[1][3]="bar2";
		  
		  dataset[2][0]="user2";
		  dataset[2][1]="mail2@mail.com";
		  dataset[2][2]="dir2";
		  dataset[2][3]="bar2";
		  
		  dataset[3][0]="user3";
		  dataset[3][1]="mail3@mail.com";
		  dataset[3][2]="dir3";
		  dataset[3][3]="bar3";
		  
		  return dataset;
	  }
}
