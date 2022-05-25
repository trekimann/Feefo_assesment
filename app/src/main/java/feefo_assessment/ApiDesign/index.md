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

**For the purpose of this assessment I will assume a mobile first design.**

---
## 1. High Level Design

---
## 2. Web App UI
As already stated, I am assuming a mobile first design. The [draw.io](https://app.diagrams.net/) files are included however png's are embedded below:

![App Wireframe](/app/src/main/java/feefo_assessment/ApiDesign/resources/images/wire_frame.png)

---
## 3. Data Model

---
## 4. Restful API
The [assumptions](#assumptions) are that the user is logged in to view and change the notes, following along with this I assume that there is a token being created and passed around for the user which can be used instead of putting any user details in the url, json body or data model.

When the web app is first called with a ```GET``` then an array of the logged in users notes is returned. This array is comprised of a way to identify the note, its title and the first n characters. These details can be used to inform the [Web App UI](#2-web-app-ui) and populate the page for the user. 
For example for the collection of notes:

```json
{
    "user_notes":[
        {
            "note_id" : "UNIQUE_ID_OF_NOTE",
            "title" : "Tale of 2 cities",
            "first_chars" : "It was the best"
        },
        {
            "note_id" : "UNIQUE_ID_OF_NOTE",
            "title" : "Food For Mars",
            "first_chars" : "Potatoes are great"
        },
        {
            "note_id" : "UNIQUE_ID_OF_NOTE",
            "title" : "10 Reasons you should hire me",
            "first_chars" : "1. Could do worse"
        },
    ]
}
```

When a user clicks on a note then another ```GET``` request can be sent with the note_id as the query parameter which will then return the specific note. The information returned would be comprised of:
* the notes id so that a basic bit of validation can be done client side.
* an extras field which can contain data such as the notes colour, if its stared, a creation data and a modified date
* The notes contents.

The note should be renderable with just the note_id and the note contents, everything in the extras field should be treated as optional.

For example for each note:

```json
{
    "note_id" : "UNIQUE_ID_OF_NOTE",
    "extras" :
        { "stared" : "false",
          "paper_colour" : "yellow",
          "created" : "01-01-1970",
          "last_modified" : "25-05-2022",
          "deleted" : "false" } ,
    "note_contents" : "The long ramblings of the notes maker go in here" 
}
```

### URLs
Utilising the [verbs](#verbs) it should be possible to use a single URL to perform the retrieval, addition and deletion of a users notes. Something simple like:
```https://feefoo.notes.app/V{apiVersion}/notes```

Where the ```apiVersion``` is the version of the api.

For modifying a note, the url would be amended slightly to include the notes id as a parameter:
```https://feefoo.notes.app/V{apiVersion}/notes/{node_id}```
This would be for updating the note and deleting it.

### Verbs
#### POST
```POST``` would be used for the creation of a new note.

#### PATCH
```PATCH``` Would be used for updating a notes contents or extras. This would potentially allow for lower bandwidth than a ```PUT``` or ```POST```.
#### GET
When a user first logs in the app should perform a ```GET``` against the [URL](#urls) to retrieve a list of the logged in users notes which can then be used to populate the UI with a list of the notes and their titles. When a user clicks on a specific note another ```GET``` would be performed with the notes id as a parameter of the URL.

---
## 5. Web Server