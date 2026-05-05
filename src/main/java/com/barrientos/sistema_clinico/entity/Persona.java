package com.barrientos.sistema_clinico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name="personas")
public class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @NotEmpty
    @Size(min=8,max = 9)
    @Column(name = "nro_documento")
    private String nroDocumento;

    @NotEmpty (message = "{persona.nombreCompleto.notempty}")
    @Column(name = "nom_completo")
    private String nombreCompleto;

    @NotEmpty (message = "no puede dejar apellido vacio")
    @Column(name = "ape_completo")
    private String apellidoCompleto;

    private String sexo;

    @NotEmpty
    @Size(min=9,max = 9)
    private String celular;

    @NotNull
    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    private String direccion;

    @JsonIgnore
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;

    /*@PrePersist
    public void prePersist(){
        fechaNacimiento = new Date();
    }*/

}
