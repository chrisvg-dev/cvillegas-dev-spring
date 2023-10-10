package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.service.ISchemaConverter;
import com.ethlo.jsons2xsd.Config;
import com.ethlo.jsons2xsd.Jsons2Xsd;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import java.io.*;

@Component
public class SchemaConverterServiceImpl implements ISchemaConverter {
    @Override
    public String fromJSONToXSD(String jsonSchema) throws IOException {
        File temp = new File("temp.txt");
        try (FileWriter fileWriter = new FileWriter(temp)) {
            fileWriter.write( jsonSchema );

            Reader reader = new FileReader( temp );

            Config cfg = new Config.Builder()
                    .targetNamespace("http://example.com/myschema.xsd")
                    .name("array")
                    .build();

            Document document = Jsons2Xsd.convert( reader, cfg );
            reader.close();
            return document.getXmlVersion();
        }
    }
}
