package com.codepath.android.booksearch.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codepath.android.booksearch.R.drawable
import com.codepath.android.booksearch.R.id
import com.codepath.android.booksearch.R.layout
import com.codepath.android.booksearch.adapters.BookAdapter.AdapterViewHolder
import com.codepath.android.booksearch.models.Book
import java.util.ArrayList

class BookAdapter(context: Context, aBooks: ArrayList<Book>) : Adapter<AdapterViewHolder>() {
    private val mBooks: List<Book>

    // Easy access to the context object in the recyclerview
    private val context: Context

    // Define listener member variable
    private var listener: OnItemClickListener? = null

    // Define the listener interface
    interface OnItemClickListener {
        fun onItemClick(itemView: View?, position: Int)
    }

    // Define the method that allows the parent activity or fragment to define the listener
    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    // View lookup cache
    inner class AdapterViewHolder(itemView: View, clickListener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        var ivCover: ImageView = itemView.findViewById<View>(id.ivBookCover) as ImageView
        var tvTitle: TextView = itemView.findViewById<View>(id.tvTitle) as TextView
        var tvAuthor: TextView = itemView.findViewById<View>(id.tvAuthor) as TextView

        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            itemView.setOnClickListener { clickListener?.onItemClick(itemView, adapterPosition) }
        }
    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val bookView = inflater.inflate(layout.item_book, parent, false)

        // Return a new holder instance
        return AdapterViewHolder(bookView, listener)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: AdapterViewHolder, position: Int) {
        // Get the data model based on position
        val book = mBooks[position]

        // Populate data into the template view using the data object
        viewHolder.tvTitle.text = book.title
        viewHolder.tvAuthor.text = book.author
        Glide.with(context)
            .load(Uri.parse(book.coverUrl))
            .apply(RequestOptions()
                .placeholder(drawable.ic_nocover))
            .into(viewHolder.ivCover)
        // Return the completed view to render on screen
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mBooks.size
    }

    init {
        mBooks = aBooks
        this.context = context
    }
}