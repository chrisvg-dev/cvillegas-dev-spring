package com.cvillegas.app.main.service;

import java.io.IOException;

public interface ISchemaConverter {

    String fromJSONToXSD( String jsonSchema ) throws IOException;

}
