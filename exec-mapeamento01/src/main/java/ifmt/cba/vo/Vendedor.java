package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor extends PessoaFisica{
    
    
    @Column(length = 10, nullable = false)
    private float per_comissao;

    @OneToMany(fetch = FetchType.LAZY)
    private List <Venda> venda;

    public Vendedor() {

    }
    
    public Vendedor(float per_comissao) {
        this.per_comissao = per_comissao;
    }

    public Vendedor(String nome, String rg, String cpf, float per_comissao) {
        super(nome, rg, cpf);
        this.per_comissao = per_comissao;
    }

    public float getComissao(float t) {
        return t*(this.getPer_comissao()/100);
    } 

    
    public float getPer_comissao() {
        return per_comissao;
    }

    public void setPer_comissao(float per_comissao) {
        this.per_comissao = per_comissao;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

  
  
}
