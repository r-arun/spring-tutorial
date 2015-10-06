package demo.pojoconversion.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import org.joda.time.DateTime;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ImmutableColumnData {
	private final String name;
	private final String displayName;
	private final DateTime releaseDate;
	
	/*
	@JsonPOJOBuilder
	public static class ImmutableColumnDataBuilder {
		
	}*/
	@Data
	public static class ImmutableColumnBuilder {
		private String name;
		private String displayName;
		private DateTime releaseDate;	
		
		public ImmutableColumnData build() {
			return new ImmutableColumnData(name, displayName, releaseDate);
		}
	}
	
	@Override
	public String toString() {
		return String.format("Name:%s, displayName:%s, releaseDate:%s ", name, displayName, releaseDate);
	}
}