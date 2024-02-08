package lesson9;

import java.util.List;
import java.util.function.ToDoubleFunction;
/**
 * @author thamsanqa 2024
 **/
public class TestToDoubleFunction {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        SalesTxn first = tList.get(1);

        ToDoubleFunction<SalesTxn> discountFunction =
                t -> t.getTransactionTotal() * t.getDiscountRate();
        System.out.println("\n== Discount");
        System.out.println(discountFunction.applyAsDouble(first));

    }
}