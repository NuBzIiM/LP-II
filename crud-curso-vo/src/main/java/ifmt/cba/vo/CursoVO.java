package ifmt.cba.vo;

public class CursoVO {
    
    private int codigo;
    private String nome;
    private int cargahoraria;
    private int numsemestre;

    public CursoVO(){

    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getCargahoraria(){
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria){
        this.cargahoraria = cargahoraria;
    }

    public int getNumsemestre(){
        return numsemestre;
    }

    public void setNumsemestre(int numsemestre){
        this.numsemestre = numsemestre;
    }

    @Override
    public String toString(){
        return nome;
    }
}
