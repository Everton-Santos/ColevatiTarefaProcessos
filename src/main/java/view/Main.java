package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {

		RedesController redesController = new RedesController();
		
//		String redes = "Windows";
//		redesController.ip(redes);
		
		String redes = "Windows";
		redesController.ping(redes);

	}

}
