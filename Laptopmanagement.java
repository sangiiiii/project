package project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * In this program we have created laptopmanagement for managing laptops 
 *for easy access and control
 *We have added some attributes like brandname,modelnumber,price,storage,colour,edition
 */

public class Laptopmanagement {

	/*
	 * We have set attributes as Private for accessing within the same class or body 
	 *For most restricted access
	 */

	private String brandName;
	private int modelNumber;
	private int price;
	private String storage;
	private String colour;
	private String edition;
	
	/*We have created list to add laptop details
	 * ArrayList implements list interface
	 * methods-->add,remove,set,get
	 */ 
	
	//Runtime polymorphism
	List <Laptopmanagement> productlist = new ArrayList<Laptopmanagement>();
	
	//We have set Scanner as private access modifier 
	private static Scanner scan = new Scanner(System.in);  
/*
 *To display the menu to the user
 *Laptopmanagement() no argument constructor is defined 
 */
	public Laptopmanagement() {   // no argument constructor
		System.out.println("   LAPTOP MANAGEMENT  ");
		System.out.println("1. Add a Laptop");
		System.out.println("2. Display all Number of laptop");
		System.out.println("3. search an Modelnumber");
		System.out.println("4. Delete an Soldgoods");
		System.out.println("5. update an Newstock");

	}
	/*
	 * laptopmanagement(brandname,modelnumber,price,storage,colour,edition) parameterized constructor is defined
	 * We are having same methods and attributes so this keyword is used
	 */
	public Laptopmanagement(String brandName,int modelNumber,int price,String storage,String colour,String edition){        
		this.brandName=brandName;      
		this.modelNumber=modelNumber;
		this.price=price;
		this.storage=storage;
		this.colour=colour;
		this.edition=edition;
	}
	/* Encapsulation using getter and setter method
	 * Getter method to get the values
	 * Setter method to put the values
    */
	public String getBrandName() {    
		return brandName;
	}
	public void setBrandname(String brandName) {   
		this.brandName=brandName;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber=modelNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage=storage;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour=colour;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition=edition;
	}

	// override from parent class to child class

	public String toString() {
		return brandName+" "+modelNumber+" "+price+" "+storage+" "+colour+" "+edition;
	}
	
	/*
	 * To add all the laptop details in this method
	 * If there is any new stock 
	 * productlist.add - to add parameters to the classname
	 */
	
	public void toAdd() {
		System.out.print("Enter Brandname:");
		String brandName = scan.next();
		System.out.print("Enter Modelnumber:");
		int modelNumber = scan.nextInt();
		System.out.print("Enter price:");
		int price = scan.nextInt();
		System.out.print("Enter a Storage:");
		String storage = scan.next();
		System.out.print("Enter colour: ");
		String colour = scan.next();
		System.out.print("Enter Edition: ");
		String edition = scan.next();
		productlist.add(new Laptopmanagement(brandName,modelNumber,price,storage,colour,edition)); // to store added input

	}
	
	/*
	 * To display all the added details to the user with the help of iterator
	 * Iterator is used like a loop in list 
	 */
	
	public void toDisplay() {
		Iterator<Laptopmanagement> products = productlist.iterator(); 
		while(products.hasNext()) {
			System.out.println(products.next());
		}
	}
	
	/*
	 * To search present items in the laptopmanagement
	 * We set unique id as model id to search the present items
	 * if the id is present it display as product found
	 * if the id is not present it display as product not found 
	 */
	
	public void toSearch(Laptopmanagement obj) {
		boolean flag = false;
		System.out.println("Enter a Model Number to Search");
		int modelId = scan.nextInt();
		Iterator<Laptopmanagement> stock = productlist.iterator();
		while(stock.hasNext()) {
			obj = stock.next();
			if(obj.getModelNumber()==modelId) {
				flag = true;
				System.out.println("Product found");
				toDisplay();
				break;
			}

		}
		if(flag==false) {
			System.out.println("Product not found");
		}
	}
	
	/*
	 * To delete present items in the laptopmanagement
	 * We set unique id as model id to delete the present items
	 * if the id is present it display as removed successfully
	 * if the id is not present it display as product out of stock 
	 */
	
	public void toDelete(Laptopmanagement obj1) {
		boolean delflag = false;
		System.out.println("Enter modelnumber to delete ");
		int modelid1=scan.nextInt();
		Iterator<Laptopmanagement> stock1 = productlist.iterator();
		while(stock1.hasNext()) {
			obj1 = stock1.next();
			if(obj1.getModelNumber()== modelid1) {
				delflag = true;
				productlist.remove(obj1);
				System.out.println("Removed successfully");
				toDisplay();
				break;

			}
		}
		if(delflag== false) {
			System.out.println("Product out of Stock");

		}
	}
	
	/*
	 * To update  items in the laptopmanagement
	 * We set unique id as model id to update items in the already presented item
	 * if the id is present it will update and display us updated successfully
	 * if the id is not present it display as product not found
	 */
	
	public void toUpdate(Laptopmanagement obj2) {
		boolean updateflag = false;
		System.out.println("Enter modelnumber to be updated");
		int modelidUpdate = scan.nextInt();
		Iterator<Laptopmanagement> stock2 = productlist.iterator();
		int ctr = -1;
		while(stock2.hasNext()) {
			obj2 = stock2.next();  
			ctr++;
			if(obj2.getModelNumber() == modelidUpdate) {
				updateflag = true;
				System.out.println("Enter updated Brandname");
				String brandname = scan.next();
				System.out.println("Enter updated Price ");
				int price1 = scan.nextInt();
				System.out.println("Enter updated Storage");
				String updatedStorage = scan.next();
				System.out.println("Enter updated colour");
				String updatedColour = scan.next();
				System.out.println("Enter updated edition");
				String updatedEdition = scan.next();
				productlist.set(ctr,new Laptopmanagement( brandname,modelidUpdate,price1,updatedStorage,updatedColour,updatedEdition));					
				toDisplay();
				System.out.println("Updated Successfully");
				break;
			}
		}
		if(updateflag == false) {
			System.out.println("Product not found");
		}


	}
}
