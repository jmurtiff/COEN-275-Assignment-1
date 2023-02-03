/**
 * 
 */
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
		USMoney amt1 = new USMoney ();
		System.out.println (amt1);
		amt1.setCents (250);
		System.out.println (amt1);
		amt1.setDollars (10);
		System.out.println (amt1);
		System.out.println (amt1.getCents());
		USMoney amt2 = amt1.add( new USMoney (2,90));
		System.out.println (amt1);
		System.out.println (amt2);
		amt2.addTo(amt1.getDollars(), amt1.getCents());
		System.out.println (amt2);
		USMoney amt3 = new USMoney (99,120);
		amt3.addTo(99,120);
		System.out.println (amt3);

	}

}
