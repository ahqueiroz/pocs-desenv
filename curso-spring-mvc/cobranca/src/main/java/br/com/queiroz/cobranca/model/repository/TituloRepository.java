package br.com.queiroz.cobranca.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.queiroz.cobranca.model.Titulo;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long>{
	
	//Containing mesmo que like %descricao%
	public List<Titulo> findByDescricaoContaining(String descricao);
}
