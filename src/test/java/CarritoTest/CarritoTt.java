package CarritoTest;

import org.example.carrito.Carrito;
import org.example.carrito.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarritoTt {

    @Test
    public void agregarYCalcularTotal(){
        Carrito carrito = new Carrito();
        carrito.agregarProducto(new Producto("Libro", 50.0));
        carrito.agregarProducto(new Producto("Lapicero", 10.0));

        assertEquals(60.0, carrito.calcularTotal());
    }

    @Test
    public void remover(){
        Carrito carrito = new Carrito();
        carrito.agregarProducto(new Producto("Libro", 50.0));
        carrito.eliminarProducto("Libro");
        assertEquals(0.0, carrito.calcularTotal());
    }

    @Test
    public void eliminarInexistente(){
        Carrito carrito = new Carrito();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            carrito.eliminarProducto("celular");
        });
        assertEquals("No se puede eliminar el producto", ex.getMessage());
    }

    @Test
    public void agregarProductoEnNegativo(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Producto("Tv", -100.0);
        });
        assertEquals("Precio no puede ser negativo", ex.getMessage());
    }
}
