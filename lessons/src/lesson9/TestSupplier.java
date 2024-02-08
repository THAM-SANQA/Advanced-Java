package lesson9;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author thamsanqa 2024
 **/
public class TestSupplier {
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        Supplier<SalesTxn> txnSupplier = () -> new SalesTxn.Builder()
                .txnId(101)
                .salesPerson("John Adams")
                .buyer(Buyer.getBuyerMap().get("PriceCo"))
                .product("Widget").paymentType("Cash")
                .unitPrice(20)
                .unitCount(10)
                .build();
        tList.add(txnSupplier.get());
        tList.forEach(t -> System.out.println(t.getTxnId() +
                t.getSalesPerson() +
                t.getProduct() +
                t.getUnitPrice() +
                t.getUnitCount()));
    }

}
