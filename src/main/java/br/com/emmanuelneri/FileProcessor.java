package br.com.emmanuelneri;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileProcessor {

    public void process(final File file) {
        System.out.println("Arquivo processado: " + file.getName());
    }

}
