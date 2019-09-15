package application;

import connection.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import logic.ClientType;

public class CarSimulatorController implements ClientType {

	@FXML
	private ImageView imageView;
	
	@FXML
	private Button right;
	@FXML
	private Button left;
	@FXML
	private Button go;
	@FXML
	private Button back;
	@FXML
	private Label speed;
	
	private int x = 30;
	private int y = 30;
	
	private Client client;
	private String command;
	
	@FXML
	public void initialize() {
		System.out.println(this.getClass());
		this.client = new Client(this);
		this.client.connect();
		imageView.setDisable(false);
		imageView.setLayoutX(x);
		imageView.setLayoutY(y);
	}
	
	@Override
	public void write(String command) {
		System.out.println("kuy");
		appendCommand(command);
	}
	
	public void appendCommand(String command) {
		System.out.println("kuy2");
		if (command == null) {
			command = "";
		} else if (command == "Right") {
			imageView.setRotate(imageView.getRotate() + 90);
			System.out.println(imageView.getRotate());
		} else if (command == "Left") {
			imageView.setRotate(imageView.getRotate() - 90);
			System.out.println(imageView.getRotate());
		} else {
			
		}	
		System.out.println(command);
	}

	// Setting the position of the image
	@FXML
	public void TurnRight() {
		imageView.setRotate(imageView.getRotate() + 90);
		System.out.println(imageView.getRotate());
		
	}
	
	@FXML
	public void TurnLeft() {
		imageView.setRotate(imageView.getRotate() - 90);
		System.out.println(imageView.getRotate());
	}
	
	@FXML
	public void GoStraight() {
		
		if(rotate() == 0 || Math.abs(rotate()) == 360) {
			x = x+1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);	
		} else if (rotate() == 90 || rotate() == 450) {
			y = y+1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);	
		} else if (rotate() == -90.0 || rotate() == -450) {
			y = y-1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);	
			System.out.println(imageView.getLayoutX());
			System.out.println(imageView.getLayoutY());
		} else if (Math.abs(rotate()) == 180 || Math.abs(rotate()) == 540) {
			x = x-1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);	
		} else if (rotate() == 270 || rotate() == 630) {
			y = y-1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);		
		} else if (rotate() == -270 || rotate() == -630) {
			y = y+1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);		
		}
	}
	
	@FXML
	public void Back() {
		if(rotate() == 0 || Math.abs(rotate()) == 360) {
			x = x-1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);	
		} else if (rotate() == 90 || rotate() == 450) {
			y = y-1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);	
		} else if (rotate() == -90.0 || rotate() == -450) {
			y = y+1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);	
			System.out.println(imageView.getLayoutX());
			System.out.println(imageView.getLayoutY());
		} else if (Math.abs(rotate()) == 180 || Math.abs(rotate()) == 540) {
			x = x+1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);	
		} else if (rotate() == 270 || rotate() == 630) {
			y = y-1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);		
		} else if (rotate() == -270 || rotate() == -630) {
			y = y+1;
			imageView.setLayoutX(x);
			imageView.setLayoutY(y);		
		}
	}
	
	public void speedUpdate() {
		
	}
	
	public double rotate() {
		return imageView.getRotate();
	}
	

}
