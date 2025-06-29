package miguel.lovelycats.userol;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = "UserUser"))
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Userid;

    private String UserNombre;
    private String UserApellido;
    private String UserUser;
    private String UserPassword;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "Userid"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rolId")

    )
    private Collection<rol> roles;


    public Users() {
        super();
    }

    public Users(Long userid, String userNombre, String userApellido, String userUser,
                 String userPassword, Collection<rol> roles) {
        super();
        Userid = userid;
        UserNombre = userNombre;
        UserApellido = userApellido;
        UserUser = userUser;
        UserPassword = userPassword;
        this.roles = roles;
    }

    public Users(String userNombre, String userApellido, String userUser,
                 String userPassword, Collection<rol> roles) {
        super();
        UserNombre = userNombre;
        UserApellido = userApellido;
        UserUser = userUser;
        UserPassword = userPassword;
        this.roles = roles;
    }

    public Long getUserid() {
        return Userid;
    }

    public void setUserid(Long userid) {
        Userid = userid;
    }

    public String getUserNombre() {
        return UserNombre;
    }

    public void setUserNombre(String userNombre) {
        UserNombre = userNombre;
    }

    public String getUserApellido() {
        return UserApellido;
    }

    public void setUserApellido(String userApellido) {
        UserApellido = userApellido;
    }

    public String getUserUser() {
        return UserUser;
    }

    public void setUserUser(String userUser) {
        UserUser = userUser;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public Collection<rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<rol> roles) {
        this.roles = roles;
    }
}
