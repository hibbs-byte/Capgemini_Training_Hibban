import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamapi {
    public static void main(String[] args) {
        List<String> immutableList = Stream.of("red", "green", null, null).toList();
        System.out.println("Immutable list: " + immutableList);
        //immutableList.add("yellow"); // Throws exception
        List<String> mutableList = Stream.of("red", "green", null, null)
                .collect(Collectors.toList());
        System.out.println("Mutable list before changes: " + mutableList);
        mutableList.add("yellow");
        mutableList.set(2, "purple");
        System.out.println("Mutable list after changes: " + mutableList);
        record Product(String name, String category, int price) {}
        Stream<Product> products=Stream.of(new Product("bat","sportsitem",4000),
            new Product("bells","sportsitem",4000),
            new Product("ball","sportsitem",2000),
            new Product("mobile","item",14000),
            new Product("banana","fruit",200));
           // Map<String, List<Product>> categoryMap=products.collect(Collectors.groupingBy(Product::category));
            //System.out.println(categoryMap);

            // Map<String,Integer> pricing=products.collect(Collectors.groupingBy(Product::category,Collectors.summingInt(Product::price)));
             //System.out.println(pricing);
             //Map<String, Double> avg = products.collect(Collectors.groupingBy(Product::category,Collectors.averagingInt(Product::price)));
             //System.out.println(avg);
             //List<Product> filtered=products.filter(Product->Product.price>2500).collect(Collectors.toList());
             //System.out.println(filtered);
             //var extractfields=products.map(Product ::price).toList();
             //System.out.println(extractfields);

             //Map<Boolean,List<Product>> part=products.collect(Collectors.partitioningBy(Product->Product.price>1000));
             //System.out.println(part);
             System.out.println(products.collect(Collectors.summarizingInt(Product::price)));
        }

    }
