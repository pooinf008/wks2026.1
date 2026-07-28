package br.edu.ifba.inf011.model.playlist.visitor;

import br.edu.ifba.inf011.model.catalogo.composite.CompositeItemCatalogo;
import br.edu.ifba.inf011.model.catalogo.composite.ItemCatalogo;
import br.edu.ifba.inf011.model.catalogo.composite.LeafItemCatalogo;
import br.edu.ifba.inf011.model.playlist.MP3;

public class XMLVisitor implements PlaylistVisitor{
	
	private StringBuilder xml = new StringBuilder("<playlist>\n");

	@Override
	public void visit(MP3 mp3) {
		this.xml.append("  <mp3 nome=\"").append(mp3.getNome()).append("/>\n");
		
	}

	@Override
	public void visit(CompositeItemCatalogo composite) {
		this.xml.append("  <pacote titulo=\"").append(composite.getTitulo()).append(">\n");
		for(ItemCatalogo item : composite.getChildren())
			item.accept(this);
		this.xml.append("  </titulo>\n");
		
	}

	@Override
	public void visit(LeafItemCatalogo leafItem) {
		this.xml.append("  <video titulo=\"").append(leafItem.getTitulo()).append("\"/>\n");
	}
	
	
	public String getXML() {
		return xml.append("</playlist>").toString();
	}
	

}
