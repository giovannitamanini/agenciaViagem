package com.tamanini.agenciaViagem.service;

import com.tamanini.agenciaViagem.DTO.DestinoDTO;
import com.tamanini.agenciaViagem.domain.entity.DestinoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final ModelMapper modelMapper;

    public DestinoService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DestinoDTO criarDestino(DestinoDTO destinoDTO) {
        DestinoEntity destinoEntity = modelMapper.map(destinoDTO, DestinoEntity.class);

        System.out.println("Simulando gravação do destino no banco de dados");
        System.out.println(destinoEntity);

        //Aqui eu deveria utilizar um método do repository para gravar o destino. O método retorna o destino Salvo
        DestinoEntity destinoEntitySalva = destinoEntity;

        return modelMapper.map(destinoEntitySalva, DestinoDTO.class);
    }


    public List<DestinoDTO> buscarTodosDestinos() {

        // Abaixo chamaria um método do repository retornando todos os destinos na lista
        List<DestinoEntity> destinos = new ArrayList<>();

        return destinos.stream()
                .map(destino -> modelMapper.map(destino, DestinoDTO.class))
                .collect(Collectors.toList());
    }

    public DestinoDTO buscarDestinoPorNome(String nome) {

        // Abaixo chamaria um método de busca por nome do destino para retornar o destino específico
        DestinoEntity destinoEncontrado = new DestinoEntity();

        return modelMapper.map(destinoEncontrado, DestinoDTO.class);
    }

    public DestinoDTO buscarDestinoPorLocalizacao(Point localizacao) {

        // Abaixo chamaria um método de busca por localização do destino para retornar o destino específico
        DestinoEntity destinoEncontrado = new DestinoEntity();

        return modelMapper.map(destinoEncontrado, DestinoDTO.class);
    }

    public DestinoDTO buscarDestino(Long id) {

        // Abaixo chamaria um método de busca por id do destino para retornar o destino específico
        DestinoEntity destinoEncontrado = new DestinoEntity();

        return modelMapper.map(destinoEncontrado, DestinoDTO.class);
    }

    public boolean atualizarAvaliacao(Long id, Double nota) {

        //  Aqui é feita a busca pelo id do destino, em sequência atualizado o atributo mediaAvaliacao a partir da nova nota informada

        return true; // Retorne true se a atualização foi bem-sucedida.
    }

    public boolean excluirDestino(Long id) {

        // Aqui é utilizado um método do repository para exluir o destino especificado se ele existir

        return true; // Retorne true se a exclusão foi bem-sucedida.
    }
}
