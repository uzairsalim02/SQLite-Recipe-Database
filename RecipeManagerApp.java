import java.util.Scanner;
public class RecipeManagerApp {
    public static void main(String[] args){
        SQLiteDatabase.initializeDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("""
                Choose an option:
                1. Find recipe by ingredient
                2. Find recipe by category
                3. Find a user's recipe
                4. Add a new recipe
                5. Delete a recipe
                0. Exit
                """);
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 ->{
                        System.out.println("Enter the ingredient name: ");
                        String ingredientName = scanner.next();
                        //RecipeManager.findRecipeByIngredient(ingredientName);
                    }
                    case 2-> System.out.println("Feature not implemented yet");
                    case 3-> System.out.println("Feature not implemented yet");
                    case 4-> System.out.println("Feature not implemented yet");
                    case 5-> System.out.println("Feature not implemented yet");
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
