package net.formula97.webapps

import net.formula97.webapps.pages.HomePage
import org.apache.wicket.util.tester.WicketTester
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

/**
 * Simple test using the WicketTester
 */
class TestHomePage {
    private var tester: WicketTester? = null

    @Before
    fun setUp() {
        tester = WicketTester(WicketApplication())
    }

    @Ignore
    @Test
    fun homepageRendersSuccessfully() {
        //start and render the test page
        tester!!.startPage(HomePage::class.java)

        //assert rendered page class
        tester!!.assertRenderedPage(HomePage::class.java)
    }
}
