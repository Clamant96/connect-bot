package br.com.helpconnect.connect.bot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpconnect.connect.bot.model.RespostaBot;
import br.com.helpconnect.connect.bot.repository.RespostaBotRepository;
import br.com.helpconnect.connect.bot.service.RespostaBotService;

@RestController
@RequestMapping("/resposta-bot")
public class RespostaBotController {
	
	@Autowired
	private RespostaBotRepository repository;
	
	@Autowired
	private RespostaBotService service;
	
	@GetMapping
	public ResponseEntity<List<RespostaBot>> findAllRespostasBot() {
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RespostaBot> findByIdRespostaBot(@PathVariable long id) {
		
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/resposta/{entradas}")
	public ResponseEntity<RespostaBot> findByEntradasBot(@PathVariable String entradas) {
		
		return ResponseEntity.ok(service.pesquisaEntrada(entradas));
	}
	
	@PostMapping
	public ResponseEntity<RespostaBot> postarRespostaBot(@RequestBody RespostaBot respostaBot) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(respostaBot));
	}
	
	@PutMapping
	public ResponseEntity<RespostaBot> atualizaRespostaBot(@RequestBody RespostaBot respostaBot) {
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(respostaBot));
	}
	
	@DeleteMapping("/{id}")
	public void deletarRespostaBot(@PathVariable long id) {
		repository.deleteById(id);
		
	}
	
}
