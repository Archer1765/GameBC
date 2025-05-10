package com.example.gamebc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import tableAtt.TableAttem;

import java.net.URL;
import java.util.*;

public class HelloController {
    @FXML
    private Label gameRules;//текст правила игры
    @FXML
    private CheckBox gameRules2;//чекбок для показа прав игры
    @FXML
    private Button checkNumber;//проверить введеное число пользователем
    @FXML
    private TextField attempt;//число пользователя в текстовом поле
    private int attempts = 0;//количество попыток игрока
    private List<Integer> secretNumber;//загаданное число комьпютером
    private List<Integer> user = new ArrayList<>();//попытка введеного числа пользователем
    @FXML
    private TableView<TableAttem> tableAttempt;//таблица попыток пользователя
    @FXML
    private TableColumn<TableAttem, String> currentAttempt;//текущая попытка пользователя
    @FXML
    private TableColumn<TableAttem, String> currentBulls;//текущее количество быков
    @FXML
    private TableColumn<TableAttem, String> currentCows;//текущее количество коров
    @FXML
    private Button starGame;//кнопка для начала игры
    private int[] result;//массив значений быков и коров при текущей попытке
    public ObservableList<TableAttem> attemData = FXCollections.observableArrayList();
    //@FXML
    //private GridPane ooo;
    /*private HelloApplication helloApplication;
    public HelloController() {

    }*/
    @FXML
    protected void check() {
        //валидность введоного числа пользователем
        String text = attempt.getText();
        if (text.length() != 4 || !text.matches("\\d+")) {
            //System.out.println("Ошибка! Введите четыре цифры без пробелов.");
            attempt.setText("");
        }
        //проверка попытки введенного числа
        else{
            for (int i = 0; i < 4; i++) {
                user.add(Integer.parseInt(String.valueOf(text.charAt(i))));
            }
            result = checkBullsAndCows(secretNumber, user);
            System.out.println("Результат: " + result[0] + " бык(ов) и " + result[1] + " коров(а).");

            //ooo.setText("Ваша попытка - " + text + "Результат: " + result[0] + " бык(ов) и " + result[1] + " коров(а).\n");
            //ooo.setConstraints(attempt, 0 ,0);

            //currentAttempt.setCellValueFactory(new PropertyValueFactory<TableAttem, String>("getCurrentAttempt"));
            //currentBulls.setCellValueFactory(new PropertyValueFactory<TableAttem, String>("getCurrentBulls"));
            //currentCows.setCellValueFactory(new PropertyValueFactory<TableAttem, String>("getCurrentCows"));
            attemData = FXCollections.observableArrayList(
                    new TableAttem(attempt.getText(), String.valueOf(result[0]), String.valueOf(result[1]))
            );

            ObservableList<TableAttem> teamMembers = FXCollections.observableArrayList(
                    new TableAttem(attempt.getText(), String.valueOf(result[0]), String.valueOf(result[1]))
            );
            tableAttempt.setItems(teamMembers);

            if (result[0] == 4) {
                System.out.println("Поздравляем! Вы угадали число: " + secretNumber);
            }
            attempts++;
            user.clear();
        }

    }
    @FXML
    protected void initialize(URL location, ResourceBundle resources){
        tableAttempt.setItems(attemData);
        //TableView tw = new TableView();

        //currentAttempt.setCellValueFactory(cellData -> cellData.getValue().currentAttemptProperty());
        //currentBulls.setCellValueFactory(cellData -> cellData.getValue().currentBullsProperty());
        //currentCows.setCellValueFactory(cellData -> cellData.getValue().currentCowsProperty());

        //ArrayList<TableAttem> alta = tw.get
        //currentAttempt.setCellValueFactory(new PropertyValueFactory<TableAttem, String>("getCurrentAttempt"));
        //currentBulls.setCellValueFactory(new PropertyValueFactory<TableAttem, String>("getCurrentBulls"));
        //currentCows.setCellValueFactory(new PropertyValueFactory<TableAttem, String>("getCurrentCows"));
        /*
        ObservableList<TableAttem> teamMembers = FXCollections.observableArrayList(
                new TableAttem(attempt.getText(), String.valueOf(result[0]), String.valueOf(result[1]))
        );
        tableAttempt.setItems(teamMembers);*/
    }
    /*public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;

        // Добавление в таблицу данных из наблюдаемого списка
        tableAttempt.setItems(helloApplication.getData());
    }*/
    //текст с правилами игры
    @FXML
    protected void showGameRules(ActionEvent actionEvent) {
        gameRules.setText("Компьютер загадает 4х-значное число\n" +
                "с неповторяющимися цифрами в диапазоне \n" +
                "от 0 до 9 от 0 до 9 включительно. Игрок должен\n" +
                "угадать загаданное число. Чтобы проверить свою\n" +
                "догадку, игрок вводит в поле число. Компьютер \n" +
                "сообщает, сколько цифр угадано без совпадения\n" +
                "с их позициями в загаданном числе\n" +
                "(количество \"коров\") и сколько угадано вплоть\n" +
                " до позиции в загаданном числе\n" +
                "(количество \"быков\").");
        gameRules.setVisible(gameRules2.isSelected());
    }
    //пусто
    @FXML
    protected  void isValid(){

    }
    @FXML
    protected  void start(){
        //генерация загаданного числа
        secretNumber = generateSecretNumber();
        //очистка поля попытки
        attempt.setText("");
        //очистка таблицы попыток
        //tableAttempt.getColumns().clear();
        tableAttempt.getItems().clear();
        attempts = 0;
    }
    private static List<Integer> generateSecretNumber() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> secretNumber = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(numbers.size());
            secretNumber.add(numbers.get(index));
            numbers.remove(index);
        }
        Collections.shuffle(secretNumber);
        System.out.println("Загаданное число: " + secretNumber);
        return secretNumber;
    }
    private static int[] checkBullsAndCows(List<Integer> secret, List<Integer> user) {
        int bulls = 0;//цифра есть и совпадает с положением
        int cows = 0;//цифра есть в загаданном числе

        for (int i = 0; i < 4; i++) {
            if (user.get(i).equals(secret.get(i))) {
                bulls++;
            } else if (secret.contains(user.get(i))) {
                cows++;
            }
        }
        return new int[]{bulls, cows};
    }
    /*private void addRow(List<Integer> row) {
        ObservableList<Integer> a = FXCollections.observableArrayList();
        a.addAll(row);

        tableAttempt.getItems().add(a);
    }*/
}