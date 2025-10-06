package com.teste;

public class Calculadora {

    public static int soma(int val1, int val2) {
        return val1 + val2;
    }

    public static double soma(double val1, double val2) {
        return val1 + val2;
    }

    public static int multiplicacao(int val1, int val2) {
        return val1 * val2;
    }

    public static int subtracao(int val1, int val2) {
        return val1 - val2;
    }

    public static int divisao(int val1, int val2) {
        if (val2 == 0) {
            throw new ArithmeticException("Divisão por zero não permitida");
        }
        return val1 / val2;
    }

    public static double divisao(double val1, double val2) {
        if (val2 == 0.0) {
            throw new ArithmeticException("Divisão por zero não permitida");
        }
        return val1 / val2;
    }
}