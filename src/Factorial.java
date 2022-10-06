

class Fact implements Runnable {
    private final int n;
    public Fact(int numero){
        this.n = numero;
    }

    public void run(){
        int factorial = 1;
        if(n!=0) {
            for (int i = n; i >= 1; i--) {
                factorial *= i;
            }
        }
        System.out.printf("%s: %d! = %d\n",Thread.currentThread().getName(),n,factorial);
    }
}
public class Factorial {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("No se encontro un número");
        }else{
            try{
                for(String s: args) {
                    int n = Integer.parseInt(s);
                    if(n<0) throw new NumberFormatException();
                    Thread t = new Thread(new Fact(n));
                    t.start();
                }
            }catch(NumberFormatException e) {
                System.out.println("Solo numeros enteros positivos");
            }
        }
    }
}
