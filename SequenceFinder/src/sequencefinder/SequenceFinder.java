package sequencefinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 *
 * @author KusyMat
 */
public class SequenceFinder extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane gridpane = new GridPane();
     gridpane.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
     gridpane.getColumnConstraints().add(new ColumnConstraints(120)); // column 1 is 120 wide
     gridpane.getRowConstraints().add(new RowConstraints(100));       //Row in column 1 is 100 high
     gridpane.getColumnConstraints().add(new ColumnConstraints(140));
     gridpane.getRowConstraints().add(new RowConstraints(100));
     gridpane.getColumnConstraints().add(new ColumnConstraints(100));
     gridpane.getRowConstraints().add(new RowConstraints(100));
     gridpane.getColumnConstraints().add(new ColumnConstraints(175));
     gridpane.getColumnConstraints().add(new ColumnConstraints(100));
     gridpane.getRowConstraints().add(new RowConstraints(100));
     /*
     Here I create elements i need and labels for them
     */
        Label Sequence = new Label("Sequence: ");
        GridPane.setConstraints(Sequence, 0, 0); // column=0 row=0
        GridPane.setMargin(Sequence, new Insets(5, 10, 5, 10));//margins
        TextArea sequence = new TextArea();
        GridPane.setConstraints(sequence, 1, 0);// column=1 row=0
        GridPane.setMargin(sequence, new Insets(5, 10, 5, 10));
        sequence.setWrapText(true);//sequence can be longer than the TextArea so we need to define wraptext
        Label lookedFor = new Label("Sequence to find: ");
        GridPane.setConstraints(lookedFor, 2, 0);
        GridPane.setMargin(lookedFor, new Insets(5, 10, 5, 10));
        TextField LookedFor = new TextField();
        GridPane.setConstraints(LookedFor, 3, 0);
        GridPane.setMargin(LookedFor, new Insets(5, 10, 5, 10));
        Label NumberOfSequences = new Label("Number of found sequences: ");
        GridPane.setConstraints(NumberOfSequences, 4, 0);
        TextField numberOfSequences = new TextField();
        GridPane.setConstraints(numberOfSequences, 5, 0);
        numberOfSequences.setEditable(false);//I don't want user to write anything here, he just gets the results
        Label result = new Label("               Result: ");
        GridPane.setConstraints(result, 4, 1);
        TextArea Result = new TextArea ();
        GridPane.setConstraints(Result, 5, 1);
        Result.setEditable(false);
        Result.setWrapText(true);
        gridpane.getChildren().addAll(Sequence, sequence, lookedFor, LookedFor,
                NumberOfSequences, numberOfSequences, result, Result);

        Button searchButton = new Button("Search");
        GridPane.setConstraints(searchButton, 0, 1);
        GridPane.setMargin(searchButton, new Insets(5, 10, 5, 10));
        // Here i set the action for search Button
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent event) {
 
                Result.setText(
                    // I'm getting static method search for Search class
                    Search.search(sequence.getText(), 
                    LookedFor.getText()));
                
            String str = sequence.getText();
            Pattern p = Pattern.compile(LookedFor.getText());
            Matcher m = p.matcher(str);
            int count = 0;
            while (m.find()){
             count +=1;
        }
                numberOfSequences.setText(String.valueOf(count));
        }
    });
       // Now button for closing the program
        Button endButton = new Button("Exit");
        GridPane.setConstraints(endButton, 1, 1);
        GridPane.setMargin(endButton, new Insets(5, 10, 5, 10));
        // Action for button Exit
        endButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        //Adding buttons to our window
        gridpane.getChildren().addAll(searchButton, endButton);
        
        Scene scene = new Scene(gridpane, 800, 275);
        // Title of window
        primaryStage.setTitle("Sequence finder");
        // Setting up the scene
        primaryStage.setScene(scene);
        // Show 
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
