package ifmt.cba.execucao;

import ifmt.cba.negocio.Calculadora;

public class AppCalculadora {
    public static void main (String[] args){
        Calculadora calc = new Calculadora();
        System.out.println("--------------------------");
        System.out.println("Soma de 10 + 30= "+calc.somar(10, 30));
        System.out.println("Subtracao de 30 - 15= "+calc.subtrair(30, 15));
        System.out.println("Multiplicacao de 20 * 30= "+calc.multiplicar(20 , 30));
        System.out.println("Divisao de 50 / 2= "+calc.dividir(50 , 2));
        System.out.println("-----------------------------------");
    }
}
