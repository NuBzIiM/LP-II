package ifmt.cba.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "venda")
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo_venda;

    @Column(length = 10, nullable = false)
    private Calendar data;

    @OneToMany(fetch = FetchType.EAGER)
    private List <ItemVenda> item_venda;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vendedor vendedor;

    public Venda(int data) {
        this.data = Calendar.getInstance();
    }

    public Venda() {

    }

    
    public float getValorVenda() {
        float valorTotal = 0;
        for(ItemVenda x : this.getItem_venda()) {
            valorTotal += x.getTotalItemVenda();
        }
        return valorTotal;
    }

    public int getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(int codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public List<ItemVenda> getItem_venda() {
        return item_venda;
    }

    public void setItem_venda(List<ItemVenda> item_venda) {
        this.item_venda = item_venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getDataFormata() {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        String x = dataFormatada.format(this.data.getTime());
        return x;
    }

    
}
