package net.shafranov.portlets.achievement.pages;

import net.shafranov.portlets.LiferayPortletPage;
import net.shafranov.portlets.achievement.model.PortletPreferenceModel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.StringResourceModel;


/**
 * Page for VIEW mode of Achievement portlet.
 * 
 * @author Artem Shafranov
 */
public class AchievementViewPage extends LiferayPortletPage {

    public AchievementViewPage() {
        add(new Label("text", new StringResourceModel("view.text", this, null, new Object[] {
                // name of portlet's creator
                new PortletPreferenceModel("name", new StringResourceModel("defaultValue.name",
                        this, null)),
                
                // task
                new PortletPreferenceModel("task", new StringResourceModel("defaultValue.task",
                        this, null)),
                        
                // task's length
                new PortletPreferenceModel("length", new StringResourceModel("defaultValue.length",
                        this, null)),
                        
                // prize
                new PortletPreferenceModel("prize", new StringResourceModel("defaultValue.prize",
                        this, null))
        })));
    }
}