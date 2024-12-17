package be.athumi

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WineShopTest {

    @Test
    fun `test standard wine price update`() {
        val wine = Wine("Standard Wine", 10, 5)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.price).isEqualTo(9)
        assertThat(wine.expiresInYears).isEqualTo(4)
    }

    @Test
    fun `test expired standard wine price update`() {
        val wine = Wine("Standard Wine", 10, -1)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.price).isEqualTo(8)
        assertThat(wine.expiresInYears).isEqualTo(-2)
    }

    @Test
    fun `test event wine price update before expiration`() {
        val wine = Wine("Event Wine", 20, 5)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.price).isEqualTo(22)
        assertThat(wine.expiresInYears).isEqualTo(4)
    }

    @Test
    fun `test eco wine price update`() {
        val wine = Wine("Eco Brilliant Wine", 10, 3)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.price).isEqualTo(8)
        assertThat(wine.expiresInYears).isEqualTo(2)
    }

    @Test
    fun `test Alexander's wine price remains unchanged`() {
        val wine = Wine("Wine brewed by Alexander the Great", 150, 0)
        val shop = WineShop(listOf(wine))

        shop.next()

        assertThat(wine.price).isEqualTo(150)
        assertThat(wine.expiresInYears).isEqualTo(0)
    }
}
