package co.fonseca.diego.Cliente.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import co.fonseca.diego.Cliente.dto.Cliente;
import co.fonseca.diego.Cliente.exception.BadRequestException;
import co.fonseca.diego.Cliente.exception.ResourceNotFoundException;
import co.fonseca.diego.Cliente.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author: Diego Fonseca
 * objetivo: consulta de clientes
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    /**
     * 
     * @param tipoDocumento tipo de documento del cliente
     * @param numeroDocumento numero de documento del cliente
     * @return información del cliente en caso de que el numro de documento y el tipo de documento sea valido
     */
    @GetMapping("/")
    public ResponseEntity<Cliente>  obtenerCliente(@RequestParam(name = "tipoDocumento",required = false) String tipoDocumento, @RequestParam(name = "numeroDocumento",required = false) String numeroDocumento){
        
        if(tipoDocumento == null || numeroDocumento==null){
            throw new BadRequestException("Parametros obligatorios"); 
        }
        
        Cliente cliente = clienteService.findByDocument(tipoDocumento, numeroDocumento);
        if(cliente == null){
            throw new ResourceNotFoundException("Not found Tutorial with id = "); 
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

}
