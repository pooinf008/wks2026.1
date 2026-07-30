package br.edu.ifba.inf011.timeline.builder;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.adapter.ClassAdapterTrack;
import br.edu.ifba.inf011.model.track.ClassVideoTrack;
import br.edu.ifba.inf011.model.track.SubTitleTrack;
import br.edu.ifba.inf011.model.track.Track;

public class ConcreteTimelineBuilder implements TimelineBuilder {

    public static final Integer DEFAULT_RATE = 50;

    private List<Track> videoTracks;
    private List<Track> audioTracks;
    private List<Track> subtitleTracks;

    public ConcreteTimelineBuilder() {
        this.reset();
    }

    @Override
    public TimelineBuilder reset() {
        this.videoTracks = new ArrayList<Track>();
        this.audioTracks = new ArrayList<Track>();
        this.subtitleTracks = new ArrayList<Track>();
        return this;
    }

    public TimelineBuilder addClassAdapterVideo(String name) {
        this.videoTracks.add(new ClassVideoTrack(name));
        return this;
    }

    public TimelineBuilder addClassAdapterAudio(String name) {
        this.audioTracks.add(new ClassAdapterTrack(name));
        return this;
    }

    public TimelineBuilder addClassAdapterSubTitle(String name, String idioma) {
        this.subtitleTracks.add(new SubTitleTrack(name, idioma));
        return this;
    }

    public Timeline build() {
        Timeline timeline = new Timeline();
        timeline.addAudioTracks(this.audioTracks);
        timeline.addVideoTracks(this.videoTracks);
        timeline.addSubTitleTracks(this.subtitleTracks);
        return timeline;
    }

}