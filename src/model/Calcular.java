package model;

import java.util.Random;

public class Calcular {

    // Variável global
    Random rand = new Random();

    // Atributos da classe
    private int valor1;
    private int valor2;
    private final int operador;
    private int resultado;


    // Construtor
    public Calcular(int dificuldade) {
        // Randomizador, 0 -> somar | 1 -> diminuir | 2 -> multiplicar
        this.operador = rand.nextInt(3);
        this.nivelDificuldade(dificuldade);
    }


    // Metodos
    // Seleção de dificuldade
    public void nivelDificuldade(int dificuldade) {
        switch (dificuldade) {
            case 1: // Nível fácil
                this.valor1 = rand.nextInt(10); // Gera um valor inteiro entre 0 a 9
                this.valor2 = rand.nextInt(10); // Gera um valor inteiro entre 0 e 9
                break;

            case 2: // Nível médio
                this.valor1 = rand.nextInt(100);
                this.valor2 = rand.nextInt(100);
                break;

            case 3: // Nível difícil
                this.valor1 = rand.nextInt(1000);
                this.valor2 = rand.nextInt(1000);
                break;

            case 4: // Nível insano
                this.valor1 = rand.nextInt(10000);
                this.valor2 = rand.nextInt(10000);
                break;

            default: // Nível ultra
                this.valor1 = rand.nextInt(100000);
                this.valor2 = rand.nextInt(100000);
        }
    }


    // Método de soma
    public boolean somar(int resposta) {
        this.resultado = this.getValor1() + this.getValor2();
        boolean certo = false;

        if (resposta == this.getResultado()) {
            System.out.println("Resposta correta");
            certo = true;
        } else {
            System.out.println("Resosta errada");
        }

        System.out.printf("%d + %d = %d", this.getValor1(), this.getValor2(), getResultado());
        return certo;
    }


    // Metodo de subtração
    public boolean subtrair(int resposta) {
        this.resultado = this.getValor1() - this.getValor2();
        boolean certo = false;

        if (resposta == this.getResultado()) {
            System.out.println("Resposta correta");
            certo = true;
        } else {
            System.out.println("Resposta errada");
        }

        System.out.printf("%d + %d = %d", this.valor1, this.valor2, getResultado());
        return certo;
    }


    // Método multiplicar
    public boolean multiplicar(int resultado) {
        this.resultado = this.valor1 * this.valor2;
        boolean certo = false;

        if (resultado == this.getResultado()) {
            System.out.println("Resposta correta");
            certo = true;
        } else {
            System.out.println("Resposta errada");
        }

        System.out.printf("%d + %d = %d", this.valor1, this.valor2, getResultado());
        return certo;
    }


    // Getters & Setters
    public Integer getValor1() {
        return this.valor1;
    }


    public Integer getValor2() {
        return this.valor2;
    }


    public Integer getOperador() {
        return this.operador;
    }


    public Integer getResultado() {
        return this.resultado;
    }


    // ToString
    public String toString() {

        String op = switch ((this.getOperador())) {

            case 0 -> "Somar";
            case 1 -> "Subtração";
            case 2 -> "Multiplicação";
            default -> "Operador desconhecido";
        };

        return String.format("1° Valor: %d\n2° Valor: %d\nDificuldade: %d\nOperação: %d",
                this.getValor1(), this.getValor2(), op);
    }
}
