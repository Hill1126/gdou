package Student.method.ShowMethod;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowToTable {
	public static void showMsg(JTable table , ResultSet rs) {
		DefaultTableModel model = new DefaultTableModel();
		
		table.setModel(model);
		
		try {
			ResultSetMetaData rsm = rs.getMetaData();
			String []colmn = new String[rsm.getColumnCount()];
			
			for (int i = 1; i <= rsm.getColumnCount();i++) {
				colmn[i-1] = rsm.getColumnName(i);
				model.addColumn(colmn[i-1]);
			}
			
			while(rs.next()){
				String Num = rs.getString(1);
				String Name = rs.getString(2);
				String Sex = rs.getString(3);
				String banji = rs.getString(4);
				String Tel = rs.getString(5);
				
				model.addRow(new Object[]{Num,Name,Sex,banji,Tel});
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
