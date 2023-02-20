package atividade1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class ColecaoDisciplina implements IColecaoGenerica {

    ArrayList listaDisciplina;

    public ColecaoDisciplina(){
        listaDisciplina = new ArrayList();
    }
    public void adicionaDisciplina(Disciplina disciplina){
        listaDisciplina.add(disciplina);
    }
    public Iterator getIterator(){
        return listaDisciplina.iterator();
    }
    public void ordena(){
        Collections.sort(listaDisciplina, new ComparaNome());
    }
}
