package com.xyzcorp.domain.objectmapper;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.xyzcorp.domain.models.Aerobics;
import com.xyzcorp.domain.models.Weights;
import com.xyzcorp.domain.serializers.AerobicsSerializer;
import com.xyzcorp.domain.serializers.WeightsSerializer;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;


@Singleton
public class RegisterCustomModuleCustomizer implements ObjectMapperCustomizer {
    @Override
    public void customize(ObjectMapper objectMapper) {
        SimpleModule aerobicsSerializer = new SimpleModule(
            "AerobicsSerializer", new Version(1, 0, 0, "", "", ""));
        aerobicsSerializer.addSerializer(new AerobicsSerializer(Aerobics.class));
        aerobicsSerializer.addSerializer(new WeightsSerializer(Weights.class));
        objectMapper.registerModule(aerobicsSerializer);
    }
}
