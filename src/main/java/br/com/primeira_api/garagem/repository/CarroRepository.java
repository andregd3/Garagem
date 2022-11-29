package br.com.primeira_api.garagem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.primeira_api.garagem.modelo.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

	Optional<Carro> findAllById(Long id);
	
}