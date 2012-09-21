package net.shafranov.portlets.achievement.pages;

import net.shafranov.portlets.LiferayPortletPage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.StringResourceModel;

/**
 * Page for HELP mode of Achievement portlet.
 * 
 * @author Artem Shafranov
 */
public class AchievementHelpPage extends LiferayPortletPage {

    /**
     * Constructor
     */
    public AchievementHelpPage() {
        add(new Label("text", new StringResourceModel("help.text", null)));
    }
}
