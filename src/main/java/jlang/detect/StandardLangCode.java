package jlang.detect;

import java.util.Arrays;

class StandardLangCode {
    static String[] getArray() {
        var enumStream = Arrays.stream(StandardLangCodeEnum.values());
        var enumMap = enumStream.map(Enum::name);
        return enumMap.toArray(String[]::new);
    }
}
