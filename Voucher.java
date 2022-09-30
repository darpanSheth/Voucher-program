public class Voucher {
    static int nextCheckNumber;
    static int nextVoucherNumber;
    static Voucher[] vouchers;
    int voucherNumber;
    String purchaseDate, debitAccount, vendor;
    double amount;
    int checkNumber;
    String paymentDate;

    Voucher(String purchaseDate, double amount, String debitAccount, String vendor){

        for(int i = 0; i < vouchers.length; i++){
            if(vouchers[i] == null){
                vouchers[i] = this;
                this.purchaseDate = purchaseDate;
                this.amount = amount;
                this.debitAccount = debitAccount;
                this.vendor = vendor;

                this.voucherNumber = nextVoucherNumber;
                nextVoucherNumber ++;
                break;
            }
        }
    }

    public static void initialize(int firstVoucher, int firstCheck, int maxNumberOfVouchers){
        nextVoucherNumber = firstVoucher;
        nextCheckNumber = firstCheck;
        vouchers = new Voucher[maxNumberOfVouchers];
    }

    public static Voucher find(int voucherNumber){

        for (int i = 0; i < vouchers.length; i++) {
            if(vouchers[i] != null && vouchers[i].voucherNumber == voucherNumber){
                return  vouchers[i];
            }

        }
        return null;
    }

    public void issueCheck(String paymentDate){
        if(this.amount <= 0 || this.vendor == null){
            System.out.println("invalid values for amount and vendor");
        }

        else {
            checkNumber = nextCheckNumber;
            this.paymentDate = paymentDate;
            nextCheckNumber++;
        }

    }

    public static void printData(){

        for (int i = 0; i < vouchers.length; i++){
            if(vouchers[i] != null) {
                System.out.println("voucher # " + vouchers[i].voucherNumber + "  date: " + vouchers[i].purchaseDate + "  amount: "
                        + vouchers[i].amount + "\n  account: " + vouchers[i].debitAccount + "  venodr: " + vouchers[i].vendor + "\n  check #: " + vouchers[i].checkNumber + "  date: " + vouchers[i].paymentDate);
                System.out.println();
            }

        }
    }

}


