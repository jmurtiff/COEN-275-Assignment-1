/**
 * 
 */
package murtiff.assign1.salebin;

import murtiff.assign1.money.USMoney;

/**
 * @author Jordan
 *
 */
public interface BinType {
	
	public void addItem(ItemType item);
	public USMoney calculatePrice();
	public double getWeight();
	public int getNoOfItems();
	public String showDetails();

}
