package br.com.helpconnect.connect.bot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.helpconnect.connect.bot.model.RespostaBot;

@Repository
public interface RespostaBotRepository extends JpaRepository<RespostaBot, Long> {
	
	public Optional<RespostaBot> findByEntradas(String entradas);
	
	public Optional<RespostaBot> findByResposta(String resposta);
	
}
