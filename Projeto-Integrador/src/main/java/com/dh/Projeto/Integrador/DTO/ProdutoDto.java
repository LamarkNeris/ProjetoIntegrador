package com.dh.Projeto.Integrador.DTO;

import com.dh.Projeto.Integrador.model.Caracteristicas;
import com.dh.Projeto.Integrador.model.Imagens;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProdutoDto {

    private Integer id;
    private String nome;
    private String descricao;
    private List<Imagens> imagens;
    private Integer categoriaId;
    private List<Caracteristicas> caracteristicas;
    private Integer cidadeId;



}
