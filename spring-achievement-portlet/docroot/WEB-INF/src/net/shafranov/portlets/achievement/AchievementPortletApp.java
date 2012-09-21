package net.shafranov.portlets.achievement;

import javax.portlet.PortletMode;

import net.shafranov.portlets.achievement.pages.AchievementEditPage;
import net.shafranov.portlets.achievement.pages.AchievementHelpPage;
import net.shafranov.portlets.achievement.pages.AchievementViewPage;

import org.apache.wicket.Page;
import org.apache.wicket.RequestContext;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.portlet.PortletRequestContext;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;


/**
 * Portlet application for displaying an achievement.
 * 
 * @author Artem Shafranov
 */
public class AchievementPortletApp extends WebApplication {

    @Override
    protected void init() {
        // initialize Spring
        addComponentInstantiationListener(new SpringComponentInjector(this));

        // pages for processing different portlet's modes
        mountBookmarkablePage("/view", AchievementViewPage.class);
        mountBookmarkablePage("/edit", AchievementEditPage.class);
        mountBookmarkablePage("/help", AchievementHelpPage.class);
    }

    @Override
    public Class<? extends Page> getHomePage() {
        /*
         * As far as I know this method is never called if different portlet's
         * modes are processed by different Wicket's pages. But just in case we
         * should provide implementation that returns a page class based on
         * current mode of the portlet.
         */
        PortletRequestContext prc = (PortletRequestContext) RequestContext.get();
        if (prc.getPortletRequest().getPortletMode() == PortletMode.EDIT) {
            return AchievementEditPage.class;
        } else if (prc.getPortletRequest().getPortletMode() == PortletMode.HELP) {
            return AchievementHelpPage.class;
        } else {
            return AchievementViewPage.class;
        }
    }
}
