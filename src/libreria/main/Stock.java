package libreria.main;

import java.util.List;
import java.util.ArrayList;

import libreria.modelo.Libro;

/**
 * La clase Stock representa el inventario de libros de una librería.
 */
public class Stock {
    private List<Libro> inventario; //lista de objetos libro


    /**
     * Constructor de la clase Stock.
     * Inicializa el inventario como una nueva lista vacía.
     */
    public Stock() {
        inventario = new ArrayList<>();
    }
    //agrega un objeto 'libro' al inventario
    public void agregarProducto(Libro libro) {
        inventario.add(libro);
    }
    //elimina el objeto 'libro' del inventario
    public void eliminarProducto(Libro libro) {
        inventario.remove(libro);
    }
    // devuelve la lista completa de libros en el inventario
    public List<Libro> getInventario() {
        return inventario;
    }

}