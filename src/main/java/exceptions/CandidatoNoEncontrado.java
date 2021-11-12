package exceptions;

import javax.persistence.PersistenceException;

public class CandidatoNoEncontrado extends PersistenceException {

    public CandidatoNoEncontrado() {
    }

    public CandidatoNoEncontrado(String message) {
        super(message);
    } //Se utiliza cuando no encuentro un candidato por ID

}
