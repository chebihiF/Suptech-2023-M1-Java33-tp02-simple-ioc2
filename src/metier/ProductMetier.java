package metier;

import dao.IProductDao;

import java.io.BufferedReader;
import java.io.FileReader;


public class ProductMetier {
    private IProductDao productDao;

    public void injection() {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("ioc.config"));

            String line = "";
            String productDaoClassString="";
            while ((line = br.readLine())!=null){
                String prefix = line.split("=")[0];
                if(prefix.equals("dao")) {
                    productDaoClassString = line.split("=")[1];
                    break;
                }

            }

            Class productDaoClass = Class.forName(productDaoClassString);
            IProductDao idao = (IProductDao) productDaoClass.newInstance(); // new
            productDao = idao;
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public double getPrice(){
        injection();
        return productDao.getPrice() * 2;
    }
}
