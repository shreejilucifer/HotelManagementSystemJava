import java.util.Scanner;

class Registeration {
    String emailID ;
    String mobileNumber ;
    String name ;
    int age ;
    String gender ;
    String address ; 
    String pincode ;
    int ch; 

    public void showMenu(){

    	System.out.println("----------------------------------------");
        System.out.println("*          Registration                *");
        System.out.println("----------------------------------------");

		System.out.println("*\t1. New Registration            *");
		System.out.println("*\t2. Go Back                     *");
		System.out.println("----------------------------------------");
		System.out.print("\nEnter Your Choice: " );
		
    	Scanner one = new Scanner(System.in);
    	ch=one.nextInt();
    	if(ch==1){
			createMemberRegister(); 
    	} else if( ch == 2 ) {
			new MainMenu();
		} else { 
			System.out.println("Invalid Choice !");
		}

		new MainMenu();
	}
	
    public void createMemberRegister(){
    	Scanner two=new Scanner(System.in);
    	Analytics A = new Analytics();

    	System.out.println("------------------------Registraton Form------------------------");
    	System.out.print("\nMobile Number: ");	
		mobileNumber=two.next();
		
		boolean result=A.isMemberOrNot(mobileNumber);
		
    	if(result){
    		System.out.println("\nYou are already Registered\n");
    	}else{

    		System.out.print("\nName: ");	
    		name=two.nextLine();
    		name+=two.nextLine();
    		System.out.print("\nAge: ");
    		age=two.nextInt();
    		System.out.print("\nEmail: ");
    		emailID=two.nextLine();
    		emailID+=two.nextLine();	
    		System.out.print("\nGender: ");
    		gender=two.next();
    		System.out.print("\nAddress: ");
    		address=two.nextLine();
    		address+=two.nextLine();
    		System.out.print("\nPincode: ");
    		pincode=two.next();
    		
			A.createMember(emailID,mobileNumber,name,age,gender,address, pincode);

			Billing B = new Billing(); 
			B.createRecord(mobileNumber);

			System.out.println("\nThanks For Registering\n");
		}

	}
}
