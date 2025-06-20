import java.util.*;
import java.nio.file.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File to read: ");
        String filename = scanner.nextLine();
        List<Recipe> recipes = readRecipesFromFile(filename);

        System.out.println("\nCommands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.print("\nEnter command: ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            } else if (command.equals("list")) {
                System.out.println("\nRecipes:");
                for (Recipe recipe : recipes) {
                    System.out.println(recipe);
                }
            } else if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String keyword = scanner.nextLine().toLowerCase();

                System.out.println("\nRecipes:");
                for (Recipe recipe : recipes) {
                    if (recipe.getName().toLowerCase().contains(keyword)) {
                        System.out.println(recipe);
                    }
                }
            } else if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxTime = Integer.parseInt(scanner.nextLine());

                System.out.println("\nRecipes:");
                for (Recipe recipe : recipes) {
                    if (recipe.getCookingTime() <= maxTime) {
                        System.out.println(recipe);
                    }
                }
            } else if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine().toLowerCase();

                System.out.println("\nRecipes:");
                for (Recipe recipe : recipes) {
                    if (recipe.getIngredients().stream()
                            .map(String::toLowerCase)
                            .anyMatch(i -> i.equals(ingredient))) {
                        System.out.println(recipe);
                    }
                }
            }
        }
    }

    public static List<Recipe> readRecipesFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<Recipe> recipes = new ArrayList<>();

        String name = null;
        int time = 0;
        List<String> ingredients = new ArrayList<>();

        for (String line : lines) {
            if (line.isEmpty()) {
                if (name != null) {
                    recipes.add(new Recipe(name, time, ingredients));
                }
                name = null;
                ingredients = new ArrayList<>();
            } else if (name == null) {
                name = line;
            } else if (ingredients.isEmpty()) {
                time = Integer.parseInt(line);
            } else {
                ingredients.add(line);
            }
        }

        // Add the last recipe if file doesn't end with empty line
        if (name != null) {
            recipes.add(new Recipe(name, time, ingredients));
        }

        return recipes;
    }
}