package br.com.helpconnect.connect.bot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpconnect.connect.bot.model.RespostaBot;
import br.com.helpconnect.connect.bot.repository.RespostaBotRepository;

@Service
public class RespostaBotService {
	
	@Autowired
	private RespostaBotRepository repository;
	
	public RespostaBot pesquisaEntrada(String entrada) {
		
		RespostaBot resposta = new RespostaBot();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
		LocalDateTime now = LocalDateTime.now();  
		
		String boasVindas = "";
	
		for (RespostaBot respostaBot : repository.findAll()) {
			
			if(respostaBot.getEntradas().replace(" ", "").toLowerCase().contains(entrada.replace("(?<=^|[^A-Za-z])([A-Z][a-z]*)(?=[^A-Za-z]|$)", "").replace(" ", "").toLowerCase())) {
				resposta.setId(respostaBot.getId());
				resposta.setEntradas(respostaBot.getEntradas());
				resposta.setResposta(respostaBot.getResposta());
				
			}
			
		}
		
		if(entrada.toLowerCase().contains("bom dia") || entrada.toLowerCase().contains("boa tarde") || entrada.toLowerCase().contains("boa noite")) {
			
			if(Integer.parseInt(dtf.format(now)) == 0 || Integer.parseInt(dtf.format(now)) == 1 || Integer.parseInt(dtf.format(now)) == 2 || Integer.parseInt(dtf.format(now)) == 3 || Integer.parseInt(dtf.format(now)) == 4 || Integer.parseInt(dtf.format(now)) == 5 || Integer.parseInt(dtf.format(now)) == 6 || Integer.parseInt(dtf.format(now)) == 7 || Integer.parseInt(dtf.format(now)) == 8 || Integer.parseInt(dtf.format(now)) == 9 || Integer.parseInt(dtf.format(now)) == 10 || Integer.parseInt(dtf.format(now)) == 11) {
				boasVindas = "Bom dia, ";
				
				resposta.setResposta(boasVindas + resposta.getResposta());
				
			}else if(Integer.parseInt(dtf.format(now)) == 12 || Integer.parseInt(dtf.format(now)) == 13 || Integer.parseInt(dtf.format(now)) == 14 || Integer.parseInt(dtf.format(now)) == 15 || Integer.parseInt(dtf.format(now)) == 16 || Integer.parseInt(dtf.format(now)) == 17) {
				boasVindas = "Boa tarde, ";
				
				resposta.setResposta(boasVindas + resposta.getResposta());
				
			}else {
				boasVindas = "Boa noite, ";
				
				resposta.setResposta(boasVindas + resposta.getResposta());
				
			}
			
		}
		
		return resposta;
	}
	
}
