package io.swagger.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;

import io.swagger.entity.ArmaEntity;
import io.swagger.model.ArmaDto;
import io.swagger.model.ArmaDto.TipoEnum;
import io.swagger.repository.ArmaRepository;

@Component
public class ArmaDAO {


	@Autowired
	private ArmaRepository armaRepository;

	public List<ArmaDto> todos() {
		List<ArmaEntity> armasEntity = armaRepository.findAll();
		List<ArmaDto> armasDto = new ArrayList<>();
		armasEntity.forEach(armaEntity -> {
			ArmaDto armaDto = armaEntityToArmaDto(armaEntity);
			armasDto.add(armaDto);

		});
		return armasDto;
	}

	public void salva(ArmaDto arma) {

		ArmaEntity armaEntity = new ArmaEntity();
		armaEntity.setDano(arma.getDano());
		armaEntity.setNome(arma.getNome());
		armaEntity.setDataAtualizacao(OffsetDateTime.now());
		armaRepository.save(armaEntity);

	}

	public void exclui(Integer id) {
		armaRepository.deleteById(Long.valueOf(id));
	}

	public ArmaDto consultaPorId(Integer id) {

		ArmaEntity armaEntity = armaRepository.findById(Long.valueOf(id)).get();
		ArmaDto armaDto = armaEntityToArmaDto(armaEntity);

		return armaDto;
	}

	private ArmaDto armaEntityToArmaDto(ArmaEntity armaEntity) {
		ArmaDto armaDto = new ArmaDto();
		armaDto.setId(armaEntity.getId().intValue());
		armaDto.setDano(armaEntity.getDano());
		armaDto.setNome(armaEntity.getNome());
		armaDto.setDtAtualizacao(armaEntity.getDataAtualizacao());
		// TODO INCREMENTAR NO BANCO DE DADOS
		armaDto.setRaridade("IMPLEMENTAR RARIDADE NO BANCO DE DADOS");
		// TODO INCREMENTAR NO BANCO DE DADOS
		armaDto.setStatus(true);
		// TODO INCREMENTAR NO BANCO DE DADOS
		armaDto.setTipo(TipoEnum.AR);
		return armaDto;
	}

}
