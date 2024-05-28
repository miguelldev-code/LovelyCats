package co.edu.usco.pw.springboot_crud01.userol;

public class UserRegistrationDto {
    private String userNombre;
    private String userApellido;
    private String userUser;
    private String userPassword;


    public UserRegistrationDto(String userNombre, String userApellido, String userUser, String userPassword) {
        this.userNombre = userNombre;
        this.userApellido = userApellido;
        this.userUser = userUser;
        this.userPassword = userPassword;
    }

    public String getUserNombre() {
        return userNombre;
    }

    public void setUserNombre(String userNombre) {
        this.userNombre = userNombre;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserUser() {
        return userUser;
    }

    public void setUserUser(String userUser) {
        this.userUser = userUser;
    }

    public String getUserApellido() {
        return userApellido;
    }

    public void setUserApellido(String userApellido) {
        this.userApellido = userApellido;
    }
}
