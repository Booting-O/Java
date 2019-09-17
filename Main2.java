class A{
    private int num;

    public void setNum(int num){
        this.num=num;
    }
    public int getNum(){
        return num;
    }
    
}
public class Main2 {

    public static void main(String[] args){
        A a = new A();
        A b = new A();
        a.setNum(25);
        b.setNum(26);
        System.out.println(a.getNum());
        System.out.println(b.getNum());

    }
}