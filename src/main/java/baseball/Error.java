package baseball;

import java.util.HashSet;
import java.util.Set;

abstract class Err {
    public abstract boolean err(String s);
}

class NumError extends Err{
    static final int ballLength = 3;
    static final String ballPattern = "[1-9]+";
    @Override
    public boolean err(String s){
        Set<String> numset = new HashSet<>();
        numset.add(String.valueOf(s.charAt(0)));
        numset.add(String.valueOf(s.charAt(1)));
        numset.add(String.valueOf(s.charAt(2)));
        if (s.length() != this.ballLength || !s.matches(this.ballPattern) || numset.size() != this.ballLength) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return false;
    }
}

class EndError extends Err{
    static final String endPattern = "[12]";
    @Override
    public boolean err(String s){
        if (!s.matches(this.endPattern)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return false;
    }
}
