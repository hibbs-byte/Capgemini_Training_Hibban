package annotation_config.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hibbs {
    @Value("100")
    private int id;
    @Value(value="ABC")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hibbs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
