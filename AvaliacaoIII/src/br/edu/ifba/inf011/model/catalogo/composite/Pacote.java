package br.edu.ifba.inf011.model.catalogo.composite;

import java.util.List;

public class Pacote extends CompositeItemCatalogo {

    public Pacote(String titulo) {
    	super(titulo); 
    }
    
    public Pacote(String titulo, List<ItemCatalogo> itens) {
    	super(titulo, itens); 
    }    
}