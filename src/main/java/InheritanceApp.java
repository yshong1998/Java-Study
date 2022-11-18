/**
 * overLoading
 * 오버로딩이란, 같은 이름의 메서드를 다른 방식으로 재정의하는 것을 말하고
 * 따라서 상속받은 자식 클래스에서도 오버로딩이 있을 수 있지만
 * 자기 자신 클래스 안에서도 오버로딩은 일어날 수 있다.
 * overRiding
 * 오버라이딩이란, 자식 클래스에서 부모 클래스의 메서드를 재정의하는 것을 말하고
 * 따라서 한 클래스 내에서 오버라이딩은 일어날 수 없다.
 * 반드시 부모와 자식 클래스 간에서 일어나는 재정의만을
 * 자식 클래스가 부모 클래스의 메서드를 오버라이딩했다고 말한다.
 * 결과만 보면,
 * 오버로딩은 한 클래스 안에 같은 이름의 메서드가 2개 있는 거고
 * 오버라이딩은 부모 클래스와 자식 클래스 모두 하나 이상씩 같은 이름의 메서드를 갖고 있는 거다.
 * super
 * super는 자식 클래스에서 부모 클래스의 메서드를 호출할 때 사용한다.
 * 원래 상속을 받으면 부모 클래스의 메서드를 활용할 수 있다.
 * 하지만 오버라이딩을 통해 같은 메서드가 같은 매개변수를 받는 경우
 * 아래의 예시에서, Cal클래스에서도 v1과 v2를 매개변수로 해서 v1 + v2를 리턴하는 sum이 있고
 * Cal3 클래스에서도 v1 + v2를 리턴하는 sum이 있다.
 * 이 경우 그냥 Cal3의 인스턴스에서 sum을 호출하면 Cal3의 sum만 호출한다.
 * 하지만 super을 쓰면, 부모 클래스를 참조하겠다는 뜻이 되서 부모 클래스의 메서드를 갖고 올 수 있다.
 * 즉 super는 반드시 상속 관계가 있는 클래스 내에서만 활용할 수 있다.
 * 다른 클래스에서 상속 관계가 있는 클래스의 인스턴스를 생성해도, 해당 클래스 자체의 부모는 없기 때문에
 * super를 쓰려면 상속 관계가 있는 클래스에서 super을 호출해서 메서드를 만든 후 갖고와야 한다.
 * this
 * this는 자기 자신을 가리킬 때 활용한다.
 * 여기서 자기 자신이라고 할 수 있는 것은 클래스 내에서
 * 메서드 / 전역 변수가 있다.
 * this와 생성자
 * 클래스 내에서 생성자를 생성할 때, 매개변수를 통해 인스턴스마다 전역 변수의 값을
 * 다르게 가져갈 때, this.을 통해 전역 변수를 생성자로 가져와 지역 변수화하고,
 * = 매개 변수를 통해 지역 변수값을 매개 변수로 초기화해 주는 것이다.
 * Ex. this.v1 = v1, 여기서 앞의 v1은 전역 변수를 갖고 온 거고 뒤의 v1은 매개변수로 가져온 값이 될 것이다.
 */
class Cal{
    int v1,v2;
    Cal(int v1, int v2){
        this.v1 = v1;
        this.v2 = v2;
    }
    public int sum(int v1, int v2){
        return v1+v2;
    }
    public int sum(int v1, int v2,int v3){

        return this.sum(v1,v2)+v3;
    }
}

/**
 * 만약 부모 클래스에 생성자를 정의했다면
 * 자식 클래스에서도 반드시 생성자를 정의해야 한다.
 * 정의하는 방법은 자식 클래스의 생성자 안에 부모 클래스의 생성자를
 * 그대로 넣는 것인데, 이 경우 원래 Cal(v1,v2)라고 해야 하지만
 * Cal을 호출하는 super라는 메서드가 있기 때문에 super로 호출한다.
 * 그 이후 Cal3만의 생성자를 구축한다.
 */
class Cal3 extends Cal{
    Cal3(int v1, int v2){
        super(v1,v2);
    }

    public int minus(int v1, int v2){
        return v1-v2;
    }
    //overRiding
    public int sum(int v1, int v2){
        System.out.println("Cal3!!");
        return super.sum(v1,v2);
    }
}
public class InheritanceApp {
    public static void main(String[] args) {
        Cal c = new Cal(2,1);
        System.out.println(c.sum(2,1));
        System.out.println(c.sum(1,2,3));

        Cal3 c3 = new Cal3(2,1);
        System.out.println(c3.sum(2,1));
        System.out.println(c3.minus(2,1));
    }
}
