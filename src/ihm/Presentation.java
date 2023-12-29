package ihm;

import metier.ProductMetier;

public class Presentation {

    private static ProductMetier productMetier = new ProductMetier();
    public static void main(String[] args) throws InterruptedException {

        while (true){
            System.out.println("Price = " + productMetier.getPrice() + " €");
            Thread.sleep(2000);
        }


    }
}
