package demo.pojoconversion.conversion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import demo.pojoconversion.pojo.ColumnData;
import demo.pojoconversion.pojo.GroupDataDeserializer;
import demo.pojoconversion.pojo.ImmutableColumnData;
import demo.pojoconversion.pojo.ImmutableGroupData;

public class ConversionTester {
    private static final Map<String, Object> columnDataMap = new HashMap<String, Object>();
    private static final Map<String, Object> groupDataMap = new HashMap<String, Object>();
    private static final Map<String, ImmutableColumnData> immutableColumnDataMap = new HashMap<String, ImmutableColumnData>();
    private static final DateTime dateTime = DateTime.parse("2015-09-07");
    		

	static {
		columnDataMap.put("name", "testColumn");
		columnDataMap.put("displayName", "dislpay Name");
		columnDataMap.put("releaseDate", "2015-09-09");
		groupDataMap.put("groupName", "group Name");
		groupDataMap.put("columns", Arrays.asList("testColumn1", "testColumn2", "testColumn3"));
		immutableColumnDataMap.put("testColumn1", buildImmutableColumnData("1", "1", dateTime));
		immutableColumnDataMap.put("testColumn2", buildImmutableColumnData("2", "2", dateTime));
		immutableColumnDataMap.put("testColumn3", buildImmutableColumnData("3", "3", dateTime));
	}
	
	private static ImmutableColumnData buildImmutableColumnData(final String a, final String b, final DateTime c) {
		final ImmutableColumnData.ImmutableColumnBuilder builder = new ImmutableColumnData.ImmutableColumnBuilder();
		builder.setName(a);
		builder.setDisplayName(b);
		builder.setReleaseDate(c);
		return builder.build();
	}

	public static void main(final String args[]) {
		performJacksonConversion();
		//performGsonConversion();
	}
	
	private static void performJacksonConversion() {
		try {
			System.out.println("Jackson conversion");
			final ObjectMapper objectMapper = new ObjectMapper();
			final ImmutableColumnData columnData =
                objectMapper.convertValue(columnDataMap,
                ImmutableColumnData.ImmutableColumnBuilder.class).build();
			System.out.println("Column Data");
			System.out.println(columnData.toString());
			//final ImmutableColumnData immutableColumnData = objectMapper.convertValue(columnDataMap, ImmutableColumnData.class);
			////System.out.println("Immutable Column Data");
			//System.out.println(immutableColumnData.toString());
			performGroupDataConversion();
		} catch(final Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void performGroupDataConversion() {
		final GroupDataDeserializer groupDataDeserializer = new GroupDataDeserializer(immutableColumnDataMap);
		

        final SimpleModule module = new SimpleModule("LongDeserializerModule",
              new Version(1, 0, 0, null));
        module.addDeserializer(ImmutableGroupData.class, groupDataDeserializer);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        final ImmutableGroupData immutableGroupData = mapper.convertValue(groupDataMap, ImmutableGroupData.class);
        System.out.println("Group Data");
        System.out.println(immutableGroupData.toString());
        for (final ImmutableColumnData columnData : immutableGroupData.getColumns()) {
        	System.out.println(columnData.toString());
        }
	}
	

	
	private static void performGsonConversion() {
		try {
            System.out.println("GSON conversion");
            final Gson gson = new Gson();
            final JsonElement jsonElement = gson.toJsonTree(columnDataMap);
            final ColumnData columnData = gson.fromJson(jsonElement, ColumnData.class);
            System.out.println(columnData.toString());
		} catch(final Exception e) {
			e.printStackTrace();
		}
	}
}
