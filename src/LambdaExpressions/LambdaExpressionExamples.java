package LambdaExpressions;

interface Drawable0{
    public void draw();
}

interface Drawable1{
    public void draw(int width);
}

interface Drawable2{
    public void draw(int width, int height);
}

public class LambdaExpressionExamples {
    public static void main(String[] args){
        implementationWithoutLambdaExpression();

        implementationWithLambdaExpressionNoParameter();

        implementationWithLambdaExpressionSingleParameter();

        implementationWithLambdaExpressionMultipleParameters();
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
}