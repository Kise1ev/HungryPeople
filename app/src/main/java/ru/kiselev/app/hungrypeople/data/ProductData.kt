package ru.kiselev.app.hungrypeople.data

import ru.kiselev.app.hungrypeople.models.Product

object ProductData {
    val productsByCategory = mapOf(
        "SOUPE" to listOf(
            Product(
                title = "French Onion Soup",
                price = "$10.99",
                description = "Classic French onion soup with caramelized onions and melted cheese."
            ),
            Product(
                title = "Tomato Bisque",
                price = "$8.99",
                description = "Creamy tomato bisque with basil garnish."
            ),
            Product(
                title = "Lobster Bisque",
                price = "$12.99",
                description = "Rich lobster bisque with chunks of lobster meat."
            ),
            Product(
                title = "Minestrone",
                price = "$9.99",
                description = "Hearty Italian minestrone soup with vegetables and pasta."
            ),
            Product(
                title = "Clam Chowder",
                price = "$11.99",
                description = "New England style clam chowder with fresh clams."
            )
        ),

        "PIZZA" to listOf(
            Product(
                title = "Margherita Pizza",
                price = "$13.99",
                description = "Traditional Italian margherita pizza with fresh mozzarella and basil."
            ),
            Product(
                title = "Pepperoni Pizza",
                price = "$12.99",
                description = "Classic pepperoni pizza with tomato sauce and mozzarella cheese."
            ),
            Product(
                title = "Vegetarian Pizza",
                price = "$11.99",
                description = "Vegetarian pizza with assorted vegetables and cheese."
            ),
            Product(
                title = "BBQ Chicken Pizza",
                price = "$14.99",
                description = "BBQ chicken pizza with tangy BBQ sauce and grilled chicken."
            ),
            Product(
                title = "Hawaiian Pizza",
                price = "$12.99",
                description = "Hawaiian pizza with pineapple, ham, and mozzarella cheese."
            )
        ),

        "PASTA" to listOf(
            Product(
                title = "Spaghetti Bolognese",
                price = "$15.99",
                description = "Spaghetti pasta with traditional Italian meat sauce."
            ),
            Product(
                title = "Fettuccine Alfredo",
                price = "$14.99",
                description = "Fettuccine pasta in a creamy Alfredo sauce with parmesan cheese."
            ),
            Product(
                title = "Penne Arrabbiata",
                price = "$12.99",
                description = "Penne pasta in a spicy Arrabbiata sauce with tomatoes and chili flakes."
            ),
            Product(
                title = "Lasagna",
                price = "$16.99",
                description = "Classic Italian lasagna with layers of pasta, meat sauce, and cheese."
            ),
            Product(
                title = "Carbonara",
                price = "$13.99",
                description = "Spaghetti carbonara with bacon, eggs, and parmesan cheese."
            )
        ),

        "DESERT" to listOf(
            Product(
                title = "Tiramisu",
                price = "$8.99",
                description = "Classic Italian tiramisu dessert with coffee-soaked ladyfingers and mascarpone cream."
            ),
            Product(
                title = "Cheesecake",
                price = "$7.99",
                description = "New York style cheesecake topped with strawberries."
            ),
            Product(
                title = "Chocolate Cake",
                price = "$9.99",
                description = "Rich chocolate cake with chocolate ganache frosting."
            ),
            Product(
                title = "Apple Pie",
                price = "$8.99",
                description = "Homemade apple pie with a flaky crust."
            ),
            Product(
                title = "Panna Cotta",
                price = "$8.99",
                description = "Vanilla panna cotta with raspberry coulis."
            )
        ),

        "WINE" to listOf(
            Product(
                title = "Cabernet Sauvignon",
                price = "$29.99",
                description = "Full-bodied Cabernet Sauvignon with rich dark fruit flavors."
            ),
            Product(
                title = "Chardonnay",
                price = "$24.99",
                description = "Buttery Chardonnay with hints of vanilla and oak."
            ),
            Product(
                title = "Merlot",
                price = "$27.99",
                description = "Smooth Merlot with plum and berry flavors."
            ),
            Product(
                title = "Pinot Noir",
                price = "$26.99",
                description = "Elegant Pinot Noir with cherry and spice notes."
            ),
            Product(
                title = "Sauvignon Blanc",
                price = "$22.99",
                description = "Crisp Sauvignon Blanc with citrus and tropical fruit flavors."
            )
        ),

        "BEER" to listOf(
            Product(
                title = "IPA",
                price = "$7.99",
                description = "India Pale Ale with hoppy and citrus flavors."
            ),
            Product(
                title = "Stout",
                price = "$6.99",
                description = "Dark and rich stout with chocolate and coffee notes."
            ),
            Product(
                title = "Pilsner",
                price = "$5.99",
                description = "Crisp and refreshing Pilsner with a balanced malt and hop profile."
            ),
            Product(
                title = "Wheat Beer",
                price = "$6.99",
                description = "Light and wheaty beer with hints of citrus and spices."
            ),
            Product(
                title = "Pale Ale",
                price = "$6.99",
                description = "American Pale Ale with a perfect balance of malt and hops."
            )
        ),

        "DRINKS" to listOf(
            Product(
                title = "Mojito",
                price = "$9.99",
                description = "Classic Mojito cocktail with fresh mint and lime."
            ),
            Product(
                title = "Old Fashioned",
                price = "$10.99",
                description = "Old Fashioned cocktail made with bourbon, sugar, and bitters."
            ),
            Product(
                title = "Moscow Mule",
                price = "$8.99",
                description = "Refreshing Moscow Mule cocktail with vodka, ginger beer, and lime."
            ),
            Product(
                title = "Gin and Tonic",
                price = "$8.99",
                description = "Classic Gin and Tonic cocktail with gin, tonic water, and lime."
            ),
            Product(
                title = "Pina Colada",
                price = "$9.99",
                description = "Tropical Pina Colada cocktail with coconut cream and pineapple juice."
            )
        )
    )
}