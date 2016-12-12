package error_handling.user_defined;

/**
 * Created by LanAnh on 12/12/2016.
 */
public class InsufficientFundsException extends Exception {
   private double amount;

   public InsufficientFundsException(double amount) {
      this.amount = amount;
   }

   public double getAmount() {
      return amount;
   }
}
