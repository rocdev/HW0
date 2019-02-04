package pricewatcher.console;

public class Item {
	public static String name = "";
	public static String url = "";
	public static double price = 0.0;
	public static double change = 0.0;
	public static String added = "";
	public static double lastPrice = 0.0;
	public static double initPrice = 0.0;
	
	public Item(){
		name = "LED monitor";
		url = "https://www.bestbuy.com/site/samsung-ue590-series-28-led-4k-uhd-monitor-black/5484022.p?skuId=5484022";
		price = 61.13;
		change = 0.00;
		added = "08/25/2018";
		lastPrice = price;
		initPrice = price;
	}	
}
