package org.hao.learn.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import jodd.datetime.JDateTime;

import java.io.IOException;

/**
 * Created by mt on 2016-07-19 19:40.
 */
public class JDateTimeDeserializer extends JsonDeserializer<JDateTime> {
    @Override
    public JDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return new JDateTime(p.getValueAsString());
    }
}