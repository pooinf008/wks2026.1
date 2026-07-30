package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.thirdPart.HDDBinaryReader;

public class StreamingContentNoFlyweight extends HDDBinaryReader implements PlayableContent {
    private Integer pos;
    private Integer taxa;

    public StreamingContentNoFlyweight(String streamName, Integer taxa) {
        super(streamName);
        this.pos = 0;
        this.taxa = taxa;
    }

    public String getStreamName() {
        return this.path;
    }

    public Integer getDurationInSeconds() {
        return super.getDuration();
    }
    
    

    public void play() {
        if (this.rawBuffer == null)
            this.loadPhysicalSectors();
        for (int time = this.pos; time < this.getDurationInSeconds(); time += this.taxa)
            System.out.println("\t\tExibindo do segundo " + time + "s até "
                    + Math.min(time + this.taxa, this.getDurationInSeconds())
                    + "s da track " + this.path + ".");
    }

}