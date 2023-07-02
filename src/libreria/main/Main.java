package libreria.main;

import libreria.ui.MenuInicial;
import libreria.ui.MenuGestionStock;

/**
* Clase principal que inicia la aplicación.
*/
public class Main {

    /**
    * Punto de entrada de la aplicación.
    *
    * @param args Argumentos de línea de comandos.
    */
    public static void main(String[] args) {
        //instancia menu inicial
        MenuInicial menuInicial = new MenuInicial();
        //mostrar el menu inicial
        menuInicial.mostrarMenu();

         // Verificar si se ha iniciado sesión correctamente
        if (menuInicial.isSesionIniciada()) {
            // Crear una instancia de MenuGestionStock
            MenuGestionStock menuStock = new MenuGestionStock();

            // Mostrar el menú de gestión de stock
            menuStock.mostrarMenu();
        }

    }
    
}
