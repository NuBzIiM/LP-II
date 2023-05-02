package ifmt.cba.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "aluno")
public class AlunoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int matricula;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(name = "nomemae", nullable = false, length = 50)
    private String nomeMae;

    @Column(name = "nomepai", nullable = false, length = 50)
    private String nomePai;

    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;

    @Embedded
    private EnderecoVO endereco;

    public AlunoVO() {
        this.endereco = new EnderecoVO();
        this.matricula = 0;
        this.nome = "";
        this.nomeMae = "";
        this.nomePai = "";
        this.sexo = EnumSexo.FEMININO;
    }

    public AlunoVO(int matricula, String nome, EnumSexo sexo) {
        this();
        this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public EnumSexo getSexo() {
        return sexo;
    }

    public void setSexo(EnumSexo sexo) {
        this.sexo = sexo;
    }

    public EnderecoVO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoVO endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return matricula + ", " + nome + ", " + sexo + ", reside em: " + endereco;
    }
}