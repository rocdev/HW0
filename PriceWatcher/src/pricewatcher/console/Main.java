package pricewatcher.console;

import pricewatcher.console.UI.SelectionHandler;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}
	public static void run() {
//		int selection = UI.readSelection();
//				while( selection != -1){
//					switch(selection) {
//					case 1: break;
//					case 2: break;
//					}
//					selection = UI.readSelection();
//				}
//	}
		UI.Selection sel = UI.readSelection();
		while(sel != UI.Selection.QUIT) {
			for(UI.Selection s:UI.Selection.values()) {
				if(sel == s) {
					s.handler.handle();
					break;
				}
			}
		}
	}
}

