package demo.pojoconversion.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupData {
	private String groupName;
	private List<ColumnData> columns;
	
	@Override
	public String toString() {
		return String.format("Group Name:%s, column size:%d", groupName, columns.size());
	}
}
