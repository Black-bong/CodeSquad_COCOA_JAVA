package moneybook.domain;


public class Member {

    private Long id;
    private final String username;
    private final String password;

    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isSameId(Long id) {
        return this.id.equals(id);
    }

    public boolean isSameUserName(String name) {
        return this.username.equals(name);
    }

    public boolean isSamePassword(String password) {
        return this.password.equals(password);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
