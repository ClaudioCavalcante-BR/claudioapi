package br.edu.infnet.claudioapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.claudioapi.model.domain.AssetCategory;

@Repository
public interface AssetRepository extends JpaRepository<AssetCategory, Integer>{

}
