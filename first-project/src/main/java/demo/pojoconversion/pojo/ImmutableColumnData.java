package demo.pojoconversion.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ColumnDataDeserializer.class)
@AllArgsConstructor
@Getter
public class ImmutableColumnData {
	private final String name;
	private final String displayName;
	private final DateTime releaseDate;
	
	@Override
	public String toString() {
		return String.format("Name:%s, displayName:%s, releaseDate:%s ", name, displayName, releaseDate);
	}
}