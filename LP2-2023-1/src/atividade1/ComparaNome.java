package atividade1;

import java.util.Comparator;

public class ComparaNome implements Comparator {
    public int compare(Object objeto1, Object objeto2) {
        String nome1 = ((IPossuiNome)objeto1).getNome();
        String nome2 = ((IPossuiNome)objeto2).getNome();
        return nome1.compareTo(nome2);
    }
}
