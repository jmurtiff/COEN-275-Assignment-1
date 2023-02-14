package murtiff.assign1.money;

/**
 * @author Jordan Murtiff
 *
 */
public class USMoney {
	
	/**
	* The two instance data members of the USMoney class, dollars
	* and cents.
	*/
	private int dollars;
	private int cents;

	/**
	* This function is a parameterized constructor that takes two parameters 
	* (dollars and cents) and initializes the corresponding data members. 
	* If the passed value of cents is greater than 100, then we deduct 100 cents and
	* add an additional dollar to the value of dollars and we continue to do this
	* until the value of cents is less than 100.
	*/
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
	
	/**
	* This function is the default constructor for the USMoney class
	* that initializes the corresponding data members of dollars and 
	* cents to values of 0. This was not explicitly defined in the 
	* assignment, so I decided for ease of use to define the default
	* constructor as such.
	*/
	public USMoney()
	{
		this.dollars = 0;
		this.cents = 0;
	}
	
	/**
	* This function is a setter that takes in an integer and sets
	* the number of dollars to be equal to the passed value. In 
	* this case I made the assumption that when you set the # of dollars,
	* it does not take into account any previous balance and only swaps the current 
	* value of dollars with the new value of dollars.
	* For example, if we have $1.50 and we call setDollars(3) then we end
	* up with $3.50 and not $1.50 + $3.00 = $4.50
	* This isn't clear given the assignment so I am using my best judgment here.
	*/
	public void setDollars(int dollars)
	{
		this.dollars = dollars;
	}
	
	
	/**
	* This function is a setter that takes in an integer and sets
	* the number of cents to be equal to the parameterized value.
	* If the passed value of cents is greater than 100, then we deduct 100 cents and
	* add an additional dollar to the value of dollars until we get
	* a value of cents that is less than 100.
	*/
	public void setCents(int cents)
	{
		//If cents is a value above 100, then we have to
		//add multiple dollars and deduct the value of cents
		//to the value under 100.
		while (cents >= 100)
		{
			this.dollars = dollars + 1;
			cents -= 100;
		}
		this.cents = cents;
	}
	
	/**
	* This function is a getter that returns the number of dollars
	* as an integer.
	*/
	public int getDollars() 
	{
		return dollars;
	}
	
	/**
	* This function is a getter that returns the number of cents
	* as an integer.
	*/
	public int getCents() 
	{
		return cents;
	}
	
	/**
	* This function takes in two parameters, an integer for dollars
	* and an integer for cents and adds the parameter values to the 
	* data members of the object that invoked this function.
	* If the passed value of cents is greater than 100, then we deduct 100 cents and
	* add an additional dollar to the value of dollars until we get
	* a value of cents that is less than 100.
	*/
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
	
	/**
	* This function takes in a USMoney object as a parameter and adds the 
	* value of dollars and cents from the passed object along
	* with the dollars and cents of the USMoney object that invoked 
	* the function and returns a new USMoney object that contains the sum.
	*/
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
	
	/**
	* Overriding the toString function, which returns a concatenated string
	* that is the value of dollars and cents in standard format. 
	* If the value of cents is less than 10, then we have to add a 
	* leading 0 in front of the value of cents in order to return
	* the string in standard form.
	* For example: 17 dollars and 2 cents would end up as $17.2 
	* which may be interpreted as $17.20 and not $17.02, so we need
	* to add a leading 0 in order to correctly display the correct
	* value for the number of cents.
	*/
	public String toString()
	{
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