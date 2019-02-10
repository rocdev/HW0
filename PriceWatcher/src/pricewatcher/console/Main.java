/*
 * Robert Corral: Rocorral@miners.utep.edu
 * 80416750
 * Prof: Yoonsik Cheon
 * CS 3331 MW 900-1020
 * Assignment: Price Watcher HW0
 * Description: The first iteration of price 
 * watcher implemented as a Console version.
 * We are to practice a modular design of 
 * our program so that updates can be more 
 * easily maintained.
 */

package pricewatcher.console;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}
	public void run() {
		Item item = new Item();
		UI ui = new UI();
		ui.showWelcome();
		while(true) {	//loop selection menu
			ui.showItem(item);
			UI.Selection sel = UI.readSelection(); //prompt user from UI to make selection
			for(UI.Selection s:UI.Selection.values()) {
				if(sel == s) {
					s.handler.handle(item);//run operation on based on selection
					sel=null;	
				}	
			}
		}
	}
}

