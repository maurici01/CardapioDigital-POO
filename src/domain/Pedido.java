package domain;

public class Pedido {
    private String id;
    private double valorTotal;

    public Pedido(String id, double valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
    }

    public String getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

}
