import java.util.Scanner ;

class CheckInCheckOut {

	public void showMenu(){
		int ch ; 
		Scanner sc = new Scanner(System.in);

		System.out.println("----------------------------------------");
        System.out.println("*        Check In / Check Out          *");
		System.out.println("----------------------------------------");
		System.out.println("*\t1. Check In                    *");
		System.out.println("*\t2. Check Out                   *");
		System.out.println("*\t3. Get Room Status             *");
		System.out.println("*\t4. Go Back                     *");
		System.out.println("----------------------------------------");
		System.out.print("\nEnter Your Choice: ");
		ch = sc.nextInt();

		if( ch == 1 ) {
			checkIn();
		} else if( ch == 2 ) {
			checkOut();
		} else if( ch == 3 ){
			getRoomDetails();
		} else if( ch == 4 ) {
			new MainMenu();
		} else {
			System.out.println("Invalid Choice !");
		}

	}

	public void getRoomDetails(){
 
		Analytics A = new Analytics();
		RoomsAna R = null ; 

		for( int i=0 ; i<10 ; i++ ) {
			R = A.getAllocatedDetailsByRoom(i);
			if( R.isRoomAvailable() )
				{ System.out.println("Room No-" + i + " Available" ); }
			else 
				{ System.out.println("Room No-" + i + " Not Avail " + R.getMobileNumber() ); }
			}

			showMenu();
		}
		

	public int getRandomIntegerFromArray(int[] integerArray){
        int retInt = -1;
        if (integerArray != null && integerArray.length > 0){
        retInt = integerArray[(int)(Math.random()*integerArray.length)];
        }
        return retInt;
	}
	
	public void checkOut(){
		Scanner sc = new Scanner(System.in);
		Analytics A = new Analytics();
		System.out.print("\nEnter Mobile Number Of User: " ) ; 
		String mobileNumber = sc.next(); 

		boolean isMember = A.isMemberOrNot(mobileNumber);

		if(isMember){
			Billing B = new Billing(); 
			int r = -1;
			CustomerDetailsAna C = A.listCustomerDetailsAna(mobileNumber);

			double finalBill = B.getBill(mobileNumber);
			B.updateBill(mobileNumber, -finalBill);

			System.out.println("\nBill for " + C.getName() );
			System.out.println("\nYour Bill Is: " + finalBill );
			System.out.println("\nThank You For Staying at our Hotel. !");
			
			RoomsAna R = null; 

			for( int i=0 ; i<10 ; i++ ) {
				R = A.getAllocatedDetailsByRoom(i); 
				if( R.isRoomAvailable() == false ){
					if( R.getMobileNumber().equals(mobileNumber) ) {
						r = i ; 
						break ; 
					}
				}
			}
			
			A.allocateDeallocateRoom("deallocate", r, 0, "");

			System.out.println("\nRoom " + r + " is DeAllocated !\n");

		} else {
			System.out.println("\nSorry You Are Not a Member ! ! ! \n");
		}

		showMenu();

	}

	public void checkIn(){
		Scanner sc = new Scanner(System.in);
		Analytics A = new Analytics();

		System.out.print("\nEnter Customer's Mobile Number: ");
		String mobileNumber = sc.next();

		// check whether any room is booked by this mobilenumber 
		// if he is reserved show the room number 
		// if he is not reserved then do checkIn
				
			   RoomsAna Ra = null; 
               int rx = 0 ; int flag = 0 ; 
			   int i ; 
			          for( i=0 ; i<10 ; i++ ) {
				          Ra = A.getAllocatedDetailsByRoom(i); 
				            if( Ra.isRoomAvailable() == false ){
					            if( Ra.getMobileNumber().equals(mobileNumber) ) {
									flag = 1 ; 
						            rx = i ; 
						            break ; 
					            }
				            }
					  } 
				
			    if( flag == 0 ) {
					boolean isMember = A.isMemberOrNot(mobileNumber);
		
					if( isMember ){
				
						int []roomAvailability = A.availableRoomsAna();
			
						if( roomAvailability.length > 0 ){
							System.out.print("\nEnter Number Of Days To Stay: " ) ;
							int daysOfStay = sc.nextInt(); 
			
							int []Room = A.availableRoomsAna();
							int r = getRandomIntegerFromArray(Room);
							
							A.allocateDeallocateRoom("allocate", r, daysOfStay, mobileNumber);
			
							System.out.println("Room " + r + " is Allocated to " + mobileNumber );
						} else {
							System.out.println("Rooms Are Full ! Sorry !");
						}
			
					} else {
						System.out.print("\nSorry You Are Not A Member. Would you like to Become One ? (Y/N)");
						String x = sc.next(); 
			
						if( x.equals("Y") || x.equals("y") ) {
							Registeration R = new Registeration();
							R.showMenu();
						} else {
							System.out.println("Thank You ! See You Later ! Bye !");
						}
					}
				} else {
					System.out.println("\nYour Room is Already Registered \n");
					System.out.println("Room Number is: " + rx + "\n");
				}
		
		
				showMenu();
	}

	public static void main(String []args){
		
	}
}

/*import java.util.*;

class CheckInCheckOut{

	void showMenu(){
		Scanner sc = new Scanner(System.in);
		int roomNo;
		 int i;
		//for Room Data
		Analytics A = new Analytics();
		//for getting Bill
		Billing b = new Billing();
	/////////////////////////////MENU//////////////////////////////////////////////////////////
		System.out.println("Press 1 to CheckIn, Press 2 to CheckOut");
		String input = sc.nextInt();
	
	//////////////////////////CheckIn///////////////////////////////////////////////////////////
			if(input==1){
	
				//store the Availble Room number in Array a
				int[]a = A.availableRoomsAna();
	
				// Display the list of Available Room
				for(i=0;i<a.length;i++){
					System.out.println(a[i]);
				}
	
				// Choose the room from the available List
				System.out.println("Enter the room To allocate for availableRooms: ");
				roomNo = sc.nextInt();
	
				//allocate the room 
				A.allocateDeallocateRoom("allocate", roomNo );
			}
			
	////////////////////////////CheckOut///////////////////////////////////////////////////////////
			else if(input==2){
	
				//print final Bill
			 
				System.out.println(b.getBill());
				
				//dellocate room
				A.allocateDeallocateRoom("deallocate", roomNo ) ;
	
			}
	}
	public static void main(String[] args){

	}
}

*/