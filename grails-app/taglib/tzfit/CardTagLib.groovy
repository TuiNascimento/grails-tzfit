package tzfit

class CardTagLib {

    static namespace = "card"

    def card = { attrs ->
        out << g.render(template: "/card/card", model: [
                title    : attrs.title,
                text     : attrs.text,
                smallText: attrs.smallText,
                imageSrc : attrs.imageSrc
        ])
    }

    def horizontalWithImage = { attrs ->
        out << g.render(template: "/card/horizontalWithImage", model: [
                title    : attrs.title,
                text     : attrs.text,
                smallText: attrs.smallText,
                imageSrc : attrs.imageSrc
        ])
    }

}
