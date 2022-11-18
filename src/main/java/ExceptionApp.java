public class ExceptionApp {
    public static void main(String[] args) {
        System.out.println(1);
        int[] scores = {10,20,30};
        try {
            System.out.println(2);
//            System.out.println(scores[3]);
            System.out.println(3);
            System.out.println(2/0);
            System.out.println(4);
            /**
             * 아래에서 e는 변수고, 그 앞에 있는 Exceoption은 자료형이다. 결국 자료형 + 변수의 형태인 것은 타 변수들과 다를 게 없다.
             */

        } catch (ArithmeticException e){
            /**
             * 그니까 결국 e는 ArithmeticException형의 변수고, getMessage()메서드를 이용해 보통의 get메서드가 그렇듯
             * 메세지를 return해 준다. 따라서 sout이 아니기 때문에 리턴값이 무시되지 않으려면 sout을 하든, String이니까 String에 저장을 하든
             * 하나는 해야 이 return값이 무시되지 않는다.
             */

            String a = e.getMessage();
            System.out.println(a);
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("뭔가 이상합니다. 오류가 발생했습니다.");
        }
        System.out.println(3);
    }
}
