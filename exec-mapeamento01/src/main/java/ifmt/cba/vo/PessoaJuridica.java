package ifmt.cba.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa {
    
    private String razaoSocial;

    public PessoaJuridica() {
        
    }

    public PessoaJuridica(String nome, String razaoSocial) {
        super(nome);
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return getNome();
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.setNome(nomeFantasia);
    }

}
