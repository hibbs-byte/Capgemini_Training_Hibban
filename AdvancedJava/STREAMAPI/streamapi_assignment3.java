    public class Product {

        private int id;

        private String name;

        private String category;

        private double price;

        private int quantity;

        private double rating;

        public int getId() {
            return id;
        }

        public String getpName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getRating() {
            return rating;
        }
    }



class tasks
{
    List<String> tasks7(List<Product> p) {
        return p.stream().filter(a->a.getCategory().equalsIgnoreCase("Electronics")  && a.getPrice()>15000 && a.getQuantity()<30)
                .sorted(Comparator.comparingDouble(Product::getRating).reversed().thenComparingDouble(Product::getPrice))
                .map(a->a.getpName().toUpperCase())
                .toList();

    }
    List<Integer> tasks8(List<Product> p) {
        return p.stream().filter(a->a.getCategory().length()>6 && a.getPrice()>2000 && a.getPrice()<10000 && a.getRating()<3.5)
                .sorted(Comparator.comparingDouble(Product::getRating).reversed().thenComparingInt(Product::getQuantity))
                .map(a->a.getId()*3)
                .toList();

    }
    List<String> tasks9(List<Product> p)
    {
        return p.stream().filter(a->a.getpName().charAt(0)=='S' && a.getPrice()<5000 && a.getQuantity()>100)
                .sorted(Comparator.comparing(Product::getCategory).reversed().thenComparingDouble(Product::getPrice))
                .map(a->new StringBuilder(a.getpName()).reverse().toString())
                .toList();
    }
}
