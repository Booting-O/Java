class A{
    private int num;
    private static A s = new A();
    public static A getInstance(){
            return s;
    }
    public void setNum(int num){
        this.num=num;
    }
    public int getNum(){
        return num;
    }

}
public class Main1 {

    public static void main(String[] args){
        A a = A.getInstance();
        A b = A.getInstance();
        a.setNum(25);
        System.out.println(a.getNum());
        System.out.println(b.getNum());

    }
}