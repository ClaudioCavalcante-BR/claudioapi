package br.edu.infnet.claudioapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.claudioapi.model.domain.Address;
import br.edu.infnet.claudioapi.model.domain.AssetCategory;
import br.edu.infnet.claudioapi.model.domain.exceptions.AssetInvalidException;
import br.edu.infnet.claudioapi.model.service.AssetCategoryService;

@Component
public class AssetLoader implements ApplicationRunner {
	
	
	private final AssetCategoryService assetCategoryService;
	
	public AssetLoader(AssetCategoryService assetCategoryService) {
		this.assetCategoryService = assetCategoryService;
	}
	
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader filea1 = new FileReader("asset.txt");
		BufferedReader vision1 = new BufferedReader(filea1);
		
		String linha = vision1.readLine();
		
		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			// TODO Atualizar o arquivo texto para recuperar as infromacoes de address
			
			Address address = new Address();
			address.setStreet(campos[9]);
			address.setNumber(campos[10]);
			address.setZipcode(campos[11]);
			address.setLocation(campos[12]);
			address.setNeighborhood(campos[13]);
			address.setState(campos[14]);
			address.setUf(campos[15]);
			address.setComplement(campos[16]);
			
			
			AssetCategory assetcategory = new AssetCategory();
			// TODO Preencher tambem os campos existentes em AssetRegistration
			
			assetcategory.setAssetName(campos[0]);
			assetcategory.setAcquisitionYear(campos[1]);
			assetcategory.setAcquisitionValue(campos[2]);
			assetcategory.setAssetCode(campos[3]);
			
			assetcategory.setCategoryName(campos[4]);
			assetcategory.setCategoryCode(Integer.valueOf(campos[5]));
			assetcategory.setTaxRate(Double.valueOf(campos[6]));
			assetcategory.setActive(Boolean.valueOf(campos[7]));
			assetcategory.setDescription(campos[8]);
			
			assetcategory.setAddress(address);
			
			try {
				assetCategoryService.include(assetcategory);
			} catch (AssetInvalidException e) {
				System.err.println("Problema na inclusao do numero do CHASSI: " + e.getMessage());
			}
							
			
			
			// TODO imprimir os assetycategory apos a leitura do arquivo
			
			linha = vision1.readLine();
			
		}
			//TODO  chamada da funcionalidade de altreaçao = change
		
		//System.out.println(" - " + assetCategoryService.obtainList().size());
		//System.out.println(assetcategory);
		
		List<AssetCategory> assetcategorys = assetCategoryService.obtainList();
		assetcategorys.forEach(System.out::println);
		
		vision1.close();
	}
}
