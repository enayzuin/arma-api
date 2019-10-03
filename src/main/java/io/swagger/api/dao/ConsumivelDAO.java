package io.swagger.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;

import io.swagger.entity.ArmaEntity;
import io.swagger.entity.ConsumivelEntity;
import io.swagger.model.ArmaDto;
import io.swagger.model.ConsumivelDto;
import io.swagger.model.ArmaDto.TipoEnum;
import io.swagger.repository.ConsumivelRepository;

@Component
public class ConsumivelDAO {


	@Autowired
	private ConsumivelRepository consumivelRepository;

	public List<ConsumivelDto> todos() {
		List<ConsumivelEntity> consumiveisEntity = consumivelRepository.findAll();
		List<ConsumivelDto> consumiveisDto = new ArrayList<>();
		consumiveisEntity.forEach(ConsumivelEntity -> {
			ConsumivelDto ConsumivelDto = consumivelEntityToConsumivelDto((io.swagger.entity.ConsumivelEntity) consumiveisEntity);
			consumiveisDto.add(ConsumivelDto);

		});
		return consumiveisDto;
	}


	public void salva(ConsumivelDto consumivel) {

		ConsumivelEntity consumivelEntity = new ConsumivelEntity();
		consumivelEntity.setDano(consumivel.getCura());
		consumivelEntity.setNome(consumivel.getNome());
		consumivelRepository.save(consumivelEntity);

	}
	

	public void exclui(Integer id) {
		consumivelRepository.deleteById(Long.valueOf(id));
	}

	public ConsumivelDto consultaPorId(Integer id) {

		ConsumivelEntity consumivelEntity = consumivelRepository.findById(Long.valueOf(id)).get();
		ConsumivelDto consumivelDto = consumivelEntityToConsumivelDto(consumivelEntity);

		return consumivelDto;
	}

	private ConsumivelDto consumivelEntityToConsumivelDto(ConsumivelEntity consumivelEntity) {
		ConsumivelDto consumivelDto = new ConsumivelDto();
		consumivelDto.setId(consumivelEntity.getId().intValue());
		consumivelDto.setCura(consumivelEntity.getCura());
		consumivelDto.setNome(consumivelEntity.getNome());

		return consumivelDto;
	}



}
