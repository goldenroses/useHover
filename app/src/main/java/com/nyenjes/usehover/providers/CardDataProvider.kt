package com.nyenjes.usehover.providers

import com.nyenjes.usehover.R
import com.nyenjes.usehover.models.Card


class CardDataProvider {
    companion object {
        fun getBanksCards(): ArrayList<Card> {

            var cards: ArrayList<Card> = ArrayList()

            val card01 = Card("NIC Bank", "Buy airtime from NIC bank", R.drawable.nic_bank)
            val card02 = Card("Coop Bank", "Airtime pirchase from Coop Bank", R.drawable.coop_bank)

            cards.add(card01)
            cards.add(card02)

            return cards
        }

            fun getAllCards(): ArrayList<Card> {

                var cards: ArrayList<Card> = ArrayList()

                val carrierCard = Card("Buy airtime from Carrier", "Buy airtime from Safaricom or airtel", R.drawable.safaricom_logo)
                val bankCard = Card("Buy airtime from Bank", "Buy airtime from a bank you bank with", R.drawable.bank)

                cards.add(carrierCard)
                cards.add(bankCard)

                return cards
            }
    }

}
