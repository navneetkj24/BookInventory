import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage; 

public class App extends Application {  
    public void start(Stage primaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Book Inventory");    
        primaryStage.setScene(scene);              
        primaryStage.show();          
        Image i = new Image("b.jpg");      
        primaryStage.getIcons().add(i); 
    }   
    
     public static void main(String[] args) {
            launch(args);
    }
}
