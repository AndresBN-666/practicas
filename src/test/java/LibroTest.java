import org.example.herencia.Libro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    @Test
    public void aplicarDescuentoValido_deberiaReducirPrecio() {
        Libro libro = new Libro("java basico", "Andres", 100.0);
        libro.aplicarDescuento(20);
        assertEquals(80.0, libro.getPrecio());
    }
}
