package designpattern.creational.builder;

public class UserBuilder {
    private User user;

    UserBuilder(int id) {
        this.user = new User(id);
    }

    UserBuilder name(String name) {
        user.setName(name);
        return this;
    }

    UserBuilder email(String email) {
        user.setEmail(email);
        return this;
    }

    UserBuilder address(String address) {
        user.setAddress(address);
        return this;
    }

    User build() {
        return user;
    }

}
