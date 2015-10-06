package demo.pojoconversion.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class ImmutableGroupData {
	private final String groupName;
	private final List<ImmutableColumnData> columns;

	@Override
	public String toString() {
		return String.format("Group Name:%s, column size:%d", groupName, columns.size());
	}
}
