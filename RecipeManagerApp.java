import java.util.Scanner;
public class RecipeManagerApp {
    public static void main(String[] args){
        SQLiteDatabase.initializeDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("""
                \nChoose an option:
                1. Find recipe by ingredient
                2. Find recipe by category
                3. Find a user's recipe
                4. Add a new recipe
                5. Delete a recipe
                0. Exit
                """);
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 ->{
                        System.out.println("Enter the ingredient name: ");
                        String ingredientName = scanner.nextLine();
                        RecipeDataAccess.findRecipesByIngredient(ingredientName);
                    }
                    case 2-> {
                        System.out.println("Enter the category name: ");
                        String categoryName = scanner.nextLine();
                        RecipeDataAccess.findRecipesByCategory(categoryName);
                    }
                    case 3-> {
                        System.out.println("Enter the username: ");
                        String username = scanner.nextLine();
                        RecipeDataAccess.findRecipesByUser(username);
                    }
                    case 4-> {
                        System.out.println("Enter the username: ");
                        String username = scanner.nextLine();
                        System.out.println("Enter the recipe name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the recipe description: ");
                        String description = scanner.nextLine();
                        System.out.println("Enter the recipe instructions: ");
                        String instructions = scanner.nextLine();
                        RecipeDataAccess.addRecipe(name, description, instructions, username);
                    }
                    case 5-> {
                        System.out.println("Enter the recipe name: ");
                        String name = scanner.nextLine();
                        RecipeDataAccess.deleteRecipe(name);
                    }
                    case 0-> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
        }
    }
}
}
