package com.codepath.android.booksearch.models.converters;

import android.text.TextUtils;

import com.codepath.android.booksearch.models.Book;
import com.codepath.android.booksearch.models.remote.BookQueryResponse;

import java.util.ArrayList;
import java.util.List;

public class BookConverter {
    public static List<Book> getBooks(BookQueryResponse response) {
        List<Book> books = new ArrayList<>();

        List<BookQueryResponse.DocsBean> docs = response.getDocs();
        for (BookQueryResponse.DocsBean doc : docs) {
            String opentLibraryId = doc.getCover_edition_key();

            // we need to fetch openLibraryId, title and author
            // from the query response

            if (TextUtils.isEmpty(opentLibraryId)) {
                List<String> ids = doc.getEdition_key();

                if (ids != null && !ids.isEmpty())
                    opentLibraryId = ids.get(0);

            }

            String titleSuggest = doc.getTitle_suggest();
            String title = TextUtils.isEmpty(titleSuggest) ? "" : titleSuggest;

            List<String> authorNames = doc.getAuthor_name();
            String authors = TextUtils.join(", ", authorNames);

            Book book = new Book(opentLibraryId, title, authors);
            books.add(book);
        }

        return books;
    }
}
