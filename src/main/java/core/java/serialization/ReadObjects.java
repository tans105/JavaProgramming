package core.java.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;



public class ReadObjects {


    public static void main(String[] args) {
        System.out.println("Reading objects...");

        try(FileInputStream fi = new FileInputStream("people.bin")) {

            ObjectInputStream os = new ObjectInputStream(fi);

            //if we change the serialVersionUID, it will throw an exception
            //java.io.InvalidClassException: core.java.serialization.Person; local class incompatible: stream classdesc serialVersionUID = 4801633306273802062, local class serialVersionUID = 3801633306273802062

            Person person1 = (Person)os.readObject();
            Person person2 = (Person)os.readObject();

            os.close();

            System.out.println(person1);
            System.out.println(person2);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}