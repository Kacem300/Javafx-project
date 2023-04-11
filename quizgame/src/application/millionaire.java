package application;

import java.lang.invoke.MethodHandles.Lookup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class millionaire extends Application {
	private static final Font FONT = Font.font(18);
	private QuestionPane qPane = new QuestionPane();
	private SidePane sPane = new SidePane();

public Parent Scene1() {
	    Text welcomeText = new Text("Welcome to Quiz Game ");
	    welcomeText.setFont(new Font(36));
	    Text owner = new Text("By Kacem Ben Brahim MDW21 ");
	    owner.setFont(new Font(36));
	    Button startButton = new Button("Start");
	    startButton.setFont(new Font(24));
	    VBox layout = new VBox(120);
	    layout.setAlignment(Pos.CENTER);
	    layout.getChildren().addAll(welcomeText, owner,startButton);  
	    return layout;
	}
private Parent Scene2() {
	HBox root = new HBox(20);
	Button bot = new Button("Exit");
    bot.setAlignment(Pos.TOP_LEFT);
	root.setPadding(new Insets(10,10,10,10));
	qPane.setQuestion(new Question("What is 2 +2 ","4","5","6","-1"));
	root.getChildren().addAll(bot,qPane,sPane);
	bot.setOnAction((ActionEvent event) -> {
        Platform.exit();
    });
	return root;
	}
private void NextQuestion() {
	 List<Question> questions = new ArrayList<>();

	 Question q1 = new Question("what is 4 + 4 ?","8","7","11","9");
	 Question q2 = new Question("what is 3 + 3 ?","6","7","8","9");
	 Question q3 = new Question("what is 7 + 5 ?","12","7","8","9");
	 Question q4=  new Question("what is 7 * 7 ?","49","7","8","9");
	 Question q5 = new Question("what is 10 - 7 ?","3","7","8","9");
	 Question q6 = new Question("what is 4 + 7 ?","11","7","8","9");
	 Question q7 = new Question("what is 6 + 6 ?","12","7","8","9");
	 Question q8 = new Question("what is 1 + 1 ?","2","7","8","9");
	 Question q9 = new Question("what is 22 + 10 ?","32","7","8","9");
	 Question q10 = new Question("what is 11+7-9+2 ?","11","7","8","9");
	 Question q11 = new Question("what is 4 + 2 - 7 ?","-1","7","8","9");
	 Question q12 = new Question("what is 10 + 9 ?","19","21","8","9");
	 Question q13 = new Question("what is 52 + 4 ?","56","7","8","9");
	 Question q14 = new Question("what is 0 + 0 ?","0","7","8","9");

	 questions.add(q1);	 questions.add(q2);
	 questions.add(q3);	 questions.add(q4);
	 questions.add(q5);	  questions.add(q6);
	  questions.add(q7);	  questions.add(q8);
	  questions.add(q9);	  questions.add(q10);
	  questions.add(q11);	  questions.add(q12);
	  questions.add(q13);	  questions.add(q14);

	  int randomIndex = (int) (Math.random() * questions.size());

	    qPane.setQuestion(questions.get(randomIndex));    
	sPane.SelectNext();
	}

private class SidePane extends VBox{

	public int current = 1 ;
	public SidePane() {
		
		super(10);
		for(int i = 15;i>0;i--) {
			Text text = new Text("Question "+ i);
			text.setFill(i == current ? Color.BLACK:Color.GRAY);
			
			getChildren().add(text);
		}
	}
	public void SelectNext(){
		
		if (current == 15) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Congrats you won");
			alert.show();
			current = 1 ; }
		Text text = (Text) getChildren().get(15 - current);
		text.setFill(Color.GRAY);
		current++;
		 text = (Text) getChildren().get(15 - current);
		text.setFill(Color.BLACK);
	}
}

private class QuestionPane extends VBox{
	private Text text = new Text();
	private List<Button> buttons = new ArrayList<>();
	private Text wrong = new Text();
	private Question current;
	public QuestionPane() {
		super(40);
		text.setFont(FONT);
		HBox hbox = new HBox();
		for(int i = 0 ;i<4;i++) {
			Button btn = new Button();
			btn.setFont(FONT);
			btn.setPrefWidth(120);
			btn.setOnAction(event -> {
				if(btn.getText().equals(current.getCorrectAnswer())) {
				wrong.setText("Correct");
				wrong.setFont(FONT);
				NextQuestion();
				}else {
					wrong.setFont(FONT);
					wrong.setText("Incorrect");
				}
			});
			buttons.add(btn);
			hbox.getChildren().add(btn);
		}
		setAlignment(Pos.CENTER);
		getChildren().addAll(text,hbox,wrong);
	}
	public void setQuestion(Question question) {
		current = question;
		text.setText(question.name);
		Collections.shuffle(buttons);
		for(int i =0 ; i<4;i++) {
			buttons.get(i).setText(question.answers.get(i));
		}
	}
}
private class Question {
	private String name;
	private List <String> answers;
	public Question (String name,String...answers) {
		this.name=name;
		this.answers=Arrays.asList(answers);
	}
	public String getCorrectAnswer() {
		return answers.get(0);
	}
}
@Override
public void start(Stage stage) throws Exception {
    Scene scene1 = new Scene(Scene1());
    Scene scene2 = new Scene(Scene2());
    Image icon = new Image("logo.png");
    stage.getIcons().add(icon);
    stage.setResizable(true);
    stage.setTitle("Quiz Game");
    stage.setFullScreen(false);
    stage.setFullScreenExitHint("escape");
    stage.setScene(scene1);
    Button startButton = (Button) scene1.lookup("Button");
    startButton.setOnAction(e -> stage.setScene(scene2));
    stage.show();
	}
public static void main(String[] args) {launch(args);}

}
