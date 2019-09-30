package io.swagger.api;

import io.swagger.model.Arma;
import io.swagger.model.Armas;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.dao.ArmaDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-19T18:58:26.782Z")

@Controller
public class ArmasApiController implements ArmasApi {

    private static final Logger log = LoggerFactory.getLogger(ArmasApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private ArmaDAO armaDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public ArmasApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.armaDAO = new ArmaDAO();
    }
/**
 501-NÃO ENCONTRADO
return new ResponseEntity<Armas>(HttpStatus.NOT_IMPLEMENTED);
 
 400-REQUISIÇÃO INVALIDA
 return new ResponseEntity<Armas>(HttpStatus.BAD_REQUEST);
 
 401-REQUISIÇÃO NÃO AUTORIZADA
 return new ResponseEntity<Armas>(HttpStatus.UNAUTHORIZED);
**/
    public ResponseEntity<Armas> consultaTodos() {
    	
    	ResponseEntity<Armas> responseEntity = null;
    	
    	try {
    		
    		List<Arma> armas = armaDAO.todos();
    		

    		if(armas != null) {

    			if(armas.size() <= 0) { 
            		//404-NENHUM REGISTRO ENCONTRADO
    				responseEntity = new ResponseEntity<Armas>(objectMapper.readValue(objectMapper.writeValueAsString(armas), Armas.class), HttpStatus.NOT_FOUND);
    			}else {
    				
    				//200-SUCESSO AO CONSULTAR
    				responseEntity = new ResponseEntity<Armas>(objectMapper.readValue(objectMapper.writeValueAsString(armas), Armas.class), HttpStatus.OK);
        			
    				
    			}
    		}
    	}catch(Exception e){
    		
    		log.error("Erro ao tentar consultar armas.");
    		responseEntity = new ResponseEntity<Armas>(HttpStatus.INTERNAL_SERVER_ERROR);
    		
    	}
      
    	return responseEntity;
    }

}
