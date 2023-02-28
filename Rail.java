import java.util.Scanner;

public class Rail {
   static int availableSeats = 10;
   static String[] reservedSeats = new String[availableSeats];
   
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String username, password;
      System.out.println("Enter username:");
      username = scan.nextLine();
      System.out.println("Enter password:");
      password = scan.nextLine();
      if(login(username, password)) {
         System.out.println("Login successful!");
         while(true) {
            System.out.println("Enter 1 to reserve a ticket.");
            System.out.println("Enter 2 to cancel a reservation.");
            System.out.println("Enter 0 to exit.");
            int choice = scan.nextInt();
            switch(choice) {
               case 1:
                  reserveTicket();
                  break;
               case 2:
                  cancelReservation();
                  break;
               case 0:
                  System.exit(0);
                  break;
               default:
                  System.out.println("Invalid choice. Please try again.");
                  break;
            }
         }
      } else {
         System.out.println("Login failed. Please try again.");
      }
   }
   
   public static boolean login(String username, String password) {
      // For simplicity, returning true for any valid username and password
      return true;
   }
   
   public static void reserveTicket() {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter number of seats to be reserved:");
      int numberOfSeats = scan.nextInt();
      if(availableSeats >= numberOfSeats) {
         for(int i = 0; i < numberOfSeats; i++) {
            reservedSeats[i] = "reserved";
         }
         availableSeats -= numberOfSeats;
         System.out.println("Reservation successful. Available seats: " + availableSeats);
      } else {
         System.out.println("Not enough available seats. Available seats: " + availableSeats);
      }
   }
   
   public static void cancelReservation() {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter number of seats to be cancelled:");
      int numberOfSeats = scan.nextInt();
      if(numberOfSeats <= reservedSeats.length) {
         for(int i = 0; i < numberOfSeats; i++) {
            reservedSeats[i] = null;
         }
         availableSeats += numberOfSeats;
         System.out.println("Cancellation successful. Available seats: " + availableSeats);
      } else {
         System.out.println("Invalid number of seats. Please try again.");
      }
   }
}
