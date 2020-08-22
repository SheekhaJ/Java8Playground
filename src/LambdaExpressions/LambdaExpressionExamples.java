package LambdaExpressions;

interface Drawable0{
    public void draw();
}

public class LambdaExpressionExamples {
    public static void main(String[] args){
        implementationWithoutLambdaExpression();

        implementationWithLambdaExpressionNoParameter();
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

}