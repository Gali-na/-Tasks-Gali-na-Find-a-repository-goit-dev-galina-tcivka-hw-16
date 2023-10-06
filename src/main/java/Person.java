import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private long id;
    private String name;

    public void setName(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        if (name.length() > 1000 || name.length() < 2) {
            throw new IllegalArgumentException("The name is incorrect, the number of characters in" +
                    " the name must not be less than 2 or more than 1000");
        }
        this.name = name;
    }

}
