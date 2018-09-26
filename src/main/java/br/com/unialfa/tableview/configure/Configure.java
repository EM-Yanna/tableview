package br.com.unialfa.tableview.configure;

import java.util.Locale;
import java.util.ResourceBundle;

public class Configure {

    final static String DIR = "br.com.unialfa.tableview.resource.";

    final static String CONF = DIR + "conf";

    final static String IDIOMA = "idioma";

    final static String PAIS = "pais";

    final static String EXCECAO = "excecao";

    /**
     * Inicializa o arquivo de configurção
     * @return - retorna o bundle do arquivo conf.properties.
     */
    public static ResourceBundle initialize() {
        ResourceBundle bundle = ResourceBundle.getBundle("conf");
        return bundle;
    }

    /**
     * Inicializa o idioma e o pais contidos no arquivo conf.properties.
     * @return - retorna o locale
     */
    public static Locale returnLocale() {
        ResourceBundle bundle = initialize();
        Locale locale = new Locale(bundle.getString(IDIOMA), bundle.getString(PAIS));
        return locale;
    }
    
    /**
     * Método resposável por retorna o nome do arquivo de exceção em execução.
     * @return - retorna o arquivo de exceção em execução.
     */
    public static String returnMessagesException() {
        ResourceBundle bundle = initialize();
        String arquivoExcecao = bundle.getString(EXCECAO);
        return arquivoExcecao;
    }

    /**
     * Método responsável pelo retorno do bundle do arquivo de exceção em excução.
     * @return - o bundle do arquivo de exceção.
     */
    public static ResourceBundle returnBundleExceptionFile() {
        Locale locale = returnLocale();
        String baseName = returnMessagesException();
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        return bundle;
    }
}