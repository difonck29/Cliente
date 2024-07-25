package co.fonseca.diego.Cliente.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.fonseca.diego.Cliente.dto.Cliente;

@Service
public class ClienteService {

    @Value("${tipoDocumento:null}")
    private String tipoDocumentoExt;
    
    @Value("${numeroDocumento:null}")
    private String numeroDocumento;

    @Value("${primerNombre:null}")
    private String primerNombre;
    
    @Value("${segundoNombre:null}")
    private String segundoNombre;

    @Value("${primerApellido:null}")
    private String primerApellido;
    
    @Value("${segundoApellido:null}")
    private String segundoApellido;

    @Value("${telefono:null}")
    private String telefono;
    
    @Value("${direccion:null}")
    private String direccion;

    @Value("${ciudad:null}")
    private String ciudad;

    public Cliente findByDocument(String tipoDocumento,String cedula){

        Cliente cliente = new Cliente();
        cliente.setTipoDocumento(tipoDocumentoExt);
        cliente.setNumeroDocumento(numeroDocumento);
        cliente.setPrimerNombre(primerNombre);
        cliente.setSegundoNombre(segundoNombre);
        cliente.setPrimerApellido(primerApellido);
        cliente.setSegundoApellido(segundoApellido);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setCiudadResidencia(ciudad);
        //cedula = null;
        if(cedula.equals(cliente.getNumeroDocumento()) || tipoDocumento.equalsIgnoreCase(tipoDocumentoExt)){
            return cliente;
        }
        System.out.println(cedula);
        return null;

    }

}
