package pricewatcher.console;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}
	public void run() {
		Item item = new Item();
		UI ui = new UI();
		ui.showWelcome();
		while(true) {	
			ui.showItem(item);
			UI.Selection sel = UI.readSelection();
			for(UI.Selection s:UI.Selection.values()) {
				if(sel == s) {
					s.handler.handle(item);
					sel=null;	
				}	
			}
		}
	}
}

