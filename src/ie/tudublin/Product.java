package ie.tudublin;

import processing.data.TableRow;

public class Product {
    public String name;
    public float price;

    // Product constructors
    public Product(TableRow tr){
        this(
            tr.getString("Name"),
            tr.getFloat("Price")
        );
    }

    public Product(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

    // getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // method to allow printing of products to console
    public String toString(){
        return name + " " + price;
    }
}