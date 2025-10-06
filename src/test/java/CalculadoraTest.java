import com.teste.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {

    //region Testes unitários básicos
    @Test
    void testSomaInteirosPositivos() {
        assertEquals(15, Calculadora.soma(10, 5));
    }

    @Test
    void testSomaInteirosNegativos() {
        assertEquals(-5, Calculadora.soma(-2, -3));
    }

    @Test
    void testSomaPositivoNegativo() {
        assertEquals(2, Calculadora.soma(5, -3));
    }

    @Test
    void testMultiplicacao() {
        assertEquals(20, Calculadora.multiplicacao(4, 5));
    }

    @Test
    void testMultiplicacaoPorZero() {
        assertEquals(0, Calculadora.multiplicacao(10, 0));
    }

    @Test
    void testSubtracao() {
        assertEquals(3, Calculadora.subtracao(10, 7));
    }

    @Test
    void testDivisaoInteiros() {
        assertEquals(2, Calculadora.divisao(10, 5));
    }

    @Test
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> {
            Calculadora.divisao(10, 0);
        });
    }
    //endregion

    //region Testes de limite & parametrizados
    @Test
    void testDivisaoValoresLimite() {
        // Valores próximos a zero
        assertEquals(0, Calculadora.divisao(1, Integer.MAX_VALUE));
        assertThrows(ArithmeticException.class, () -> Calculadora.divisao(1, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "0, 0, 0",
            "-1, -1, -2",
            "100, 200, 300"
    })
    void testSomaParametrizada(int a, int b, int expected) {
        assertEquals(expected, Calculadora.soma(a, b));
    }

    @Test
    void testSomaDouble() {
        assertEquals(4.5, Calculadora.soma(2.5, 2.0));
    }

    @Test
    void testDivisaoDouble() {
        assertEquals(2.5, Calculadora.divisao(5.0, 2.0));
    }

    @Test
    void testDivisaoDoublePorZero() {
        assertThrows(ArithmeticException.class, () -> {
            Calculadora.divisao(5.0, 0.0);
        });
    }

    @Test
    void testSomaValoresExtremos() {
        assertEquals(-1, Calculadora.soma(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
    //endregion
}