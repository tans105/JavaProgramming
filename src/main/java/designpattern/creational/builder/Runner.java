package designpattern.creational.builder;

public class Runner {
    public static void main(String[] args) {
        UserBuilder builder = new UserBuilder(1);
        System.out.println(builder.address("abc").email("t@t.com").name("Tanmay").build());
    }
}
