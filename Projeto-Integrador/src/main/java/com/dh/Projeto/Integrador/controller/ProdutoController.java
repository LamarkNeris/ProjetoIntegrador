package com.dh.Projeto.Integrador.controller;

import com.dh.Projeto.Integrador.DTO.ProdutoDto;
import com.dh.Projeto.Integrador.model.Cidades;
import com.dh.Projeto.Integrador.model.Produtos;
import com.dh.Projeto.Integrador.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produtos> post(@RequestBody ProdutoDto produtoDto) {
        return ResponseEntity.ok(produtoService.createProduto(produtoDto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> get() {
        return ResponseEntity.ok(produtoService.selectAllProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> getById(@PathVariable Integer id) {

        return ResponseEntity.ok(produtoService.selectById(id));
    }

    @GetMapping("categoria/{id}")
    public ResponseEntity<List<ProdutoDto>> selectProdCateg(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.listProdCateg(id));
    }

    @GetMapping("cidade/{id}")
    public ResponseEntity<List<ProdutoDto>> selectProdCity(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.listProdCity(id));
    }
}
