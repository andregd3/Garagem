package br.com.primeira_api.garagem.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.primeira_api.garagem.controllers.dto.CarroDto;
import br.com.primeira_api.garagem.controllers.form.CarroForm;
import br.com.primeira_api.garagem.modelo.Carro;
import br.com.primeira_api.garagem.repository.CarroRepository;

@RestController
@RequestMapping("/garagem")
public class CarroController {
	
	@Autowired
	private CarroRepository carroRepository;
    
    @GetMapping
    public List<CarroDto> getEstoque(){
	    	List<Carro> carros = (List<Carro>) carroRepository.findAll();
	    	return CarroDto.converter(carros);    
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarroDto> getId (@PathVariable Long id) {
    	Optional<Carro> carro = carroRepository.findById(id);
    	
    	if(carro.isPresent()) {                               
    		return ResponseEntity.ok(new CarroDto(carro.get()));
    	}
    	
		return ResponseEntity.notFound().build();   	
    }
    
    @PostMapping
    public ResponseEntity<CarroDto> postCarro(@RequestBody @Valid CarroForm form, UriComponentsBuilder uriBuilder){
    	Carro carro = form.converter(carroRepository);
    	carroRepository.save(carro);
    	
    	URI uri = uriBuilder.path("/garagem/{id}").buildAndExpand(carro.getId()).toUri();
    	return (ResponseEntity<CarroDto>) ResponseEntity.created(uri).body(new CarroDto(carro));
		}
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CarroDto> updateCarro(@PathVariable Long id, @RequestBody @Valid CarroForm form) {
    	Optional<Carro> optional = carroRepository.findById(id);
    	if (optional.isPresent()) {
    		Carro carro = form.update(id, carroRepository);
    		return ResponseEntity.ok(new CarroDto(carro));
    	}
		return ResponseEntity.notFound().build();   	
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete (@PathVariable Long id) {
    	carroRepository.deleteById(id);
    	return ResponseEntity.ok().build(); 	
    }
}  