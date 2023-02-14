package murtiff.assign1.q2;
import murtiff.assign1.money.USMoney;
import murtiff.assign1.salebin.Bin;
import murtiff.assign1.salebin.SaleItem;
import murtiff.assign1.salebin.SmartBin;

/**
 * @author Jordan Murtiff
 *
 */
public class Q2TestCase {
	
	//The main function below is based on the instructions given on Page 5 of the assignment.
	public static void main(String[] args) 
	{
		//Create at least 5 instances of SaleItems with data of your choice. Make some of the items “fragile”.
		//The two last items are "fragile" and the second to last item should fit in the Bin with a maxWeight of 10.0.
		SaleItem s1 = new SaleItem ("Feathers", new USMoney (2,90), 2.20, false);
		SaleItem s2 = new SaleItem ("Books", new USMoney (5,100), 3.25, false);
		SaleItem s3 = new SaleItem ("Bricks", new USMoney (2,25), 9.00, false);
		SaleItem s4 = new SaleItem ("Legos", new USMoney (10,20), 2.00, true);
		SaleItem s5 = new SaleItem ("Textbooks", new USMoney (2,50), 5.00, true);	
		
		//Create an instance of a Bin.
		Bin bin1 = new Bin();
		
		//Add the instances of SaleItems from a) to the Bin instance in b). Make sure that you exceed the maximum weight of the bin.
		bin1.addItem(s1);
		bin1.addItem(s2);
		bin1.addItem(s3);
		bin1.addItem(s4);
		bin1.addItem(s5);
		
		//Show details on the Bin instance in b)
		System.out.println (bin1.showDetails());
		
		//Create at least 5 more instances of SaleItems with data of your choice. Make some of the items “fragile”.
		//The two last items are "fragile" and the second to last item should fit in the Bin with a maxWeight of 10.0.
		SaleItem sm1 = new SaleItem ("Feathers", new USMoney (2,90), 2.20, false);
		SaleItem sm2 = new SaleItem ("Books", new USMoney (5,100), 3.25, false);
		SaleItem sm3 = new SaleItem ("Bricks", new USMoney (2,25), 7.00, false);
		SaleItem sm4 = new SaleItem ("Legos", new USMoney (10,20), 2.00, true);
		SaleItem sm5 = new SaleItem ("Textbooks", new USMoney (2,50), 5.00, true);
		
		//Create an instance of a SmartBin.
		SmartBin bin2 = new SmartBin();
		
		//Add the instances of SaleItems from e) to the Bin instance in f). Make sure that you exceed the maximum weight of the bin.
		bin2.addItem(sm1);
		bin2.addItem(sm2);
		bin2.addItem(sm3);
		bin2.addItem(sm4);
		bin2.addItem(sm5);
		
		//Show details on the Bin instance in f)
		System.out.println (bin2.showDetails());
		
		//Create an instance of a Bin as follows:
		Bin bin3 = new SmartBin();
		
		//Can you add fragile SaleItems to bin3?
		bin3.addItem(sm4);
		
		//Yes, you can add fragile SaleItems to bin3 as the dynamic type
		//is a SmartBin and therefore the subclass addTo() method is called.
		System.out.println (bin3.showDetails());
		
	}

}
