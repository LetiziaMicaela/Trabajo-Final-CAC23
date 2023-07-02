package libreria.ui;
// user interface 
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
* Clase que representa el menú inicial de la aplicación.
*/
public class MenuInicial  extends JFrame{
    private static final String usuariosFile = "usuarios.txt"; // Nombre del archivo de usuarios
    private boolean sesionIniciada = false; // Variable para rastrear si se ha iniciado sesión

    /**
    * Constructor de la clase MenuInicial.
    * Inicializa la variable de sesión iniciada como falsa.
    */
    public MenuInicial() {
        sesionIniciada = false;// Al crear una instancia, se inicia sin sesión iniciada
    }

    /**
    * Método para mostrar el menú inicial en la ventana.
    */
    public void mostrarMenu (){
      setTitle("Menu Inicial");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton crearUsuarioBtn = new JButton("Crear Usuario");
        crearUsuarioBtn.setBounds(50, 30, 200, 30);
        crearUsuarioBtn.addActionListener(e -> crearUsuario());
        add(crearUsuarioBtn);

        JButton iniciarSesionBtn = new JButton("Iniciar Sesión");
        iniciarSesionBtn.setBounds(50, 70, 200, 30);
        iniciarSesionBtn.addActionListener(e -> iniciarSesion());
        add(iniciarSesionBtn);

        JButton salirBtn = new JButton("Salir");
        salirBtn.setBounds(50, 110, 200, 30);
        salirBtn.addActionListener(e -> salir());
        add(salirBtn);

        
        
        setVisible(true);

    }

    /**
    * Método para crear un nuevo usuario.
    * Solicita al usuario el nombre y la contraseña, y luego guarda la información en el archivo de usuarios.
    */
     public void crearUsuario() {
        String username = JOptionPane.showInputDialog(this, "Ingrese el nombre de usuario:");
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(this, passwordField, "Ingrese la contraseña:", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION && username != null) {
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            guardarUsuario(username, password);
            JOptionPane.showMessageDialog(this, "Usuario creado exitosamente");
        }
    } 
    
    /**
    * Método para guardar un nuevo usuario en el archivo de usuarios.
    *
    * @param username el nombre de usuario a guardar.
    * @param password la contraseña del usuario a guardar.
    */
    public void guardarUsuario(String username, String password) {
        try {
            FileWriter fileWriter = new FileWriter("usuarios.txt", true);
            //txt de usuarios 
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(username + "," + password);
            printWriter.close();
            System.out.println("Usuario guardado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Método para iniciar sesión.
    * Solicita al usuario el nombre y la contraseña, y verifica las credenciales con el archivo de usuarios.
    */
    public void iniciarSesion() {
        String username = JOptionPane.showInputDialog(this, "Ingrese el nombre de usuario:");
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(this, passwordField, "Ingrese la contraseña:", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION && username != null) {
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            // Lógica para verificar el inicio de sesión del usuario
            if (verificarCredenciales(username, password)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                // Crear una instancia de MenuGestionStock y pasar la referencia correcta de MenuInicial
            
                MenuGestionStock menuGestionStock = new MenuGestionStock(this);
                menuGestionStock.mostrarMenu();              

            } else {
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos");
            } 
        }
    }


    /**
    * Verifica las credenciales del usuario comparándolas con los datos del archivo de usuarios.
    *
    * @param username el nombre de usuario a verificar.
    * @param password la contraseña a verificar.
    * @return true si las credenciales son válidas, false en caso contrario.
    */
    public boolean verificarCredenciales(String username, String password) {
       
    try {
        File file = new File(usuariosFile);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                scanner.close();
                return true;
            }
        }

        scanner.close();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
    
    return false; // Si no se encontró ninguna coincidencia, se devuelve false
    }

    /**
    * Verifica si se ha iniciado una sesión.
    *
    * @return true si se ha iniciado una sesión, false en caso contrario.
    */
    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    /**
    * Método para salir del programa.
    */
    public void salir() {
        System.exit(0);// salir del programa
    }
         
}
