package com.codepath.android.booksearch.activities

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.codepath.android.booksearch.R
import com.codepath.android.booksearch.R.id
import com.codepath.android.booksearch.R.layout

class BookDetailActivity : AppCompatActivity() {
    private var ivBookCover: ImageView? = null
    private var tvTitle: TextView? = null
    private var tvAuthor: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_book_detail)
        // Fetch views
        ivBookCover = findViewById<View>(id.ivBookCover) as ImageView
        tvTitle = findViewById<View>(id.tvTitle) as TextView
        tvAuthor = findViewById<View>(id.tvAuthor) as TextView

        // Extract book object from intent extras

        // Use book object to populate data into views
        // Checkpoint #5
        // Reuse the Toolbar previously used in the detailed activity by referring to this guide
        // Follow using a Toolbar guide to set the Toolbar as the ActionBar.
        // Change activity title to reflect the book title by referring to the Configuring The ActionBar guide.
        // (Bonus) Get additional book information like publisher and publish_year from the Books API and display in details view.

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_book_detail, menu)
        // Checkpoint #6
        // Add Share Intent
        // see http://guides.codepath.org/android/Sharing-Content-with-Intents#shareactionprovider
        // (Bonus) Share book title and cover image using the same intent.

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}