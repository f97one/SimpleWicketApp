package net.formula97.webapps.pages

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.request.mapper.parameter.PageParameters

class HelloPage(parameters: PageParameters) : WebPage(parameters) {

    init {

        add(Label("str", "はろー、わーるど"))
    }

    companion object {
        private const val serialVersionUID = -9161901974192841699L
    }
}
