package net.shafranov.portlets.achievement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.StringResourceModel;

/**
 * Implementation of IPrizeService interface. It's a stub actually. An object 
 * generates small list of names of prizes on the fly and returns them.
 * 
 * @author Artem Shafranov
 */
public class PrizeServiceImpl implements IPrizeService {

	/**
	 * Generate small list of the names of prizes on the fly and return it
	 * 
	 * @return list of prize items
	 */
	public List<String> loadPrizes() {
		List<String> result = new ArrayList<String>();
		result.add(getLocalizedString("defaultValue.prize"));
		result.add(getLocalizedString("value.prize.iceCream"));
		result.add(getLocalizedString("value.prize.iPhone5"));
		result.add(getLocalizedString("value.prize.newShoes"));
		return result;
	}

	/**
	 * Return localized string for a key 
	 *
	 * @param key
	 * @return
	 */
	private String getLocalizedString(String key) {
		return new StringResourceModel(key, null).getObject();
	}
}