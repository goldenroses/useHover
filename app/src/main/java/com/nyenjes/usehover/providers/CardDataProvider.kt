package com.nyenjes.usehover.providers

import com.nyenjes.usehover.models.Card


class CardDataProvider {
    companion object {
        fun getSafaricomCards(): ArrayList<Card> {

            var cards: ArrayList<Card> = ArrayList()

            val card01 = Card("Safaricom 5 bundle", "(7MB + 7SMS)", "Ksh. 5")
            val card02 = Card("Safaricom 10 bundle", "(15MB + 15SMS)", "Ksh. 10")
            val card03 = Card("Safaricom 20 bundle", "(50MB + 50SMS)", "Ksh. 20")
            val card04 = Card("Safaricom 50 bundle", "(150MB + 150SMS)", "Ksh. 50")
            val card05 = Card("Safaricom 99 bundle", "(500MB + 500SMS)", "Ksh. 99")

            cards.add(card01)
            cards.add(card02)
            cards.add(card03)
            cards.add(card04)
            cards.add(card05)

            return cards
        }

        fun getBanksCards(): ArrayList<Card> {

            var cards: ArrayList<Card> = ArrayList()

            val card01 = Card("Safaricom 5 bundle", "(7MB + 7SMS)", "Ksh. 5")
            val card02 = Card("Safaricom 10 bundle", "(15MB + 15SMS)", "Ksh. 10")
            val card03 = Card("Safaricom 20 bundle", "(50MB + 50SMS)", "Ksh. 20")
            val card04 = Card("Safaricom 50 bundle", "(150MB + 150SMS)", "Ksh. 50")
            val card05 = Card("Safaricom 99 bundle", "(500MB + 500SMS)", "Ksh. 99")

            cards.add(card01)
            cards.add(card02)
            cards.add(card03)
            cards.add(card04)
            cards.add(card05)

            return cards
        }
    }

}