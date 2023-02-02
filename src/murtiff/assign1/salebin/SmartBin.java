/**
 * 
 */
package murtiff.assign1.salebin;
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan
 *
 */
public class SmartBin extends Bin{

	private String label;
	
	//Cannot use binCounter from the Bin class since we have to use a 
	//different static variable for the SmartBin class.
	private static int binCounter = 0;
	
	public SmartBin()
	{
		items = new ItemType [10];
		currentitemsLength = 0;
		binNumber = "SM" + generateBinNumber();
		label = "";
	}
	
	//Cannot use generateBinNumbers from the Bin class since we have to use a 
	//different static function for the SmartBin class.
	public static int generateBinNumber() 
	{
		binCounter = binCounter + 1;
		return binCounter;
	}
	
	public void setLabel(String label)
	{
		this.label = label;
	}
	
	public void addItem (ItemType item)
	{
		if(item.getWeight() + getWeight() <= maxWeight)
		{
			items[currentitemsLength] = item;
			currentitemsLength = currentitemsLength + 1;
			if(item.isFragile())
			{
				setLabel("Fragile - Handle with Care");
			}
		}
	}
	
	public USMoney calculatePrice()
	{
		USMoney totalPrice = new USMoney(0,0);
		for (int i = 0; i < currentitemsLength; i++)
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
	
	public String showDetails()
	{
		return binNumber + "," + label + "," + getWeight() + "," + calculatePrice();
	}
		
}
