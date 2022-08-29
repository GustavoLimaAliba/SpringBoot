package com.stefood.controller;

import com.stefood.controller.dto.DetalhesDoPedidoDto;
import com.stefood.controller.dto.PedidoDto;
import com.stefood.controller.form.AtualizacaoPedidoForm;
import com.stefood.controller.form.PedidoForm;
import com.stefood.modelo.Pedido;
import com.stefood.repository.EmpresaRepository;
import com.stefood.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;


    @GetMapping
    @Cacheable(value = "ListaDePedidos")
    public Page<PedidoDto> lista(@RequestParam(required = false) String nomeEmpresa, @PageableDefault(sort = "id",
            direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {



        if (nomeEmpresa == null) {
            Page<Pedido> pedidos = pedidoRepository.findAll(paginacao);
            return PedidoDto.converter(pedidos);
        } else {
            Page<Pedido> pedidos = pedidoRepository.findByEmpresa_Nome(nomeEmpresa, paginacao);
            return PedidoDto.converter(pedidos);
        }
    }


    @PostMapping
    @Transactional
    @CacheEvict(value = "ListaDePedidos", allEntries = true)

    public ResponseEntity<PedidoDto> cadastrar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {
        Pedido pedido = form.converter(empresaRepository);
        pedidoRepository.save(pedido);

        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDto(pedido));
    }

    @GetMapping("/{id}")
    public DetalhesDoPedidoDto detalhar(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.getOne(id);
        return new DetalhesDoPedidoDto(pedido);
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "ListaDePedidos", allEntries = true)
    public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoPedidoForm form) {
        Pedido pedido = form.atualizar(id, pedidoRepository);
       return ResponseEntity.ok(new PedidoDto(pedido));
    }
    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "ListaDePedidos", allEntries = true)
    public  ResponseEntity<?> remover(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
