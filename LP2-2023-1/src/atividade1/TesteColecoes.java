package atividade1;

public class TesteColecoes {
    public static void main(String args[]){
        Aluno aluno;
        ColecaoAluno colecaoAluno = new ColecaoAluno();

        ImprimeColecao relatorio;

        aluno = new Aluno();
        aluno.setMatricula(10);
        aluno.setNome("Fulano");
        aluno.setSemestre(1);
        colecaoAluno.adicionaAluno(aluno);

        aluno = new Aluno();
        aluno.setMatricula(10);
        aluno.setNome("Fulana");
        aluno.setSemestre(1);
        colecaoAluno.adicionaAluno(aluno);

        colecaoAluno.ordena();
        relatorio = new ImprimeColecao(colecaoAluno);
        relatorio.imprimir();
    }
}
