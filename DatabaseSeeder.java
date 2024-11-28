import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseSeeder {
    private static final String URL = "jdbc:sqlite:recipe_manager.db";

    public static void seedDatabase() {
        // Predefined data
        String[] users = {
            "INSERT INTO users (username, password, email) VALUES ('john_doe', 'password123', 'john.doe@example.com');",
            "INSERT INTO users (username, password, email) VALUES ('jane_smith', 'securePass!', 'jane.smith@example.com');"
        };

        String[] recipes = {
            "INSERT INTO recipes (user_id, name, description, instructions) VALUES (1, 'Spaghetti Bolognese', 'Classic Italian pasta', 'Cook pasta, prepare sauce, mix together.');",
            "INSERT INTO recipes (user_id, name, description, instructions) VALUES (2, 'Vegetable Stir Fry', 'Quick and healthy stir fry', 'Chop vegetables, stir fry in wok, season to taste.');"
        };

        String[] ingredients = {
            "INSERT INTO ingredients (name) VALUES ('Spaghetti');",
            "INSERT INTO ingredients (name) VALUES ('Ground Beef');",
            "INSERT INTO ingredients (name) VALUES ('Tomato Sauce');",
            "INSERT INTO ingredients (name) VALUES ('Mixed Vegetables');",
            "INSERT INTO ingredients (name) VALUES ('Soy Sauce');"
        };

        String[] recipeIngredients = {
            "INSERT INTO recipe_ingredients (recipe_id, ingredient_id, quantity) VALUES (1, 1, '200g');",
            "INSERT INTO recipe_ingredients (recipe_id, ingredient_id, quantity) VALUES (1, 2, '300g');",
            "INSERT INTO recipe_ingredients (recipe_id, ingredient_id, quantity) VALUES (1, 3, '400ml');",
            "INSERT INTO recipe_ingredients (recipe_id, ingredient_id, quantity) VALUES (2, 4, '500g');",
            "INSERT INTO recipe_ingredients (recipe_id, ingredient_id, quantity) VALUES (2, 5, '50ml');"
        };

        String[] categories = {
            "INSERT INTO categories (name) VALUES ('Italian');",
            "INSERT INTO categories (name) VALUES ('Healthy');",
            "INSERT INTO categories (name) VALUES ('Quick Meals');"
        };

        String[] recipeCategories = {
            "INSERT INTO recipecategories (recipe_id, category_id) VALUES (1, 1);",
            "INSERT INTO recipecategories (recipe_id, category_id) VALUES (2, 2);",
            "INSERT INTO recipecategories (recipe_id, category_id) VALUES (2, 3);"
        };

        // Seed data
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            System.out.println("Seeding users...");
            for (String query : users) {
                stmt.execute(query);
            }

            System.out.println("Seeding recipes...");
            for (String query : recipes) {
                stmt.execute(query);
            }

            System.out.println("Seeding ingredients...");
            for (String query : ingredients) {
                stmt.execute(query);
            }

            System.out.println("Seeding recipe ingredients...");
            for (String query : recipeIngredients) {
                stmt.execute(query);
            }

            System.out.println("Seeding categories...");
            for (String query : categories) {
                stmt.execute(query);
            }

            System.out.println("Seeding recipe categories...");
            for (String query : recipeCategories) {
                stmt.execute(query);
            }

            System.out.println("Database seeding completed successfully.");

        } catch (Exception e) {
            System.err.println("Error seeding database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ensure database is initialized
        SQLiteDatabase.initializeDatabase();

        // Seed the database
        seedDatabase();
    }
}

