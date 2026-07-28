package br.edu.ifba.inf011.model.catalogo.builder;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.model.catalogo.composite.Episodio;
import br.edu.ifba.inf011.model.catalogo.composite.Filme;
import br.edu.ifba.inf011.model.catalogo.composite.ItemCatalogo;
import br.edu.ifba.inf011.model.catalogo.composite.Pacote;

public class PacoteBuilder {
	
    private List<ItemCatalogo> items;

    public static PacoteBuilder builder() {
    	return new PacoteBuilder();
    }
    
    public PacoteBuilder() {
    	this.reset();
    }
    
    public PacoteBuilder reset() {
    	this.items = new ArrayList<ItemCatalogo>();
    	return this;
    }

    public PacoteBuilder addFilme(String titulo, Double preco, Timeline timeline) {
        this.items.add(new Filme(titulo, preco, timeline));
        return this;
    }

    public PacoteBuilder addPacote(Pacote pacote) {
        this.items.add(pacote);
        return this;
    }
    
    public PacoteBuilder addPacote(Episodio episodio) {
        this.items.add(episodio);
        return this;
    }    

    public Pacote build(String nome) {
        return new Pacote(nome, this.items);
    }
}
