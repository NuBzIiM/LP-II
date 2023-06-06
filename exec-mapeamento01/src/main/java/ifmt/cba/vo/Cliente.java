package ifmt.cba.vo;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends PessoaFisica{
    
    @Column(length = 10000, nullable = false)
    private float limiteCred;

    @OneToMany(fetch = FetchType.LAZY)
    private List <Venda> venda;

    public Cliente() {
        
    }

    public Cliente(String nome, String rg, String cpf, float limiteCred) {
        super(nome, rg, cpf);
        this.limiteCred = limiteCred;
    }

    public float getLimiteCred() {
        return limiteCred;
    }

    public void setLimiteCred(float limiteCred) {
        this.limiteCred = limiteCred;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

    

   

}