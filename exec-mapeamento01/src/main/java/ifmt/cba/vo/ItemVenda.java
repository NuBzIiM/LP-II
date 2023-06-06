package ifmt.cba.vo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo_item;

    @Column(length = 5, nullable = false)
    private int quantidade;

    @Column(length = 10, nullable = false)
    private float preco_venda;

    @Column(length = 3, nullable = false)
    private float perDesconto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    public ItemVenda(){
        
    }

    public ItemVenda( int quantidade, float preco_venda, float perDesconto) {
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.perDesconto = perDesconto;
    }

    public double getTotalItemVenda() {
        return (1-this.perDesconto/100)*(this.quantidade*this.preco_venda);
    }

    public int getCodigo_item() {
        return codigo_item;
    }

    public void setCodigo_item(int codigo_item) {
        this.codigo_item = codigo_item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public float getPerDesconto() {
        return perDesconto;
    }

    public void setPerDesconto(float perDesconto) {
        this.perDesconto = perDesconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
