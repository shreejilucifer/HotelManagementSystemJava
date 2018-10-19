import java.io.*;
import java.util.Scanner;

class CustomerDetailsAna implements Serializable {
    private static final long serialVersionUID = 1L;
    String emailID;
    String mobileNumber ;
    String name ;
    int age ;
    String gender ;
    String address ; 
    String pincode ; 

    CustomerDetailsAna( String emailID , String mobileNumber , String name, int age, String gender, String address, String pincode ) {
        this.emailID = emailID;
        this.mobileNumber = mobileNumber;
        this.name = name ;
        this.age = age ;
        this.gender = gender ;
        this.address = address ;
        this.pincode = pincode ;
    }

    CustomerDetailsAna( CustomerDetailsAna X ){
        this.emailID = X.emailID;
        this.mobileNumber = X.mobileNumber;
        this.name = X.name ;
        this.age = X.age ;
        this.gender = X.gender ;
        this.address = X.address ;
        this.pincode = X.pincode ;
    }

    public void show(){
        System.out.println(emailID);
        System.out.println(mobileNumber);
        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(address);
        System.out.println(pincode);
        System.out.println();
    }

    public String getMobileNumber(){
        return mobileNumber ; 
    }

    public String getEmailID(){
        return emailID ; 
    }

    public String getName(){
        return name ; 
    }

    public int getAge(){
        return age ; 
    }

    public String getGender(){
        return gender ;
    }

    public String getPincode(){
        return pincode ; 
    }

    public String getAddress(){
        return address ;
    }
}

class RoomsAna implements Serializable {
   
    private static final long serialVersionUID = 1L;
    boolean isAvailable;
    int roomId ; 
    int daysOfStay ; 
    String mobileNumber ; 

    RoomsAna(int id){
        roomId = id ; 
        isAvailable = true ; 
        daysOfStay = 0; 
        mobileNumber = "";
    }

    RoomsAna( RoomsAna x ){
        this.isAvailable = x.isAvailable ; 
        this.roomId = x.roomId ; 
        this.daysOfStay = x.daysOfStay ;
        this.mobileNumber = x.mobileNumber ; 
    }

    void show(){
        System.out.println(isAvailable);
        System.out.println(roomId);
        System.out.println(daysOfStay);
        System.out.println(mobileNumber);
    }

    public boolean isRoomAvailable(){
        return isAvailable ;
    }

    public int getRoomId(){
        return roomId ; 
    }

    public String getMobileNumber(){
        return mobileNumber ;
    }

    public int getDaysOfStay(){
        return daysOfStay;
    }

    public void setAvailability(String choice, int daysOfStay, String mobileNumber){
        if( choice.equals("allocate") ){
            isAvailable = false ;
            this.daysOfStay = daysOfStay ; 
            this.mobileNumber = mobileNumber ; 
        } else {
            isAvailable = true ;
            this.daysOfStay = 0 ; 
            this.mobileNumber = "";
        }
    }
}

public class Analytics {
    int count = 0 ; 

    Analytics(){
        
    }

    public RoomsAna getAllocatedDetailsByRoom(int roomId){
        RoomsAna result = null ;
        String cwd = System.getProperty("user.dir");
        String fileName = cwd + "/RoomsAna/" + "RoomsAna-" + roomId + ".txt"; 

        try{
            FileInputStream fi = new FileInputStream(new File(fileName) );
            ObjectInputStream oi = new ObjectInputStream(fi);
            
            RoomsAna c = (RoomsAna)oi.readObject();

            if( roomId == c.getRoomId() ){
                result = new RoomsAna(c);
                
                return result ; 
            }
            else {
                System.out.println("Gave Default");
                result = new RoomsAna(roomId);
            }
        } catch( Exception e){
            System.out.println("Entered Error");
        }

        return result ; 
    }

    public void createMember(String emailID, String mobileNumber, String name, int age, String gender, String address, String pincode){
        
        CustomerDetailsAna C = new CustomerDetailsAna(emailID, mobileNumber, name, age, gender, address, pincode);

        String filePath = "CustomersAna/" + mobileNumber + ".txt";
        try {
            FileOutputStream f = new FileOutputStream(new File(filePath));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(C);

            o.close();
            f.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public CustomerDetailsAna listCustomerDetailsAna(String mobileNumber){
        
        String cwd = System.getProperty("user.dir");   
        File folder = new File(cwd+"/CustomersAna");
        File[] listOfFiles = folder.listFiles();
        String fileName ;
        CustomerDetailsAna result = null ; 

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                fileName = listOfFiles[i].getName() ; 
                if( fileName.equals(mobileNumber+".txt")){
                    try{
                        FileInputStream fi = new FileInputStream(new File(cwd + "/CustomersAna/" + fileName) );
                        ObjectInputStream oi = new ObjectInputStream(fi);
    
                        CustomerDetailsAna c = (CustomerDetailsAna) oi.readObject();
    
                        result = new CustomerDetailsAna(c);

                        oi.close();
                        fi.close();
                        break ;
                    } catch( Exception e){
                        System.out.println(e);
                    }
                }
            } 
        }

        return result ;
    }

    public void checkDirectories(String abc){
        String cwd = System.getProperty("user.dir"); 

        File f = new File(cwd+abc);

        if (!f.exists() && !f.isDirectory()) {
            new File(cwd+abc).mkdir();
        } 
    }

    public boolean isMemberOrNot(String mobileNumber){
        
        String cwd = System.getProperty("user.dir");   
        File folder = new File(cwd+"/CustomersAna");
        File[] listOfFiles = folder.listFiles();
        String fileName ;
        int flag = 0 ; 

        for( int i=0 ; i < listOfFiles.length ; i++ ) {
            if( listOfFiles[i].isFile() ) {
                fileName = listOfFiles[i].getName();

                try {
                    FileInputStream fi = new FileInputStream(new File(cwd + "/CustomersAna/" + fileName )); 
                    ObjectInputStream oi = new ObjectInputStream(fi);

                    CustomerDetailsAna c = (CustomerDetailsAna) oi.readObject();

                    if( c.getMobileNumber().equals(mobileNumber) ) { 
                        flag = 1; break ; 
                     }

                    oi.close();
                    fi.close();

                } catch( Exception e ) {
                    System.out.println(e);
                }

            }
        }

        if( flag == 1 ) return true ; 
        else return false ; 
    }

    public void createRoomsAna(){  
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

    public int[] availableRoomsAna() {
        
        int oldArray[] = {} ;

        String cwd = System.getProperty("user.dir");   
        File folder = new File(cwd+"/RoomsAna");
        File[] listOfFiles = folder.listFiles();
        String fileName ;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                fileName = listOfFiles[i].getName() ; 

                try{
                    FileInputStream fi = new FileInputStream(new File(cwd + "/RoomsAna/" + fileName) );
                    ObjectInputStream oi = new ObjectInputStream(fi);

                    RoomsAna c = (RoomsAna) oi.readObject();

                    if( c.isRoomAvailable() == true ) {
                        int[] newArray = new int[oldArray.length + 1];
                        for(int x=0;x < oldArray.length;x++) newArray[x] = oldArray[x];
                        newArray[newArray.length-1] = c.getRoomId();
                        oldArray = newArray;
                    }

                    oi.close();
                    fi.close();
                    
                } catch( Exception e){
                    System.out.println(e);
                }
            } 
        }

        return oldArray ; 
    }

    public void allocateDeallocateRoom(String choice, int RoomNumber, int daysOfStay, String mobileNumber ){
        // choice can be "allocate" | "deallocate"
        String filePath = "RoomsAna/" + "RoomsAna-" + RoomNumber + ".txt";

        try {
            FileOutputStream f = new FileOutputStream(new File(filePath), false );
            ObjectOutputStream o = new ObjectOutputStream(f);

            RoomsAna x = new RoomsAna(RoomNumber);

            x.setAvailability(choice, daysOfStay, mobileNumber);
            
            o.writeObject(x);

            o.close();
            f.close();

        } catch ( Exception e){
            System.out.println(e);
        }
    }

    // Avoid The Main Function For UML Design
    public static void main(String []args){

    }
}
