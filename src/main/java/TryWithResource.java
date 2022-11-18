import java.io.FileWriter;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) {
        //이걸 try with resource statements라고 한다. 리소스 언급과 try를 함께 한다는 말.
        try (FileWriter f = new FileWriter("data.txt")){
            f.write("Hellod");
            f.close(); // 이거 중복이다. try 안에 FileWriter ~~~이거 있으면 자동으로  close 해 준다. 그래서 검은 글씨로 나온다.
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
