package murtiff.assign1.salebin;

//In order to use the class methods and decelerations of USMoney outside of its
//package we have to import it into this java file.
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan Murtiff
 *
 */
public class SmartBin extends Bin {

	private String label;
	
	//In this case we cannot share the binCounter data members from the Bin class so
	//instead we need to create a new static variable that we can use.
	private static int smartBinCounter = 0;
	
	/*
	* The default constructor for the SmartBin class which creates
	* an array of ItemType objects of length 10 (I decided on this 
	* value as the testing requires at least 5 Items per Bin or SmartBin)
	* as well as initializes the length of the items array to 0 (since 
	* there are no SaleItems in the array yet) and we generate a binNumber
	* using the letters "SM" along with the output of the generateBinNumber()
	* function. Finally, for the label String I have decided to initialize the value
	* to an empty string ("") as the only time that we change the label is when we 
	* add a fragile SaleItem to the items array.
	*/
	public SmartBin()
	{
		items = new ItemType [10];
		currentItemsLength = 0;
		binNumber = "SM" + generateBinNumber();
		label = "";
	}
	
	/*
	* This function has been overridden in order to use the new 
	* static variable for the SmartBin class. It is exactly the 
	* same logic as in the Bin class except we are using the 
	* new static variable.
	*/
	public static int generateBinNumber() 
	{
		smartBinCounter = smartBinCounter + 1;
		return smartBinCounter;
	}
	
	/**
	* This function is a setter that takes in a string and sets
	* the label instance data member to the passed string.
	*/
	public void setLabel(String label)
	{
		this.label = label;
	}
	
	/*
	* This function takes in a SaleItem as an argument and adds it to 
	* the items array if the weight of the new SaleItem does not cause the SmartBin
	* to go over the value of maxWeight (which is set to 
	* a value of 10.0). If the SaleItem is fragile then we change
	* the label of the SmartBin to the message ""Fragile - Handle with Care".
	* If the SaleItem meets the maxWeight requirement then we add it to the array at 
	* index currentItemsLength and we increment currentItemsLength to make ready 
	* for the next SaleItem that we are going to add to the items array.
	*/
	public void addItem(ItemType item)
	{
		if(item.getWeight() + getWeight() <= maxWeight)
		{
			items[currentItemsLength] = item;
			currentItemsLength = currentItemsLength + 1;
			if(item.isFragile())
			{
				setLabel("Fragile - Handle with Care");
			}
		}
	}
	
	/*
	* This function returns a USMoney object that is the total
	* cost of all SaleItems within the items array.
	* The function utilizes a for loop in order to 
	* access each item in the items array and calls 
	* the getPrice() function from the SaleItem class
	* in order to grab the price and add it to the 
	* totalPrice object via the add() function.
	* The value for currentItemsLength will always be the 
	* total number of SaleItems in our item array. In this case
	* the assignment also specifies that we add on $100 extra at the
	* end in order to compensate for the cost of the SmartBin itself as
	* well as add $10 for each fragile item in the items array.
	* 
	* The assignment specifies that we need to print out 
	* the "total Cost of Items" in the showDetails() function, 
	* and as such I interpreted this total cost of items to
	* include all SaleItems in the items array as well as the
	* cost of the SmartBin and the extra fee tacked on for fragile
	* SaleItems.
	*/
	public USMoney calculatePrice()
	{
		USMoney totalPrice = new USMoney(0,0);
		for (int i = 0; i < currentItemsLength; i++)
		{
			totalPrice = totalPrice.add(items[i].getPrice());
			if(items[i].isFragile())
			{
				totalPrice.addTo(10, 0);
			}
		}
		totalPrice.addTo(100,0);
		return totalPrice;
	}
	
	/*
	* This function has been overridden for the SmartBin class. 
	* This function returns a concatenated string with the binNumber
	* followed by a "," followed by the SmartBin label followed by the total 
	* weight of the Bin and a "," and concluded with the total price of 
	* the Bin (including the $100 added on for the cost of the SmartBin itself
	* as well as any extra fees due to fragile SaleItems).
	*/
	public String showDetails()
	{
		return binNumber + "," + label + "," + getWeight() + "," + calculatePrice();
	}
		
}
