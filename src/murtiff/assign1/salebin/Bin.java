package murtiff.assign1.salebin;

//In order to use the class methods and decelerations of USMoney outside of its
//package we have to import it into this java file.
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan Murtiff
 *
 */
public class Bin implements BinType {
	
	/*
	* The three instance data members of the SaleItem class: binNumber,
	* items[], and currentItemsLength, along with the constant maxWeight,
	* and the class-level variable binCounter. All variables are protected
	* instead of private so that we can re-use these variables 
	* for the SmartBin class.
	*/
	
	protected String binNumber;
	
	protected ItemType items[];
	
	//This data member keeps track of the length of the items array
	//at all times and makes it easier to calculate the weight and 
	//price of a Bin object. The assignment specifies that I am 
	//free to add any extra data members as I see fit.
	protected int currentItemsLength;
	
	//maxWeight is a constant and its value should not change, so
	//we need to use the "final" keyword.
	protected static final double maxWeight = 10.0;
	
	protected static int binCounter = 0;
	
	/*
	* The default constructor for the Bin class which creates
	* an array of ItemType objects of length 10 (I decided on this 
	* value as the testing requires at least 5 Items per Bin or SmartBin)
	* as well as initializes the length of the items array to 0 (since 
	* there are no SaleItems in the array yet) and we generate a binNumber
	* using the letter "A" along with the output of the generateBinNumber()
	* function.
	*/
	public Bin()
	{
		items = new ItemType [10];
		currentItemsLength = 0;
		binNumber = "A" + generateBinNumber();
	}
	
	/*
	* This function returns an integer that is the Bin
	* number that will be associated with the Bin object.
	*/
	public static int generateBinNumber() 
	{
		binCounter = binCounter + 1;
		return binCounter;
	}
	
	/*
	* This function returns a double that is the total
	* weight of all SaleItems within the items array.
	* The function utilizes a for loop in order to 
	* access each item in the items array and calls 
	* the getWeight() function from the SaleItem class
	* in order to grab the weight and add it to the 
	* totalWeight variable. The value for currentItemsLength
	* will always be the total number of SaleItems in our 
	* item array.
	*/
	public double getWeight()
	{
		double totalWeight = 0.0;
		for (int i = 0; i < currentItemsLength; i++)
		{
			totalWeight += items[i].getWeight();
		}
		return totalWeight;
	}
	
	/*
	* This function takes in a SaleItem as an argument and adds it to 
	* the items array if it is not fragile AND if the 
	* weight of the new SaleItem does not cause the Bin
	* to go over the value of maxWeight (which is set to 
	* a value of 10.0). If the SaleItem meets both of these requirements
	* then we add it to the array at index currentItemsLength and we 
	* increment currentItemsLength to make ready for the next SaleItem
	* that we are going to add to the items array.
	*/
	public void addItem (ItemType item)
	{
		if (item.isFragile())
		{
			return;
		}
		if(item.getWeight() + getWeight() <= maxWeight)
		{
			items[currentItemsLength] = item;
			currentItemsLength = currentItemsLength + 1;
		}
		else
		{
			return;
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
	* end in order to compensate for the cost of the Bin itself. 
	* 
	* The assignment specifies that we need to print out 
	* the "total Cost of Items" in the showDetails() function, 
	* and as such I interpreted this total cost of items to
	* include all SaleItems in the items array as well as the
	* cost of the Bin.
	*/
	public USMoney calculatePrice()
	{
		USMoney totalPrice = new USMoney(0,0);
		for (int i = 0; i < currentItemsLength; i++)
		{
			totalPrice = totalPrice.add(items[i].getPrice());
		}
		totalPrice.addTo(100,0);
		return totalPrice;
	}
	
	/*
	* This function returns a concatenated string with the binNumber
	* followed by a "," followed by the total weight of the Bin
	* and a "," and concluded with the total price of the Bin (including
	* the $100 added on for the cost of the Bin itself).
	*/
	public String showDetails()
	{
		return binNumber + "," + getWeight() + "," + calculatePrice();
	}
	
	/*
	* With the addition of the currentItemsLength instance data member
	* I can utilize this variable to continually keep track of how 
	* many SaleItems are in the items array at any given time, so
	* all we need to do is return this value and we can know how many
	* items are in the array.
	*/
	public int getNoOfItems()
	{
		return currentItemsLength;
	}
}
