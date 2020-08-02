package designpattern.behavioural.memento.example;

public class Editor {
    StringBuilder builder;
    String file;

    Editor(String file) {
        this.file = file;
        this.builder = new StringBuilder();
    }

    public void write(String str) {
        builder.append(str);
    }

    @Override
    public String toString() {
        return "Editor{" + "builder=" + builder + '}';
    }

    public void undoToMostRecent(Object obj) {
        Memento memento = (Memento) obj;
        this.file = memento.file;
        this.builder = memento.builder;
    }

    public Memento save() {
        return new Memento(this.file, this.builder);
    }

    //Keeping the inner class is very important
    private class Memento {
        StringBuilder builder;
        String file;

        Memento(String file, StringBuilder builder) {
            this.builder = builder;
            this.file = file;
        }
    }
}
