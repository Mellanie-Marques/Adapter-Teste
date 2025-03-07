package translation;

public interface Translator {
    String translate(String fromLang, String toLang, String text) throws Exception;
}

