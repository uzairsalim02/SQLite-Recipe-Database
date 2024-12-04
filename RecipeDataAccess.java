import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RecipeDataAccess {
    private static final String URL = "jdbc:sqlite:recipe_manager.db";
    //Returns recipes that contain the specified ingredient
    public static void findRecipesByIngredient(String ingredient){
        String query = """
            SELECT r.name, r.description, r.instructions
            FROM recipes r
            JOIN recipe_ingredients ri ON r.recipe_id = ri.recipe_id
            JOIN ingredients i ON ri.ingredient_id = i.ingredient_id
            WHERE i.name = ?
            """;
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, ingredient);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Instructions: " + resultSet.getString("instructions"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //returns recipes that belong to the specified category
    public static void findRecipesByCategory(String category){
        String query = """
            SELECT r.name, r.description, r.instructions
            FROM recipes r
            JOIN RecipeCategories rc ON r.recipe_id = rc.recipe_id
            JOIN categories c ON rc.category_id = c.category_id
            WHERE c.name = ?
            """;
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Instructions: " + resultSet.getString("instructions"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //returns recipes that belong to the specified user
    public static void findRecipesByUser(String username){
        String query = """
            SELECT r.name, r.description, r.instructions
            FROM recipes r
            JOIN users u ON r.user_id = u.user_id
            WHERE u.username = ?
            """;
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Instructions: " + resultSet.getString("instructions"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //adds a new recipe to the database
    public static void addRecipe(String name, String description, String instructions, String username){
        String query = """
            INSERT INTO recipes (user_id, name, description, instructions)
            VALUES ((SELECT user_id FROM users WHERE username = ?), ?, ?, ?)
            """;
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, instructions);
            preparedStatement.executeUpdate();
            System.out.println("Recipe added successfully.");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //deletes a recipe from the database
    public static void deleteRecipe(String name){
        String query = """
            DELETE FROM recipes
            WHERE name = ?
            """;
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Recipe deleted successfully.");
        } catch (Exception e){
            e.printStackTrace();

        }
    }
}
