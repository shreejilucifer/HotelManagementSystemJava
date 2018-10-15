import java.util.Scanner ; 

class Club {
    
    public void showMenu(){
        int ch ; 
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("*            Clubs Menu                *");
		System.out.println("----------------------------------------");
		System.out.println("*\t1. Game Zone                        *");
        System.out.println("*\t2. Dance                            *");
        System.out.println("*\t3. Gym & Relaxation Center          *");
		System.out.println("*\t4. Go Back                          *");
		System.out.println("----------------------------------------");
		System.out.print("\nEnter Your Choice: ");
        ch = sc.nextInt();
        
        if( ch == 1 ) {
            gamezone();
        } else if( ch == 2 ) {
            dance();
        } else if( ch == 3 ) {
            gymandrelax();
        } else if( ch == 4 ) {
            new MainMenu();
        } else {
            System.out.println("Invalid Choice !");
        }

    }

    public void gamezone(){
        
        Scanner sc = new Scanner(System.in); 
        Analytics A = new Analytics();
        Billing B = new Billing(); 

        System.out.print( "\nEnter Mobile Number: " );
        String mobileNumber = sc.next();

        if( A.isMemberOrNot(mobileNumber) ) {
            System.out.print("\nEnter Hours for Playing Games: " );
            int hrs = sc.nextInt();

            int amount = hrs * 100 ; 

            B.updateBill(mobileNumber, amount);
            System.out.println("--------------------------------");
            System.out.println("Your Total Bill is: " + B.getBill(mobileNumber) ) ;
            System.out.println("--------------------------------");
            B.updateBill(mobileNumber, -amount);
            
        } else {
            System.out.println("--------------------------------");
            System.out.println("Sorry You are Not a Member ! ") ;
            System.out.println("--------------------------------");
        }

        showMenu();
    }

    public void dance(){
        Scanner sc = new Scanner(System.in); 
        Analytics A = new Analytics();
        Billing B = new Billing(); 

        System.out.print( "\nEnter Mobile Number: " );
        String mobileNumber = sc.next();

        if( A.isMemberOrNot(mobileNumber) ) {
            System.out.print("\nEnter Hours for Dance Class: " );
            int hrs = sc.nextInt();

            int amount = hrs * 50 ; 

            B.updateBill(mobileNumber, amount);
            System.out.println("--------------------------------");
            System.out.println("Your Total Bill is: " + B.getBill(mobileNumber) ) ;
            System.out.println("--------------------------------");
            B.updateBill(mobileNumber, -amount);
            
        } else {
            System.out.println("--------------------------------");
            System.out.println("Sorry You are Not a Member ! ") ;
            System.out.println("--------------------------------");
        }

        showMenu();
    }

    public void gymandrelax(){
        Scanner sc = new Scanner(System.in); 
        Analytics A = new Analytics();
        Billing B = new Billing(); 

        System.out.print( "\nEnter Mobile Number: " );
        String mobileNumber = sc.next();

        if( A.isMemberOrNot(mobileNumber) ) {
            System.out.print("\nEnter Hours for Gym/Relaxation: " );
            int hrs = sc.nextInt();

            int amount = hrs * 500 ; 

            B.updateBill(mobileNumber, amount);
            System.out.println("--------------------------------");
            System.out.println("Your Total Bill is: " + B.getBill(mobileNumber) ) ;
            System.out.println("--------------------------------");
            B.updateBill(mobileNumber, -amount);
            
        } else {
            System.out.println("--------------------------------");
            System.out.println("Sorry You are Not a Member ! ") ;
            System.out.println("--------------------------------");
        }

        showMenu();
    }

}


/*import java.util.Scanner;

class Club{
	public String name;
    public String mobile;
    public String temp_no;
    public int EN_time;
    public int EX_time;
    final public int price=50;  
	//public void entry();
	//public void exit();
	//public void menu();
	
public void showmenu()
{
    
	System.out.println(" INITIAL MENU ");
    System.out.println("Press 1 for ENTRY");
    System.out.println("Press 2 for EXIT");
    System.out.println("Press 3 for Club MENU");
    System.out.println("Press 4 to Go Back");
    System.out.println("Enter your choice: ");
    Scanner Sc = new Scanner(System.in);
    int n = Sc.nextInt();
    switch(n){
    	case 1: entry();
    	         break;
    	case 2: exit();
    	         break;
    	case 3: menu();
                 break;
        case 4: new MainMenu(); 
                 break ; 
    	default: System.out.println("PLEASE ENTER YOU CORRECT CHOICE: ");         

    }
}
        void  entry(){
            Scanner in =new Scanner(System.in);

            System.out.println("ENTER MOBILE NUMBER : ");
            String mobile = in.next();

        Analytics A=new Analytics();
        boolean result = A.isMemberOrNot(mobile);

         if(result==true){
            System.out.println("FREE OF COST");
         }
         else{
                 
                 System.out.println("ENTER NAME : ");
                 String name = in.next();
                 System.out.println("ENTER TEMP NUMBER: ");
                 String temp_no = in.next();
                 System.out.println("ENTER ENTRY TIME OF THAT PERSON: ");
                 int EN_time = in.nextInt();
                
         }
         

in.close();
showmenu();

    }
        void exit(){
        Scanner ex = new Scanner(System.in);
        System.out.println("ENTER NAME: ");
        String name = ex.next();
        System.out.println("ENTER EXIT TIME: ");
        int ex_time=ex.nextInt();
        System.out.println("ENTER MOBILE NUMBER: ");
        String moblie = ex.nextLine(); 
        int t = EX_time - EN_time;
        //int hours = t / 60; 
        //int minutes = t % 60;
        System.out.println("HOURS ARE : "+t); 
        double amount = t * price;
        System.out.println("AMOUNT IS " + amount);

        Billing B = new Billing();
        B.updateBill(moblie,amount);
        showmenu();
   }
        void menu(){
    	System.out.println("MENU");
    	System.out.println("TABLE TENNIS");
    	System.out.println("SWIMMING ");
    	System.out.println("POOL");
    	System.out.println("GAME ZONE");
    }
    public static void main(String[] args){
    	
    }
}

*/