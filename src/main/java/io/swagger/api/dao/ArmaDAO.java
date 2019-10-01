package io.swagger.api.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.threeten.bp.OffsetDateTime;

import io.swagger.entity.ArmaEntity;
import io.swagger.model.Arma;
import io.swagger.model.Arma.TipoEnum;
import io.swagger.repository.ArmaRepository;

public class ArmaDAO {

	private static List<Arma> armas; 
	
	@Autowired private ArmaRepository armaRepository;
	
	
	
	public ArmaDAO() {
		armas = new ArrayList<Arma>();
		armas.add(mockInicial());
	}
	
	public List<Arma> todos(){
		return armas;
	}
	
	public void salva(Arma arma) {
		
		ArmaEntity armaEntity = new ArmaEntity();
		
		armaEntity.setNome(arma.getNome());
		armaRepository.save(armaEntity);

	}
	
	public boolean exclui(Integer id) {
		
		Integer idToRemove = null;
		
		for(Arma arma: armas) {
			if(arma.getId().equals(id)) {
				idToRemove = armas.indexOf(arma);
			}
		}
		
		if(idToRemove != null) {
			Arma arma = armas.get(idToRemove.intValue());
			
			if(arma != null) {
				boolean removed = armas.remove(arma);
				return removed;
			}
		}
		
		return false;
	}
	
	public Arma consultaPorId(Integer id) {
		
		Integer idToRead = null;
		
		for(Arma armalz: armas) {
			if(armalz.getId().equals(id)) {
				idToRead = armas.indexOf(armalz);
			}
		}
		
		if(idToRead != null) {
			return armas.get(idToRead);
		}
		
		return null;
	}
	
	public List<Arma> consultaPorRaridade(String raridade) {

		Integer idToRead = null;
		List<Arma> armaslz = new ArrayList<Arma>();
		
		for(Arma armalz: armas) {
			if(armalz.getRaridade().equals(raridade)) {
				idToRead = armas.indexOf(armalz);
			}
			
			if(idToRead != null) {
				
				armaslz.add(armas.get(idToRead));
				
				idToRead = null;
			}
		}
		
		if(armaslz.isEmpty()) {
			return null;
		}
		
		return armaslz;
	}
	
	public boolean alteraStatus(Integer id) {
		
		Integer idToRemove = null;
		
		for(Arma arma: armas) {
			if(arma.getId().equals(id)) {
				idToRemove = armas.indexOf(arma);
			}
		}
		
		if(idToRemove != null) {
			return armas.remove(idToRemove);
		}
		
		return false;
	}
	
	public Arma altera(Arma arma) {
		
		Integer idToUpdate = null;
		
		for(Arma armalz: armas) {
			if(armalz.getId().equals(arma.getId())) {
				idToUpdate = armas.indexOf(armalz);
			}
		}
		
		if(idToUpdate != null) {
			
			Arma armal = armas.get(idToUpdate);
			armal.setNome(arma.getNome());
			armal.setRaridade(arma.getRaridade());
			armal.setDano(arma.getDano());
			armal.setStatus(arma.isStatus());			
			armal.setDtAtualizacao(OffsetDateTime.now());
            armal.setTipo(arma.getTipo());
			
	return armal;
		}
		
		return null;
	}
	
	public Arma alteraStatusPorId(Integer id, String status) {
		
		Integer idToUpdate = null;
		
		for(Arma armalz: armas) {
			if(armalz.getId().equals(id)) {
				idToUpdate = armas.indexOf(armalz);
			}
		}
		
		if(idToUpdate != null) {
			
			Arma armal = armas.get(idToUpdate);
			
			if("ativo".equalsIgnoreCase(status)) {
				armal.setStatus(true);
			}else {
				armal.setStatus(false);
			}
			
			return armal;
		}
		
		return null;
	}		

	private Integer generatetId() {
		Double random = Math.random() * 112;
		return new Random().nextInt(random.intValue()) + 132;
	}
	
	private Arma mockInicial() {
		
		Arma arma = new Arma();
    	arma.setId(125);
    	arma.setNome("Rifle de Assalto");
    	arma.setRaridade("Rara");
    	arma.setDano(33);
    	arma.setStatus(true);
    	arma.setTipo(TipoEnum.AR);
    	arma.setDtAtualizacao(OffsetDateTime.now());
    	
    	return arma;
	}

}
