package br.edu.ifba.inf011.model.playlist.visitor;

import br.edu.ifba.inf011.model.catalogo.composite.CompositeItemCatalogo;
import br.edu.ifba.inf011.model.catalogo.composite.LeafItemCatalogo;
import br.edu.ifba.inf011.model.playlist.MP3;

public interface PlaylistVisitor {
	public void visit(MP3 mp3);
    public void visit(CompositeItemCatalogo leafItem);
    public void visit(LeafItemCatalogo episodio);
}
