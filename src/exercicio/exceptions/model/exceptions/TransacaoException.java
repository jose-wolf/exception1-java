package exercicio.exceptions.model.exceptions;

public class TransacaoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public TransacaoException(String mensagem) {
		super(mensagem);
	}
}
