package application;
	
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static Main singleton;
	
	private Stage setStage = new Stage();
	
//------------------------------------------------------------------------
	
	private int toggle;
	public int toggle() { return toggle; }
	private int count;
	public int count() { return count; }
	private int judge;
	public int judge() { return judge; }
	public void judge_c() { judge++; }
	private List<String> Q = new ArrayList<String>();
	private List<String> A = new ArrayList<String>();
	private List<String> J = new ArrayList<String>();
	public void input_Q(String q) { Q.add(q); }
	public void input_A(String a) { A.add(a); }
	public void input_J(String j) { J.add(j); }
	public String write_Q(int c) { return Q.get(c); }
	public String write_A(int c) { return A.get(c); }
	public String write_J(int c) { return J.get(c); }
	public int Q_count() { return A.size(); }
	
	private Timer timer = new Timer(false);
	private Timer timer2 = new Timer(false); 
	private Calendar start;
	private Calendar end;
	public String result_time() {
		String tm;
		end = Calendar.getInstance();
		long mill = end.getTimeInMillis() - start.getTimeInMillis();
		int TIME = (int)(mill/1000);
		int min = TIME / 60;
		int sec = TIME % 60;
		tm = (min + "ï™" + sec + "ïb");
		return tm;
	}	

	public void View() {
		Group g = new Group();
		Rectangle rect = new Rectangle(0,-10,10,410);
		DropShadow dropshadow = new DropShadow(BlurType.GAUSSIAN, Color.GRAY, 10, 0.3, -1, 0);
		rect.setEffect(dropshadow);
		TranslateTransition animation = new TranslateTransition(Duration.seconds(0.3), rect);
		animation.setFromY(0);
		animation.setToY(0);
		animation.setFromX(-10);
		animation.setToX(910);
		animation.play();
		g.getChildren().add(rect);
		setStage.setScene(new Scene(g, 900, 400));
	}
	
	public void backView() {
		Group g = new Group();
		Rectangle rect = new Rectangle(0,-10,10,410);
		DropShadow dropshadow = new DropShadow(BlurType.GAUSSIAN, Color.GRAY, 10, 0.3, -1, 0);
		rect.setEffect(dropshadow);
		TranslateTransition animation = new TranslateTransition(Duration.seconds(0.3), rect);
		animation.setFromY(0);
		animation.setToY(0);
		animation.setFromX(910);
		animation.setToX(-10);
		animation.play();
		g.getChildren().add(rect);
		setStage.setScene(new Scene(g, 900, 400));
	}
	
// -------------------------------------------------------------------------------------
	
	public void setPage_M_byMenu() {
		timer = new Timer(false);
		timer2 = new Timer(false);
		toggle = 1;
		View();
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				try {
					AnchorPane root = FXMLLoader.load( getClass().getResource("test15_check.fxml") );
					Platform.runLater( () -> setStage.setScene(new Scene(root)) );
					timer2.cancel();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		timer2.schedule(task2, 400);
	}
	
	public void setPage_Q_byMenu() {
		timer2 = new Timer(false);
		toggle = 2;
		View();
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				try {
					AnchorPane root = FXMLLoader.load( getClass().getResource("test15_check.fxml") );
					Platform.runLater( () -> setStage.setScene(new Scene(root)) );
					timer2.cancel();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		timer2.schedule(task2, 400);
	}
	
	public void setPage_bycheck() {
		count = 0;
		judge = 0;
		Q.clear();
		A.clear();
		J.clear();
		timer2 = new Timer(false);
		start = Calendar.getInstance();
		try {
			if(toggle == 1) {
				TimerTask task = new TimerTask() {
					@Override
					public void run()  {
							Platform.runLater( () -> View() );
							TimerTask task2 = new TimerTask() {
								@Override
								public void run() {
									try {
										AnchorPane root = FXMLLoader.load( getClass().getResource("test15_result.fxml") );
										Platform.runLater( () -> setStage.setScene(new Scene(root)) );
										timer2.cancel();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							};
							timer2.schedule(task2, 400);
							timer.cancel();
					}
				};
				timer.schedule(task, 600000);
			}
			View();
			TimerTask task2 = new TimerTask() {
				@Override
				public void run() {
					try {
						AnchorPane root = FXMLLoader.load( getClass().getResource("test15_ex.fxml") );
						Platform.runLater( () -> setStage.setScene(new Scene(root)) );
						timer2.cancel();
						timer2 = new Timer(false);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			timer2.schedule(task2, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPage_byEx() {
		try {
			count++;
			if(toggle == 2) {
				if(count > 9) {
					View();
					TimerTask task2 = new TimerTask() {
						@Override
						public void run() {
							try {
								AnchorPane root = FXMLLoader.load( getClass().getResource("test15_result.fxml") );
								Platform.runLater( () -> setStage.setScene(new Scene(root)) );
								timer2.cancel();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					};
					timer2.schedule(task2, 400);
					end = Calendar.getInstance();
					return;
				}
			}
			AnchorPane root = FXMLLoader.load( getClass().getResource("test15_ex.fxml") );
			setStage.setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cancel_byEx() {
		if(toggle == 1) {
			timer.cancel();
		} else if(toggle == 2) {
			end = Calendar.getInstance();
		}
		View();
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				try {
					AnchorPane root = FXMLLoader.load( getClass().getResource("test15_result.fxml") );
					Platform.runLater( () -> setStage.setScene(new Scene(root)) );
					timer2.cancel();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		timer2.schedule(task2, 400);
	}
	
	public void setPage_byResult() {
		timer2 = new Timer(false);
		backView();
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				try {
					AnchorPane root = FXMLLoader.load( getClass().getResource("test15_menu.fxml") );
					Platform.runLater( () -> setStage.setScene(new Scene(root)) );
					timer2.cancel();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		timer2.schedule(task2, 400);
	}
	
	public void closeWindow(ActionEvent event) {
		Scene scene = ( (Node) event.getSource() ).getScene();
		Window window = scene.getWindow();
		window.hide();
		}
	
// -------------------------------------------Ç±Ç±Ç‹Ç≈-----------------------------------------------------
	
	@Override
	public void start(Stage primaryStage) {
		try {
			singleton = this;
			setStage = primaryStage;
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("test15_menu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ç‚Ç¡ÇƒÇ›ÇÊÇ§ÅIíZï∂ì¸óÕ");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Main getInstance() {
		return singleton;
	}
	
}
