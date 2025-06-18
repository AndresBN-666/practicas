package org.example.carrito;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    public void eliminarProducto(String nombre) {
        boolean eliminado = productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        if (!eliminado) {
            throw new IllegalArgumentException("No se puede eliminar el producto");
        }
    }
    public Double calcularTotal(){
        return productos.stream().mapToDouble(Producto :: getPrecio).sum();
    }

    public List<Producto>getProductos() {
        return productos;
    }
}
