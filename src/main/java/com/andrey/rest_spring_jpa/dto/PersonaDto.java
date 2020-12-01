package com.andrey.rest_spring_jpa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(description = "Dto para el manejo de los datos de la tabla personas y relaciones")
@Data
public class PersonaDto {

    @ApiModelProperty(notes = "ID generado automáticamente por la BD")
    @JsonProperty("id")
    private Integer id;

    @ApiModelProperty(notes = "Nombre de la persona")
    @JsonProperty("nombre")
    private String nombre;

    @ApiModelProperty(notes = "Apellido de la persona")
    @JsonProperty("apellido")
    private String apellido;

    @ApiModelProperty(notes = "Apellido de la persona")
    @JsonProperty("fecha_nacimiento")
    private Date fechanacimiento;

    @ApiModelProperty(notes = "Apellido de la persona")
    @JsonProperty("telefono")
    private String telefono;

    @ApiModelProperty(notes = "Apellido de la persona")
    @JsonProperty("direccion")
    private String direccion;

    @ApiModelProperty(notes = "Estado de la persona")
    @JsonProperty("estado")
    private String estado;

    public PersonaDto() {
    }
     
    public PersonaDto(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public PersonaDto(Integer id, String nombre, String apellido, Date fechanacimiento, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public PersonaDto(Integer id, String nombre, String apellido, Date fechanacimiento, String telefono, String direccion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }


}
