package br.edu.ifba.inf011.model.catalogo.composite;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;

public class Filme extends LeafItemCatalogo{

	public Filme(String titulo, Double preco, Timeline timeline) {
		super(titulo, preco, timeline);
	}
	
}