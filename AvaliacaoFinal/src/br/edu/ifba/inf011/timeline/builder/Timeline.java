package br.edu.ifba.inf011.timeline.builder;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.RenderableContent;
import br.edu.ifba.inf011.model.track.AudioTrack;
import br.edu.ifba.inf011.model.track.SubTitleTrack;
import br.edu.ifba.inf011.model.track.Track;
import br.edu.ifba.inf011.thirdPart.HDDBinaryWriter;

public class Timeline implements RenderableContent {

    private List<Track> videoTracks = new ArrayList<Track>();
    private List<Track> audioTracks = new ArrayList<Track>();
    private List<Track> subTitleTracks = new ArrayList<Track>();

    protected Timeline() {
    }

    public void addVideoTrack(Track track) {
        this.videoTracks.add(track);
    }

    public void addVideoTracks(List<Track> videoTracks) {
        this.videoTracks = videoTracks;
    }

    public void addAudioTrack(AudioTrack track) {
        this.audioTracks.add(track);
    }

    public void addAudioTracks(List<Track> audioTracks) {
        this.audioTracks = audioTracks;
    }

    public void addSubTitleTrack(SubTitleTrack track) {
        this.subTitleTracks.add(track);
    }

    public void addSubTitleTracks(List<Track> subTitleTracks) {
        this.subTitleTracks = subTitleTracks;
    }

    public void removeVideoTrack(Track track) {
        this.videoTracks.remove(track);
    }

    public void removeVideoTrack(String trackName) {
        for (Track track : this.videoTracks)
            if (trackName.equals(track.getStreamName())) {
                this.videoTracks.remove(track);
                return;
            }
    }

    public String listVideoTrack() {
        StringBuffer lista = new StringBuffer();
        for (Track track : this.videoTracks)
            lista.append(track.getStreamName() + "\n");
        return lista.toString();

    }

    public List<Track> getSubTitleTracks() {
        return subTitleTracks;
    }


    public void render(Integer inicio, Integer duration) {
        Integer fimDesejado = inicio + duration;
        Integer fimVideo = this.renderChannel(this.videoTracks, inicio, fimDesejado);
        Integer fimAudio = this.renderChannel(this.audioTracks, inicio, fimDesejado);
        Integer fimLegenda = this.renderChannel(this.subTitleTracks, inicio, fimDesejado);

        Integer fimMaiorCanal = Math.max(fimVideo, Math.max(fimAudio, fimLegenda));

        Integer fimReal = Math.min(fimDesejado, fimMaiorCanal);

        System.out.println("[Timeline] >> Timeline Principal  do segundo " +
                inicio + "s até " + fimReal + "s.");
    }

    private Integer renderChannel(List<? extends Track> tracks, Integer inicio, Integer fimDesejado) {
        Integer tempoAcumulado = 0;
        for (Track track : tracks) {
            Integer trackDuracao = track.getDurationInSeconds();
            Integer trackInicioNaTimeline = tempoAcumulado;
            Integer trackFimNaTimeline = trackInicioNaTimeline + trackDuracao;

            if (tempoAcumulado >= fimDesejado)
                break;

            if (inicio < trackFimNaTimeline && fimDesejado > trackInicioNaTimeline) {
                Integer initRelativo = Math.max(0, inicio - trackInicioNaTimeline);
                Integer duracaoRelativa = Math.min(trackFimNaTimeline, fimDesejado)
                        - Math.max(trackInicioNaTimeline, inicio);
                track.render(initRelativo, duracaoRelativa);
            }
            tempoAcumulado += trackDuracao;
        }
        return Math.min(tempoAcumulado, fimDesejado);
    }

    public Integer getDurationInSeconds() {
        Integer maxDuration = 0;

        maxDuration = Math.max(maxDuration, this.getChannelDuration(this.videoTracks));
        maxDuration = Math.max(maxDuration, this.getChannelDuration(this.audioTracks));
        maxDuration = Math.max(maxDuration, this.getChannelDuration(this.subTitleTracks));

        return maxDuration;
    }

    private Integer getChannelDuration(List<? extends Track> tracks) {
        Integer trackDuration;
        trackDuration = 0;
        for (Track track : tracks)
            trackDuration += track.getDurationInSeconds();
        return trackDuration;
    }

    public HDDBinaryWriter make(String name) {
        return new HDDBinaryWriter(name);
    }

}