package br.edu.ifba.inf011.model.catalogo.composite;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;

public class Episodio extends LeafItemCatalogo{

	public Episodio(String titulo, Double preco, Timeline timeline) {
		super(titulo, preco, timeline);
	}
	
}