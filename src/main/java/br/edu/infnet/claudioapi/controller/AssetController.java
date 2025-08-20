package br.edu.infnet.claudioapi.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.edu.infnet.claudioapi.model.domain.AssetCategory;
import br.edu.infnet.claudioapi.model.domain.exceptions.AssetInvalidException;
import br.edu.infnet.claudioapi.model.service.AssetCategoryService;

@RestController
@RequestMapping("/api/assetCategorys")
public class AssetController {
	
	
	private final AssetCategoryService assetCategoryService;
	
	public AssetController(AssetCategoryService assetCategoryService) {
		this.assetCategoryService = assetCategoryService;
	}
	
	@PostMapping
	public ResponseEntity<AssetCategory> include(@RequestBody AssetCategory assetcategory) {
		
		try {
			AssetCategory newassetCategory = assetCategoryService.include(assetcategory);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(newassetCategory);
			
			
		} catch (AssetInvalidException e) {
			return ResponseEntity.badRequest().build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
				
	}
	
	// mexer
	@PutMapping(value = "/{id}")
	public ResponseEntity<AssetCategory> change(@PathVariable Integer id, @RequestBody AssetCategory assetcategory) {
		AssetCategory assetcategoryChanged = assetCategoryService.change(id, assetcategory);
		
		return ResponseEntity.ok(assetcategoryChanged);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		assetCategoryService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	// mexer
	@PatchMapping(value = "/{id}/deactivate")
	public ResponseEntity<AssetCategory> deactivate(@PathVariable Integer id) {
		AssetCategory assetcategory = assetCategoryService.deactivate(id);
		
		return ResponseEntity.ok(assetcategory);
	}
	// ok
	@GetMapping
	public ResponseEntity<List<AssetCategory>> obtainList(){
		
		List<AssetCategory> list =  assetCategoryService.obtainList();
		
		if(list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(list);
	}
	// ok
	@GetMapping(value = "/{id}")
	public ResponseEntity<AssetCategory> obtainPutId(@PathVariable Integer id) {
		
		AssetCategory assetcategory = assetCategoryService.obtainPutId(id);
		
		return ResponseEntity.ok(assetcategory);
	}
}
