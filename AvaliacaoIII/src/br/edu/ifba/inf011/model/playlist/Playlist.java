package br.edu.ifba.inf011.model.playlist;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.playlist.visitor.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.visitor.PlaylistVisitor;

public class Playlist {
	
	private List<PlaylistItem> items;
	
	public Playlist() {
		this.items = new ArrayList<PlaylistItem>();
	}
	
	public void addItem(PlaylistItem item) {
		this.items.add(item);
	}
	
	public void accept(PlaylistVisitor visitor) {
		this.items.forEach(item -> item.accept(visitor));
	}
}
