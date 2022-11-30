package br.com.primeira_api.garagem.modelo.factory;

import br.com.primeira_api.garagem.controllers.dto.CarroDto;
import br.com.primeira_api.garagem.modelo.Carro;

import java.math.BigDecimal;

public class CarroMapper {

    public static CarroDto getDto(Carro carro) {
        return CarroDto.builder()
                .id(carro.getId())
                .lucro(carro.getLucro().doubleValue())
                .valorVenda(carro.getValorVenda().doubleValue())
                .valorCompra(carro.getValorCompra().doubleValue())
                .ano(carro.getAno())
                .marca(carro.getMarca())
                .cor(carro.getCor())
                .modelo(carro.getModelo())
                .situacao(carro.getSituacao())
                .build();
    }

    public static Carro getCarro(CarroDto carro) {
        return Carro.builder()
                .id(carro.getId())
                .lucro(BigDecimal.valueOf(carro.getLucro()))
                .valorVenda(BigDecimal.valueOf(carro.getValorVenda()))
                .valorCompra(BigDecimal.valueOf(carro.getValorCompra()))
                .ano(carro.getAno())
                .marca(carro.getMarca())
                .cor(carro.getCor())
                .modelo(carro.getModelo())
                .situacao(carro.getSituacao())
                .build();
    }
}
