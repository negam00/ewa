package exceptions;

import java.io.IOException;

/**
 * Een zelfgemaakte exception wanneer schrijven van data fout gaat.
 *
 * @author HvA HBO-ICT
 */
public class WriteDataFileException extends IOException {
    
    public WriteDataFileException(String message) {
        super(message);
    }
}
