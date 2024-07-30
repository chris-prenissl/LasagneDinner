package data.repository

import domain.model.Dish
import domain.model.DishStep
import domain.model.IngredientType
import domain.model.OnePersonIngredient
import domain.repository.RecipeRepository
import lasagnedinner.composeapp.generated.resources.Res
import lasagnedinner.composeapp.generated.resources.bruschetta
import lasagnedinner.composeapp.generated.resources.flambananen
import lasagnedinner.composeapp.generated.resources.lasagne
import lasagnedinner.composeapp.generated.resources.schritt1
import lasagnedinner.composeapp.generated.resources.schritt10
import lasagnedinner.composeapp.generated.resources.schritt11
import lasagnedinner.composeapp.generated.resources.schritt12
import lasagnedinner.composeapp.generated.resources.schritt13
import lasagnedinner.composeapp.generated.resources.schritt2
import lasagnedinner.composeapp.generated.resources.schritt3
import lasagnedinner.composeapp.generated.resources.schritt4
import lasagnedinner.composeapp.generated.resources.schritt5
import lasagnedinner.composeapp.generated.resources.schritt6
import lasagnedinner.composeapp.generated.resources.schritt7
import lasagnedinner.composeapp.generated.resources.schritt8
import lasagnedinner.composeapp.generated.resources.schritt9

class RecipeRepositoryImpl : RecipeRepository {
    private val recipes =
        listOf(
            Dish(
                title = "Bruschetta",
                ingredients = listOf(
                    OnePersonIngredient(
                        title = "Tomaten",
                        value = 0.5f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Zwiebeln",
                        value = 0.25f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Olivenöl",
                        value = 10.0f,
                        type = IngredientType.Milliliter,
                    ),
                    OnePersonIngredient(
                        title = "Ciabatta",
                        value = 0.25f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Basilikum",
                        value = 0.25f,
                        type = IngredientType.Truss,
                    ),
                    OnePersonIngredient(
                        title = "Knoblauchzehen",
                        value = 0.5f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Salz",
                        value = 1.0f,
                        type = IngredientType.Skosh,
                    ),
                    OnePersonIngredient(
                        title = "Pfeffer",
                        value = 1.0f,
                        type = IngredientType.Skosh,
                    ),
                ),
                image = Res.drawable.bruschetta,
                steps = listOf(
                    DishStep(
                        image = Res.drawable.schritt1,
                        title = "Baguette Vorbereiten",
                        stepDescription = "Schneide das Ciabatta nach Belieben in Scheiben und reibe " +
                            "es mit einer halbierten Knoblauchzehe und Olivenöl gründlich ein.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt2,
                        title = "Backofen Vorheizen",
                        stepDescription = "Heize den Backofen auf 150°C bei Ober-Unterhitze vor und " +
                            "lege die Ciabattascheiben auf einen mit Backpapier belegten Rost." +
                            " Die Scheiben müssen nun bis zur gewünschten Bräune und " +
                            "angenehmen Knoblauch-Duft für ca. 5-10 min. im Ofen bleiben.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt3,
                        title = "Topping",
                        stepDescription = "Schneide nun die Zwiebeln und Tomaten in Würfel und das" +
                            " Basilikum in Streifen. Mische die Zutaten und würze die Masse " +
                            "mit Basilikum, Salz und Pfeffer.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt4,
                        title = "Anrichten",
                        stepDescription = "Trage nun die Bruschettamasse auf die knusprig" +
                            " duftenden Ciabattascheiben auf. Nach Wunsch kann das Topping" +
                            " noch mit Olivenöl beträufelt werden.Das Gericht" +
                            " lässt sich gut mit Prosecco zu einem Gruß aus der Küche kombinieren.",
                    ),
                ),
                durationInMin = 20,
            ),
            Dish(
                title = "Lasagne",
                ingredients = listOf(
                    OnePersonIngredient(
                        title = "Rinderhackfleisch",
                        value = 100.0f,
                        type = IngredientType.Gram,
                    ),
                    OnePersonIngredient(
                        title = "Rotwein",
                        value = 25.0f,
                        type = IngredientType.Milliliter,
                    ),
                    OnePersonIngredient(
                        title = "Butter",
                        value = 12.5f,
                        type = IngredientType.Gram,
                    ),
                    OnePersonIngredient(
                        title = "Olivenöl",
                        value = 12.5f,
                        type = IngredientType.Milliliter,
                    ),
                    OnePersonIngredient(
                        title = "Karotten",
                        value = 0.5f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Zwiebeln",
                        value = 0.5f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Selerie Staude",
                        value = 0.25f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Knoblauchzehe",
                        value = 0.25f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Passierte Tomaten",
                        value = 125.0f,
                        type = IngredientType.Milliliter,
                    ),
                    OnePersonIngredient(
                        title = "Mehl",
                        value = 10.0f,
                        type = IngredientType.Gram,
                    ),
                    OnePersonIngredient(
                        title = "Milch",
                        value = 50.0f,
                        type = IngredientType.Milliliter,
                    ),
                    OnePersonIngredient(
                        title = "Lasagneplatten",
                        value = 3.0f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Mozzarella",
                        value = 50f,
                        type = IngredientType.Gram,
                    ),
                    OnePersonIngredient(
                        title = "Salz",
                        value = 1.0f,
                        type = IngredientType.Skosh,
                    ),
                    OnePersonIngredient(
                        title = "Pfeffer",
                        value = 1.0f,
                        type = IngredientType.Skosh,
                    ),
                ),
                image = Res.drawable.lasagne,
                steps = listOf(
                    DishStep(
                        image = Res.drawable.schritt5,
                        title = "Sofrito",
                        stepDescription = "Für die Lasagne: Schneide zuerst Karotten, Zwiebeln" +
                            " und Selerie zu ungefähr gleich großen Würfeln. Lasse das Gemüse " +
                            "in einem guten Stück Butter und Olivenöl für eine halbe " +
                            "Stunde andünsten.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt6,
                        title = "Bolognese",
                        stepDescription = "Brate nun bei hoher Hitze das Rinderhack mit Olivenöl" +
                            " und Butter in einem großen Topf an. Dabei ist es wichtig, die" +
                            " Fleischstücke möglichst klein zu stoßen. Lösche das braun" +
                            " gebratene Fleisch mit Rotwein ab.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt7,
                        title = "Bolognese",
                        stepDescription = "Füge nun zum Hackfleisch das Gemüse, die passierten" +
                            " Tomaten und den Knoblauch hinzu. Dies muss nun 45 Minuten" +
                            " (für 1-2 Personen) bzw. 1-2 Stunden (3-6 Personen) bei " +
                            "geringer Temperatur einkochen. Nehme den Topf bei gewünschter " +
                            "Cremigkeit vom Herd. Mit Pfeffer und Salz abschmecken.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt8,
                        title = "Bechamelsoße",
                        stepDescription = "Heize für die Lasagne nun den Ofen auf 180°C vor. " +
                            "Für die Bechamelsoße: Schmelze die Butter in" +
                            " einem Topf an und füge zu gleichen Teilen der Butter das" +
                            " Mehl hinzu. Rühre mit dem Schneebesen die Mehlschwitze" +
                            " zu einer leicht festen Masse und " +
                            "lasse diese eine leichte Bräune annehmen.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt9,
                        title = "Bechamelsoße",
                        stepDescription = "Schütte nun schrittweise Milch in die Mehlschwitze. " +
                            "Wird die Soße fest, füge erneut Milch hinzu. Wiederhole diesen" +
                            " Schritt bis eine cremige Soße entsteht. Mit Salz, Pfeffer und " +
                            "evtl. Muskat abschmecken.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt10,
                        title = "Lasagne einschichten",
                        stepDescription = "Reibe den Bräter nun mit Butter ein. " +
                            "Verteile die Zutaten in Schichten.\n1. Schicht: Verteile " +
                            "Hackfleisch am Boden.\n2.Schicht: Verteile Bechamelsoße" +
                            "\n3.Schicht: Verteile die getrockneten Lasagneplatten." +
                            "\n4.Schicht: Eine weitere Schicht Hackfleisch.\n5.Schicht: " +
                            "Eine weitere Schicht Lasagneplatten.\n6.Schicht: " +
                            "Verteile den zerzupften Mozzarella.\n7.Schicht: Verteile " +
                            "den Rest der Bechamelsoße.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt11,
                        title = "Lasagne backen",
                        stepDescription = "Schiebe nun die Lasagne in den vorgeheizten" +
                            " Backofen bei 180°C. Die Lasagne braucht ca. 45 Minuten. " +
                            "Guten Appetit:)",
                    ),
                ),
                durationInMin = 100,
            ),
            Dish(
                title = "Flammbierte Bananen",
                ingredients = listOf(
                    OnePersonIngredient(
                        title = "Bananen",
                        value = 1.0f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
                        title = "Zucker",
                        value = 10.0f,
                        type = IngredientType.Gram,
                    ),
                    OnePersonIngredient(
                        title = "Zimt",
                        value = 1.0f,
                        type = IngredientType.Skosh,
                    ),
                    OnePersonIngredient(
                        title = "Butter",
                        value = 10.0f,
                        type = IngredientType.Gram,
                    ),
                    OnePersonIngredient(
                        title = "Rum",
                        value = 20.0f,
                        type = IngredientType.Milliliter,
                    ),
                ),
                image = Res.drawable.flambananen,
                steps = listOf(
                    DishStep(
                        image = Res.drawable.schritt12,
                        title = "Bananen anbraten",
                        stepDescription = "Für die flammbierten Bananen Butter mit " +
                            "Zucker und Zimt in einer Pfanne erhitzen. Rühre das Ganze " +
                            "bis es zu einem Sirup geschmolzen ist. Füge nun die längs- " +
                            "und querhalbierten Bananen hinzu und erhitze sie. Begieße die " +
                            "Bananen mit dem Sirup aus der Pfanne.",
                    ),
                    DishStep(
                        image = Res.drawable.schritt13,
                        title = "Banane flammbieren",
                        stepDescription = "Gieße nun den Rum über die Bananen und entzünde sie" +
                            " mit einen Streichholz. Serviere alsbald der Rum sich " +
                            "verflüchtigt hat, die Bananen auf dem Teller zusammen " +
                            "mit Vanilleeis an.",
                    ),
                ),
                durationInMin = 20,
            ),
        )

    override fun getRecipe(title: String): Dish? {
        return recipes.firstOrNull { it.title == title }
    }

    override fun getAllRecipes(): List<Dish> {
        return recipes
    }
}
