package br.edu.ifba.inf011.model.catalogo.composite;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.playlist.visitor.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.visitor.PlaylistVisitor;

public class CompositeItemCatalogo extends ItemCatalogo implements PlaylistItem{

    public CompositeItemCatalogo(String titulo, List<ItemCatalogo> itens){
    	super(titulo, itens);
    }
    
    public CompositeItemCatalogo(String titulo) {
    	super(titulo); 
    }       
    
    public ItemCatalogo getCompositeItemCatalogo() {
    	return this;
    }

    @Override 
    public Double getPreco() {
        double soma = itens.stream().mapToDouble(ItemCatalogo::getPreco).sum();
        return soma * 0.9;
    }
    
    @Override 
    public Integer getDuracao() {
        return itens.stream().mapToInt(ItemCatalogo::getDuracao).sum();
    }
    
    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }    
}