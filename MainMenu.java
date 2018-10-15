import java.util.NoSuchElementException;
import java.util.Scanner ; 
import java.io.*;

public class MainMenu{
  
    MainMenu(){
        Scanner sc = new Scanner(System.in);
        Restaurant R = new Restaurant();
        Reservation Re = new Reservation();
        Registeration Reg = new Registeration();
        
        System.out.println("--------------------------------");
        System.out.println("*          Main Menu           *");
        System.out.println("--------------------------------");
        System.out.println("*\t1. Registration        *");
        System.out.println("*\t2. Reservation         *");
        System.out.println("*\t3. Restaurant          *");
        System.out.println("*\t4. Club                *");
        System.out.println("*\t5. Check In/Check Out  *");
        System.out.println("*\t6. Exit                *");
        System.out.println("--------------------------------");
        System.out.print("\nEnter Your Choice: " );
        String ch = sc.next();

        if( ch.equals("1") ) {
                Reg.showMenu();
        } else if( ch.equals("2") ) {
                Re.ShowReservationMenu();
        } else if( ch.equals("3" ) ) {   
                R.showMenu();
        } else if( ch.equals("4") ) {
                Club C = new Club();
                C.showMenu();
        } else if( ch.equals("5") ) {
                CheckInCheckOut Cin = new CheckInCheckOut();
                Cin.showMenu();
        } else if( ch.equals("6") ) {
                System.out.println("--------------------------------");
                System.out.println("*          Thank You           *");
                System.out.println("--------------------------------");
        } else {
                System.out.println("\nInvalid Choice !\n");
        }

    }

    public static void createRoomsAna(){  
        RoomsAna R[] = new RoomsAna[10] ; 

        for( int i=0 ; i<R.length ; i++ ) {
            
            String filePath = "RoomsAna/" + "RoomsAna-" + i + ".txt";
            
            RoomsAna x = new RoomsAna(i);

            try {
                FileOutputStream f = new FileOutputStream(new File(filePath));
                ObjectOutputStream o = new ObjectOutputStream(f);
    
                o.writeObject(x);
    
                o.close();
                f.close();

            } catch ( Exception e){
                System.out.println(e);
            }
        }

    }
    
public static void checkDirectories(String abc){
        String cwd = System.getProperty("user.dir"); 

        File f = new File(cwd+abc);

        if (!f.exists() && !f.isDirectory()) {
            new File(cwd+abc).mkdir();

            if( abc.equals("/RoomsAna") ) createRoomsAna();
        } 
        
    }

    public static void main(String []args){
        checkDirectories("/CustomersAna");
        checkDirectories("/RoomsAna");
        checkDirectories("/BillingRecord");
                try{
                        new MainMenu();
                    } catch(NoSuchElementException e){
                            System.out.println("Error Occured !");
                    }
            
    }
}