package br.edu.ifba.inf011.timeline.builder;

public interface TimelineBuilder {
	public TimelineBuilder reset();
	public TimelineBuilder addClassAdapterVideo(String name);
	public TimelineBuilder addClassAdapterAudio(String name);
	public TimelineBuilder addClassAdapterSubTitle(String name, String idioma);
	public Timeline build();
}