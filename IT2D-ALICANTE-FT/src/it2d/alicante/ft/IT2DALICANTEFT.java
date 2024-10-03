package it2d.alicante.ft;

import java.util.Scanner;

public class IT2DALICANTEFT {

   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
        
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        IT2DALICANTEFT workouts = new IT2DALICANTEFT ();

        switch(action){
            case 1:
                workouts.addWorkouts();           
                break;
            case 2:
             
                workouts.viewWorkouts();
                break;
              
        }
        System.out.println("Do you want to continue? (yes/no)");
        response = sc.next();
    }while(response.equalsIgnoreCase("yes"));
    System.out.println("Thank You, See you soonest!");
    
    }
    
    
    public void addWorkouts(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Date: ");
        String wdate = sc.next();
        System.out.print("Type: ");
        String wtype = sc.next();
        System.out.print("Duration: ");
        String dura = sc.next();
        System.out.print("CaloriesBurned: ");
        String cb = sc.next();

        String sql = "INSERT INTO tbl_workouts (date, type, duration, caloriesburned) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, wdate, wtype, dura, cb);


    }

    private void viewWorkouts() {
        config conf = new config();
        String votersQuery = "SELECT * FROM tbl_workouts";
        String[] votersHeaders = {"W_id","Date", "Type", "Duration", "CaloriesBurned"};
        String[] votersColumns = {"w_id", "date", "type", "duration", "caloriesburned"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }
    
    }
    

