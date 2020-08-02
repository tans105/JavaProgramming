package designpattern.behavioural.memento.example;

public class Caretaker {
    Object memento; //cannot keep it as object of memento since memento is an inner class

    public void save(Editor state) {
        this.memento = state.save(); // will return the saved state in the form of memento object
    }

    public void undo(Editor editor) {
        editor.undoToMostRecent(memento); // will update the editor with what is there in memento
    }
}
