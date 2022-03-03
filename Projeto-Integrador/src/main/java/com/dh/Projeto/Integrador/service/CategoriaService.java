package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.model.Categorias;
import com.dh.Projeto.Integrador.model.Produtos;
import com.dh.Projeto.Integrador.repository.CategoriaRepository;
import com.dh.Projeto.Integrador.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categorias create(Categorias categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categorias> selectAll(){
        return categoriaRepository.findAll();
    }


    public String delete(Integer id){
        categoriaRepository.deleteById(id);
        return ("Categoria deletada");
    }

    public Categorias update(Categorias categoria){
        Categorias categoria1 = categoriaRepository.getById(categoria.getId());
        categoria1.setTitulo(categoria.getTitulo());
        categoria1.setDescricao(categoria.getDescricao());
        categoria1.setUrl_Img(categoria.getUrl_Img());

        return categoriaRepository.save(categoria1);

    }


}
