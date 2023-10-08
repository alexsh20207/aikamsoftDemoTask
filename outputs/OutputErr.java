package rus.aikamsoft.demotask.shtang.outputs;

import rus.aikamsoft.demotask.shtang.Const;

public class OutputErr extends Output {
    String message;
    public OutputErr(String message) {
        type = Const.OUTPUT_TYPE_ERROR;
        this.message = message;
    }
}
