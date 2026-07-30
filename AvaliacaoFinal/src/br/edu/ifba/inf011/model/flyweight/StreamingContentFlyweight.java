package br.edu.ifba.inf011.model.flyweight;

import br.edu.ifba.inf011.thirdPart.HDDBinaryReader;

public class StreamingContentFlyweight extends HDDBinaryReader{

    public StreamingContentFlyweight(String streamName) {
        super(streamName);
    }

    public String getStreamName() {
        return this.path;
    }

    public Integer getDurationInSeconds() {
        return super.getDuration();
    }

    public void play(Integer pos, Integer taxa) {
        if (this.rawBuffer == null)
            this.loadPhysicalSectors();
       System.out.println("\t\tExibindo do segundo " + pos + "s até "
                    + Math.min(pos + taxa, this.getDurationInSeconds())
                    + "s da track " + this.path + ".");
    }

}