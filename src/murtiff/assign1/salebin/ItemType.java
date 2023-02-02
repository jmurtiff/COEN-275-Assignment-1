/**
 * 
 */
package murtiff.assign1.salebin;
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan
 *
 */
public interface ItemType {
	
	public Boolean isFragile();
	public USMoney getPrice();
	public double getWeight();
	public String getDetails();

}
