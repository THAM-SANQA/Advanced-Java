package lesson9;

import java.util.List;
import java.util.function.BiPredicate;

/**
 *
 * @author TJ
 */
public class TestBiPredicate {

  public static void main(String[] args){

    List<SalesTxn> tList = SalesTxn.createTxnList();
    SalesTxn first = tList.get(0);
    String testState = "CA";
    SalesTxn sixth = tList.get(5);

    BiPredicate<SalesTxn,String> stateBiPred =
      (t, s) -> t.getState().getStr().equals(s);

    System.out.println("\n== First is CA?");
    System.out.println(stateBiPred.test(first, testState));
    System.out.println("\n== Sixth is CA?");
    System.out.println(stateBiPred.test(sixth, testState));
  }
}
