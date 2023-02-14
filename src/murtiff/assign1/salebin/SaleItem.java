package murtiff.assign1.salebin;

//In order to use the class methods and decelerations of USMoney outside of its
//package we have to import it into this java file.
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan Murtiff
 *
 */
public class SaleItem implements ItemType{

	/*
	* The four instance data members of the SaleItem class: itemName,
	* price, weight, and fragile. 
	*/
	private String itemName;
	
	private USMoney price;
	
	private double weight;
	
	private boolean fragile;
	
	/*
	* This function is a parameterized constructor that takes four parameters 
	* (itemName, price, weight, and fragile) and initializes the corresponding data members.
	* These values are set and cannot be changed later (since we have no setter methods for 
	* these data members). 
	*/
	public SaleItem(String itemName, USMoney price, double weight, boolean fragile) 
	{
		this.itemName = itemName;
		this.price = price;
		this.weight = weight;
		this.fragile = fragile;
	}
	
	/*
	* This function is a getter that returns the boolean of whether 
	* or not a given SaleItem is fragile or not. If an item is fragile
	* then it means that we cannot put it inside of the items array 
	* of Bin objects, however, we can put it inside of the items array of
	* SmartBin objects (given that the SaleItem does not go over the maximum
	* weight of the SmartBin). 
	*/
	public Boolean isFragile()
	{
		return fragile;
	}
	
	/*
	* This function is a getter that returns the price of a SaleItem
	* as a USMoney object.
	*/ 
	public USMoney getPrice()
	{
		return price;
	}
	
	/**
	* This function is a getter that returns the weight of a SaleItem
	* as a double.
	*/
	public double getWeight() 
	{
		return weight;
		
	}
	
	/**
	* This function returns a concatenated string with the name of
	* the SaleItem followed by a "," and the price of the SaleItem.
	*/
	public String getDetails()
	{
		return itemName + "," + price;
	}
	
}
