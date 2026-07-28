package br.edu.ifba.inf011.model.playlist.visitor;

import br.edu.ifba.inf011.model.catalogo.composite.CompositeItemCatalogo;
import br.edu.ifba.inf011.model.catalogo.composite.ItemCatalogo;
import br.edu.ifba.inf011.model.catalogo.composite.LeafItemCatalogo;
import br.edu.ifba.inf011.model.playlist.MP3;

public class BandwidthVisitor implements PlaylistVisitor{

	private static Double BAND_PER_SECOND = 1.5;
	
	private double bandaTotalMb = 0;
	
	@Override
	public void visit(MP3 mp3) {
		this.bandaTotalMb += mp3.getTamanhoMegaBytes();
		
	}

	@Override
	public void visit(CompositeItemCatalogo compositeItem) {
		for(ItemCatalogo item : compositeItem.getChildren())
			item.accept(this);
	}

	@Override
	public void visit(LeafItemCatalogo leafItem) {
		this.bandaTotalMb += leafItem.getDuracao() * BandwidthVisitor.BAND_PER_SECOND;
	}
	
	public double getBandaTotal() { 
		return this.bandaTotalMb; 
	}

}
