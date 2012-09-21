package net.shafranov.portlets.achievement.service;

import java.util.List;

/**
 * Interface for class to load names of prize items from somewhere
 * 
 * @author Artem Shafranov
 */
public interface IPrizeService {

	/**
	 * Load the list of prize items from somewhere
	 * 
	 * @return list of prize items
	 */
	List<String> loadPrizes();
}