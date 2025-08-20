package br.edu.infnet.claudioapi.model.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

import br.edu.infnet.claudioapi.model.domain.AssetCategory;
import br.edu.infnet.claudioapi.model.domain.exceptions.AssetInvalidException;
import br.edu.infnet.claudioapi.model.domain.exceptions.AssetNotFoundException;
import br.edu.infnet.claudioapi.model.repository.AssetRepository;

@Service
public class AssetCategoryService implements CrudService<AssetCategory, Integer> {
	
	private final AssetRepository assetRepository;
	
	public AssetCategoryService(AssetRepository assetRepository) {
		this.assetRepository = assetRepository;
	}
	
	private final Map<Integer, AssetCategory> mapa = new ConcurrentHashMap<Integer, AssetCategory>();

	
	private void validate(AssetCategory assetcategory) {
		if(assetcategory == null) {
			throw new IllegalArgumentException("O número do CHASSI nao pode ser nulo!");
		}
		
		if(assetcategory.getAssetCode() == null || assetcategory.getAssetCode().trim().isEmpty()) {
			throw new AssetInvalidException("A inclusao do CHASSI do equipamento é um item obrigatório!");
		}
	}
	
	@Override
	public AssetCategory include(AssetCategory assetcategory) {
		
		
		// validacao para o assetcategory: validar se o objeto esta nulo e se o nome esta preenchido
		
		validate(assetcategory);
		
		// validacao especifica: um novo assetcode (CHASSI) nao deve ter ID
		
		if(assetcategory.getId() != null && assetcategory.getId() != 0) {
			throw new IllegalArgumentException("Um novo número do CHASSI nao pode ter um ID na inclusao!");
		}
		
		// validacao para o endereco: se ele foi fornecido
		
		return assetRepository.save(assetcategory);
	}

	@Override
	public AssetCategory change(Integer id, AssetCategory assetcategory) {

		// se o ID é válido
		
		if(id == null || id == 0) {
			throw new IllegalArgumentException("O ID para alteracao nao pode nulo/zero!");
		}
		
		// validacao para o assetcategory: validar se o objetivo esta nulo e se o nome esta preenchido
		
		validate(assetcategory);
		
		// verificar se o assetcode existe
		
		obtainPutId(id);
		
		// validacao para o endereco: se ele foi fornecido
		
				
		// substituicao do assetcode 
		
		assetcategory.setId(id);
		
		mapa.put(assetcategory.getId(), assetcategory);
		
		return assetcategory;
		
	}
		
	@Override
	public void delete(Integer id) {

		AssetCategory assetcategory = obtainPutId(id);
		
		assetRepository.delete(assetcategory);
			
	}

	public AssetCategory deactivate(Integer id) {
		
		if(id == null || id == 0) {
			throw new IllegalArgumentException("O ID para inativaca nao pode nulo/zero!");
		}
		
		 AssetCategory assetcategory = obtainPutId(id);
		 
		 if(!assetcategory.isActive()) {
			 System.out.println("O Equipamento" + assetcategory.getAssetCode() + "já está inativo!");
			 return assetcategory;
		 }
		 
		 assetcategory.setActive(false);
		
		 mapa.put(assetcategory.getId(), assetcategory);
			
		 return assetcategory;
		 
	}
	
	@Override
	public List<AssetCategory> obtainList() {
		
			
		return assetRepository.findAll();
	}


	@Override
	public AssetCategory obtainPutId(Integer id) {
		
		if(id == null || id <= 0) {
			throw new IllegalArgumentException("O ID para a exclusao nao pode nulo/zero!");
		}		
				
		return assetRepository.findById(id).orElseThrow(() -> new AssetNotFoundException("O Equipamento com ID " + id + "nao foi econtrado!"));
	}

}
