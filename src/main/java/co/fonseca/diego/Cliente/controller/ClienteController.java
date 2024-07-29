package co.fonseca.diego.Cliente.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import co.fonseca.diego.Cliente.dto.Cliente;
import co.fonseca.diego.Cliente.exception.BadRequestException;
import co.fonseca.diego.Cliente.exception.ResourceNotFoundException;
import co.fonseca.diego.Cliente.model.Empleado;
import co.fonseca.diego.Cliente.request.EmpleadoRequest;
import co.fonseca.diego.Cliente.services.ClienteService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * author: Diego Fonseca
 * objetivo: consulta de clientes
 */
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    /**
     * 
     * @param tipoDocumento tipo de documento del cliente
     * @param numeroDocumento numero de documento del cliente
     * @return información del cliente en caso de que el numro de documento y el tipo de documento sea valido
     */
    @GetMapping("/cliente")
    public ResponseEntity<Cliente>  obtenerCliente(@RequestParam(name = "tipoDocumento",required = false) String tipoDocumento, @RequestParam(name = "numeroDocumento",required = false) String numeroDocumento){
        
        /*if(tipoDocumento == null || numeroDocumento==null){
            throw new BadRequestException("Parametros obligatorios"); 
        }
        
        Cliente cliente = clienteService.findByDocument(tipoDocumento, numeroDocumento);
        clienteService.crearEmpleado();
        if(cliente == null){
            throw new ResourceNotFoundException("Not found Tutorial with id = "); 
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);*/
        //clienteService.crearEmpleado(Long.parseLong(tipoDocumento));
        return new ResponseEntity<>(new Cliente(), HttpStatus.OK);
    }

    @PostMapping(value = "/empleado",consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> registrarCliente(@Valid @RequestBody Empleado empleado){
        Empleado empleadoCreado = clienteService.crearEmpleado(empleado);
        return new ResponseEntity<>(empleadoCreado, HttpStatus.OK);
    }

}
