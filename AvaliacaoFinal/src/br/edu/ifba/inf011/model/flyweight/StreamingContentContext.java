package br.edu.ifba.inf011.model.flyweight;

import br.edu.ifba.inf011.model.PlayableContent;

public class StreamingContentContext implements PlayableContent {
    private Integer pos;
    private Integer taxa;
    private StreamingContentFlyweight flyweight;

    public StreamingContentContext(String streamName, Integer taxa) {
        this.pos = 0;
        this.taxa = taxa;
        this.flyweight = StreamingContentFlyweightFactory.instance().getStreaming(streamName);
    }

    public String getStreamName() {
        return this.flyweight.getStreamName();
    }

    public Integer getDurationInSeconds() {
        return this.flyweight.getDuration();
    }

    public void play() {
        for (int time = this.pos; time < this.getDurationInSeconds(); time += this.taxa)
        	this.flyweight.play(time, this.taxa);
    }

}