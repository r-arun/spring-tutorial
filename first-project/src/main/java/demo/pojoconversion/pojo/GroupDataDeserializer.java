package demo.pojoconversion.pojo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.type.TypeReference;

@AllArgsConstructor
public class GroupDataDeserializer extends JsonDeserializer<ImmutableGroupData> {
	private final Map<String, ImmutableColumnData> immutableColumnMap;

	@Override
	public ImmutableGroupData deserialize(final JsonParser jsonParser,
			final DeserializationContext deserializationContext) throws IOException,
			JsonProcessingException {
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        final String groupName = node.get("groupName").getTextValue();
        final List<String> columnList = getColumnList(oc, node);
        final List<ImmutableColumnData> matchingColumnList = getMatchingColumnData(columnList);
        return new ImmutableGroupData(groupName, matchingColumnList);
	}
	
	private List<String> getColumnList(final ObjectCodec objectCodec, final JsonNode node) {
		try {
            final JsonNode node2 = node.get("columns");
            final TypeReference<List<String>> typeRef = new TypeReference<List<String>>(){};
            return objectCodec.readValue(node2.traverse(), typeRef);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private List<ImmutableColumnData> getMatchingColumnData(final List<String> columnDataList) {
		final List<ImmutableColumnData> columns = new ArrayList<ImmutableColumnData>();
		for (final String columnData : columnDataList) {
			columns.add(immutableColumnMap.get(columnData));
		}
		return columns;
	}

}
