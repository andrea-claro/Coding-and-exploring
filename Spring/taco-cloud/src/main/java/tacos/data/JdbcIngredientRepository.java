package tacos.data;
/*
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<Ingredient> findAll() {
		Iterable<Ingredient> ingredients = jdbc.query("select id, name, type from Ingredient", (rs, rowNum) -> {
			try {
				return mapRowToIngredient(rs, rowNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return ingredients;
	}

	
	 * Implementazione utilizzando il RowMapper con la method reference di Java 8
	 * 
	 * @Override public Ingredient findOne(String id) { Ingredient ingredient =
	 * jdbc.queryForObject("select id, name, type from Ingredient where id=?",
	 * this::mapRowToIngredient, id); return ingredient; }
	 

	@Override
	public Ingredient findOne(String id) {
		Ingredient ingredient = jdbc.queryForObject("select id, name, type from Ingredient where id=?", getMapper(),
				id);
		return ingredient;
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		jdbc.update("insert into Ingredient (id, name, type) values (?, ?, ?)", ingredient.getId(),
				ingredient.getName(), ingredient.getType());
		return ingredient;
	}

	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws Exception {
		Ingredient ingredient = new Ingredient(rs.getString("id"), rs.getString("name"),
				Ingredient.Type.valueOf(rs.getString("type")));
		return ingredient;
	}
	
	
	 * Metodo per prendere un ingrediente dal database grazie al nome
	 * 
	public Ingredient findOneFromName(String name) {
		Ingredient ingredient = jdbc.queryForObject("select id, name, type from Ingredient where name=?", getMapper(),
				name);
		return ingredient;
	}
	
	
	private RowMapper<Ingredient> getMapper() {
		RowMapper<Ingredient> mapper = new RowMapper<Ingredient>() {

			@Override
			public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ingredient ingredient = new Ingredient(rs.getString("id"), rs.getString("name"),
						Ingredient.Type.valueOf(rs.getString("type")));
				return ingredient;
			};
		};
		return mapper;
	}
}
*/