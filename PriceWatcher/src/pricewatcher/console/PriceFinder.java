/*
 * Robert Corral: Rocorral@miners.utep.edu
 * 80416750
 */
package pricewatcher.console;
import java.util.Random;

public class PriceFinder {
	/*
	 * Price Simulation in the form of a random number generator
	 * and a price change calculator that can still be used when 
	 * real web scraped quantities are being calculated.
	 */
	public static double simulatePriceChange() {
		Random c = new Random();
		double rangeMin = -3;
		double rangeMax = 3;
		return ((rangeMax-rangeMin)* c.nextDouble())-3;	
	}
	public static double calcChange(Item curItem) {
		double is = Item.price;
		double was = Item.lastPrice;
		return (is-was)/((is+was)/2)*100;			
	}
}

