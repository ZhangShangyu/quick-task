
import com.git.hui.task.api.ITask;
import com.git.hui.task.util.FileUtils;

public class Hello implements ITask {
    @Override
    public void run() {
        System.out.println("in java hahahddddsdda");
    }

    @Override
    public void interrupt() {
        System.out.println("原来的结束 over");
    }
}