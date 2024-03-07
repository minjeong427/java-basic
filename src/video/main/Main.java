package video.main;

import oop.modi.constructor.pac1.A;
import video.ui.AppUi;

import static video.ui.AppUi.inputInteger;
import static video.ui.AppUi.startScreen;

public class Main {

    public static void main(String[] args) {

        AppController controller = new AppController();

        while (true) {
            startScreen();
            int selectNumber = inputInteger(">>> ");
            controller.chooseSystem(selectNumber);
        }

    }
}
