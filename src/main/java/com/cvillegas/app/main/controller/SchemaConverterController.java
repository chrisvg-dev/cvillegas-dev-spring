package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.dto.Message;
import com.cvillegas.app.main.service.ISchemaConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/helpers")
@RestController
@AllArgsConstructor
public class SchemaConverterController {

    private final ISchemaConverter schemaConverter;

    @PostMapping("/json-to-xsd")
    public ResponseEntity<Message> convertToXsd(@RequestBody Message message) {
        try {
            String xsd = schemaConverter.fromJSONToXSD(message.getText());
            return ResponseEntity.ok( new Message(xsd) );
        } catch ( Exception e ) {
            return ResponseEntity.badRequest().body( new Message("Error...") );
        }
    }


}
