package io.swagger.api;

import io.swagger.model.Arma;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.dao.ArmaDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-19T18:58:26.782Z")

@Controller
public class ArmaApiController implements ArmaApi {

    private static final Logger log = LoggerFactory.getLogger(ArmaApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private ArmaDAO armaDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public ArmaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.armaDAO = new ArmaDAO();
    }

    public ResponseEntity<Arma> alteraArma(@ApiParam(value = "Id da arma.",required=true) @PathVariable("id") Integer id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody Arma arma) {
          
        ResponseEntity<Arma> responseEntity = null;
        
        try {
        	arma.setId(id);
        	Arma armaUpdate = armaDAO.altera(arma);
        	
        	if(armaUpdate == null) {
    		    throw new RuntimeException("Erro ao tentar alterar arma.");
    		
        	}
        	
        	responseEntity = new ResponseEntity<Arma>(armaUpdate, getHeaderlocation(armaUpdate.getId()), HttpStatus.ACCEPTED);
        
        } catch(Exception e) {
        	log.error("Falha ao tentar alterar arma.", e);
        	responseEntity = new ResponseEntity<Arma>(HttpStatus.INTERNAL_SERVER_ERROR);
        	
        }
        
        return responseEntity;
    
    }

    private MultiValueMap<String, String> getHeaderlocation(Integer id) {
    	
    	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
    	
    	    MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
    	    headers.add("location", location.getPath());
    
            return headers;
            
    }
    
    public ResponseEntity<Arma> alteraStatusPorId(@ApiParam(value = "Status da arma.",required=true, allowableValues = "\"ativo\", \"cofre\"") @PathVariable("status") String status,@ApiParam(value = "Numero do id da arma.",required=true) @PathVariable("id") Integer id) {

    //TODO implementar     
    return null;
    }

    public ResponseEntity<Arma> cadastraNova(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Arma arma) {

        ResponseEntity<Arma> responseEntity = null;
         
        try {
        
        	if(ehValido(arma)) {
        		
        		Arma armaNew = armaDAO.salva(arma);
        		
        		if(armaNew == null) {
        			throw new RuntimeException("Erro ao tentar cadastrar novo cliente.");
        		}
        		
        		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(armaNew.getId()).toUri();
        		
        		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        		headers.add("location", location.getPath());
        		
        		responseEntity = new ResponseEntity<Arma>(armaNew, headers , HttpStatus.CREATED);
        	}else {
        		responseEntity = new ResponseEntity<Arma>(HttpStatus.BAD_REQUEST);
        	}
        } catch (Exception e) {
        	log.error("Falha ao tentar cadastrar cliente.", e);
        	responseEntity = new ResponseEntity<Arma>(HttpStatus.INTERNAL_SERVER_ERROR);
        	
        }
    	
        return responseEntity;
    }
    
    private boolean ehValido(Arma arma) {
    	
    	if(arma != null) {
    		return true;
    	}
    	
    	return false;
    }

    public ResponseEntity<Arma> consultaPorId(@ApiParam(value = "Numero do Id da arma.",required=true) @PathVariable("id") Integer id) {
       ResponseEntity<Arma> responseEntity = null;
        
       try {
    	   
    	   Arma arma = armaDAO.consultaPorId(id);
    	   
    	   if(arma == null) {
    		   responseEntity = new ResponseEntity<Arma>(HttpStatus.NOT_FOUND);
    		   
    	   }else {
    		   responseEntity = new ResponseEntity<Arma>(arma,HttpStatus.OK);
    		   
    	   }
    	   
       } catch (Exception e) {
    	   log.error("Falha ao tentar consultar arma por id.", e);
    	   return new ResponseEntity<Arma>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
                 
    
        return responseEntity;
     }
    	

    public ResponseEntity<Arma> consultaPorRaridade(@ApiParam(value = "Raridade da arma",required=true) @PathVariable("raridade") String raridade) {

        //TODO implementar     
        return null;
        }

    public ResponseEntity<Void> excluiExistente(@ApiParam(value = "Numero do Id da arma.",required=true) @PathVariable("id") Integer id) {

        //TODO implementar     
        return null;
        }
}
