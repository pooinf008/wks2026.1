package br.edu.ifba.inf011.editor.command;

public interface EditCommand {
	public void execute();
	public void undo();
}
