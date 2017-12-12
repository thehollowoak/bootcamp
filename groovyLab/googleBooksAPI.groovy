import groovy.json.JsonSlurper

def googleBooks (String title) {
    def urlTitle = title.replaceAll(' ', '%20')
    def url = new URL("https://www.googleapis.com/books/v1/volumes?q=${urlTitle}")
    def books = new JsonSlurper().parseText(url.text)

    if (books.items[0].volumeInfo.title == title) {
        return """
        Authors: ${books.items[0].volumeInfo.authors}
        ISBN#: ${books.items[0].volumeInfo.industryIdentifiers.identifier}
        Summary: ${books.items[0].volumeInfo.description}"""
    }
    else {
        return "Title not found"
    }
}

def title = this.args[0]
println googleBooks(title)