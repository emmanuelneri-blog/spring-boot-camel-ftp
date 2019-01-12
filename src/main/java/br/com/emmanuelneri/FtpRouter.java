package br.com.emmanuelneri;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FtpRouter extends RouteBuilder {

    private static final String DELAY = "6000";
    private static final String FTP_PASTA = "arquivos";
    private static final String FTP_USUARIO = "usuario";
    private static final String FTP_SENHA = "123";
    private static final String PASTA_TEMPORARIA_LOCAL = "/tmp";

    @Autowired
    private FileProcessor fileProcessor;

    @Override
    public void configure() throws Exception {
        fromF("ftp://%s/%s?username=%s" +
                        "&password=%s" +
                        "&move=sucesso" +
                        "&moveFailed=erro" +
                        "&initialDelay=6000" +
                        "&delay=%s" +
                        "&binary=true" +
                        "&localWorkDirectory=%s",
                "localhost",
                FTP_PASTA,
                FTP_USUARIO,
                FTP_SENHA,
                DELAY,
                PASTA_TEMPORARIA_LOCAL)
                .routeId(FtpRouter.class.getSimpleName())
                .bean(fileProcessor, "process");
    }
}
