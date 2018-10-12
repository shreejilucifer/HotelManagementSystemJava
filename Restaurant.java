import java.util.*;

class Restaurant {	
	static protected String emailID;
	static protected String name;
	static protected String mobileNumber;
	static protected String gender;
	static protected String address;
	static protected String pincode;
	static protected int age ; 
	
	public void showMenu(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----------------------------------------");
        System.out.println("*          Restaurant                  *");
        System.out.println("----------------------------------------");
		System.out.println("*\t1. New Table Booking           *");
		System.out.println("*\t2. Cancel Table Booking        *");  
		System.out.println("*\t3. Go Back                     *");
		System.out.println("----------------------------------------");
        System.out.print("\nEnter Your Choice: " );
		int choice = sc.nextInt();

		if(choice==1)
		{
			boolean check;
			Analytics ana = new Analytics();

			System.out.print("\nEnter Mobile Number:   ");
			mobileNumber = sc.next();
			check = ana.isMemberOrNot( mobileNumber );
			
			if(check==false){

				System.out.println("\n----------------------------------------");
				System.out.println("           Lets Register You !            ");
				System.out.println("----------------------------------------\n");

				Registeration Reg = new Registeration();
				Reg.createMemberRegister();

				Tables tab = new Tables();
				boolean avail = tab.tableAvailableOrNot();

				if (avail==true){
					Order ord = new Order();
					ord.menu(mobileNumber);
				}
				else{
					System.out.println("\nSorry Tables are Not Available\n");
				}
			}  
			if(check==true){				
				Tables tab = new Tables();
				boolean avail = tab.tableAvailableOrNot();
				if (avail==true){
					Order ord = new Order();
					ord.menu(mobileNumber);
				}
				else{
					System.out.println("\nSorry Tables are Not Available\n");
				}
			}	
		}

		if(choice==2){
			Tables tab = new Tables();
			tab.cancelTable();
		}

		if( choice == 3 ) {
			new MainMenu();
		}

		new MainMenu(); 
	}

	public static void main(String args[]) {

	}
}

class Tables extends Restaurant{
	
	final private int totalTables=20;
	static private int tablesOccupied=0;
	
	public boolean tableAvailableOrNot() {

		CustomerDetailsAna C = null;
		Analytics A = new Analytics();

		C = A.listCustomerDetailsAna(mobileNumber);
		String myName = C.getName(); 

		if (tablesOccupied < 20){
			System.out.println( "\n" + myName +", your table is booked successfully ");
			tablesOccupied++;
			return true;
		}
		else{
			System.out.println( "\n" + myName +", there is no table available ");
			return false;
		}
	}
	
	void cancelTable() {
		Scanner sc = new Scanner(System.in);
		CustomerDetailsAna C = null;

		Analytics A = new Analytics();

		System.out.print("\nEnter Mobile Number: ");
		mobileNumber = sc.next();

		C = A.listCustomerDetailsAna(mobileNumber);
		String myName = C.getName(); 

		if( tablesOccupied <= 0 ) {
			System.out.print("\nAll Tables are Cancelled !\n");
		} else {
			tablesOccupied--;
			System.out.println( "\n" + myName + ", your table booking is canceled ");
		}
	}
}
		
class Order extends Restaurant {

	private float price[] = new float[10];
	int i=0;
	int n=0;
	double totalBill=0;
	
	Scanner sc = new Scanner(System.in);
	
	void menu(String mobileNumber) {
		
		price[0]=200;	//items[0]="Appetizers";
		price[1]=100;	//items[1]="Salad";
		price[2]=150;	//items[2]="Soups";
		price[3]=300;	//items[3]="Starters";
		price[4]=400;	//items[4]="Indian Food";
		price[5]=500;	//items[5]="Italian Food";
		price[6]=550;	//items[6]="Mexican Food";
		price[7]=400;	//items[7]="Chinese Food";
		price[8]=180;	//items[8]="Extras";
		price[9]=200;	//items[9]="Dessert";
	
		System.out.println("\n-------------------------Menu--------------------------");
		System.out.println("1. Appetizers \n2. Salad \n3. Soups \n4. Starters \n5. Indian Food \n6. Italian Food \n7. Mexican Food \n8. Chinese Food \n9. Extras \n10. Dessert");
		System.out.println("\nPress 0 to exit");
		
		do{
				System.out.print("\nEnter Your Choice: ");
				i = sc.nextInt();
			
			if( i!=0 ){
				System.out.print("\nEnter Quantity: ");
				n = sc.nextInt();
			}
			
		if(i!=0){
			totalBill = totalBill + price[i]*n;
		}
		
		}while(i!=0);
		
		System.out.println("\nTotal bill : " + totalBill);
		Billing B = new Billing(); 
		B.updateBill(mobileNumber, totalBill);
	}
	
}
















	