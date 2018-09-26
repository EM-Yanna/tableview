package br.com.unialfa.tableview.exception;

import java.util.Locale;
import java.util.ResourceBundle;

import br.com.unialfa.tableview.configure.Configure;

public class RegraDeNegocioException extends Exception {

    public ResourceBundle configure() {
        ResourceBundle rsb = Configure.returnBundleExceptionFile();
        return rsb;
    }

    public RegraDeNegocioException(String message) {
        super(message);
    }
    public RegraDeNegocioException() {
		super();
	}
    @Override
    public String getMessage() {
		ResourceBundle resource = ResourceBundle
				.getBundle("messages", new Locale("pt", "BR"));
		String msg = resource.getString(getClass().getSimpleName());
		return msg;
    }
}
