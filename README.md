# TestCasePractice
Programming exercise:
Recipe search (4 parts)


Points
0
/
4
NB! By submitting a solution to a part of an exercise which has multiple parts, you can get part of the exercise points. You can submit a part by using the 'submit' button on NetBeans. More on the programming exercise submission instructions: Exercise submission instructions.

In this exercise we are going to create a program that allows for searching for recipes based on their name, cooking time, or the name of an ingredient. The program should read the recipes from a file that the user provides. It might be a good idea to brush up on reading information from files (part 4) before beginning

Each recipe consists of three or more rows in a recipe file. The first row is for the name of the recipe, the second the cooking time (an integer), and the third and possibly following rows list the ingredients used in the recipe. An empty row follows the last ingredient row. There can be many recipes in a single file. Below, an example file containing recipes is described.

Sample output
Pancake dough
60
milk
egg
flour
salt
butter

Meatballs
20
ground meat
egg
breadcrumbs

Tofu rolls
30
tofu
rice
water
carrot
cucumber
avocado
wasabi
The program will be implemented in parts. First we'll create the possibility to read and list recipes. After that we'll add the functionality to search for recipes based on their name, cooking time, or the name of an ingredient.

There is a file called recipes.txt supplied with the exercise base. You can use it for testing purposes. Notice that the program should not list the ingredients of the recipes, but they will be used in the search functionality.

Reading and listing recipes

First create the functionality to read and list recipes. The user interface of the program is described below. You may assume that the user only enters files that exist. Below we assume that the example recipes given earlier in the exercise description are stored in the file recipes.txt.

Sample output
File to read: recipes.txt

Commands:
list - lists the recipes
stop - stops the program

Enter command: list

Recipes:
Pancake dough, cooking time: 60
Meatballs, cooking time: 20
Tofu rolls, cooking time: 30

Enter command:  stop
Finding recipes by name

Make it possible to find recipes by their names. Finding by name is done with the command find name, after which the user is asked for the name that is used to search. The search should print all the recipes whose names contain the string given by the user.

Sample output
File to read: recipes.txt

Commands:
list - lists the recipes
stop - stops the program
find name - searches recipes by name

Enter command: list

Recipes:
Pancake dough, cooking time: 60
Meatballs, cooking time: 20
Tofu rolls, cooking time: 30

Enter command: find name
Searched word: roll

Recipes:
Tofu rolls, cooking time: 30

Enter command:  stop
Searching for recipes by cooking time

Next, implement the possibility to find recipes based on their cooking time. This is done with the command find cooking time, after which the user is asked for the longest acceptable cooking time. The program should react by printing all the recipes whose cooking times don't exceed the cooking time given by the user (so equal or less time).

Sample output
File to read: recipes.txt

Commands:
list - lists the recipes
stop - stops the program
find name - searches recipes by name
find cooking time - searches recipes by cooking time

Enter command: find cooking time
Max cooking time: 30

Recipes:
Meatballs, cooking time: 20
Tofu rolls, cooking time: 30

Enter command: find cooking time
Max cooking time: 15

Recipes:

Enter command: find name
Searched word: roll

Recipes:
Tofu rolls, cooking time: 30

Enter command:  stop
Finding recipes based on their ingredients

Finally, add the functionality to search for recipes based on their ingredients. This is done by choosing the command find ingredient, after which the user is asked for a string. The program should then print all the recipes that contain the specified string. Notice that with this option the given string must match exactly the ingredient that is searched for (e.g. "ugar" will return different results than "sugar").

Sample output
File to read: recipes.txt

Commands:
list - lists the recipes
stop - stops the program
find name - searches recipes by name
find cooking time - searches recipes by cooking time
find ingredient - searches recipes by ingredient

Enter command: find cooking time
Max cooking time: 30

Recipes:
Meatballs, cooking time: 20
Tofu rolls, cooking time: 30

Enter command: find ingredient
Ingredient: sugar

Recipes:
Pancake dough, cooking time: 60

Enter command: find ingredient
Ingredient: egg

Recipes:
Pancake dough, cooking time: 60
Meatballs, cooking time: 20

Enter command: find ingredient
Ingredient: gg

Recipes:

Enter command:  stop
