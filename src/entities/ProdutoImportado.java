package entities;

public class ProdutoImportado extends Produto {
    private double customsFree;

    public ProdutoImportado() {
        super();
    }

    public ProdutoImportado(String name, double price, double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(double customsFree) {
        this.customsFree = customsFree;
    }

    public double totalPrice() {
        return getPrice() + customsFree;
    }

    @Override
    public String princeTag() {
        return super.getName() + " $ " + totalPrice() + "(Customs fee: $ " + customsFree + ")";
    }

}
