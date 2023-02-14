package murtiff.assign1.q1;

//In order to use the class methods of USMoney outside of its
//package we have to import it into this java file.
import murtiff.assign1.money.USMoney;

/**
 * @author Jordan Murtiff
 *
 */
public class USMoneyTester {

	/**
	 * The main function for USMoneyTester is taken directly from the 
	 * original assignment. Both the default constructor and the parameterized
	 * constructor is called here, as well as both setters and getters (for dollars
	 * and cents) and finally both add() and addTo() functions.
	**/
	public static void main(String[] args) {
		//Default value of $0.00.
		USMoney amt1 = new USMoney ();
		System.out.println (amt1);
		
		//Value is now at $2.50.
		amt1.setCents (250);
		System.out.println (amt1);
		
		//Value is now at $10.50, not $12.50 if we do not take into account the old balance.
		amt1.setDollars (10); 
		System.out.println (amt1);
		
		//This is a value of 50.
		System.out.println (amt1.getCents());
		USMoney amt2 = amt1.add( new USMoney (2,90));
		
		//This value stays the same at $10.50 (it should not change given the add() function).
		System.out.println (amt1); 
		
		//This is now $13.40 since we add $2.90 to $10.50.
		System.out.println (amt2); 
		
		//Value is now at $23.90 as we add $10.50 and $13.40 together.
		amt2.addTo(amt1.getDollars(), amt1.getCents());
		System.out.println (amt2);
		
		//Value is $200.40 as we add $100.20 and $100.20 together.
		USMoney amt3 = new USMoney (99,120);
		amt3.addTo(99,120);
		System.out.println (amt3);

	}

}
