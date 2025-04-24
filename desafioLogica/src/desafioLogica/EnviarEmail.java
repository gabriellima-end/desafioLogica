package desafioLogica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnviarEmail {
	
	public static void main(String[] args) {
		
		
		//CRIANDO ARRAYLIST
		ArrayList<FilaAprovada> filasAprovadas = new ArrayList<>();
		
		FilaAprovada fila1 = new FilaAprovada("aabbccdd1020", "fila-urgencia");		
		FilaAprovada fila2 = new FilaAprovada("aabbccdd1020", "fila-negocio");
		FilaAprovada fila3 = new FilaAprovada("aabbccdd1020", "fila-pendencias");		
		FilaAprovada fila4 = new FilaAprovada("aabbccdd1020", "fila-projetos");
		FilaAprovada fila5 = new FilaAprovada("aabbccdd1020", "fila-dividas");		
		FilaAprovada fila6 = new FilaAprovada("eeffgghh3040", "fila-licitação");
		FilaAprovada fila7 = new FilaAprovada("eeffgghh3040", "fila-crédito");		
		FilaAprovada fila8 = new FilaAprovada("eeffgghh3040", "fila-débito");
		FilaAprovada fila9 = new FilaAprovada("eeffgghh3040", "fila-atendimento");		
		FilaAprovada fila10 = new FilaAprovada("eeffgghh3040", "fila-cliente");
		
		//ADICIONANDO VALORES À LISTA
		filasAprovadas.add(fila1);
		filasAprovadas.add(fila2);
		filasAprovadas.add(fila3);
		filasAprovadas.add(fila4);
		filasAprovadas.add(fila5);
		filasAprovadas.add(fila6);
		filasAprovadas.add(fila7);
		filasAprovadas.add(fila8);
		filasAprovadas.add(fila9);
		filasAprovadas.add(fila10);
		
		
		//ATRIBUINDO AS FILAS À SEUS RESPECTIVOS ID'S DE CRIADOR
		
		//CRIANDO UM MAP, ONDE A CHAVE É O ID DO CRIADOR E O VALOR É O NOME DAS FILAS
		Map<String, List<String>> filasPorCriador = new HashMap<>();
		
		for(FilaAprovada fila : filasAprovadas) {
			
			//MÉTODO COMPUTEIFABSENT RECEBE DOIS PARAMETROS --> (CHAVE, FUNÇÃO)
			
			
			//A FUNÇÃO DESSE MÉTODO É VERIFICAR SE A CHAVE JA EXISTE NO HASHMAP, SE NÃO EXISTIR ELE VAI 
			//CRIAR UMA NOVA ENTRADA COM UMA LISTA VAZIA COMO VALOR
			// O .ADD ADICIONA O NOME DA FILA A LISTA CORRESPONDENTE AO ID CRIADOR
			filasPorCriador.computeIfAbsent(fila.getCreatedById(), k -> new ArrayList<>())
			.add(fila.getNomeFila());   
			
			//MOSTRANDO COMO FUNCIONA O MÉTODO
			System.out.println(filasPorCriador + "\n\nadicionando mais item à lista");
			
		}
		
		//ENVIANDO EMAIL
		
		//O MAP ENTRY ACESSA OS PARES DE CHAVE-VALOR QUE ESTÃO EM UM MAP 
		for (Map.Entry<String, List<String>> entry : filasPorCriador.entrySet()) {
			
			//MOSTRANDO COMO FUNCIONA
			System.out.println("acessando pares de chave-valor do map: " + filasPorCriador.entrySet() + "\n");
			
			//ATRIBUINDO A CHAVE "GETKEY"(CREATEDBYID) A VARIAVEL 
		    String criadorId = entry.getKey();
		    //ATRIBUINDO O VALOR "GETVALUE"(NOME DAS FILAS) À LISTA
		    List<String> filasDoCriador = entry.getValue();
		    
		    
		    //CONSTRUINDO O CORPO DO EMAIL-------------------//
		    
		    //CLASSE STRINGBUILDER FACILITA A CONSTRUÇÃO DE STRINGS, POIS É UM OBJETO MUTÁVEL
		    StringBuilder corpoEmail = new StringBuilder();
		    corpoEmail.append("\nPrezado(a),\n\n");
		    corpoEmail.append("As filas \n\n");
		    
		    //PERCORRE CADA ITEM DA LISTA E ADICIONA EM CADA NOME DE FILA, UM HÍFEN E PULA UMA LINHA
		    for (String fila : filasDoCriador) {
		        corpoEmail.append("- ").append(fila).append("\n");
		    }
		    
		    corpoEmail.append("\nForam Criadas. Abraço.");
		    
		    //FIM DO CORPO DO EMAIL----------------------//
		    
		    //USANDO O METODO SEND PARA ENVIAR O EMAIL
		    FilaAprovada enviador = new FilaAprovada();
		    String resultadoEnvio = enviador.send(criadorId, corpoEmail.toString());
		    
		    System.out.println(resultadoEnvio);
		    System.out.println("----------------------------------");
		}
		
		
		
		
		
		
		
	}
	
}
