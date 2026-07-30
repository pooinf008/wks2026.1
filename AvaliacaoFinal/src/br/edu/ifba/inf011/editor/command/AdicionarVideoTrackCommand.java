package br.edu.ifba.inf011.editor.command;

import br.edu.ifba.inf011.model.track.ClassVideoTrack;
import br.edu.ifba.inf011.timeline.builder.Timeline;

public class AdicionarVideoTrackCommand implements EditCommand{
	
	private Timeline timeline;
    private String nomeTrilha;
    
    public AdicionarVideoTrackCommand(Timeline timeline, String nomeTrilha) {
        this.timeline = timeline;
        this.nomeTrilha = nomeTrilha;
    }    
    
    @Override
    public void execute() {
    	this.timeline.addVideoTrack(new ClassVideoTrack(nomeTrilha));
    }

    @Override
    public void undo() {
    	this.timeline.removeVideoTrack(nomeTrilha);
    }    
    

}
