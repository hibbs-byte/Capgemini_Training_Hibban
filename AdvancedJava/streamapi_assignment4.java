class Order {

    private int orderId;

    private String customerName;

    private String city;

    private double amount;

    private int itemCount;

    private String status;

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCity() {
        return city;
    }

    public double getAmount() {
        return amount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getStatus() {
        return status;
    }
}

class Taskss
{
    List<String> task10(List<Order> orders)
    {
        return orders.stream().filter(p->p.getCity().equalsIgnoreCase("Bangalore") && p.getAmount()>7000 && p.getItemCount()<5)
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed().thenComparing(Order::getCustomerName))
                .map(p->p.getCustomerName().toUpperCase())
                .toList();
    }


    List<String> task12(List<Order> orders)
    {
        return orders.stream().filter(o->o.getCustomerName().length()>5 && o.getAmount()<5000 && o.getItemCount()>2 )
                .sorted(Comparator.comparing(Order::getCity).reversed().thenComparingDouble(Order::getAmount))
                .map(o->new StringBuilder(o.getCustomerName())
                        .reverse().toString())
                .toList();
    }
    List<String> task11(List<Order> orders)
    {
        return orders.stream().filter(o->o.getStatus().equalsIgnoreCase("pending") && o.getAmount()>2000 && o.getAmount()<9000 && o.getCity().charAt(o.getCity().length()-1)=='i')
                .sorted(Comparator.comparingDouble(Order::getAmount).thenComparingInt(Order::getItemCount))
                .map(o->String.valueOf(o.getOrderId()))
                .toList();
    }

}
