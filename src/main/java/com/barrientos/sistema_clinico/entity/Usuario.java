package com.barrientos.sistema_clinico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotEmpty
    @Column(name = "nom_usu")
    private String nomUsuario;

    @NotEmpty
    @Column(name = "clave_usu")
    private String claveUsuario;

    private Date fechaCreacion;

    private Date horaCreacion;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personas_id_persona", referencedColumnName = "id_persona", unique = true)
    private Persona persona;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipos_usuario_id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @PrePersist
    public void prePersist(){
        fechaCreacion = new Date();
        horaCreacion = new Date();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*List<GrantedAuthority> authorities = role.getPermissions().stream().map(permissionEnum
                -> new SimpleGrantedAuthority(permissionEnum.name())).collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        return authorities;*/

        return List.of(
                new SimpleGrantedAuthority("ROLE_" + tipoUsuario.getCodigoRol())
        );
    }

    @Override
    public @Nullable String getPassword() {
        return claveUsuario;
    }

    @Override
    public String getUsername() {
        return nomUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        //return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return UserDetails.super.isEnabled();
        return true;
    }
}
