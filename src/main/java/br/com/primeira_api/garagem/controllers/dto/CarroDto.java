package br.com.primeira_api.garagem.controllers.dto;

import br.com.primeira_api.garagem.modelo.enums.Marcas;
import br.com.primeira_api.garagem.modelo.enums.StatusSituacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarroDto {

    private Long id;

    private String modelo;

    private String cor;

    private Integer ano;

    private Double valorCompra;

    private Double valorVenda;

    private Double lucro;

    private Marcas marca;

    @Enumerated(EnumType.STRING)
    private StatusSituacao situacao;

}
