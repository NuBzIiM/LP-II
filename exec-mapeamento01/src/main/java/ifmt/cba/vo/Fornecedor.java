package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends PessoaJuridica{
    
    @ManyToMany
    private List <Produto> produto;

    public Fornecedor(){

    }

    public Fornecedor(List<Produto> produto) {
        this.produto = produto;
    }

    public Fornecedor(String nome, String razaoSocial) {
        super(nome, razaoSocial);
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
    
}