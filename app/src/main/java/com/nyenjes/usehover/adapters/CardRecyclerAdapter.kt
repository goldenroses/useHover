package com.nyenjes.usehover.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.nyenjes.usehover.ConfirmCardActivity
import com.nyenjes.usehover.R
import com.nyenjes.usehover.models.Card
import com.nyenjes.usehover.providers.CardDataProvider
import com.squareup.picasso.Picasso

class CardRecyclerAdapter : RecyclerView.Adapter<CardHolder>() {
    val TAG: String = "CardRecyclerAdapter"
    var cardData: List<Card>? = ArrayList<Card>()


    init {
        cardData = CardDataProvider.getSafaricomCards()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_holder, parent, false)

        return CardHolder(itemView)    }

    override fun getItemCount(): Int {
        return cardData!!.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {

        var currentItem = cardData!![position]
        holder.cardTitle.text = currentItem.cardTitle
        holder.cardDecription.text = currentItem.cardDescription
        holder.cardPrice.text = currentItem.cardPrice

        holder.updateCurrentItems(currentItem)    }
    }


class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val cardTitle = itemView.findViewById<TextView>(R.id.cardTitle)
    val cardDecription = itemView.findViewById<TextView>(R.id.cardDescription)
    val cardPrice = itemView.findViewById<TextView>(R.id.cardPrice)
    val imageLocation = itemView.findViewById<ImageView>(R.id.cardImageView)
    var card: ArrayList<Card>? = null

    init {
        itemView.setOnClickListener {
            val pos = adapterPosition
            val card = Gson().toJson(card!![pos])
            Log.d("--","setOnClickListener: ${card}")

            val intent: Intent = Intent(itemView.context, ConfirmCardActivity::class.java)
            intent.putExtra("cardData", card)
            itemView.context.startActivity(intent)
        }
    }

    fun updateCurrentItems(currentItem: Card) {

        cardTitle.text = currentItem.cardTitle
        cardDecription.text = currentItem.cardDescription
        if(currentItem.imageUrl != null) showImage(currentItem.imageUrl!!)
        if(currentItem.imageUrl != null) {
            Picasso.with(itemView.context).load(currentItem.imageUrl).into(imageLocation)
        }
    }

    fun showImage(url: String) {

        if(url.isEmpty() == false) {
            Picasso.with(itemView.context).load(url).resize(144, 144).centerCrop().into(imageLocation)
        }
    }

}
