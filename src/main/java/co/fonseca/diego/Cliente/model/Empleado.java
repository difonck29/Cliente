package co.fonseca.diego.Cliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Empleado {

    @Id
    @Max(4999)
    @Column(name="ID_EMPLEADO")
    @Min(2) 
    private Long idEmpleado;

    @Column(name="PRIMER_NOMBRE")
    @NotBlank(message = "primerNombre is mandatory")
    private String primerNombre;

    @Column(name="SEGUNDO_NOMBRE")
    private String segundoNombre;

    @Column(name="PRIMER_APELLIDO")
    private String primerApellido;

    @Column(name="SEGUNDO_APELLIDO")
    private String segundoApllido;

    @Column(name="EDAD")
    private int edad;

    @Column(name="NUM_IDENTIFICACION")
    private String numIdentificacion;
}
