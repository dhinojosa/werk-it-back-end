package com.xyzcorp.domain.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.xyzcorp.domain.models.Aerobics;

import java.io.IOException;

public class AerobicsSerializer extends StdSerializer<Aerobics> {

    public AerobicsSerializer(Class<Aerobics> t) {
        super(t);
    }

    @Override
    public void serialize(Aerobics aerobics, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", aerobics.getId());
        jsonGenerator.writeStringField("name", aerobics.getName());
        jsonGenerator.writeNumberField("seconds", aerobics.getSeconds());
        jsonGenerator.writeNumberField("userId", aerobics.getUser().getId());
        jsonGenerator.writeEndObject();
    }
}
