package atividade1;

public class Disciplina extends ElementoAcademico {
    private int semestre;
    private int cargaHoraria;

    public void setSemestre(int semestre) {

        this.semestre = semestre;
    }
    public int getSemestre(){
        return semestre;
    }
    public void setCargaHoraria(int cargaHoraria){

        this.cargaHoraria = cargaHoraria;
    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }
}
