package com.nyenjes.usehover.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nyenjes.usehover.BankOfferPageActivity
import com.nyenjes.usehover.SafaricomOfferPageActivity
import com.nyenjes.usehover.fragments.BankListActivity
import com.nyenjes.usehover.models.Card
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_holder.view.*


class CardRecyclerAdapter(data: ArrayList<Card>?, var context: Context) : RecyclerView.Adapter<CardHolder>() {
    var cardData: List<Card>? = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(com.nyenjes.usehover.R.layout.card_holder, parent, false)
        return CardHolder(itemView)    }

    override fun getItemCount(): Int {
        return cardData!!.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {

        var currentItem = cardData!![position]
        holder.cardTitle.text = currentItem.cardTitle
        holder.cardDecription.text = currentItem.cardDescription

        //Set drawable
        val name = "your_drawable"
        val id = context.getResources().getIdentifier(name, "drawable", context.getPackageName())
        val drawable = context.getResources().getDrawable(id, null)
        holder.imageLocation.setImageDrawable(drawable)

        holder.updateCurrentItems(currentItem)
    }
}

class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val cardTitle = itemView.findViewById<TextView>(com.nyenjes.usehover.R.id.cardTitle)
    val cardDecription = itemView.findViewById<TextView>(com.nyenjes.usehover.R.id.cardDescription)
    val imageLocation = itemView.findViewById<ImageView>(com.nyenjes.usehover.R.id.cardImageView)

    init {
        itemView.setOnClickListener {
            Log.d("--","setOnClickListener: ${cardTitle.text}")
            if (it.cardTitle.text.equals("Buy airtime from Carrier")) {
                val intent: Intent = Intent(itemView.context, SafaricomOfferPageActivity::class.java)
                itemView.context.startActivity(intent)
            } else if (it.cardTitle.text.equals("NIC Bank")) {
                    val intent: Intent = Intent(itemView.context, BankOfferPageActivity::class.java)
                    itemView.context.startActivity(intent)
            }
            else {
                val intent: Intent = Intent(itemView.context, BankListActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }

    fun updateCurrentItems(currentItem: Card) {
        cardTitle.text = currentItem.cardTitle
        cardDecription.text = currentItem.cardDescription
        if(currentItem.imageUrl != null) {
            Picasso.with(itemView.context).load(currentItem.imageUrl!!).fit().into(imageLocation)

        }
    }
}
