/**
 * 
 */
package murtiff.assign1.money;

/**
 * @author Jordan
 *
 */
public class USMoney {

	private int dollars;
	private int cents;

	public USMoney(int dollars, int cents) 
	{
		while (cents >= 100)
		{
			dollars = dollars + 1;
			cents -= 100;
		}
		this.dollars = dollars;
		this.cents = cents;
		
	}
	
	//Should the default constructor for the USMoney class set dollars and cents to
	//"0" or some other value.
	public USMoney()
	{
		this.dollars = 0;
		this.cents = 0;
	}
	
	public void setDollars(int dollars)
	{
		this.dollars = dollars;
	}
	
	public void setCents(int cents)
	{
		while (cents >= 100)
		{
			this.dollars = dollars + 1;
			cents -= 100;
		}
		this.cents = cents;
	}
	
	public int getDollars() 
	{
		return dollars;
	}
	
	public int getCents() 
	{
		return cents;
	}
	
	public void addTo(int dollars, int cents)
	{
		while (cents >= 100)
		{
			dollars = dollars + 1;
			cents -= 100;
		}
		this.dollars = this.dollars + dollars;
		this.cents = this.cents + cents;
	}
	
	public USMoney add(USMoney money)
	{
		USMoney moneySum = new USMoney();
		moneySum.dollars = this.dollars + money.dollars;
		moneySum.cents = this.cents + money.cents;
		while (moneySum.cents >= 100)
		{
			moneySum.dollars = moneySum.dollars + 1;
			moneySum.cents -= 100;
		}
		return moneySum;
	}
	
	public String toString(){//overriding the toString() method
		if (cents < 10)
		{
			return "$" + dollars + "." + "0" + cents;
		}
		else
		{
			return "$" + dollars + "." + cents;
		}
	}
}
