/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht.pkg3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Stefan
 */
public class Opdracht3 extends Application {
    
    public ArrayList<Werknemer> employees = new ArrayList<>();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void checkEmployee(String name, String worksFor)
    {
        boolean exists = false;
        for(int i = 0; i <= employees.size(); i++)
        {
            if(employees.get(i).name.equals(name))
            {
                exists = true;
                employees.get(i).worksFor = worksFor;
            }           
        }
        if(!exists)
        {
            Werknemer employee = new Werknemer(name, worksFor);
            employees.add(employee);
        }
    }
    public void addEmployee()
    {
        
    }
    
}
