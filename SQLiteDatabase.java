import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteDatabase {
    public static void initializeDatabase() {
        String url = "jdbc:sqlite:recipe_manager.db";

        //SQL statements for table creation
        //Create users table with columns: user_id, username, password, email
        String createUsersTable = """
            CREATE TABLE IF NOT EXISTS users (
                user_id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL,
                email TEXT UNIQUE NOT NULL
                );
                """;
        //Recipe Table with columns: recipe_id, user_is, name, description, instructions, created_at, updated_at, FOREIGN KEY(user_id) REFERENCES users(user_id)
        String createRecipesTable = """
            CREATE TABLE IF NOT EXISTS recipes (
                recipe_id INTEGER PRIMARY KEY AUTOINCREMENT,
                user_id INTEGER NOT NULL,
                name TEXT NOT NULL,
                description TEXT,
                instructions TEXT NOT NULL,
                created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY(user_id) REFERENCES users(user_id)
                );
                """;
        
        String createIngredientsTable = """
            CREATE TABLE IF NOT EXISTS Ingredients (
                ingredient_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL
            );
        """;
        //RECIPE INGREDIENTS TABLE with columns: recipe_id, ingredient_id, quantity, PRIMARY KEY (recipe_id, ingredient_id), FOREIGN KEY(recipe_id) REFERENCES recipes(recipe_id), FOREIGN KEY(ingredient_id) REFERENCES ingredients(ingredient_id)
        String createRecipeIngredientsTable = """
            CREATE TABLE IF NOT EXISTS recipe_ingredients (
                recipe_id INTEGER NOT NULL,
                ingredient_id INTEGER NOT NULL,
                quantity TEXT,
                PRIMARY KEY (recipe_id, ingredient_id),
                FOREIGN KEY(recipe_id) REFERENCES recipes(recipe_id),
                FOREIGN KEY(ingredient_id) REFERENCES ingredients(ingredient_id)
                );
                """;
        
        //Categories Table with columns: recipe_id, category_id, PRIMARY KEY (recipe_id, category_id), FOREIGN KEY(recipe_id) REFERENCES recipes(recipe_id), FOREIGN KEY(category_id) REFERENCES categories(category_id)
        String createCategoriesTable = """
            CREATE TABLE IF NOT EXISTS Categories (
                category_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT UNIQUE NOT NULL
            );
            """;

        String createRecipeCategoriesTable = """
            CREATE TABLE IF NOT EXISTS RecipeCategories (
                recipe_id INTEGER NOT NULL,
                category_id INTEGER NOT NULL,
                PRIMARY KEY (recipe_id, category_id),
                FOREIGN KEY (recipe_id) REFERENCES Recipes(recipe_id),
                FOREIGN KEY (category_id) REFERENCES Categories(category_id)
            );
            """;

                try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
   
               // Execute table creation SQL
               stmt.execute(createUsersTable);
               stmt.execute(createRecipesTable);
               stmt.execute(createIngredientsTable);
               stmt.execute(createRecipeIngredientsTable);
               stmt.execute(createCategoriesTable);
               stmt.execute(createRecipeCategoriesTable);
   
               System.out.println("Database and tables created successfully.");
           } catch (Exception e) {
               System.err.println(e.getMessage());
           }
        
    }
}