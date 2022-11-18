import java.io.FileWriter;
import java.io.IOException;

public class MyException {
    public static void main(String[] args) {
        //내가 직접 예외를 발생 시킬 때
        try {
            int a = 0;
            System.out.println(2/a);
        } catch (Exception e) {
            throw new IllegalArgumentException("뭔가 잘못됐어요.");
            //내가 "뭔가 잘못됐어요"라고 출력시키고 있는 거고,
            //이거 대신 e.printStackTrace()를 하면 컴파일러가 보여주는 에러 메세지를 보여준다.
            //이 경우에는 0으로 나누는 게 틀린 거니까 /by zero가 나온다.
        }
    }
}
