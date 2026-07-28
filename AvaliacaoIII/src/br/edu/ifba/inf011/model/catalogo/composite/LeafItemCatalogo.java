package br.edu.ifba.inf011.model.catalogo.composite;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.model.playlist.visitor.PlaylistVisitor;

public class LeafItemCatalogo extends ItemCatalogo {
    private Double preco;
    private Timeline timeline;

    public LeafItemCatalogo(String titulo, Double preco, Timeline timeline) {
    	super(titulo);
        this.preco = preco;
        this.timeline = timeline;
    }
    
    @Override 
    public Double getPreco() {
    	return preco; 
    }
    
    @Override 
    public Integer getDuracao() { 
    	return this.timeline.getDurationInSeconds();
    }
    
    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }    
}