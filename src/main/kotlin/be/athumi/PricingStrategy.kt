package be.athumi

interface PricingStrategy {
    fun updatePrice(wine: Wine)
}

// Standard Wine
class StandardWineStrategy : PricingStrategy {
    override fun updatePrice(wine: Wine) {
        wine.expiresInYears--
        if (wine.price > 0) {
            wine.price -= if (wine.expiresInYears < 0) 2 else 1
        }
        wine.price = wine.price.coerceAtLeast(0)
    }
}

// Conservato Wine
class ConservatoWineStrategy : PricingStrategy {
    override fun updatePrice(wine: Wine) {
        wine.expiresInYears--
        if (wine.price < 100) {
            wine.price++
        }
        wine.price = wine.price.coerceAtMost(100)
    }
}

// Alexander's Wine
class AlexandersWineStrategy : PricingStrategy {
    override fun updatePrice(wine: Wine) {
        // No changes to price or expiresInYears
    }
}

// Event Wine
class EventWineStrategy : PricingStrategy {
    override fun updatePrice(wine: Wine) {
        wine.expiresInYears--
        if (wine.expiresInYears < 0) {
            wine.price = 0
        } else if (wine.expiresInYears <= 2) {
            wine.price += 4
        } else if (wine.expiresInYears <= 7) {
            wine.price += 2
        } else {
            wine.price++
        }
        wine.price = wine.price.coerceIn(0, 100)
    }
}

// Eco Wine
class EcoWineStrategy : PricingStrategy {
    override fun updatePrice(wine: Wine) {
        wine.expiresInYears--
        if (wine.price > 0) {
            wine.price -= if (wine.expiresInYears < 0) 4 else 2
        }
        wine.price = wine.price.coerceAtLeast(0)
    }
}

