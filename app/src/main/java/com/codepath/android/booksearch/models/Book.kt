package com.codepath.android.booksearch.models

import android.text.TextUtils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class Book(
    var openLibraryId: String? = null,
    var author: String? = null,
    var title: String? = null,
    // Get book cover from covers API
    val coverUrl: String = "https://covers.openlibrary.org/b/olid/$openLibraryId-L.jpg?default=false"
) {

    companion object {
        // Returns a Book given the expected JSON
        private fun fromJson(jsonObject: JSONObject): Book? {
            val book = Book()
            try {
                // Deserialize json into object fields
                // Check if a cover edition is available
                if (jsonObject.has("cover_edition_key")) {
                    book.openLibraryId = jsonObject.getString("cover_edition_key")
                } else if (jsonObject.has("edition_key")) {
                    val ids = jsonObject.getJSONArray("edition_key")
                    book.openLibraryId = ids.getString(0)
                }
                book.title = if (jsonObject.has("title_suggest")) jsonObject.getString("title_suggest") else ""
                book.author = getAuthor(jsonObject)
            } catch (e: JSONException) {
                e.printStackTrace()
                return null
            }
            // Return new object
            return book
        }

        // Return comma separated author list when there is more than one author
        private fun getAuthor(jsonObject: JSONObject): String {
            return try {
                val authors = jsonObject.getJSONArray("author_name")
                val numAuthors = authors.length()
                val authorStrings = arrayOfNulls<String>(numAuthors)
                for (i in 0 until numAuthors) {
                    authorStrings[i] = authors.getString(i)
                }
                TextUtils.join(", ", authorStrings)
            } catch (e: JSONException) {
                ""
            }
        }

        // Decodes array of book json results into business model objects
        fun fromJson(jsonArray: JSONArray): ArrayList<Book> {
            val books = ArrayList<Book>(jsonArray.length())
            // Process each result in json array, decode and convert to business
            // object
            for (i in 0 until jsonArray.length()) {
                var bookJson: JSONObject = try {
                    jsonArray.getJSONObject(i)
                } catch (e: Exception) {
                    e.printStackTrace()
                    continue
                }
                val book = fromJson(bookJson)
                if (book != null) {
                    books.add(book)
                }
            }
            return books
        }
    }
}