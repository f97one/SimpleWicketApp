package net.formula97.webapps.pages

import org.apache.wicket.request.mapper.parameter.PageParameters
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage

class HomePage(parameters: PageParameters) : WebPage(parameters) {

    init {

        add(Label("version", application.frameworkSettings.version))

        // TODO Add your page's components here

    }

    companion object {

        private val serialVersionUID = -1486188871787945417L
    }
}
