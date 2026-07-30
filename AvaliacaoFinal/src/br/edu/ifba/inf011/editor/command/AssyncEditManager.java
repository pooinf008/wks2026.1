package br.edu.ifba.inf011.editor.command;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import br.edu.ifba.inf011.timeline.builder.Timeline;

public class AssyncEditManager {

	private Queue<EditCommand> filaProcessamentoAsync = new LinkedList<EditCommand>();
	private Stack<EditCommand> historicoUndo = new Stack<EditCommand>();

	public void enfileirarAdicaoVideo(Timeline timeline, String streamName) {
		filaProcessamentoAsync.add(new AdicionarVideoTrackCommand(timeline, streamName));
		System.out.println("[Invoker] Comando enfileirado para processamento assíncrono.");
	}

	public void processar() {
		while (!filaProcessamentoAsync.isEmpty()) {
			EditCommand comando = filaProcessamentoAsync.poll();
			comando.execute();
			historicoUndo.push(comando);
		}
	}

	public void desfazerUltimaAcao() {
		if (!historicoUndo.isEmpty()) {
			System.out.println("[Invoker] Solicitado comando de Desfazer (Undo)...");
			EditCommand ultimoComando = historicoUndo.pop();
			ultimoComando.undo();
		}
	}
}
