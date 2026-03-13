package dependancy_injection_usingMap;

import java.util.Map;

public class Kit {
    private String name;
    private Map<String, Integer> items;

    public Kit(String name, Map<String, Integer> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Kit{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}

