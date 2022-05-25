# Web App Restful API System Design
Index:

* [High Level Design](#1-high-level-design)
* [Web App UI](#2-web-app-ui)
* [Data Model](#3-data-model)
* [Restful API](#4-restful-api)
* [Web Server](#5-web-server)
* [Assumptions](#assumptions)

---
# Assumptions
* The user must be logged in to use the note app
    * login is required for the user to view their saved notes
    * login is required for the user to save a new note
* The web app maintains a user session

---
## 1. High Level Design

---
## 2. Web App UI

---
## 3. Data Model
When the web app is first called with a ```GET``` then an array of the logged in users notes is returned. This array is comprised of a way to identify the note, its title and the first n characters. These details can be used to inform the [Web App UI](#2-web-app-ui) and populate the page for the user. 
For example for the collection of notes:

```json
{
    "user_notes":[
        {"title" : "Tale of 2 cities",
        "note_id" : "UNIQUE_ID_OF_NOTE",
        "first_chars" : "It was the best"},
        {"title" : "Food For Mars",
        "note_id" : "UNIQUE_ID_OF_NOTE",
        "first_chars" : "Potatoes are more"},
        {"title" : "10 Reasons you should hire me",
        "note_id" : "UNIQUE_ID_OF_NOTE",
        "first_chars" : "1. Could do worse"},
    ]
}
```

When a user clicks on a note then another ```GET``` request can be sent with the note_id as the query parameter which will then return the specific note. The information returned would be comprised of:
* the notes id so that a basic bit of validation can be done client side.
* an extras field which can contain data such as the notes colour, if its stared, a creation data and a modified date
* The notes contents.

The note should be renderable with just the note_id and the note contents, everything in the extras field should be treated as optional

For example for each note:

```json
{
    "note_id" : "UNIQUE_ID_OF_NOTE",
    "extras" :
        { "stared" : "false",
          "paper_colour" : "yellow",
          "created" : "01-01-1970",
          "last_modified" : "25-05-2022" } ,
    "note_contents" : "The long ramblings of the notes maker go in here" 
}
```

---
## 4. Restful API
The [assumptions](#assumptions) are that the user is logged in to view and change the notes, following along with this I assume that there is a token being created and passed around for the user which can be used instead of putting any user details in the url, json body or data model.
### URLs
Utilising the [verbs](#verbs) it should be possible to use a single URL to perform the retrieval, addition and deletion of a users notes. Something simple like:
``` https://feefoo.notes.app/V{apiVersion}/notes?={query_paramiters}``

Where the ```apiVersion``` is the version of the api and ```query_parameters``` would be the unique id of a specific note.


### Verbs
#### POST
```POST``` would be used for the creation of a new note
#### GET
When a user first logs in the app should perform a ```GET``` against the [URL](./index.md#L41) to retrieve a list of the logged in users notes which can then be used to populate the UI with a list of the notes and their titles. When a user clicks on a specific note another ```GET``` would be performed with the 
#### DELETE


---
## 5. Web Server