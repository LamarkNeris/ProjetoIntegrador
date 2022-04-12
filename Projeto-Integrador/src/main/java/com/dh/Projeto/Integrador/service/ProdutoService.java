package com.dh.Projeto.Integrador.service;

import com.dh.Projeto.Integrador.DTO.ProdutoDto;
import com.dh.Projeto.Integrador.model.*;
import com.dh.Projeto.Integrador.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private CaracteristicasRepository repository;
    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    public Produtos createProduto(ProdutoDto produtoDto) {
        Categorias categoria = categoriaRepository.getById(produtoDto.getCategoriaId());
        Cidades cidade = cidadeRepository.getById(produtoDto.getCidadeId());
        Caracteristicas caracteristicas = repository.save(produtoDto.getCaracteristicas());
        Produtos produto = new Produtos();
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setImagens(produtoDto.getImagens());
        produto.setCategorias(categoria);
        produto.setCaracteristicas(caracteristicas);
        produto.setCidades(cidade);
        produto.setAvaliacao(produtoDto.getAvaliacao());
        produto.setLatitude(produtoDto.getLatitude());
        produto.setLongitude(produtoDto.getLongitude());

        return produtoRepository.save(produto);

    }
    public Produtos updateProduto(ProdutoDto produtoDto){
        Produtos produto = produtoRepository.getById(produtoDto.getId());
        Categorias categoria = categoriaRepository.getById(produtoDto.getCategoriaId());
        Cidades cidade = cidadeRepository.getById(produtoDto.getCidadeId());
        Caracteristicas caracteristicas = repository.save(produtoDto.getCaracteristicas());
        produto.setNome(produtoDto.getNome());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setDescricao(produtoDto.getDescricao());
        produto.setImagens(produtoDto.getImagens());
        produto.setCategorias(categoria);
        produto.setCaracteristicas(caracteristicas);
        produto.setCidades(cidade);
        produto.setAvaliacao(produtoDto.getAvaliacao());
        produto.setLatitude(produtoDto.getLatitude());
        produto.setLongitude(produtoDto.getLongitude());

        return produtoRepository.save(produto);
    }

    public ProdutoDto converteDto(Produtos produtos) {
        Caracteristicas caracteristicas = repository.save(produtos.getCaracteristicas());
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setId(produtos.getId());
        produtoDto.setNome(produtos.getNome());
        produtoDto.setDescricao(produtos.getDescricao());
        produtoDto.setImagens(produtos.getImagens());
        produtoDto.setCategoriaId(produtos.getCategorias().getId());
        produtoDto.setCaracteristicas(caracteristicas);
        produtoDto.setCidadeId(produtos.getCidades().getId());
        produtoDto.setAvaliacao(produtos.getAvaliacao());
        produtoDto.setLatitude(produtos.getLatitude());
        produtoDto.setLongitude(produtos.getLongitude());

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
            produtosDto.setAvaliacao(listProdutos.get(i).getAvaliacao());
            produtosDto.setLatitude(listProdutos.get(i).getLatitude());
            produtosDto.setLongitude(listProdutos.get(i).getLongitude());

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
                produtosDto.setAvaliacao(listProdutos.get(i).getAvaliacao());
                produtosDto.setLatitude(listProdutos.get(i).getLatitude());
                produtosDto.setLongitude(listProdutos.get(i).getLongitude());

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
                produtosDto.setAvaliacao(listProdutos.get(i).getAvaliacao());
                produtosDto.setLatitude(listProdutos.get(i).getLatitude());
                produtosDto.setLongitude(listProdutos.get(i).getLongitude());

                listProDCity.add(produtosDto);

            }
        }
        return listProDCity;
    }

    public List<Reservas> listDate(Date checkIn, Date checkOut, Integer id) {

        List<Reservas> listaData = reservaRepository.findBycheckInLessThanEqualAndCheckOutGreaterThanEqualAndProdutoId(checkIn, checkOut, id);

        return listaData;
    }

}
