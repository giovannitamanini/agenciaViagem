package com.tamanini.agenciaViagem.DTO;

import lombok.Data;
import org.springframework.data.geo.Point;

@Data
public class DestinoDTO {

    private Long Id;

    private String nome;

    private Point localizacao;

    private String descricao;

    private Double mediaAvaliacao;
}
