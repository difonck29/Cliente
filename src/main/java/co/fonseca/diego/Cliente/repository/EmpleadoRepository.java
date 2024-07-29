package co.fonseca.diego.Cliente.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.fonseca.diego.Cliente.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

  List<Empleado> findByPrimerNombre(String lastName);

  Empleado findById(long id);
}
