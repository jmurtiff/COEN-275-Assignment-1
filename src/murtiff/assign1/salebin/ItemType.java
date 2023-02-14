package murtiff.assign1.salebin;

//In order to use the class methods and decelerations of USMoney outside of its
//package we have to import it into this java file.
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan Murtiff
 *
 */

/*
 * This abstract class defines abstract methods that will be later
 * implemented in SaleItem.java.
 */
public interface ItemType {
	
	/*
	 * This function is going to be used to return a boolean value 
	 * whether or not an item is fragile.
	 */
	public Boolean isFragile();
		
	/*
	 * This function is going to be used to return the total price of
	 * an item as a USMoney object.
	 */
	public USMoney getPrice();
	
	//This function is going to be used to return the weight of an 
	//item as a double.
	
	/*
	 * This function is going to be used to return the weight of an 
	 * item as a double.
	 */
	public double getWeight();
	
	/*
	 * This function is going to return a string that is the concatenation of
	 * an item's name followed by a "," and then the price of the item.
	 */
	public String getDetails();

}
