package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.editor.command.AssyncEditManager;
import br.edu.ifba.inf011.model.flyweight.StreamingContentContext;
import br.edu.ifba.inf011.timeline.builder.ConcreteTimelineBuilder;
import br.edu.ifba.inf011.timeline.builder.Timeline;
import br.edu.ifba.inf011.timeline.builder.TimelineBuilder;

public class ClientFinal {

        public void runQ1() {
                System.out.println("==========CRIANDO FILME============");
                TimelineBuilder builder = new ConcreteTimelineBuilder();
                Timeline cinemaTimeline = builder.reset()
                                .addClassAdapterVideo("MainShot_4K.mov")
                                .build();

                System.out.println(cinemaTimeline.listVideoTrack());

                AssyncEditManager editor = new AssyncEditManager();
                editor.enfileirarAdicaoVideo(cinemaTimeline, "VooBalao.mov");
                editor.enfileirarAdicaoVideo(cinemaTimeline, "MergulhoBTS.mov");

                System.out.println("==========PROCESSAMENTO ASSINCRONO============");
                editor.processar();
                System.out.println(cinemaTimeline.listVideoTrack());

                System.out.println("==========DESFAZENDO PROCESSAMENTO============");
                editor.desfazerUltimaAcao();
                editor.desfazerUltimaAcao();
                System.out.println(cinemaTimeline.listVideoTrack());
        }
        
        public void runQ2() {
        	StreamDispatcher dispatcher = new StreamDispatcher();
        	dispatcher.runNoFly();
        	dispatcher.runFly();
        }	

        
        public void run() {
        	this.runQ1();
        	this.runQ2();
        }

        public static void main(String[] args) {
                new ClientFinal().run();
        }

}
