package exceptions;

import java.io.IOException;

/**
 * Een zelfgemaakte exception wanneer lezen van data fout gaat.
 *
 * @author HvA HBO-ICT
 */
public class ReadDataFileException extends IOException {
    
    public ReadDataFileException(String message) {
        super(message);
    }
}
