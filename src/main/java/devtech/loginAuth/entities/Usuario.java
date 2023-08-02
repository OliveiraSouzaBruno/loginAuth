package devtech.loginAuth.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name ="USUARIO")
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Column(name = "LOGIN")
    private String login;

    @Type(type = "true_false")
    @Column(name = "IS_ENABLED")
    private Boolean isEnabled;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ROLE_ID")
    private Role role;

    @NotNull
    @JsonIgnore
    @Column(name = "SENHA")
    private String senha;

    public Usuario(Usuario usuario) {
        super();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.isEnabled = usuario.getIsEnabled();
        this.role = usuario.getRole();
    }

    public Usuario() {
    }
}
