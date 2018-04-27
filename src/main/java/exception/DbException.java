package exception;

public class DbException extends Exception {
    public DbException(Throwable throwable) {
        super(throwable);
    }
}
