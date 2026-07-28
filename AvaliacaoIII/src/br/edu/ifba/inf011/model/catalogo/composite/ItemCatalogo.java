package br.edu.ifba.inf011.model.catalogo.composite;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.playlist.visitor.PlaylistItem;

public abstract class ItemCatalogo implements PlaylistItem{
	
	protected String titulo;
    protected List<ItemCatalogo> itens;
    
    public ItemCatalogo(String titulo) {
    	this.titulo = titulo;
    	this.itens = new ArrayList<ItemCatalogo>();
    };
    
    public ItemCatalogo(String titulo, List<ItemCatalogo> itens){
    	this.titulo = titulo;
    	this.itens = itens;
    }    
	
    public String getTitulo() {
    	return this.titulo;
    };
    
    public void addItem(ItemCatalogo item) {
    	this.itens.add(item); 
    }
    
    public ItemCatalogo getCompositeItemCatalogo() {
    	return null;
    }
    
    public List<ItemCatalogo> getChildren() {
    	return this.itens;
    }
    
    public abstract  Double getPreco();
    public abstract Integer getDuracao();
}