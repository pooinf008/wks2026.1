package br.edu.ifba.inf011.model.playlist.visitor;

public interface PlaylistItem {
	public void accept(PlaylistVisitor visitor);
}
