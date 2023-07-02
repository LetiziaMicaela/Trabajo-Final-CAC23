package libreria.ui;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import libreria.main.Stock;
import libreria.modelo.Libro;

public class MenuGestionStock  extends JFrame{

    private MenuInicial menuInicial; // Agrega una referencia al menú inicial

    /**
    * Constructor que recibe una instancia del menú inicial.
    *
    * @param menuInicial La instancia del menú inicial.
    */
    public MenuGestionStock(MenuInicial menuInicial) {
        this.menuInicial = menuInicial;
    }


    private Stock stock; // Variable  ara almacenar la instancia de Stock

    /**
    * Constructor de la clase MenuGestionStock.
    * Inicializa la instancia de Stock.
    */
    public MenuGestionStock() {
        stock = new Stock(); // Inicializar la instancia de Stock
    }
    
    /**
    * Interfaz gráfica del menú de stock.
    */
    public void mostrarMenu(){
        setTitle("Menu de Stock");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton agregarProductoBtn = new JButton("Agregar Producto");
        agregarProductoBtn.setBounds(50, 30, 200, 30);
        agregarProductoBtn.addActionListener(e -> agregarProducto());
        panel.add(agregarProductoBtn);

        JButton eliminarProductoBtn = new JButton("Eliminar Producto");
        eliminarProductoBtn.setBounds(50, 70, 200, 30);
        eliminarProductoBtn.addActionListener(e -> eliminarProducto());
        panel.add(eliminarProductoBtn);

        JButton mostrarInventarioBtn = new JButton("Mostrar Inventario");
        mostrarInventarioBtn.setBounds(50, 110, 200, 30);
        mostrarInventarioBtn.addActionListener(e -> mostrarInventario());
        panel.add(mostrarInventarioBtn);

        JButton cerrarSesionBtn = new JButton("Cerrar Sesión");
        cerrarSesionBtn.setBounds(50, 150, 200, 30);
        cerrarSesionBtn.addActionListener(e -> cerrarSesion());
        add(cerrarSesionBtn);

         // Agregar el panel al marco
        add(panel);
        
        setVisible(true);
    }

 

    /**
    * Método para agregar un producto al stock.
    */
    public void agregarProducto(){
        String codigo = JOptionPane.showInputDialog(this, "Ingrese el código del producto:");
        String titulo = JOptionPane.showInputDialog(this, "Ingrese el título del producto:");
        String autor = JOptionPane.showInputDialog(this, "Ingrese el autor del producto:");
        String editorial = JOptionPane.showInputDialog(this, "Ingrese la editorial del producto:");
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad disponible del producto:");
        int cantidad = Integer.parseInt(cantidadStr);
        
        // Crear el objeto Libro con los datos ingresados
        Libro libro = new Libro(codigo, titulo, autor, editorial, cantidad);

        // Agregar el libro al inventario utilizando la instancia de Stock
        stock.agregarProducto(libro);

        JOptionPane.showMessageDialog(this, "Producto agregado al inventario exitosamente");

    }


    /**
    * Método para eliminar un producto del stock.
    */
    public void eliminarProducto(){
        String codigo = JOptionPane.showInputDialog(this, "Ingrese el código del producto a eliminar:");
         // Buscar el libro en el inventario por su código
        Libro libroEncontrado = null;
        for (Libro libro : stock.getInventario()) {
            if (libro.getCodigo().equals(codigo)) {
                libroEncontrado = libro;
                break;
            }
        }

        if (libroEncontrado != null) {
            // Eliminar el libro del inventario utilizando la instancia de Stock
            stock.eliminarProducto(libroEncontrado);
            JOptionPane.showMessageDialog(this, "Producto eliminado del inventario exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún producto con el código ingresado");
        }


    }


    /**
    * Método para mopstrar el inventario.
    */
    public void mostrarInventario(){
        List<Libro> inventario = stock.getInventario();

        if (inventario.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El inventario está vacío");
        } else {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventario de Libros:\n");

        for (Libro libro : inventario) {
            sb.append("Código: ").append(libro.getCodigo()).append("\n");
            sb.append("Título: ").append(libro.getTitulo()).append("\n");
            sb.append("Autor: ").append(libro.getAutor()).append("\n");
            sb.append("Editorial: ").append(libro.getEditorial()).append("\n");
            sb.append("Cantidad: ").append(libro.getCantidad()).append("\n");
            sb.append("-----------------------------------\n");
        }

         JOptionPane.showMessageDialog(this, sb.toString());
        }


    }

    /**
    * Método para cerrar la sesión actual y mostrar el menú inicial.
    */
    public void cerrarSesion(){
        setVisible(false); // Ocultar la ventana actual 
        menuInicial.mostrarMenu(); // Mostrar el menú inicial
    }

}





  
