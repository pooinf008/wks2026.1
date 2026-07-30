package br.edu.ifba.inf011.model.track;

import br.edu.ifba.inf011.adapter.ClassAdapterTrack;

public class ClassVideoTrack extends ClassAdapterTrack {
    private String streamName;

    public ClassVideoTrack(String streamName) {
        super(streamName);
    }

    public ClassVideoTrack(ClassVideoTrack vt) {
        super(vt.streamName);
    }

}
