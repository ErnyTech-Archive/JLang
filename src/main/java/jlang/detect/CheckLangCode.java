package jlang.detect;

class CheckLangCode {
    private String lang_code;

    CheckLangCode(String lang_code) {
        this.lang_code = lang_code;
    }

    boolean isOk() {
        var standardLangCodes = StandardLangCode.getArray();

        for (String standardLangCode : standardLangCodes) {
            if (this.lang_code.equals(standardLangCode)) {
                return true;
            }
        }
        return false;
    }
}
