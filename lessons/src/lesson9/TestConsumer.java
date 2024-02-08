package lesson9;

import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();

        //consumer takes an object as input and returns void/nothing
        Consumer<SalesTxn> buyerConsumer = t -> System.out.println("Id: " + t.getTxnId() + " Buyer: " + t.getBuyerName());
        tList.stream()
                .forEach(buyerConsumer);
    }
}
