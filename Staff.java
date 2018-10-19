import java.io.*;
import java.util.*;

class Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String email ; 
    String id ; 
    String address ; 
    String phone ; 
    int salary ; 
    int present_days ; 

    Worker(){

    }

    Worker( Worker W ) {
        this.name = W.name ; 
        this.email = W.email ; 
        this.id = W.id ; 
        this.address = W.address ; 
        this.phone = W.phone ; 
        this.salary = W.salary ; 
        this.present_days = W.present_days ; 
    }

    void accept(){
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter Name: " ) ;
        name = sc.nextLine();
        

        System.out.print("Enter Phone: " ) ;
        phone = sc.next(); 

        System.out.print("Enter Email: ");
        email = sc.nextLine(); 
        email += sc.nextLine();

        System.out.print("Enter ID: " );
        id = sc.next();

        System.out.print("Enter Address: " );
        address = sc.nextLine();
        address += sc.nextLine(); 

        System.out.print("Enter Present Days: " );
        present_days = sc.nextInt();

        salary =  CalculateSalary(present_days, id);
    }

    int CalculateSalary(int x, String sid){
		int sal;
		char[] id = sid.toCharArray();

		if(id[0]=='C'|| id[0]=='S'|| id[0]=='H')
			sal=250*x;
		else if(id[0]=='R'|| id[0]=='K')
			sal = 500*x;
		else if(id[0]=='A')
			sal= 1000*x;
		else sal=0;
	
		return sal;
		}

    void showDetails(){
        System.out.println("Name: " + name ) ;
        System.out.println("ID: " + id );
        System.out.println("Address: " + address );
        System.out.println("Phone: " + phone );
        System.out.println("Salary: " + salary );
        System.out.println("Present Days: " + present_days );
    }

    String getMobileNumber(){
        return phone ; 
    }
}

class Staff implements Serializable{

    public void showMenu(){
        int ch ; 
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Password: ");
        String password = sc.next(); 

        if( password.equals("hotel123") ) 
        {
            System.out.println("----------------------------------------");
            System.out.println("*            Staff Menu                *");
            System.out.println("----------------------------------------");
            System.out.println("*\t1. New Staff                        *");
            System.out.println("*\t2. Display Staff                    *");
            System.out.println("*\t3. Go Back                          *");
            System.out.println("----------------------------------------");
            System.out.print("\nEnter Your Choice: ");
            ch = sc.nextInt();
            
            if( ch == 1 ) {
                getinfo();
            } else if( ch == 2 ) {
                display();
            } else if( ch == 3 ) {
                new MainMenu();
            } else {
                System.out.println("Invalid Choice !");
            }
            
        } else {
            System.out.println("--------");
            System.out.println("Password is Wrong ! ");
            System.out.println("--------");

            showMenu();
        }

    }
	 
	void getinfo(){

        Worker W = new Worker(); 

        W.accept();

        String filePath = "StaffManagement/" + W.getMobileNumber() + ".txt";
        
		try{
			FileOutputStream f = new FileOutputStream(new File(filePath));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			Worker B = new Worker(W);
			o.writeObject(B);

			o.close();
			f.close();

		} catch( Exception e ) {
			System.out.println("Staff Creation Error !");
        }
        
        System.out.println("Staff Member Added Successfully ! ");

        showMenu();
	}

	void display(){

        String cwd = System.getProperty("user.dir");   
        File folder = new File(cwd+"/StaffManagement");
        File[] listOfFiles = folder.listFiles();
        String fileName ;
        Worker result = null ; 

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                fileName = listOfFiles[i].getName() ;
                
                try{
                    FileInputStream fi = new FileInputStream(new File(cwd + "/StaffManagement/" + fileName) );
                    ObjectInputStream oi = new ObjectInputStream(fi);

                    Worker c = (Worker) oi.readObject();
                    result = new Worker(c);

                    System.out.println("--------");
                    result.showDetails();
                    System.out.println("--------");

                    oi.close();
                    fi.close();
                    
                } catch( Exception e){
                    System.out.println(e);
                }
            } else {
                System.out.println("End");
            }
        }

        showMenu();
	}


	

	public static void main(String args[]){
		/*Staff s = new Staff();
		s.getinfo();
		s.display(); */
	}

}