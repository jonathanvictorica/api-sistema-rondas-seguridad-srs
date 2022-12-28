package com.utn.frba.srs.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class DataLoadConfig {

    private static final Boolean CONTINUE_ERROR = true;

    private final DataSource dataSource;

    public DataLoadConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void loadData() throws IOException {
        List<String> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get("src/main/resources/script"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        files.add(path.getFileName().toString());

                    });


            files.stream().map(file -> "script/" + file).forEach(name -> {
//                ClassPathResource resource = new ClassPathResource(name);
//                ScriptUtils.executeSqlScript(ConexionDB.getConexion(), new EncodedResource(resource),
//                        false, false,
//                        ScriptUtils.DEFAULT_COMMENT_PREFIX, ScriptUtils.EOF_STATEMENT_SEPARATOR,
//                        ScriptUtils.DEFAULT_BLOCK_COMMENT_START_DELIMITER, ScriptUtils.DEFAULT_BLOCK_COMMENT_END_DELIMITER);


                ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(CONTINUE_ERROR, false, "UTF-8", new ClassPathResource(name));


                resourceDatabasePopulator.execute(dataSource);
            });

        }
    }
}
