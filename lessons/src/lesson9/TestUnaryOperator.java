package lesson9;

import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author TJ
 */
public class TestUnaryOperator {

    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        SalesTxn first = tList.get(0);

        UnaryOperator<String> unaryStr = String::toUpperCase;

        System.out.println("== Upper Buyer");
        System.out.println(unaryStr.apply(first.getBuyerName()));
    }
}
