package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import io.swagger.api.dao.ArmaDAO;
import io.swagger.model.ArmaDto;

@Controller
public class ArmaApiController implements ArmaApi {

	@Autowired
	private ArmaDAO armaDAO;

	@Override
	public ResponseEntity<Void> cadastraNova(@Valid ArmaDto arma) {
		armaDAO.salva(arma);
		return ResponseEntity.ok(null);
	}

	@Override
	public ResponseEntity<ArmaDto> consultaPorId(Integer id) {
		return ResponseEntity.ok(armaDAO.consultaPorId(id));
	}

	@Override
	public ResponseEntity<Void> excluiExistente(Integer id) {
		armaDAO.exclui(id);
		return ResponseEntity.ok(null);
	}

	@Override
	public ResponseEntity<List<ArmaDto>> consultarTodos() {
		return ResponseEntity.ok(armaDAO.todos());
	}

}
