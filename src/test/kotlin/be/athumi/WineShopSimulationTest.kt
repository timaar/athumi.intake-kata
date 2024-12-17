package be.athumi

import org.junit.jupiter.api.Test

class WineShopSimulationTest {

    @Test
    fun `simulate wine shop changes over 3 years`() {
        // Initial inventory "3 years ago"
        val wines = listOf(
            Wine("Standard Wine", 20, 10),
            Wine("Bourdeaux Conservato", 0, 2),
            Wine("Another Standard Wine", 7, 5),
            Wine("Wine brewed by Alexander the Great", 150, 0),
            Wine("Wine brewed by Alexander the Great", 80, 10),
            Wine("Event Wine", 20, 15),
            Wine("Event Wine", 49, 10),
            Wine("Event Wine", 49, 5),
            Wine("Eco Brilliant Wine", 6, 3)
        )

        val wineShop = WineShop(wines)

        // Print initial state (3 years ago)
        println("3 years ago:")
        printWines(wines)

        // Simulate 3 years of updates
        repeat(3) { wineShop.next() }

        // Print final state (today)
        println("\n\ntoday:")
        printWines(wines)
    }

    private fun printWines(wines: List<Wine>) {
        println("\nwine, price, expiresInYears")
        wines.forEach { println(it) }
    }
}
