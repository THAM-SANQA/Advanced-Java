package lesson6;

public class TestWidgetPro {
    public static void main(String[] args) {
        WidgetPro wp = new WidgetPro(2_000,369,4000L,"BigWidget");
        System.out.println("Profit: R"+wp.calcProfit());
        wp.printItemReport();
    }
}
