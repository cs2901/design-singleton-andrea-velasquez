public class SingletonChocolateBoiler extends Thread{
    private boolean empty;
    private boolean boiled;

    private static SingletonChocolateBoiler instance;

    private SingletonChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    synchronized public static SingletonChocolateBoiler getInstance() {
        if (instance == null){
            instance = new SingletonChocolateBoiler();
            System.out.println("SingletonChocolateBoiler instance was created");
        }
        System.out.println("SingletonChocolateBoiler instance already created");
        return instance;
    }

    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }

    public void drain(){
        if(isEmpty() && isBoiled()){
            //drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil(){
        if(!isEmpty() && isBoiled()){
            //bring the contents to a boil
            boiled = true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }

    public void run() {
        SingletonChocolateBoiler.getInstance();
    }
    public static void main(String [] args)
    {
        int N = 8;
        SingletonChocolateBoiler threads[] = new SingletonChocolateBoiler[N];
        for (int i=0; i<N; ++i){
            threads[i] = new SingletonChocolateBoiler();
            threads[i].start();
        }
    }
}
