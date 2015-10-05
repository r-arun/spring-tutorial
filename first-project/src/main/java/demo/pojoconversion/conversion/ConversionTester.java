package demo.pojoconversion.conversion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import demo.pojoconversion.pojo.ColumnData;
import demo.pojoconversion.pojo.ImmutableColumnData;

public class ConversionTester {
    private static final Map<String, Object> columnDataMap = new HashMap<String, Object>();
    private static final Map<String, Object> groupDataMap = new HashMap<String, Object>();

	static {
		columnDataMap.put("name", "testColumn");
		columnDataMap.put("displayName", "dislpay Name");
		columnDataMap.put("releaseDate", "2015-09-09");
		groupDataMap.put("groupName", "group Name");
		groupDataMap.put("columns", Arrays.asList("testColumn"));
	}

	public static void main(final String args[]) {
		performJacksonConversion();
		performGsonConversion();
	}
	
	private static void performJacksonConversion() {
		try {
			System.out.println("Jackson conversion");
			final ObjectMapper objectMapper = new ObjectMapper();
			final ColumnData columnData = objectMapper.convertValue(columnDataMap, ColumnData.class);
			System.out.println("Column Data");
			System.out.println(columnData.toString());
			final ImmutableColumnData immutableColumnData = objectMapper.convertValue(columnDataMap, ImmutableColumnData.class);
			System.out.println("Immutable Column Data");
			System.out.println(immutableColumnData.toString());
		} catch(final Exception e) {
			e.printStackTrace();
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
