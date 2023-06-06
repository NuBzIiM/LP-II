package ifmt.cba.vo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo_Produto;

    @Column(length = 40, nullable = false)
    private String nome_produto;

    @Column(length = 5, nullable = false)
    private float preco_venda;

    @ManyToOne(fetch = FetchType.EAGER)
    private GrupoProduto grupo_produto;

    @ManyToMany(fetch = FetchType.LAZY)
    private List <Fornecedor> fornecedor;

    public Produto(){

    }

    public Produto( String nome_produto, float preco_venda) {
        this.nome_produto = nome_produto;
        this.preco_venda = preco_venda;
        
    }



    public int getCodigo_Produto() {
        return codigo_Produto;
    }

    public void setCodigo_Produto(int codigo_Produto) {
        this.codigo_Produto = codigo_Produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public GrupoProduto getGrupo_produto() {
        return grupo_produto;
    }

    public void setGrupo_produto(GrupoProduto grupo_produto) {
        this.grupo_produto = grupo_produto;
    }

    public List<Fornecedor> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }

    


}   
