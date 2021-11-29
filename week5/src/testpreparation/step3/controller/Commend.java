package testpreparation.step3.controller;

import testpreparation.step3.Model.RubiksCube;
import testpreparation.step3.resource.Commends;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commend extends RubiksCube {

    public void splitInputString(String inputString) {
        List<String> commends = new ArrayList<>();
        int commendsIndex = 0;
        String commend;

        for (int i = 0; i < inputString.length(); i++) {
            if (isSpecialCharacter(inputString, commends, commendsIndex, i)) {
                continue;
            }
            if (isDigitCharacter(inputString, commends, i)) {
                continue;
            }
            commend = String.valueOf(inputString.charAt(i));
            commends.add(commend);
            commendsIndex++;
        }
        commendController(commends);
    }

    private void commendController(List<String> commends) {
        Map<Integer, Runnable> commendList = new HashMap<>();
        createCommend(commendList);
        for(var i : commends) {
            commendList.get(Commends.transferCommendID(i)).run();
        }
    }

    private boolean isDigitCharacter(String inputString, List<String> commends, int i) {
        if (Character.isDigit(inputString.charAt(i))) {
            for (int j = 0; j < (inputString.charAt(i) - '0') - 1; j++) {
                commends.add(String.valueOf(inputString.charAt(i - 1)));
            }
            return true;
        }
        return false;
    }

    private boolean isSpecialCharacter(String inputString, List<String> commends, int commendsIndex, int i) {
        StringBuilder sb = new StringBuilder();
        String commend;
        if (inputString.charAt(i) == '\'') {
            commend = sb.append(inputString.charAt(i - 1)).append(inputString.charAt(i)).toString();
            commends.set(commendsIndex - 1, commend);
            return true;
        }
        return false;
    }

    private void createCommend(Map<Integer, Runnable> commendList) {
        commendList.put(0, () -> movingToRightTopLine());
        commendList.put(1, () -> movingToLeftTopLine());
        commendList.put(2, () -> movingToDownRightLine());
        commendList.put(3, () -> movingToUpRightLine());
        commendList.put(4, () -> movingToUpLeftLine());
        commendList.put(5, () -> movingToDownLeftLine());
        commendList.put(6, () -> movingToRightBottomLine());
        commendList.put(7, () -> movingToLeftBottomLine());
        commendList.put(8, () -> cubeExit());
    }
}
