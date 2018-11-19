# Book Search App

Android app that leverages the [OpenLibrary API](https://openlibrary.org/developers/api) to search books and display cover images. This app is to be used as the base app for adding suggested extensions.

![Imgur](http://i.imgur.com/NJmF42Yl.png)

## Overview

I've forked this repository in order to demonstrate refactoring of legacy code base into the latest used libraries + architectural patterns, right now.

I'll be adding more wiki as I integrate the Suggested Extensions and Milestones

The app does the following:

1. Fetch the books from the [OpenLibrary Search API](https://openlibrary.org/dev/docs/api/search) in JSON format
2. Deserialize the JSON data for each of the books into `Book` objects
3. Build an array of `Book` objects and notify the adapter to display the new data. 
4. Define a view holder so the adapter can render each book model. 

To achieve this, there are four different components in this app:

1. `BookClient` - Responsible for executing the API requests and retrieving the JSON
2. `Book` - Model object responsible for encapsulating the attributes for each individual book
3. `BookAdapter` - Responsible for mapping each `Book` to a particular view layout
4. `BookListActivity` - Responsible for fetching and deserializing the data and configuring the adapter

## Suggested Extensions

- [ ] Use SearchView to search for books with a title
- [ ] Show ProgressBar before each network request
- [ ] Add a detail view to display more information about the selected book from the list
- [ ] Use a share intent to recommend a book to friends

## Milestones
- [x] Add Retrofit
- [x] Add Data Binding
- [ ] Add RxJava
- [ ] Add Dagger
- [ ] Update to Material Design 2.0  
