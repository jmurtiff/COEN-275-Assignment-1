/**
 * 
 */
package murtiff.assign1.salebin;
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan
 *
 */
public class Bin implements BinType {
	
	protected String binNumber;
	
	protected ItemType items[];
	
	protected int currentitemsLength;
	
	protected static double maxWeight = 10.0;
	
	protected static int binCounter = 0;
	
	//
	public Bin()
	{
		items = new ItemType [10];
		currentitemsLength = 0;
		binNumber = "A" + generateBinNumber();
	}
	
	public static int generateBinNumber() 
	{
		binCounter = binCounter + 1;
		return binCounter;
	}
	
	public double getWeight()
	{
		double totalWeight = 0.0;
		for (int i = 0; i < currentitemsLength; i++)
		{
			totalWeight += items[i].getWeight();
		}
		return totalWeight;
	}
	
	public void addItem (ItemType item)
	{
		if (item.isFragile())
		{
			return;
		}
		//
		if(item.getWeight() + getWeight() <= maxWeight)
		{
			items[currentitemsLength] = item;
			currentitemsLength = currentitemsLength + 1;
		}
		else
		{
			return;
		}
	}
	
	public USMoney calculatePrice()
	{
		USMoney totalPrice = new USMoney(0,0);
		for (int i = 0; i < currentitemsLength; i++)
		{
			totalPrice = totalPrice.add(items[i].getPrice());
		}
		totalPrice.addTo(100,0);
		return totalPrice;
	}
	
	public String showDetails()
	{
		return binNumber + "," + getWeight() + "," + calculatePrice();
	}
	
	public int getNoOfItems()
	{
		return currentitemsLength;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaleItem s1 = new SaleItem ("Feathers", new USMoney (2,90), 4.35, false);
		SaleItem s2 = new SaleItem ("Feathers", new USMoney (5,100), 5.10, false);
		SaleItem s3 = new SaleItem ("Bricks", new USMoney (4,20), 1.0, true);
		Bin b1 = new Bin();
		Bin b2 = new Bin();
		System.out.println (b1.showDetails());
		b1.addItem(s1);
		System.out.println (b1.showDetails());
		b1.addItem(s2);
		System.out.println (b1.showDetails());
		b1.addItem(s3);
		System.out.println (b1.showDetails());
		System.out.println (b2.showDetails());
		

	}

}
