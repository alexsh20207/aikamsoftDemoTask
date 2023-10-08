package rus.aikamsoft.demotask.shtang;

public class Main {

    public static void main(String[] args) {
        if (args.length != Const.ARG_LENGTH) {
            System.err.println(Const.ARGS_LENGTH_ERRMSG);
        }
        else {
            HandlerOperation handlerOperation = new HandlerOperation(args);
            handlerOperation.handle();
        }
    }
}