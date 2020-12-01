package com.andrey.rest_spring_jpa.respository;

import com.andrey.rest_spring_jpa.dto.PersonaDto;
import com.andrey.rest_spring_jpa.models.Persona;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IPersonaRepositoryJpa extends JpaRepository<Persona, Integer> {

    @Query(value = "SELECT new com.andrey.rest_spring_jpa.dto.PersonaDto("
            + "p.id, "
            + "p.nombre, "
            + "p.apellido, "
            + "p.fechanacimiento, "
            + "p.telefono, "
            + "p.direccion, "
            + "p.estado) "
            + "FROM Persona AS p "
            + "ORDER BY p.estado")
    List<PersonaDto> obtenerPersonas();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO persona (nombre, apellido, telefono, fechanacimiento, direccion, estado) "
            + "values  (:nombre, :apellido, :telefono, :fechanacimiento, :direccion, :estado) ", nativeQuery = true)
    Integer crearPersona(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("fechanacimiento") Date fechanacimiento,
            @Param("telefono") String telefono,
            @Param("direccion") String direccion,
            @Param("estado") String estado);

    @Transactional
    @Modifying
    @Query(value = "UPDATE persona SET "
            + "nombre =:nombre, "
            + "apellido =:apellido, "
            + "fechanacimiento =:fechanacimiento, "
            + "telefono =:telefono, "
            + "direccion =:direccion "
            + "WHERE id = :id", nativeQuery = true)
    Integer actualizarPersona(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("fechanacimiento") Date fechanacimiento,
            @Param("telefono") String telefono,
            @Param("direccion") String direccion,
            @Param("id") Integer id);
    
    @Query(value = "SELECT new com.andrey.rest_spring_jpa.dto.PersonaDto("
            + "p.id, "
            + "p.nombre, "
            + "p.apellido, "
            + "p.fechanacimiento, "
            + "p.telefono, "
            + "p.direccion, "
            + "p.estado) "
            + "FROM Persona AS p "
            + "WHERE p.id = :id "
            + "ORDER BY p.estado")
    PersonaDto obtenerPersona(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE persona SET estado =:estado "
            + "WHERE id = :id", nativeQuery = true)
    Integer actualizarEstadoPersona(
            @Param("estado") String estado,
            @Param("id") Integer id);
    
}
