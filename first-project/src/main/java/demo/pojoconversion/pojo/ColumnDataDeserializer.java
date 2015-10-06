package demo.pojoconversion.pojo;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.joda.time.DateTime;


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
