package testpreparation.step3.controller;

public class Commend {

    public void splitCommend(String commend) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < commend.length(); i++) {
            if(commend.charAt(i) == '\'') {
                sb.append(commend.charAt(i - 1)).append(commend.charAt(i));
                System.out.println(sb);
            }
        }
    }
}
