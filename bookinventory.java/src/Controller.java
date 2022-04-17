import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller 
{

    @FXML
    private Button btnWrite;

    @FXML
    private Button btnread;

    @FXML
    private TextArea taResult;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtCopies;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtUnitPrice;
    File myfile=new File("book.txt"); //path

    @FXML
    void addBook(ActionEvent event)
     {
        taResult.clear();
        
         taResult.appendText("Book\t\tDescription \tUnit Price \tNo. of copies\t Total\n");
        try 
        {
            Scanner keyboard=new Scanner(myfile);
            if(myfile.exists())
            {
                while(keyboard.hasNext())
                {
                    String s=keyboard.next();
                    
                    Scanner scan=new Scanner(s);
                    scan.useDelimiter(",");
                    String s1=scan.next();
                    String s2= scan.next();
                    

                    double c=scan.nextDouble();
                    double p=scan.nextDouble();
                    double total=c*p;
                    taResult.appendText(s1+"\t\t" +s2+"\t\t\t"+p+"\t\t\t"+c+"\t\t"+total+"\n");
                }
            }
        }
        catch (IOException e) 
        {
            System.out.println("error in file read"+e.getMessage());
        } 
        catch(InputMismatchException e)
        {
            System.out.println("invalid input"+e.getMessage());
        }

     }
    
    @FXML
    void addBook(ActionEvent event) {
        try 
        {
            PrintWriter output=new PrintWriter(new BufferedWriter(new FileWriter(myfile,true)));
            String s=txtBookName.getText();
            String d = txtDescription.getText();
            double p=Double.parseDouble(txtUnitPrice.getText());
            double c=Double.parseDouble(txtCopies.getText());
            output.println(s+ "," +d +"," + p+","+c);
            System.out.println("file created");
            txtBookName.clear();
            txtCopies.clear();
            txtUnitPrice.clear();
            txtDescription.clear();
            output.close();
        } 
        catch (IOException e) 
        {
            System.out.println("error in file read"+e.getMessage());
        } 
        catch(InputMismatchException e)
        {
            System.out.println("invalid input"+e.getMessage());
        }
    }

}
