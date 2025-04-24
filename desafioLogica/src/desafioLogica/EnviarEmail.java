package desafioLogica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnviarEmail {
	
	public static void main(String[] args) {
		
		
		
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
		Map<String, List<String>> filasPorCriador = new HashMap<>();
		
		for(FilaAprovada fila : filasAprovadas) {
		
			filasPorCriador.computeIfAbsent(fila.getCreatedById(), k -> new ArrayList<>())
			.add(fila.getNomeFila());
			
			System.out.println(filasPorCriador);
		}
		
		//ENVIANDO EMAIL
		
		for (Map.Entry<String, List<String>> entry : filasPorCriador.entrySet()) {
		    String criadorId = entry.getKey();
		    List<String> filasDoCriador = entry.getValue();
		    
		    
		    //CONSTRUINDO O CORPO DO EMAIL
		    StringBuilder corpoEmail = new StringBuilder();
		    corpoEmail.append("\nPrezado(a),\n\n");
		    corpoEmail.append("As filas \n\n");
		    
		    for (String fila : filasDoCriador) {
		        corpoEmail.append("- ").append(fila).append("\n");
		    }
		    
		    corpoEmail.append("\nForam Criadas. Abraço.");
		    
		    //USANDO O METODO SEND
		    FilaAprovada enviador = new FilaAprovada();
		    String resultadoEnvio = enviador.send(criadorId, corpoEmail.toString());
		    
		    System.out.println(resultadoEnvio);
		    System.out.println("----------------------------------");
		}
		
		
		
		
		
		
		
	}
	
}
