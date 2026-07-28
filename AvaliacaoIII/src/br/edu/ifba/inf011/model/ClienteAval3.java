package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.CinemaTimelineBuilder;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.TimelineBuilder;
import br.edu.ifba.inf011.model.catalogo.builder.PacoteBuilder;
import br.edu.ifba.inf011.model.catalogo.composite.Pacote;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Playlist;
import br.edu.ifba.inf011.model.playlist.visitor.BandwidthVisitor;
import br.edu.ifba.inf011.model.playlist.visitor.XMLVisitor;

public class ClienteAval3 {

	public void run() {
		
		TimelineBuilder builder = new CinemaTimelineBuilder();
	    Timeline cinemaTimeline = builder.reset().addClassAdapterVideo("MainShot_4K.mov").build();
	    
        Pacote trilogiaMatrix = PacoteBuilder.builder()
        								      .reset()
        								      .addFilme("Matrix 1", 20.0, cinemaTimeline)
        								      .addFilme("Matrix Reloaded", 20.0, cinemaTimeline)
        								      .addFilme("Matrix Revolutions", 20.0, cinemaTimeline)
        								      .build("Trilogia Matrix");
        
        Pacote blackMirror =  PacoteBuilder.builder()
        								   .reset()
        								   .addFilme("Episodio 1", 10.0, cinemaTimeline)
        								   .addFilme("Episodio 2", 10.0, cinemaTimeline)
        								   .addFilme("Episodio 3", 10.0, cinemaTimeline)
        								   .build("Temporada I");

        Pacote sciFi = PacoteBuilder.builder()
        						    .addPacote(trilogiaMatrix)
        						    .addPacote(blackMirror)
        						    .addFilme("Blade Runner", 15.0, cinemaTimeline)
        						    .build("Sci-Fi");
        

        System.out.println("Preço da Super Coleção: " + sciFi.getPreco());
        System.out.println("Duração da Super Coleção: " + sciFi.getDuracao());
        
        Playlist playlist = new Playlist();
        
        playlist.addItem(sciFi);
        playlist.addItem(new MP3("Son Of A Gun", 1000));
        
        BandwidthVisitor bandwidthVisitor = new BandwidthVisitor(); 
        playlist.accept(bandwidthVisitor);
        double largura =  bandwidthVisitor.getBandaTotal();
        System.out.println("Consumo de Largura de Banda: " + largura);
        
        XMLVisitor xmlVisitor = new XMLVisitor();
        playlist.accept(xmlVisitor);
        System.out.println(xmlVisitor.getXML());
        
        
    }		

	public static void main(String[] args) {
		new ClienteAval3().run();
	}

	
}
