package br.edu.ifba.inf011.model.track;

import br.edu.ifba.inf011.adapter.ClassAdapterTrack;

public class AudioTrack extends ClassAdapterTrack {
    private String streamName;

    public AudioTrack(String streamName) {
        super(streamName);
    }

    public AudioTrack(AudioTrack at) {
        super(at.streamName);
    }


}
