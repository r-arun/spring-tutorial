package demo.pojoconversion.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.joda.time.DateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ColumnData {
	private String name;
	private String displayName;
	private DateTime releaseDate;
	
	@Override
	public String toString() {
		return String.format("Name:%s, displayName:%s, releaseDate:%s ", name, displayName, releaseDate);
	}

}
