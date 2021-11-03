package mission.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomMembers {
    public static void main(String[] args) throws IOException {

        RandomMembers randomMember = new RandomMembers();

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("몇 명인가요? ");
        int searchCount = Integer.parseInt(buf.readLine());
        buf.close();

        randomMember.outPutMembers(searchCount);

    }

    void outPutMembers(int count) {
        Member member = new Member();

        member.addMember();

        int length = member.getMembers().size();

        for (int i = 0; i < count; i++) {

            System.out.print(member.getMembers().get((int) (Math.random() * length)));
            if (i == count - 1) {
                break;
            }
            System.out.print(", ");
        }
    }
}
