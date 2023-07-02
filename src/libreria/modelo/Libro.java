package libreria.modelo;

/**
* Representa un libro en el inventario de la librería.
*/
public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private String editorial;
    private int cantidad;

    /**
    * Crea un nuevo objeto Libro con los datos proporcionados.
    *
    * @param codigo     El código del libro.
    * @param titulo     El título del libro.
    * @param autor      El autor del libro.
    * @param editorial  La editorial del libro.
    * @param cantidad   La cantidad disponible del libro.
    */
    public Libro(String codigo, String titulo, String autor, String editorial, int cantidad){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.cantidad = cantidad;
    }

    /**
    * Obtiene el código del libro.
    *
    * @return El código del libro.
    */
    public String getCodigo() {
        return codigo;
    }

    /**
    * Establece el código del libro.
    *
    * @param codigo El código del libro a establecer.
    */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
    * Obtiene el título del libro.
    *
    * @return El título del libro.
    */
    public String getTitulo() {
        return titulo;
    }

    /**
    * Establece el título del libro.
    *
    * @param titulo El título del libro a establecer.
    */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
    * Obtiene el autor del libro.
    *
    * @return El autor del libro.
    */
    public String getAutor() {
        return autor;
    }

    /**
    * Establece el autor del libro.
    *
    * @param autor El autor del libro a establecer.
    */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
    * Obtiene la editorial del libro.
    *
    * @return La editorial del libro.
    */
    public String getEditorial() {
        return editorial;
    }

    /**
    * Establece la editorial del libro.
    *
    * @param editorial La editorial del libro a establecer.
    */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
    * Obtiene la cantidad disponible del libro.
    *
    * @return La cantidad disponible del libro.
    */
    public int getCantidad() {
        return cantidad;
    }

    /**
    * Establece la cantidad disponible del libro.
    *
    * @param cantidad La cantidad disponible del libro a establecer.
    */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

