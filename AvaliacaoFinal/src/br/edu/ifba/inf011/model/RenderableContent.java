package br.edu.ifba.inf011.model;

public interface RenderableContent {
	public Integer getDurationInSeconds();
	public void render(Integer inicio, Integer fim);
}