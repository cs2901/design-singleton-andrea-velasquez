public class SingletonChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    private static SingletonChocolateBoiler instance;

    private SingletonChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static SingletonChocolateBoiler getInstance() {
        if (instance == null){
            instance = new SingletonChocolateBoiler();
        }
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
}
