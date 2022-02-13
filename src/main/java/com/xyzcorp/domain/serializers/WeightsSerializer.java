package com.xyzcorp.domain.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.xyzcorp.domain.models.Aerobics;
import com.xyzcorp.domain.models.Weights;

import java.io.IOException;

public class WeightsSerializer extends StdSerializer<Weights> {

    public WeightsSerializer(Class<Weights> t) {
        super(t);
    }

    @Override
    public void serialize(Weights weights, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", weights.getId());
        jsonGenerator.writeStringField("name", weights.getName());
        jsonGenerator.writeNumberField("sets", weights.getSets());
        jsonGenerator.writeNumberField("reps", weights.getReps());
        jsonGenerator.writeNumberField("pounds", weights.getPounds());
        jsonGenerator.writeNumberField("userId", weights.getUser().getId());
        jsonGenerator.writeEndObject();
    }
}
