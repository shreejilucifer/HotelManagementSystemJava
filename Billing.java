import java.io.*; 

class BillRecord implements Serializable{

	private static final long serialVersionUID = 1L;
	String mobileNumber;
	double myBill ; 

	BillRecord(String mobileNumber , double myBill ) {
		this.mobileNumber = mobileNumber ; 
		this.myBill = myBill ; 
	}

	public String getMobileNumber(){
		return mobileNumber ; 
	}

	public double getMyBill(){
		return myBill ; 
	}

}

class Billing {

	public static void main(String []args) {
		
	}

	public void createRecord(String mobileNumber){

		String filePath = "BillingRecord/" + "Bill-" + mobileNumber + ".txt";
		//System.out.println(filePath);

		try{
			FileOutputStream f = new FileOutputStream(new File(filePath));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			BillRecord B = new BillRecord(mobileNumber, 0.0);
			o.writeObject(B);

			o.close();
			f.close();

		} catch( Exception e ) {
			System.out.println("Billing Error !");
		}

	}

	public void updateBill(String mobileNumber , double amount ){

		String cwd = System.getProperty("user.dir");
		String filePath = cwd + "/BillingRecord/" + "Bill-" + mobileNumber + ".txt";
		
		try {
			FileInputStream fi = new FileInputStream(new File(filePath));
			ObjectInputStream oi = new ObjectInputStream(fi);

			BillRecord myB = (BillRecord) oi.readObject();

			double myBill = myB.getMyBill();

			oi.close();
			fi.close();

			// write 
			FileOutputStream f = new FileOutputStream(new File(filePath));
			ObjectOutputStream o = new ObjectOutputStream(f);

			BillRecord B = new BillRecord(mobileNumber, myBill + amount );
			o.writeObject(B);

			o.close();
			f.close();

		} catch ( Exception e){
			System.out.println(e);
		}
	}

	public double getBill(String mobileNumber){
		double bill = 0 ; 
		String cwd = System.getProperty("user.dir");
		String filePath = cwd + "/BillingRecord/" + "Bill-" + mobileNumber + ".txt";
		
		try {
			FileInputStream fi = new FileInputStream(new File(filePath));
			ObjectInputStream oi = new ObjectInputStream(fi);

			BillRecord myB = (BillRecord) oi.readObject();

			bill = myB.getMyBill();

			oi.close();
			fi.close();
		} catch( Exception e ) {
			System.out.println(e);
		}

		return bill ; 
	}
	
}
// Todo Segregate The Bills 

/* class Billing {
	double totalBill = 0;

	public double getFinalBill(){
		return totalBill ; 
	}

	public void getRestaurantBill(double totalBill){
		System.out.println("Send to Billing: " + totalBill);
	}

	public void getCluB(double amount, String mobile){
        System.out.println("Sent To Billing: " + amount + " " + mobile );
	}
	
}
*/

/*import java.util.*;

class Billing{
		
	public void getBill(){
			Scanner sc = new Scanner(System.in);
			Restaurant R = new Restaurant();
			Club C = new Club();
			Analytics A = new Analytics();

			System.out.println("Enter Mobile Number of the Guest");
			String mobileNo = sc.nextInt();
			CustomerDetailsAna x = A.listCustomerDetailsAna(mobileNo) ;

			String name = x.getName();
			String emailId = x.getEmailID();
			//Get Total bill from Restaurant
			double restaurantBill = R.getRestaurantBill();
			//Get Total bill from Club
			double clubBill = C.getClubBill();
			//sum the bills
			double totalBill = restaurantBill + clubBill;

			//Printing the final Bill

			System.out.println("Name: "+name);
			System.out.println("MobileNumber: "+mobileNo);
			System.out.println("Email ID: "+emailId);
			System.out.println("Bill of Club: "+clubBill);
			System.out.println("Bill of Restaurant: "+restaurantBill);
			System.out.println("Final Bill: "+totalBill);

	}
}
class Main{


	public static void main(String[] args){
	
		//implementation of Billing class

		Billing B = new B();
		B.getBill();
	

	}
}
*/
