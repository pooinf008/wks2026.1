package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.model.playlist.visitor.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.visitor.PlaylistVisitor;

public class MP3 implements PlaylistItem {
    public String nome;
    public double tamanhoMegaBytes;

    public MP3(String nome, double tamanho) { 
        this.nome = nome; 
        this.tamanhoMegaBytes = tamanho; 
    }
    
    public double getTamanhoMegaBytes() {
    	return this.tamanhoMegaBytes;
    }

    @Override
    public void accept(PlaylistVisitor visitor) {
        visitor.visit(this);
    }
    
    public String getNome() {
    	return this.nome;
    }
}
