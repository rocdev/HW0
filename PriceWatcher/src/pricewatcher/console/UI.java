package pricewatcher.console;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class UI {
	public static DecimalFormat df2 = new DecimalFormat(".##");
	public static final int QUIT = -1;
	public static final int PRICE = 1;
	public static final int VIEW = 2;
	public void showWelcome() {
		System.out.println("Welcome to Price Watcher!\n");
	}
	public void showItem(Item curItem){
		System.out.println(""
		+ "Name:    "+Item.name+"\n"
		+ "URL:     "+Item.url+"\n"
		+ "Price:   $"+df2.format(Item.price)+"\n"
		+ "Change:  "+df2.format(Item.change)+ "%\n"
		+ "Added:   "+Item.added+" ("+Item.initPrice+")\n"); 
	}
	public static Selection readSelection() {
		try {
			System.out.printf("\n Enter %d (to check price), %d(to view page), or %d to quit?\n", PRICE,VIEW,QUIT);
			System.out.flush();
			Scanner input = new Scanner(System.in);
			int sel = input.nextInt(); 
			for(Selection s: Selection.values()) {
				if(sel == s.number) {
					System.out.println(" \n you selected option: "+sel+"\n");
					return s;
				}
			}
		}
		catch(InputMismatchException e2){
			System.out.println("Invalid entry!!!\n"
					+ "Try a number from the menu\n");
			return null;
		}
		System.out.println("Invalid Number!!!\n"
				+ "Please refer to options menu\n");
		return null;	
	}
	public enum Selection{
		PRICE(1, new PriceHandler()),
		VIEW(2, new ViewHandler()),
		QUIT(-1, new QuitHandler());
		public final int number;
		public final SelectionHandler handler;
	
		Selection(int number, SelectionHandler handler){
			this.number = number;
			this.handler = handler;
		}
	}
	static class SelectionHandler {
		public void handle(Item curItem) {
		}
	}
	static class PriceHandler extends SelectionHandler{
		public void handle(Item curItem) {
			System.out.println("Checking Price....\n");
			Item.lastPrice = Item.price;
			Item.price += PriceFinder.simulatePriceChange();
			Item.change = PriceFinder.calcChange(curItem);	
		}
	}
	static class ViewHandler extends SelectionHandler{
		public void handle(Item curItem) {
			System.out.println("Opening Browser please wait.....\n");
			URI url = null;
			try {
				url = new URI(Item.url);
			} catch (URISyntaxException e1) {
				System.out.println("!!!!!invalid URL!!!!!\n"
						+ "Try something else...\n");
				return;
			}
			try {
				java.awt.Desktop.getDesktop().browse(url);
			} catch (IOException e) {
				System.out.println("!!!!!invalid URL!!!!!\n"
						+ "Try something else...\n");
				return;
			}
		}
	}
	static class QuitHandler extends SelectionHandler{
		public void handle(Item curItem) {
			System.out.println("Exiting...");
			System.exit(0);
		}
	}
}
