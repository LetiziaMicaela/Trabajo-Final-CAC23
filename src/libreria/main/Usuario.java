package libreria.main;

/**
 * La clase Usuario representa un usuario del sistema.
 */
public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    
    /**
     * Constructor de la clase Usuario.
     * @param nombreUsuario El nombre de usuario del usuario.
     * @param contrasena La contraseña del usuario.
     */
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    
     /**
     * Obtiene el nombre de usuario del usuario.
     * @return El nombre de usuario.
     */
     public String getNombreUsuario() {
        return nombreUsuario;
    }
     /**
     * Establece el nombre de usuario del usuario.
     * @param nombreUsuario El nombre de usuario a establecer.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
     /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Establece la contraseña del usuario.
     * @param contrasena La contraseña a establecer.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
