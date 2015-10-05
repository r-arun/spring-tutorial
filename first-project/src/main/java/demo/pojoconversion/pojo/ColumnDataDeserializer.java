package demo.pojoconversion.pojo;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ColumnDataDeserializer extends JsonDeserializer<ImmutableColumnData> {

	@Override
	public ImmutableColumnData deserialize(final JsonParser jsonParser,
			final DeserializationContext context) throws IOException,
			JsonProcessingException {
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        return new ImmutableColumnData(
                node.get("name").getTextValue(),
                node.get("displayName").getTextValue(),
                DateTime.parse(node.get("releaseDate").getTextValue()));
	}

}
