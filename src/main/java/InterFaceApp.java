/**
 * 인터페이스는 형용사로 정의한다.
 * 결국 인터페이스를 만들고, 어떤 클래스에서 이를 상속받아서 쓰게 한다면
 * 해당 클래스에서는 인터페이스의 모든 메서드를 override 해야 한다.
 * 만약 하지 않았다면 컴파일 에러가 떠서 뻘건 줄이 생긴다
 * 인터페이스에서 메서드를 만들 때는 매개변수까지만 넣고 지역변수에는 무언가를 추가하지 않는다.
 * 어차피 클래스에서 override 해서 다시 쓸 거니까 어떤 기능이 필요한지 알 수 있는 메서드명만 잘 만들면 된다.
 * 인터페이스에서 선언한 변수의 값은 final로 고정이기 때문에 변경할 수 없다.
 *
 *
 */
interface Calculable{
    double PI = 3.14;
    int sum(int v1, int v2);
    int minus(int v1, int v2);
}
interface Printable{
    void print();
}

/**
 * RealCal이라는 클래스에서 Calculable과 Printable이라는 인터페이스를 상속받고 있다.
 * 이 클래스를 이용해 메인 함수에서 변수를 선언하면 RealCal의 메서드를 모두 사용할 수 있다.
 * 그리고 그 메서드의 종류는
 * RealCal클래스의 고유 메서드 / Calculable를 override 한 메서드 / Printable을 override 한 메서드
 * 이렇게 3 종류의 메서드를 활용할 수 있게 된다.
 * 하지만 특정 변수에게 필요한 메서드가 오직 계산만을 해야 해서 Calculable의 메서드만 필요하고, 나머지 두 메서드는 필요가 없다고 해 보자
 * 이 경우 변수를 선언할 때 Calculable의 형태로 선언하고, 생성은 RealCal로 하면
 * 자료형은 Calculable이라는 인터페이스 형이지만 생성은 RealCal로 되기 때문에
 * Calculable의 기능민을 활용할 수 있는 RealCal인스턴스가 생성되는 것이다. !! 중요. 이게 핵심이다.
 */
class RealCal implements Calculable,Printable{
    public int sum(int v1, int v2){
        return v1+v2;
    }
    public int minus(int v1, int v2){
        return v1-v2;
    }
    public void print(){
        System.out.println("This is RealCal!!");
    }
}
public class InterFaceApp {
    public static void main(String[] args) {
        RealCal c = new RealCal();
        Calculable a;
        System.out.println(c.sum(2,1));
        c.print();

    }
}
