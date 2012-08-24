package net.shafranov.portlets.achievement.model;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.apache.wicket.RequestContext;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.portlet.PortletRequestContext;

/**
 * Wicket model for reading from and writing to portlet's preferences. Reading
 * and writing are doing by predefined key.
 * 
 * @author Artem Shafranov
 */
public class PortletPreferenceModel extends Model<String> {

    private static final long serialVersionUID = 7765602991135133312L;

    /** Key of portlet's preference for reading and writing */
    private String preferenceKey;

    /**
     * String model that returns value to use if preference with preferenceKey
     * doesn't exist
     */
    private IModel<String> defaultValueModel;

    /**
     * @param preferenceKey
     * @param defaultValue
     */
    public PortletPreferenceModel(String preferenceKey, IModel<String> defaultValueModel) {
        if (preferenceKey == null) {
            throw new IllegalArgumentException("Portlet's preference key can't be null");
        }

        this.preferenceKey = preferenceKey;
        this.defaultValueModel = defaultValueModel != null ? defaultValueModel : new Model<String>();
    }

    @Override
    public String getObject() {
        return getPortletPreferences().getValue(this.preferenceKey, this.defaultValueModel.getObject());
    }

    @Override
    public void setObject(String value) {
        try {
            getPortletPreferences().setValue(this.preferenceKey, value);
            getPortletPreferences().store();
        } catch (PortletException e) {
            throw new RuntimeException("Error while saving portlet preference's value", e);
        } catch (IOException e) {
            throw new RuntimeException("Error while saving portlet preference's value", e);
        }
    }

    /**
     * @return portlet preferences' store
     */
    private PortletPreferences getPortletPreferences() {
        final PortletRequestContext prc = (PortletRequestContext) RequestContext.get();
        return prc.getPortletRequest().getPreferences();
    }
}
