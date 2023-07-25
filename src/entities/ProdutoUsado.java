package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    private Date manufactureDate;

    public ProdutoUsado(){
        super();
    }

    public ProdutoUsado(String name, double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String princeTag() throws ParseException {
        return super.getName() + "(used)" + " $ "+super.getPrice() + "(Manufacture date: " + fmt.format(manufactureDate) + ")";
    }
}
