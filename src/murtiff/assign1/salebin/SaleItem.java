/**
 * 
 */
package murtiff.assign1.salebin;

import murtiff.assign1.money.USMoney;

/**
 * @author Jordan
 *
 */
public class SaleItem implements ItemType{

	private String itemName;
	private USMoney price;
	private double weight;
	private boolean fragile;
	
	public SaleItem(String itemName, USMoney price, double weight, boolean fragile) 
	{
		this.weight = weight;
		this.itemName = itemName;
		this.price = price;
		this.fragile = fragile;
	}
	
	public Boolean isFragile()
	{
		return fragile;
	}
	
	public USMoney getPrice()
	{
		return price;
	}
	
	public double getWeight() 
	{
		return weight;
		
	}
	
	public String getDetails()
	{
		return itemName + "," + price;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SaleItem s1 = new SaleItem ("Feathers", new USMoney (2,90), 4.0, true);
		System.out.println (s1.getPrice());
		System.out.println (s1.getWeight());
		System.out.println (s1.getDetails());
		System.out.println (s1.isFragile());
	}
	
}
