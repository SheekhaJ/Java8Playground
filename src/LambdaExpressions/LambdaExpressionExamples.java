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

interface Drawable3{
    public boolean isDrawable(int width, int height);
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

}