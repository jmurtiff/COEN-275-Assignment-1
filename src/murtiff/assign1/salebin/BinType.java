package murtiff.assign1.salebin;

//In order to use the class methods of USMoney outside of its
//package we have to import it into this java file.
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan Murtiff
 *
 */

/**
 * This abstract class defines abstract methods that will be later
 * implemented in Bin.java.
 **/
public interface BinType {
	
	//This function is going to be used to add items (in this case SaleItems)
	//to an array of Items.
	public void addItem(ItemType item);
	
	//This function is going to be used to calculate and return the total price
	//of all items contained in a Bin along with the cost of the Bin 
	//itself (an extra $100 added on).
	public USMoney calculatePrice();
	
	//This function is going to be used to calculate and return the total weight
	//of all items contained in a Bin (value will be less than or equal
	//to the maximum weight of a Bin).
	public double getWeight();
	
	//This function is going to return the total number of items contained
	//within the items array (which contains all the SaleItems associated 
	//with a Bin).
	public int getNoOfItems();
	
	//This function is going to return a string that is the concatenation of
	//the Bin number followed by the current weight of the bin, and finally the total 
	//cost of all the items (including the added Bin fee).
	public String showDetails();

}
