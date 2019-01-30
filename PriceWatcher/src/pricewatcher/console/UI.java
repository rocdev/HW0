package pricewatcher.console;
import java.util.Scanner;
//import pricewatcher.console.Main.SelectionHandler;

public class UI {
	public static final int QUIT = -1;
	public static final int PRICE = 1;
	public static final int VIEW = 2;
	
	public static Selection readSelection() {
		while(true) {
			System.out.printf("/n/nEnter %d (to check price), %d(to view page), or %d to quit?", PRICE,VIEW,QUIT);
			System.out.flush();
			

			Scanner input = new Scanner(System.in);  // Reading from System.in
			
			int in = input.nextInt(); // Scans the next token of the input as an int.
			//once finished
			input.close();
			return Selection(in);
		}
		
	}
	public enum Selection{
		PRICE(1, new PriceHandler()),
		VIEW(2, new ViewHandler()),
		QUIT(-1, null);
		
		public final int number;
		public final SelectionHandler handler;
		
		Selection(int number, SelectionHandler handler){
			this.number = number;
			this.handler = handler;
		}
	}
	static class SelectionHandler {public void handle() {}}
	static class PriceHandler extends SelectionHandler{public void handle() {}}
	static class ViewHandler extends SelectionHandler{public void handle() {}}
	
}
