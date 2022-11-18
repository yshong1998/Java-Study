import java.io.FileWriter;
import java.io.IOException;

public class CheckedExceptionApp {
    /**
     * 무심코 넘어가는 것을 용인하지 않는 예외가
     * CheckException이라고 한다.
     * RuntimeException과 같은 uncheckedException의 경우 컴파일 시도를 하고, 문제가 생기면 문제가 생긴 것을 알려주는 예외라면
     * CheckedException의 경우는 애초에 예외 처리에 대한 코드를 try catch나 throw(s)로 처리해 주지 않으면
     * 컴파일읋 시도조차 하지 않는 예외다.
     */
    public static void main(String[] args) {
        FileWriter f = null; // null
        FileWriter g;
        FileWriter r;
        try{
            f = new FileWriter("data.txt"); // 이렇게 할 경우 같은 층위에 있는 파일에 data.txt가 new로 생성된다. 그 경로를 가리키고 있는 변수가 f다
            g = new FileWriter("data.md"); // 혹시 이러면 md가 생성이 되나? 되네
            r = new FileWriter("ReadMe.md"); // ReadMe가 이렇게 생기는 거였구나
            System.out.println(f); //data.txt의 경로가 출력된다.
            f.write("Helllo"); // data.txt에 글이 써진다.
            //근데 만약이 close를 하기 전에  IOException이 발생해서 아래 catch 된다면? close가 안 된다. 파일이 열린 상태로 그냥 끝난 것
            //그래서 반드시 finally를 써서 얘네를 닫아줘야 한다. finally는 마지막에 반드시 실행하는 블럭이다.

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            /**
             * 그래서 닫아주려고 왔더니만 지역이 달라서 변수들을 못 읽는다.
             * 때문에 이 변수들의 선언 자체는 try 밖에서 해서 전역 변수화 해주어야 한다.
             * 그런데도 또 불만이 있는데, 이건 초기화가 안 돼 있어서 그렇다. 만약 try 안으로 컴파일러가 진입하지 못 한다면
             * f,g,r은 생성될 수 없는 것이고, 존재하지 않는 것을 close할 수는 없기 때문이다.
             * 근데 ㅅㅂ 또 이번엔 f라는 변수는 null로 초기화를 했으니까 알겠는데, close를 못하겠다고 한다.
             * 왜냐하면 IOException을 처리하는 것 역시 위의 try로 컴파일러가 진입해야 할 수 있는데,
             * finally는 진입하지 않아도 실행되는 코드블럭이라 여기서 IOException을 처리하는 코드를 짜 줘야 한다.
             */
            if(f != null){
                try{
                    f.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            //근데 스벌 이거 depth가 5임 이걸 자바 개발자들도 알아서? 한 번에 해 주는 애들 개발했다.

        }
    }
}
