package org.hao.learn.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import jodd.datetime.JDateTime;

import java.io.IOException;

/**
 * Created by XizeTian on 2017/2/23.
 */
public class JDateSerializer extends JsonSerializer<JDateTime> {
    public void serialize(JDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString(getFormat()));
    }

    public String getFormat() {
        return "YYYY-MM-DD";
    }
}
