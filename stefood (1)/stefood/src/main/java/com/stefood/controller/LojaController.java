package com.stefood.controller;

import com.stefood.controller.dto.DetalhesDaLojaDto;
import com.stefood.controller.dto.LojaDto;
import com.stefood.controller.form.AtualizacaoLojaForm;
import com.stefood.controller.form.LojaForm;
import com.stefood.modelo.Loja;
import com.stefood.repository.LojaRepository;
import com.stefood.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    @GetMapping
    public List<LojaDto> lista(String nomeProduto) {
        if (nomeProduto == null) {
            List<Loja> lojas = lojaRepository.findAll();
            return LojaDto.converter(lojas);
        } else {
            List<Loja> lojas = lojaRepository.findByProduto_Nome(nomeProduto);
            return LojaDto.converter(lojas);
        }
    }


    @PostMapping

    public ResponseEntity<LojaDto> cadastrar(@RequestBody @Valid LojaForm form, UriComponentsBuilder uriBuilder) {
        Loja loja = form.converter(produtoRepository);
        lojaRepository.save(loja);

        URI uri = uriBuilder.path("/lojas/{id}").buildAndExpand(loja.getId()).toUri();
        return ResponseEntity.created(uri).body(new LojaDto(loja));
    }

    @GetMapping("/{id}")
    public DetalhesDaLojaDto detalhar(@PathVariable Long id) {
        Loja loja = lojaRepository.getOne(id);
        return new DetalhesDaLojaDto(loja);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<LojaDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoLojaForm form) {
        Loja loja = form.atualizar(id, lojaRepository);
        return ResponseEntity.ok(new LojaDto(loja));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity<?> remover(@PathVariable Long id) {
        lojaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
