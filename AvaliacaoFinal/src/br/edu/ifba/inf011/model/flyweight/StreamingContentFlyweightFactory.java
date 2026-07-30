package br.edu.ifba.inf011.model.flyweight;

import java.util.HashMap;
import java.util.Map;

public class StreamingContentFlyweightFactory {

	
	private static StreamingContentFlyweightFactory instance;
	
	public static StreamingContentFlyweightFactory instance() {
		if(StreamingContentFlyweightFactory.instance == null)
			StreamingContentFlyweightFactory.instance = new StreamingContentFlyweightFactory();
		return StreamingContentFlyweightFactory.instance;
	}
	
	
	private Map<String, StreamingContentFlyweight> cache;
	
	
	private StreamingContentFlyweightFactory() {
		this.cache = new HashMap<String, StreamingContentFlyweight>();
	}
	
	public StreamingContentFlyweight getStreaming(String nome) {
		StreamingContentFlyweight content = cache.get(nome);
		if(content == null) {
			content = new StreamingContentFlyweight(nome);
			this.cache.put(nome, content);
		}	
		return content;
	}
	

}
