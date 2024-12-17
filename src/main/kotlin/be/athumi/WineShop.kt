package be.athumi

class WineShop(private val items: List<Wine>) {

    private val strategies: Map<String, PricingStrategy> = mapOf(
        "Standard Wine" to StandardWineStrategy(),
        "Another Standard Wine" to StandardWineStrategy(),
        "Bourdeaux Conservato" to ConservatoWineStrategy(),
        "Bourgogne Conservato" to ConservatoWineStrategy(),
        "Wine brewed by Alexander the Great" to AlexandersWineStrategy(),
        "Event Wine" to EventWineStrategy(),
        "Eco Brilliant Wine" to EcoWineStrategy()
    )

    fun next() {
        for (wine in items) {
            val strategy = strategies[wine.name] ?: StandardWineStrategy()
            strategy.updatePrice(wine)
        }
    }
}
