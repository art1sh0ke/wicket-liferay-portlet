package net.shafranov.portlets.achievement.pages;

import java.util.List;

import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import net.shafranov.portlets.LiferayPortletPage;
import net.shafranov.portlets.achievement.model.PortletPreferenceModel;
import net.shafranov.portlets.achievement.service.IPrizeService;

import org.apache.wicket.RequestContext;
import org.apache.wicket.extensions.ajax.markup.html.AjaxEditableLabel;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.protocol.http.portlet.PortletRequestContext;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Page for EDIT mode of Achievement portlet.
 * 
 * @author Artem Shafranov
 */
public class AchievementEditPage extends LiferayPortletPage {

    /** Service to load names of prizes */
    @SpringBean
    private IPrizeService prizeService;

    /**
     * Constructor
     */
    public AchievementEditPage() {
        // edit for name of portlet's creator
        add(new AjaxEditableLabel<String>("name", 
                new PortletPreferenceModel("name", new StringResourceModel("defaultValue.name", this, null))));

        // edit for task
        add(new AjaxEditableLabel<String>("task", 
                new PortletPreferenceModel("task", new StringResourceModel("defaultValue.task", this, null))));

        // edit for taks's length
        add(new AjaxEditableLabel<String>("length", 
                new PortletPreferenceModel("length", new StringResourceModel("defaultValue.length", this, null))));

        // edit for prize
        add(new DropDownChoice<String>("prize", 
                new PortletPreferenceModel("prize", new StringResourceModel("defaultValue.prize", this, null)),
                new LoadableDetachableModel<List<String>>() {
                    
                    public List<String> load() {
                        return prizeService.loadPrizes();
                    }
                }) {

            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
        });

        // button for return to VIEW mode
        add(new Link<Void>("view_button") {

            private static final long serialVersionUID = -4476155587383963311L;

            @Override
            public void onClick() {
                // change portlet's mode to VIEW and window state to normal
                final PortletRequestContext prc = (PortletRequestContext) RequestContext.get();
                final ActionResponse response = (ActionResponse) prc.getPortletResponse();
                try {
                    response.setWindowState(WindowState.NORMAL);
                    response.setPortletMode(PortletMode.VIEW);
                } catch (PortletException e) {
                    throw new RuntimeException("Exception while changing portlet's window state and mode", e);
                }

                // go to portlet's view mode pages
                setResponsePage(AchievementViewPage.class);
            }
        });
    }
}
