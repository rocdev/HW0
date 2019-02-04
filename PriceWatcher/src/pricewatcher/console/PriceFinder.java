package pricewatcher.console;
import java.util.Random;

public class PriceFinder {

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

