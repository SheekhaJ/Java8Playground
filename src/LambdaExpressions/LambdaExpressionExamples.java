package LambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface Drawable0{
    public void draw();
}

interface Drawable1{
    public void draw(int width);
}

interface Drawable2{
    public void draw(int width, int height);
}

interface Drawable3{
    public boolean isDrawable(int width, int height);
}

class Product{
    int id;
    String name;
    float price;

    public Product(int id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

}

public class LambdaExpressionExamples {
    public static void main(String[] args){
        implementationWithoutLambdaExpression();
        printSeparator();

        implementationWithLambdaExpressionNoParameter();
        printSeparator();

        implementationWithLambdaExpressionSingleParameter();
        printSeparator();

        implementationWithLambdaExpressionMultipleParameters();
        printSeparator();

        implementationWithLambdaExpressionWithReturn();
        printSeparator();

        implementationWithLambdaExpressionWithoutReturn();
        printSeparator();

        forEachExample();
        printSeparator();

        threadExample();
        printSeparator();

        comparatorExample();
        printSeparator();
    }

    public static void printSeparator(){
        System.out.println("----------------------------------------------------------------------------------");
    }

    // Without Lambda Expression
    public static void implementationWithoutLambdaExpression(){
        int width = 10;
        Drawable0 drawable = new Drawable0(){

            @Override
            public void draw() {
                System.out.println(String.format("implementationWithoutLambdaExpression - Printing width %d in draw method!", width));
            }
            
        };
        drawable.draw();
    }

    // With Lambda Expression And No Parameter
    public static void implementationWithLambdaExpressionNoParameter(){
        int width = 20;
        Drawable0 drawable = () -> {
            System.out.println(String.format("implementationWithLambdaExpression - Printing width %d in draw method!", width));
        };
        drawable.draw();
    }

    // With Lambda Expression And Single Parameter
    public static void implementationWithLambdaExpressionSingleParameter(){
        Drawable1 drawable = (width) -> {
            System.out.println(String.format("implementationWithLambdaExpressionSingleParameter - Printing width %d in draw method!", width));
        };
        drawable.draw(25);
    }

    // With Lambda Expression And Multiple Parameters
    public static void implementationWithLambdaExpressionMultipleParameters(){
        Drawable2 drawable = (width, height) -> {
            System.out.println(String.format("implementationWithLambdaExpressionMultipleParameters - Printing width %d and height %d in draw method!", width,height));
        };
        drawable.draw(30, 35);
    }

    public static void implementationWithLambdaExpressionWithReturn(){
        Drawable3 drawable = (width, height) -> {
            return width*height>0;
        };
        
        int width0 = -40, height0 = 10;
        System.out.println(String.format("implementationWithLambdaExpressionWithReturn - width0 - %d height0 - %d isDrawable? - %b",width0 ,height0 ,drawable.isDrawable(width0, height0)));

        int width1 = 40, height1 = 10;
        System.out.println(String.format("implementationWithLambdaExpressionWithReturn - width0 - %d height0 - %d isDrawable? - %b",width1 ,height1 ,drawable.isDrawable(width1, height1)));
    }

    public static void implementationWithLambdaExpressionWithoutReturn(){
        // Note that in this case when we don't specify the return statement, instead of curly braces {} we use round braces () and the return type is inferred from the method signature.
        Drawable3 drawable = (width, height) -> (width*height>0);
        
        int width0 = -40, height0 = 10;
        System.out.println(String.format("implementationWithLambdaExpressionWithoutReturn - width0 - %d height0 - %d isDrawable? - %b",width0 ,height0 ,drawable.isDrawable(width0, height0)));

        int width1 = 40, height1 = 10;
        System.out.println(String.format("implementationWithLambdaExpressionWithoutReturn - width0 - %d height0 - %d isDrawable? - %b",width1 ,height1 ,drawable.isDrawable(width1, height1)));
    }

    public static void forEachExample(){
        List<String> fruitsList = Arrays.asList("Banana", "Mango", "Pear", "Apple", "Pineapple");

        fruitsList.forEach((fruit) -> {
            System.out.println("Printing fruit name - "+fruit);
        });
    }

    public static void threadExample(){
        System.out.println("0 Printing statement - Thread1!");

        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                System.out.println("Thread 1 is running!");
            }
        });
        thread1.start();
        System.out.println("1 Printing statement - Thread1!");
        
        System.out.println("2 Printing statement - Thread1!");
        // Type is inferred from the type expected in the constructor of Thread
        Thread thread2 = new Thread(()->{
            System.out.println("Thread 2 is running!");
        });
        thread2.start();
        System.out.println("3 Printing statement - Thread1!");
    }

    public static void comparatorExample(){
        List<Product> products1 = Arrays.asList(new Product(1,"Laptop",1500), new Product(2,"Phone",800), new Product(3,"TV",4000));
        
        System.out.println("Sorting based on price without lambda expression!");
        Collections.sort(products1, new Comparator<Product>(){

			@Override
			public int compare(Product o1, Product o2) {
				return (int) (o1.price - o2.price);
			}
            
        });

        for(Product p : products1){
            System.out.println("Product p - "+p.id+" "+p.name+" "+p.price);
        }

        List<Product> products2 = Arrays.asList(new Product(1,"Laptop",1500), new Product(2,"Phone",800), new Product(3,"TV",4000));
        System.out.println("Sorting based on price with lambda expression!");
        Collections.sort(products2, (p1,p2)->{
            return (int)(p1.price - p2.price);
        });

        for(Product p : products2){
            System.out.println("Product p - "+p.id+" "+p.name+" "+p.price);
        }
    }

}