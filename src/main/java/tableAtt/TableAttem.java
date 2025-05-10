package tableAtt;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableAttem {
    private SimpleStringProperty currentAttempt;
    private SimpleStringProperty currentBulls;
    private SimpleStringProperty currentCows;
    public TableAttem(String currentAttempt, String currentBulls, String currentCows) {
        this.currentAttempt = new SimpleStringProperty(currentAttempt);
        this.currentBulls = new SimpleStringProperty(currentBulls);
        this.currentCows = new SimpleStringProperty(currentCows);
    }
    /*public TableAttem(StringProperty currentAttempt, StringProperty currentBulls, StringProperty currentCows) {
        this.currentAttempt = currentAttempt;
        this.currentBulls = currentBulls;
        this.currentCows = currentCows;
    }*/
    public String getCurrentAttempt() {
        return currentAttempt.get();
    }
    public void setCurrentAttempt(String currentAttempt) {
        this.currentAttempt.set(currentAttempt);
    }
    public StringProperty currentAttemptProperty() {
        return currentAttempt;
    }
    public String getCurrentBulls() {
        return currentBulls.get();
    }
    public void setCurrentBulls(String currentBulls) {
        this.currentBulls.set(currentBulls);
    }
    public StringProperty currentBullsProperty() {
        return currentBulls;
    }
    public String getCurrentCows() {
        return currentCows.get();
    }
    public void setCurrentCows(String currentCows) {
        this.currentCows.set(currentCows);
    }
    public StringProperty currentCowsProperty() {
        return currentCows;
    }
    /*public TypeVariable<GenericDeclaration> firstNameProperty() {

    }*/


    /*public ObservableValue<Integer> attemptProperty() {
        return personData;
    }*/
}
