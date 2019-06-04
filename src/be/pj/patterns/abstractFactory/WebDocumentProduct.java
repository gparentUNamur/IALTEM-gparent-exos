package be.pj.patterns.abstractFactory;


import java.io.IOException;

public interface WebDocumentProduct {

    void generateFile(String path) throws IOException;
}
