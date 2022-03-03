package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.DTO.ProdutoDto;
import com.dh.Projeto.Integrador.model.Categorias;
import com.dh.Projeto.Integrador.model.Cidades;
import com.dh.Projeto.Integrador.model.Produtos;
import com.dh.Projeto.Integrador.repository.CategoriaRepository;
import com.dh.Projeto.Integrador.repository.CidadeRepository;
import com.dh.Projeto.Integrador.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public Produtos createProduto(ProdutoDto produtoDto) {
        Categorias categoria = categoriaRepository.getById(produtoDto.getCategoriaId());
        Cidades cidade = cidadeRepository.getById(produtoDto.getCidadeId());
        Produtos produto = new Produtos();
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setImagens(produtoDto.getImagens());
        produto.setCategorias(categoria);
        produto.setCaracteristicas(produtoDto.getCaracteristicas());
        produto.setCidades(cidade);

        return produtoRepository.save(produto);

    }

    public ProdutoDto converteDto(Produtos produtos) {
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setId(produtos.getId());
        produtoDto.setNome(produtos.getNome());
        produtoDto.setDescricao(produtos.getDescricao());
        produtoDto.setImagens(produtos.getImagens());
        produtoDto.setCategoriaId(produtos.getCategorias().getId());
        produtoDto.setCaracteristicas(produtos.getCaracteristicas());
        produtoDto.setCidadeId(produtos.getCidades().getId());

        return produtoDto;
    }

    public List<ProdutoDto> selectAllProdutos() {

        List<Produtos> listProdutos = produtoRepository.findAll();
        List<ProdutoDto> listProdutosDto = new ArrayList<>();
        for (int i = 0; i < listProdutos.size(); i++) {
            ProdutoDto produtosDto = new ProdutoDto();
            produtosDto.setId(listProdutos.get(i).getId());
            produtosDto.setNome(listProdutos.get(i).getNome());
            produtosDto.setDescricao(listProdutos.get(i).getDescricao());
            produtosDto.setImagens(listProdutos.get(i).getImagens());
            produtosDto.setCategoriaId(listProdutos.get(i).getCategorias().getId());
            produtosDto.setCaracteristicas(listProdutos.get(i).getCaracteristicas());
            produtosDto.setCidadeId(listProdutos.get(i).getCidades().getId());

            listProdutosDto.add(produtosDto);
        }
        return listProdutosDto;
    }

    public ProdutoDto selectById(Integer id) {
        Produtos produto = produtoRepository.getById(id);
        return converteDto(produto);
    }

    public List<ProdutoDto> listProdCateg(Integer id) {
        Categorias categoria = categoriaRepository.getById(id);
        List<Produtos> listProdutos = produtoRepository.listarProdutos(categoria);
        List<ProdutoDto> listProDto = new ArrayList<>();

        if (id == categoria.getId()) {
            for (int i = 0; i < listProdutos.size(); i++) {
                ProdutoDto produtosDto = new ProdutoDto();
                produtosDto.setId(listProdutos.get(i).getId());
                produtosDto.setNome(listProdutos.get(i).getNome());
                produtosDto.setDescricao(listProdutos.get(i).getDescricao());
                produtosDto.setImagens(listProdutos.get(i).getImagens());
                produtosDto.setCategoriaId(listProdutos.get(i).getCategorias().getId());
                produtosDto.setCaracteristicas(listProdutos.get(i).getCaracteristicas());
                produtosDto.setCidadeId(listProdutos.get(i).getCidades().getId());

                listProDto.add(produtosDto);
            }
        }
        return listProDto;
    }

    public List<ProdutoDto> listProdCity(Integer id) {
        Cidades cidade = cidadeRepository.getById(id);
        List<Produtos> listProdutos = produtoRepository.listProdutos(cidade);
        List<ProdutoDto> listProDCity = new ArrayList<>();

        if (id == cidade.getId()) {
            for (int i = 0; i < listProdutos.size(); i++) {
                ProdutoDto produtosDto = new ProdutoDto();
                produtosDto.setId(listProdutos.get(i).getId());
                produtosDto.setNome(listProdutos.get(i).getNome());
                produtosDto.setDescricao(listProdutos.get(i).getDescricao());
                produtosDto.setImagens(listProdutos.get(i).getImagens());
                produtosDto.setCategoriaId(listProdutos.get(i).getCategorias().getId());
                produtosDto.setCaracteristicas(listProdutos.get(i).getCaracteristicas());
                produtosDto.setCidadeId(listProdutos.get(i).getCidades().getId());

                listProDCity.add(produtosDto);

            }
        }
        return listProDCity;
    }
}
