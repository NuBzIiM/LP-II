package atividade1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class ColecaoAluno implements IColecaoGenerica {

    ArrayList listaAluno;

    public ColecaoAluno(){
        listaAluno = new ArrayList();
    }
    public void adicionaAluno(Aluno aluno){
        listaAluno.add(aluno);
    }
    public Iterator getIterator(){
        return listaAluno.iterator();
    }
    public void ordena(){
        Collections.sort(listaAluno, new ComparaNome());
    }
}
