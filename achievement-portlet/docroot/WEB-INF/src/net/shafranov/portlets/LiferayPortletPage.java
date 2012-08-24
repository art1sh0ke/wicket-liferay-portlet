package net.shafranov.portlets;

import org.apache.wicket.markup.html.WebPage;

/**
 * Common functionality for all Wicket pages that are used for processing
 * requests for different portlet's modes.
 * 
 * @author Artem Shafranov
 */
public class LiferayPortletPage extends WebPage {

    /**
     * Constructor
     */
    public LiferayPortletPage() {
        /*
         * There are two facts:<br>
         * 1) Locale in Liferay can be changed dynamically by user with help of
         * "Languages" portlet.<br>
         * 2) Wicket determines the locale of the application based on value in
         * the session.<br>
         * <br>
         * So we've got no other choices than to set locale in Wicket's session
         * with value from Request object on every portlet request to Wicket.
         */
        getSession().setLocale(getRequest().getLocale());
    }
}
