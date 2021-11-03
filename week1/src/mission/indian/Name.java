package mission.indian;

class Name {

    private final int yearIndex;
    private final int monthIndex;
    private final int dayIndex;
    private final int index = 1;

    public String[] year = {"시끄러운, 말 많은", "푸른", "어두운 -> 적색", "조용한", "웅크린", "백색", "지혜로운", "용감한", "날카로운", "욕심많은"};
    public String[] month = {"늑대", "태양", "양", "매", "황소", "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"};
    public String[] day = {"와(과) 함께 춤을", "의 기상", "은(는) 그림자 속에", "따로 붙는 말이 없음", "따로 붙는 말이 없음", "따로 붙는 말이 없음", "의 환생", "의 죽음", "아래에서", "을(를) 보라.", "이(가) 노래하다", "의 그늘 → 그림자", "의 일격", "에게 쫒기는 남자", "의 행진", "의 왕", "의 유령", "을 죽인 자", "은(는) 맨날 잠잔다", "처럼", "의 고향", "의 전사", "은(는) 나의 친구", "의 노래", "의 정령", "의 파수꾼", "의 악마", "와(과) 같은 사나이", "의 심판자→을(를) 쓰러뜨린 자", "의 혼", "은(는) 말이 없다"};

    public Name(int yearIndex, int monthIndex, int dayIndex) {
        this.yearIndex = yearIndex;
        this.monthIndex = monthIndex;
        this.dayIndex = dayIndex;
    }

    public int getYear() {
        return yearIndex % 10;
    }

    public int getMonth() {
        return monthIndex - index;
    }

    public int getDay() {
        return dayIndex - index;
    }

    @Override
    public String toString() {
        return "당신의 이름은 " + year[getYear()] + " " + month[getMonth()] + " " + day[getDay()] + "입니다.";
    }
}
