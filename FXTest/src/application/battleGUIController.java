package application;

import entities.Player;
import entities.Enemy;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import entities.Battle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class battleGUIController implements Initializable{
	
	Player protagonist = new Player("Wojak", 5, 1, 10);
	Enemy enemy = new Enemy("Gigachad", 5, 1, 10);

    @FXML
    private TextArea battleText;
    
    @FXML
    private ImageView portrait;

    @FXML
    private void initialize() {
        // Called automatically after FXML is loaded
        battleText.appendText("Welcome to the battle!\n");
        
        
        
    }
    
    // gigachad.png is currently hardcoded into battleGUITest.fxml
    /* TODO
     * Pass battle text into TextArea. Update battle text as the battle progresses. Implement buttons and menus.
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//File enemyPortrait = new File("/application/gigachad.jpg");
      //  Image gigachad = new Image(enemyPortrait.toURI().toString());
        //portrait.setImage(gigachad);
	}
}
