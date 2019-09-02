package net.formula97.webapps

import net.formula97.webapps.pages.HelloPage
import net.formula97.webapps.pages.HomePage
import net.formula97.webapps.pages.ToDoPage
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.protocol.http.WebApplication

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see net.formula97.webapps.Start.main
 */
class WicketApplication : WebApplication() {
    /**
     * @see org.apache.wicket.Application.getHomePage
     */
    override fun getHomePage(): Class<out WebPage> {
        return HomePage::class.java
    }

    /**
     * @see org.apache.wicket.Application.init
     */
    public override fun init() {
        super.init()

        // add your configuration here
        configureRouter()
    }

    private fun configureRouter() {
        mountPage("/hello", HelloPage::class.java)
        mountPage("/todo", ToDoPage::class.java)
    }
}
