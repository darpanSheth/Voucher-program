import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class VoucherDriver {

    public static void main(String[] args){
        Voucher.initialize(1001,2001,10);


        Scanner stdIn = new Scanner(System.in);
        int choice;
        String date, debit, vendor, paymentDate;
        double amount;
        int voucherNumber;

        System.out.println("XYZ COMPANY Voucher Manager");
        System.out.println();
        System.out.println("Activities available: \n1. create voucher\n2. print voucher register\n3. issue checks");
        System.out.print("Enter number of choice (or zero to quit): ");
        choice = stdIn.nextInt();

        while(choice != 0){

            if(choice > 3){
                System.out.println("Invalid choice. Try again.");
            }
            else{
                if(choice == 1){
                    System.out.print("Enter purchase date (dd/mm/yyyy): ");
                    date = stdIn.next();



                    System.out.print("Enter amount: $");
                    amount = stdIn.nextDouble();

                    stdIn.nextLine();

                    System.out.print("Enter name of account to debit: ");
                    debit = stdIn.next();



                    System.out.print("Enter name of vendor: ");
                    stdIn.nextLine();
                    vendor = stdIn.nextLine();



                    new Voucher(date, amount, debit, vendor);
                }
                if(choice == 2){
                    System.out.println();
                    System.out.println("Voucher Register:");
                    System.out.println();
                    Voucher.printData();
                }
                if(choice == 3){
                    System.out.print("Enter number of voucher to pay: ");
                    voucherNumber = stdIn.nextInt();

                    Voucher voucher = Voucher.find(voucherNumber);

                    while(voucher == null){
                        System.out.println("No vouchers have that number");

                        System.out.print("Enter number of voucher to pay: ");
                        voucherNumber = stdIn.nextInt();
                        voucher = Voucher.find(voucherNumber);
                    }
                    stdIn.nextLine();
                    System.out.print("Enter payment date (dd/mm/yyyy): ");
                    paymentDate = stdIn.nextLine();
                    voucher.issueCheck(paymentDate);



                }
            }

            System.out.println();
            System.out.println("Activities available: \n1. create voucher\n2. print voucher register\n3. issue checks");
            System.out.print("Enter number of choice (or zero to quit): ");
            choice = stdIn.nextInt();
        }
    }

}



