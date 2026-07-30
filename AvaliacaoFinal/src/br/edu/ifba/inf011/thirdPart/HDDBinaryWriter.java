package br.edu.ifba.inf011.thirdPart;

public class HDDBinaryWriter {

    protected byte[] rawBuffer;
    protected String path;

    public HDDBinaryWriter(String path) {
        this.path = path;
        this.rawBuffer = new byte[1];
    }

    public void writePhysicalSectors() {
    }

}
