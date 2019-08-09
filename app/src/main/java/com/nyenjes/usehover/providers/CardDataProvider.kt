package com.nyenjes.usehover.providers

import com.nyenjes.usehover.models.Card


class CardDataProvider {
    companion object {
            fun getAllCards(): ArrayList<Card> {

                var cards: ArrayList<Card> = ArrayList()

                val carrierCard = Card("Carrier Airtime", "Buy airtime from Safaricom or airtel")
                val bankCard = Card("Bank Airtime", "Buy airtime from a bank you bank with")

                cards.add(carrierCard)
                cards.add(bankCard)

                return cards
            }
    }

}
