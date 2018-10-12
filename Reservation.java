import java.io.*;
import java.util.Random;
import java.util.Scanner;

class Reservation{
    public static String getNumber(){

        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter Mobile Number: ");
        String MobileNumber=s.next();

        return MobileNumber;
    }

    public static int getChoice(){
      Scanner s = new Scanner(System.in);
      System.out.print("\nEnter choice: ");
      int Number=s.nextInt();

      return Number;
    }

    public int getRandomIntegerFromArray(int[] integerArray){

        int retInt = -1;
        if (integerArray != null && integerArray.length > 0){
        retInt = integerArray[(int)(Math.random()*integerArray.length)];
        }

        return retInt;
    }

    public void ShowReservationMenu(){

      Analytics A = new Analytics();

        System.out.println("----------------------------------------");
        System.out.println("*          Reservation                 *");
        System.out.println("----------------------------------------");
        System.out.println("*\t1.Reservation of Room          *");
        System.out.println("*\t2.Cancel Reservation of Room   *");
        System.out.println("*\t3.Reservation of Restaurants   *");
        System.out.println("*\t4.Go Back                      *");
        System.out.println("----------------------------------------");
        int number = getChoice();

        int []Room = A.availableRoomsAna();
        int r = getRandomIntegerFromArray(Room);

    switch(number){
    //Case statements

      case 1:
      String MobileNumber = getNumber();
      boolean b = A.isMemberOrNot(MobileNumber);
              
            if(b){
                if(Room.length > 0){
                  Scanner sc = new Scanner(System.in);
                    
                    System.out.print("\nEnter Number Of Days To Stay: " ) ;
                    int daysOfStay = sc.nextInt() ;
                     
                    A.allocateDeallocateRoom("allocate", r , daysOfStay, MobileNumber);
          
                    System.out.println("\nRoom Booked : "+ r + "\n");

                    ShowReservationMenu();
                  }
                else {
                  System.out.println("\nSorry No Room Available !\n");
                  ShowReservationMenu();
                }
              }
              else{
                System.out.println("\nPLEASE REGISTER !\n");
                Registeration Re = new Registeration();
                Re.showMenu();
              }
            break;
        case 2:
              String MobileNumber2 = getNumber();
              boolean b2 = A.isMemberOrNot(MobileNumber2);

               Scanner s = new Scanner(System.in);

               // use getting Room Number Logic here 
               RoomsAna R = null; 
               int rx = 0 ; 

			          for( int i=0 ; i<10 ; i++ ) {
				          R = A.getAllocatedDetailsByRoom(i); 
				            if( R.isRoomAvailable() == false ){
					            if( R.getMobileNumber().equals(MobileNumber2) ) {
						            rx = i ; 
						            break ; 
					            }
				            }
				
			          } 
                
            if(b2){
                if(Room.length > 0){
                    A.allocateDeallocateRoom("deallocate", rx, 0, "");
                    
                    System.out.println("\nRoom canceled : "  + rx + "\n");

                    ShowReservationMenu();
                  }
              }
            break;
        case 3: Restaurant Res = new Restaurant();
                Res.showMenu();
                break;
        case 4: new MainMenu(); break; 
        default:System.out.println("ENTER VALID CHOICE");
      }
    }

    public static void main(String[] args){

  }
}