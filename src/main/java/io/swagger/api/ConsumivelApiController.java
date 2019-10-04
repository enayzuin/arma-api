package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import io.swagger.api.dao.ConsumivelDAO;
import io.swagger.model.ArmaDto;
import io.swagger.model.ConsumivelDto;


@Controller
public class ConsumivelApiController implements ConsumivelApi {

	@Autowired
	private ConsumivelDAO consumivelDAO;

	@Override
	public ResponseEntity<Void> cadastraNova(@Valid ConsumivelDto consumivel) {
		consumivelDAO.salva(consumivel);
		return ResponseEntity.ok(null);
	}

	@Override
	public ResponseEntity<ConsumivelDto> consultaPorId(Integer id) {
		return ResponseEntity.ok(consumivelDAO.consultaPorId(id));
	}

	@Override
	public ResponseEntity<Void> excluiExistente(Integer id) {
		consumivelDAO.exclui(id);
		return ResponseEntity.ok(null);
	}

	@Override
	public ResponseEntity<List<ConsumivelDto>> consultarTodos() {
		return ResponseEntity.ok(consumivelDAO.todos());
	}

}
