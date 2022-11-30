package br.com.primeira_api.garagem.controllers;

import br.com.primeira_api.garagem.controllers.dto.CarroDto;
import br.com.primeira_api.garagem.modelo.Carro;
import br.com.primeira_api.garagem.modelo.factory.CarroMapper;
import br.com.primeira_api.garagem.repository.CarroRepository;
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

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/garagem")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public List<CarroDto> getEstoque() {
        //jogar para service
        List<Carro> carros = carroRepository.findAll();
        return carros.stream().map(CarroMapper::getDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDto> getId(@PathVariable Long id) {
        Optional<Carro> carro = carroRepository.findById(id);

        if (carro.isPresent()) {
            return ResponseEntity.ok(CarroMapper.getDto(carro.get()));
        }
        /// colocar numa service e caso não ache o objeto retornar um erro
        //udar e usar Optional.ofNullable() para retornar o erro

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CarroDto> postCarro(@RequestBody @Valid CarroDto dto) {
        Carro carro = carroRepository.save(CarroMapper.getCarro(dto));
        //mover metodo para salver em uma service
        return ResponseEntity.ok(CarroMapper.getDto(carro));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CarroDto> updateCarro(@PathVariable Long id, @RequestBody @Valid CarroDto dto) {
        //Correto sempre validar se existe pelo id antes de atualizar
        Optional<Carro> optional = carroRepository.findById(id);
        // retornar erro caso não exista

        Carro carro = carroRepository.save(CarroMapper.getCarro(dto));
        //excluir classe CarroForm e deixar atualização em uma service
        return ResponseEntity.ok(CarroMapper.getDto(carro));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        //Jogar para service
        carroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}  