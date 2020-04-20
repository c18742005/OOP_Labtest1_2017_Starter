package ie.tudublin;

// Class to hold the main method of the program
public class Main
{	

	public void cafeRubis()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CafeRubis());
	}
	
	public static void main(String[] args)
	{
		Main main = new Main();
		main.cafeRubis();		
	}
}