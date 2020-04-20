package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class CafeRubis extends PApplet {
    // Name : Steven Aherne
    // Student Num: C18742005
    // ArrayLists to store products and bill
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Product> bill = new ArrayList<Product>();

    float border; // border around the edge of the screen
    float left;
    float w; // width of a product box
    float h; // height of a product box

	public void settings() {
        size(800, 600); // screen size
        
        border = 0.1f * width;
        left = 0.05f * width;
        w = 0.3f * width;   // width of product box
        h = 0.09f * height; // height of product box
	}

	// method to load products from the csv file with headers
	public void loadData() {
		// create table and load file to table
		Table table = loadTable("cafe.csv", "header");

		// iterate through each row of table and add to colours arraylist
		for (TableRow tr : table.rows()) {
			Product product = new Product(tr);
			products.add(product);
		}
    }
    
    // method to print colours to console
	public void printProducts(){
		for(Product product : products){
			System.out.println(product);
		}
    }

    // method to display products to the screen 
    public void displayProducts()
    {
        // loop through each product and draw it on the screen
        for(int i = 0; i < products.size(); i++)
        {
            Product product = products.get(i);
            float y = map(i, 0, products.size(), border, height - border);

            fill(255);
            rect(left, y, w, h);
            fill(0);
            textAlign(LEFT, CENTER);
            text(product.getName(), left + 10, y + (h / 2));
            textAlign(RIGHT, CENTER);
            text(nf(product.getPrice(), 0, 2), left + w - 10, y + (h / 2));
        }
    }

    // method to display bill to the screen
    public void displayBill()
    {
        float billLeft = (width / 2) + 50;
        float billHeight = height * 0.8f;
       
        stroke(0);
        fill(255);
        rect(billLeft, border, w, billHeight); // rectangle to encapsule the bill

        float y = border + 50;
        float total = 0; // bill total

        // loop through the bill to draw to screen and get total
        for(int i = 0; i < bill.size(); i++)
        {
            Product p = bill.get(i);
            textAlign(LEFT, CENTER);
            fill(0);
            text(p.getName(), billLeft + 10, y);
            textAlign(RIGHT, CENTER);
            text(nf(p.getPrice(), 0, 2), billLeft + w - 10, y);            
            y += 30;
            total += p.getPrice();
        }

        fill(0);
        textAlign(LEFT, CENTER);
        text("Total:", billLeft + 10, y);
        textAlign(RIGHT, CENTER);
        text(nf(total, 0, 2), billLeft + w - 10, y); 
    }

    // method to control what a mouse click does
    public void mousePressed(){
        // loop to check if a product is clicked
        for(int i = 0; i < products.size(); i++)
        {
            float y = map(i, 0, products.size(), border, height - border);
            // if a product is clicked add it to the bill array list 
            if(mouseX > left && mouseX < left + w && mouseY > y && mouseY < y + h )
            {
                bill.add(products.get(i));
            }
        }
    }
    
    // setup method
    public void setup() {
        loadData(); // load data in from the csv file
        printProducts();    // print products to console
	}

	public void draw()
	{			
        displayProducts();
        displayBill();
	}
}