package model;

import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCBoxDAO implements BoxDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	

	public JDBCBoxDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public List<Box> getAllBoxes() {
		List<Box> boxList = new LinkedList<Box>();
		
		String sqlStatement = "SELECT * FROM box";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlStatement);
		
		while (result.next()) {
			boxList.add(mapRowToBox(result));
		}
		
		return boxList;
		
		
	}
	
	private Box mapRowToBox(SqlRowSet result) {

		Box b = new Box(result.getDouble("length"), result.getDouble("width"),result.getDouble("height"));
		b.setPriceInCents(result.getInt("price"));
		b.setSupplier(result.getString("supplier"));
		
		return b;
		
		
	}

}
