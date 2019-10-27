package br.com.jeoas.angularboot.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeoas.angularboot.document.Pedido;
import br.com.jeoas.angularboot.service.PedidoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
 
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<Collection<Pedido>> listar() {
		log.info("Retornando lista.");
		Collection<Pedido> pedidos = pedidoService.listar();
		return new ResponseEntity<Collection<Pedido>>(pedidos, OK);
	}

	@GetMapping(value = "/{codigoPedido}")
	public ResponseEntity<Pedido> consultar(@PathVariable String codigoPedido) {
		log.info("consultando pedido");

		Pedido pedido = pedidoService.consultar(codigoPedido);
		return new ResponseEntity<Pedido>(pedido, OK);
	}

	@PostMapping
	private ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido) {
		log.info("salvando pedido");
		pedido = pedidoService.salvar(pedido);
		return new ResponseEntity<Pedido>(pedido, OK);
	}

	@DeleteMapping(value = "/{codigoPedido}")
	public ResponseEntity<Pedido> remover(@PathVariable String codigoPedido) {
		log.info("removendo pedido");

		pedidoService.remover(codigoPedido);
		return new ResponseEntity<>(OK);
	}

	@PutMapping
	public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido) {
		log.info("atualizando pedido");

		pedido = pedidoService.atualizar(pedido);
		return new ResponseEntity<>(pedido, OK);
	}
}