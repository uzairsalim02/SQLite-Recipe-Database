# SQLite-Recipe-Database
# Project File Overview

## **1. DatabaseSeeder.java**
- **Purpose**: Preloads the database with initial data.
- **Functionality**: Inserts sample users, recipes, ingredients, and categories into the database to provide a starting dataset for testing and usage.

---

## **2. SQLiteDatabase.java**
- **Purpose**: Sets up the database and creates the necessary tables.
- **Functionality**:
  - Establishes a connection to the SQLite database.
  - Creates the following tables:
    - `users`: Stores user information (e.g., username, password, email).
    - `recipes`: Contains recipe details (e.g., name, description, instructions).
    - `ingredients`: Lists ingredients available for recipes.
    - `recipe_ingredients`: Links recipes to their respective ingredients.
    - `categories`: Defines categories for recipes.
    - `recipe_categories`: Links recipes to their categories.

---

## **3. RecipeManagerApp.java**
- **Purpose**: Provides the main user interface.
- **Functionality**:
  - Displays a menu with available queries and actions for the user.
  - Accepts user input for various operations, such as:
    - Finding recipes by ingredient or category.
    - Viewing recipes created by a specific user.
    - Adding or deleting recipes.
  - Calls the corresponding methods in `RecipeDataAccess.java` to execute the chosen query or action.

---

## **4. RecipeDataAccess.java**
- **Purpose**: Handles database interactions.
- **Functionality**:
  - Contains functions for executing SQL queries based on user input.
  - Examples of available methods:
    - `findRecipesByIngredient(String ingredient)`: Searches recipes contain
