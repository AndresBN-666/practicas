package PruebaUnitariaMetodos;

import org.example.ejercicios.Metodos;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMetodos {

    @Test
    void sumarImpares_ArrayImpares(){
        Metodos metodos = new Metodos();
        int[] numeros = {1, 2, 3, 4, 5};
        int resultado = metodos.sumarImpares(numeros);
        assertEquals(9, resultado);

    }

    @Test
    void FizzBuzz(){
        Metodos metodos = new Metodos();
        List<String> resultado = metodos.fizzBuzz();
        assertEquals("Fizz", resultado.get(2));
        assertEquals(100, resultado.size());
    }

    @Test
    void contarPalabras(){
        Metodos metodos = new Metodos();
        String texto = "hola mundo hola java mundo java hola";

        Map<String, Integer> resultado = metodos.contarPalabras(texto);

        assertEquals(3, resultado.size());
        assertEquals(3, resultado.get("hola"));
        assertEquals(2, resultado.get("java"));
        assertEquals(2, resultado.get("mundo"));
    }


}
