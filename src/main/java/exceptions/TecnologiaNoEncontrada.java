package exceptions;

import javax.persistence.PersistenceException;

public class TecnologiaNoEncontrada extends PersistenceException {

        public TecnologiaNoEncontrada() {
        }

    public TecnologiaNoEncontrada(String message) {
            super(message);
        } //Se utiliza cuando no encuentro una tecnologia por ID
    }

