package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.flyweight.StreamingContentContext;

public class StreamDispatcher {

	public void runNoFly() {
		
		System.out.println("==========EXECUTANDO NOFLYWEIGHT============");
		
    	PlayableContent clienteA = new StreamingContentNoFlyweight("Voices.film", 10);
    	PlayableContent clienteB = new StreamingContentNoFlyweight("Voices.film", 20);
        
        System.out.println("========== CLIENTE A ASSISTINDO ==========");
        clienteA.play();
        
        System.out.println("\n========== CLIENTE B ASSISTINDO ==========");
        clienteB.play();   
	}	
	
	
	public void runFly() {
		
		System.out.println("==========EXECUTANDO FLYWEIGHT============");
		
    	PlayableContent clienteA = new StreamingContentContext("Odisseia.film", 10);
    	PlayableContent clienteB = new StreamingContentContext("Odisseia.film", 20);
        
        System.out.println("========== CLIENTE A ASSISTINDO ==========");
        clienteA.play();
        
        System.out.println("\n========== CLIENTE B ASSISTINDO ==========");
        clienteB.play();   
	}


}
